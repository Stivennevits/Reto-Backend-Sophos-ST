package com.challenge.backend.service.interfaces;

import com.challenge.backend.entity.Tests;

import java.util.List;
import java.util.Optional;

/**
 * Interface que contiene los metodos de logica de negocio para los tests
 *
 * @author Edison Restrepo - edisonestival@gmail.com
 * @version 1.0.0 2022-12-01
 * @since 1.0.0
 */

public interface ITest {

    /**
     * Metodo que permite consultar un listado de tests
     *
     * @return listado de tests
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public List<Tests> getList();

    /**
     * Metodo que permite consultar un test por id
     *
     * @param id
     * @return un test por id
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public Optional<Tests> getById(Integer id);

    /**
     * Metodo que permite crear un test
     *
     * @param test
     * @return test creado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public Tests post(Tests test);

    /**
     * Metodo que permite actualizar datos de un test
     *
     * @param test
     * @return test actualizado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public Optional<Tests> put(Tests test);

    /**
     * Metodo que permite eliminar un test por id
     *
     * @param id
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public void deleteById(Integer id);
}
