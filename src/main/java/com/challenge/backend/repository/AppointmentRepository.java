package com.challenge.backend.repository;

import com.challenge.backend.entity.Affiliate;
import com.challenge.backend.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

/**
 * Interface que contiene el CRUD con Spring JPA para la tabla de appointments.
 *
 * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
 * @version 1.0.0 
 * @since 1.0.0
 */
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

    /**
     * Metodo que permite obtener todos las appointments de un affiliate
     *
     * @param affiliate
     * @return lista de appointments
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    public List<Appointment> findByIdAffiliateOrderByDateAsc(Affiliate affiliate);

    /**
     * Metodo que permite obtener todos las appointments de una fecha, agrupadas por affiliate
     *
     * @param date
     * @return lista de appointments
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    public Collection<Appointment> findByDateOrderByIdAffiliateAsc(LocalDate date);
}
