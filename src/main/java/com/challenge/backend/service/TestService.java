package com.challenge.backend.service;

import com.challenge.backend.entity.Tests;
import com.challenge.backend.repository.TestRepository;
import com.challenge.backend.service.interfaces.ITest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa los metodos de logica de negocio de la interface de ITest
 *
 * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */

@Service
public class TestService implements ITest {

    /**
     * Repositorio de Test
     */
    @Autowired
    private TestRepository testRepository;

    /**
     * Metodo que permite consultar un listado de tests
     *
     * @return listado de tests
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @Override
    public List<Tests> getList() {
        return (List<Tests>) testRepository.findAll();
    }

    /**
     * Metodo que permite consultar un test por id
     *
     * @param id
     * @return un test por id
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @Override
    public Optional<Tests> getById(Integer id) {
        Optional<Tests> test = this.testRepository.findById(id);
        return test;
    }

    /**
     * Metodo que permite crear un test
     *
     * @param test
     * @return test creado
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @Override
    public Tests post(Tests test) {

        return this.testRepository.save(test);
    }

    /**
     * Metodo que permite actualizar datos de un test
     *
     * @param test
     * @return test actualizado
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @Override
    public Optional<Tests> put(Tests test) {
        Optional<Tests> optionalTest = testRepository.findById(test.getId());

        if (optionalTest.isPresent()) {
            Tests updatedTest = optionalTest.get();

            updatedTest.setName(test.getName());
            updatedTest.setDescription(test.getDescription());

            testRepository.save(updatedTest);

            return Optional.ofNullable(updatedTest);
        } else {
            return Optional.empty();
        }
    }

    /**
     * Metodo que permite eliminar un test por id
     *
     * @param id
     * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
     * @since 1.0.0
     */
    @Override
    public void deleteById(Integer id) {
        this.testRepository.deleteById(id);
    }
}
