
package com.challenge.backend.controller;

import com.challenge.backend.entity.Appointment;
import com.challenge.backend.service.interfaces.IAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Controlador que manipula el flujo de los servicios rest del microservicio de appointments
 *
 * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
 * @version 1.0.0 
 * @since 1.0.0
 */

@RestController
@RequestMapping("/api/controller")
public class AppointmentController {

    /**
     * Servicio para el manejo de appointments
     */
    @Autowired
    private IAppointment appointmentService;

    /**
     * Metodo que permite consultar un listado de appointments
     *
     * @return Objeto Response en formato JSON
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @GetMapping("appointments")
    public ResponseEntity<?> getList() {
        List<Appointment> appointmentList = this.appointmentService.getList();
        if (appointmentList.isEmpty()) {
            return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(appointmentList, HttpStatus.OK);
        }
    }

    /**
     * Metodo que permite consultar un appointment por id
     *
     * @param id
     * @return un appoinment por id
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @GetMapping("appointments/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Optional<Appointment> appointment = this.appointmentService.getById(id);
        if (appointment.isEmpty()) {
            return new ResponseEntity<>("No found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(appointment, HttpStatus.OK);
        }
    }

    /**
     * Metodo que permite crear un appointment
     *
     * @param appointment
     * @return test creado
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @PostMapping("appointments")
    public ResponseEntity<?> post(@RequestBody Appointment appointment) {
        Appointment appointmentCreated = appointmentService.post(appointment);
        if (appointmentCreated!=null) {
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("No found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que permite actualizar datos de un appointment
     *
     * @param appointment
     * @return appointment actualizado
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @PutMapping("appointments")
    public ResponseEntity<?> put(@RequestBody Appointment appointment) {
        Optional<Appointment> appointmentUpdated = appointmentService.put(appointment);
        if(appointmentUpdated.isEmpty()){
            return new ResponseEntity<>("No found", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>("Updated", HttpStatus.CREATED);
        }
    }

    /**
     * Metodo que permite eliminar un appoinment por id
     *
     * @param id
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @DeleteMapping("appointments/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            this.appointmentService.deleteById(id);
        } catch (Exception exception) {
            return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * Metodo que permite obtener todos las appointments de una fecha, agrupadas por affiliate
     *
     * @param day
     * @return lista de appointments
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @GetMapping("appointments/date/{day}/{month}/{year}")
    public ResponseEntity<?> getByDate(@PathVariable int day, @PathVariable int month, @PathVariable int year) {

        try{
            LocalDate date = LocalDate.of(year, month, day);

            Collection<Appointment> appointmentList = this.appointmentService.getByDate(date);
            if(appointmentList.isEmpty()){
                return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
            }else {
                return new ResponseEntity<>(appointmentList, HttpStatus.OK);
            }
            }catch(Exception exception){
                return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
            }
        }

    /**
     * Metodo que permite obtener todos las appointments de un affiliate
     *
     * @param id
     * @return lista de appointments
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @GetMapping("appointments/getbyaffiliates/{id}")
    public ResponseEntity<?> getByAffiliates(@PathVariable Integer id) {

        try{
            List<Appointment> appointments = appointmentService.getByAffiliate(id);
            if(appointments.isEmpty()){
                return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(appointments, HttpStatus.OK);
            }
        }catch(Exception exception){
            return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
        }
    }
}
