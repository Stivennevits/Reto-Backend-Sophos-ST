package com.challenge.backend.controller;

import com.challenge.backend.entity.Affiliate;
import com.challenge.backend.service.interfaces.IAffiliate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador que manipula el flujo de los servicios rest del microservicio de affiliates
 *
 *	@author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
 * @version 1.0.0 
 * @since 1.0.0
 */

@RestController
@RequestMapping("/api/controller")
public class AffiliateController {

    /**
     * Servicio para el manejo de affiliates
     */
    @Autowired
    private IAffiliate affiliateService;

    /**
     * * ResponseEntity es un objeto que me va a permitir generar una respuesta http
     * * a la peticion que yo le haga desde una aplicación con posmant
     * * y el signo de ? se le indica que es una respuesta dinamica como tal puede llegarle cualquier cosa
     * <p>
     * Metodo que permite consultar un listado de affiliates
     *
     * @return Objeto Response en formato JSON
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @GetMapping("affiliates")
    public ResponseEntity<?> getList() {

        List<Affiliate> affiliateList = this.affiliateService.getList();
        if (affiliateList.isEmpty()) {
            return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(affiliateList, HttpStatus.OK);
        }
    }

    /**
     * Metodo que permite consultar un affiliate por id
     *
     * @param id
     * @return un affiliate por id
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @GetMapping("affiliates/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Optional<Affiliate> affiliate = this.affiliateService.getById(id);
        if (affiliate.isEmpty()) {
            return new ResponseEntity<>("No found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(affiliate, HttpStatus.OK);
        }
    }

    /**
     * Metodo que permite crear un affiliate
     *
     * @param affiliate
     * @return affiliate creado
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @PostMapping("affiliates")
    public ResponseEntity<?> post(@RequestBody Affiliate affiliate) {
        try {
            Affiliate affiliateSave = this.affiliateService.post(affiliate);
            return new ResponseEntity<>(affiliateSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("No found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que permite actualizar datos de un affiliate
     *
     * @param affiliate
     * @return affiliate actualizado
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @PutMapping("affiliates")
    public ResponseEntity<?> put(@RequestBody Affiliate affiliate) {
        try {
            Optional<Affiliate> affiliateUpdated = affiliateService.put(affiliate);
            if (affiliateUpdated.isPresent()) {
                return new ResponseEntity<>("Updated", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("No found", HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>("No found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que permite eliminar un affiliate por id
     *
     * @param id
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @DeleteMapping("affiliates/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            this.affiliateService.deleteById(id);
        } catch (Exception exception) {
            return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
