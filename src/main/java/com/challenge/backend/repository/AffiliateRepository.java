package com.challenge.backend.repository;

import com.challenge.backend.entity.Affiliate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface que contiene el CRUD con Spring JPA para la tabla de affiliate.
 *
 * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
 * @version 1.0.0 
 * @since 1.0.0
 */
@Repository
public interface AffiliateRepository extends CrudRepository<Affiliate, Integer> {
}
