package com.challenge.backend.controller;

import com.challenge.backend.entity.Tests;
import com.challenge.backend.service.interfaces.ITest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador que manipula el flujo de los servicios rest del microservicio de tests
 *
 * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
 * @version 1.0.0 
 * @since 1.0.0
 */

@RestController
@RequestMapping("/api/controller")
public class TestController {

    /**
     * Servicio para el manejo de tests
     */
    @Autowired
    private ITest testService;

    /**
     * Metodo que permite consultar un listado de tests
     *
     * @return Objeto Response en formato JSON
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @GetMapping("tests")
    public ResponseEntity<?> getList() {

        List<Tests> testList = this.testService.getList();
        if (testList.isEmpty()) {
            return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(testList, HttpStatus.OK);
        }
    }

    /**
     * Metodo que permite consultar un test por id
     *
     * @param id
     * @return un test por id
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @GetMapping("tests/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Optional<Tests> test = this.testService.getById(id);
        if (test.isEmpty()) {
            return new ResponseEntity<>("No found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(test, HttpStatus.OK);
        }
    }

    /**
     * Metodo que permite crear un test
     *
     * @param test
     * @return test creado
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @PostMapping("tests")
    public ResponseEntity<?> post(@RequestBody Tests test) {
        try {
            Tests testSave = this.testService.post(test);
            return new ResponseEntity<>(testSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("No found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que permite actualizar datos de un test
     *
     * @param test
     * @return test actualizado
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @PutMapping("tests")
    public ResponseEntity<?> put(@RequestBody Tests test) {
        try{
            Optional<Tests> testUpdated = testService.put(test);
            if (testUpdated.isPresent()) {
                return new ResponseEntity<>("Updated", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("No found", HttpStatus.NOT_FOUND);
        }catch(Exception exception){
            System.out.println("an exception has occurred !!!\n" + "<" + exception.getMessage() + ">");
            return new ResponseEntity<>("No found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que permite eliminar un test por id
     *
     * @param id
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @DeleteMapping("tests/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            this.testService.deleteById(id);
        } catch (Exception exception) {
            return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
