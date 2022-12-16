package com.challenge.backend.service.interfaces;

import com.challenge.backend.entity.Appointment;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Interface que contiene los metodos de logica de negocio para los appointments
 *
 * @author Edison Restrepo - edisonestival@gmail.com
 * @version 1.0.0 2022-12-02
 * @since 1.0.0
 */

public interface IAppointment {

    /**
     * Metodo que permite consultar un listado de appointments
     *
     * @return listado de appointments
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public List<Appointment> getList();

    /**
     * Metodo que permite consultar un appoinntment por id
     *
     * @param id
     * @return un appoinment por id
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public Optional<Appointment> getById(Integer id);

    /**
     * Metodo que permite crear un appointment
     *
     * @param appointment
     * @return appointment creado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public Appointment post(Appointment appointment);

    /**
     * Metodo que permite actualizar datos de un appointment
     *
     * @param appointment
     * @return appointment actualizado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public Optional<Appointment> put(Appointment appointment);

    /**
     * Metodo que permite eliminar un appointment por id
     *
     * @param id
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public void deleteById(Integer id);

    /**
     * Metodo que permite obtener todos las appointments de una fecha, agrupadas por affiliate
     *
     * @param date
     * @return lista de appointments
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public Collection<Appointment> getByDate(LocalDate date);

    /**
     * Metodo que permite obtener todos las appointments de un affiliate
     *
     * @param id
     * @return lista de appointments
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public List<Appointment> getByAffiliate(Integer id);

}
