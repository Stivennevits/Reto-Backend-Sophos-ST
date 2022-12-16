package com.challenge.backend.service;

import com.challenge.backend.entity.Affiliate;
import com.challenge.backend.repository.AffiliateRepository;
import com.challenge.backend.service.interfaces.IAffiliate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa los metodos de logica de negocio de la interface de IAffiliate
 *
 * @author Edison Restrepo - edisonestival@gmail.com
 * @version 1.0.0 2022-11-29
 * @since 1.0.0
 */

@Service
public class AffiliateService implements IAffiliate {

    /**
     * Repositorio de Affiliate
     */
    @Autowired
    private AffiliateRepository affiliateRepository;

    /**
     * Metodo que permite consultar un listado de affiliates
     *
     * @return listado de affiliates
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public List<Affiliate> getList() {
        return (List<Affiliate>) affiliateRepository.findAll();
    }

    /**
     * Metodo que permite consultar un affiliate por id
     *
     * @param id
     * @return un affiliate por id
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public Optional<Affiliate> getById(Integer id) {
        Optional<Affiliate> affiliate = this.affiliateRepository.findById(id);
        return affiliate;
    }

    /**
     * Metodo que permite crear un affiliate
     *
     * @param affiliate
     * @return affiliate creado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public Affiliate post(Affiliate affiliate) {
        return this.affiliateRepository.save(affiliate);
    }

    /**
     * Metodo que permite actualizar datos de un affiliate
     *
     * @param affiliate
     * @return affiliate actualizado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public Optional<Affiliate> put(Affiliate affiliate) {
        Optional<Affiliate> optionalAffiliate = affiliateRepository.findById(affiliate.getId());

        if (optionalAffiliate.isPresent()) {
            Affiliate updatedAffiliate = optionalAffiliate.get();

            updatedAffiliate.setName(affiliate.getName());
            updatedAffiliate.setAge(affiliate.getAge());
            updatedAffiliate.setMail(affiliate.getMail());

            affiliateRepository.save(updatedAffiliate);

            return Optional.ofNullable(updatedAffiliate);
        } else {
            return Optional.empty();
        }

    }

    /**
     * Metodo que permite eliminar un affiliate por id
     *
     * @param id
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public void deleteById(Integer id) {
        this.affiliateRepository.deleteById(id);
    }
}
