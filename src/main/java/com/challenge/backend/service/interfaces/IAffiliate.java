package com.challenge.backend.service.interfaces;

import com.challenge.backend.entity.Affiliate;

import java.util.List;
import java.util.Optional;

/**
 * Interface que contiene los metodos de logica de negocio para los affiliates
 *
 * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
 * @version 1.0.0 
 * @since 1.0.0
 */

public interface IAffiliate {

    /**
     * Metodo que permite consultar un listado de affiliates
     *
     * @return listado de affiliates
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    public List<Affiliate> getList();

    /**
     * Metodo que permite consultar un affiliate por id
     *
     * @param id
     * @return un affiliate por id
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    public Optional<Affiliate> getById(Integer id);

    /**
     * Metodo que permite crear un affiliate
     *
     * @param affiliate
     * @return affiliate creado
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    public Affiliate post(Affiliate affiliate);

    /**
     * Metodo que permite actualizar datos de un affiliate
     *
     * @param affiliate
     * @return affiliate actualizado
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    public Optional<Affiliate> put(Affiliate affiliate);

    /**
     * Metodo que permite eliminar un affiliate por id
     *
     * @param id
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    public void deleteById(Integer id);
}
