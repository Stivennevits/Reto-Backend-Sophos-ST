package com.challenge.backend.repository;

import com.challenge.backend.entity.Tests;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface que contiene el CRUD con Spring JPA para la tabla de tests.
 *
 * @author Edison Restrepo - edisonestival@gmail.com
 * @version 1.0.0 2022-12-01
 * @since 1.0.0
 */
@Repository
public interface TestRepository extends CrudRepository<Tests, Integer> {
}
