package com.challenge.backend.controller;

import com.challenge.backend.entity.Affiliate;
import com.challenge.backend.service.interfaces.IAffiliate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * ExtendWith ecesario para inyectar el Mock a la dependencia que queremos Testear
 */
@ExtendWith(MockitoExtension.class)
class AffiliateControllerTest {

    /**
     * InjectMocks prepara al objeto real para inyectarle un mock en ese caso el objeto real (AffiliateController)
     * y el mock viene a ser el AffiliateService
     */
    @InjectMocks
    private AffiliateController affiliateController = new AffiliateController();

    /**
     * Se hace con interface para que pueda ser un codigo testeable y poderlo convertir en un Mock (un objeto NO real)
     */
    @Mock
    private IAffiliate affiliateServiceMock;

    /**
     * Testear una lista vacia de affiliates
     */
    @Test
    void getListAffiliateEmpty() {
        when(affiliateServiceMock.getList()).thenReturn(Collections.emptyList());
        var response = affiliateController.getList();
        Assertions.assertEquals(204, response.getStatusCodeValue());
    }

    /**
     * Testear una lista de affiliates
     */
        @Test
        void getListAffiliate() {
            List<Affiliate> affiliateListMock = new ArrayList<>();
            affiliateListMock.add(new Affiliate());
            when(affiliateServiceMock.getList()).thenReturn(affiliateListMock);
            var response = affiliateController.getList();
            Assertions.assertEquals(200, response.getStatusCodeValue());
        }

    /**
     * Testear una id vacio de affiliates
     */
    @Test
    void getByIdEmpty() {
        when(affiliateServiceMock.getById(anyInt())).thenReturn(Optional.empty());
        var response = affiliateController.getById(anyInt());
        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    /**
     * Testear una id de affiliates
     */
    @Test
    void getByIdAffiliate() {
        Affiliate affiliateMock = new Affiliate();
        when(affiliateServiceMock.getById(anyInt())).thenReturn(Optional.of(affiliateMock));
        var response = affiliateController.getById(anyInt());
        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    /**
     * Testea una exception al crear un affiliate
     */
    @Test
    void postAffiliateException() {
        Affiliate affiliateMock = new Affiliate();
        doThrow(new RuntimeException()).when(affiliateServiceMock).post(affiliateMock);
        var response = affiliateController.post(affiliateMock);
        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    /**
     * Testea que se haya creado un affiliate
     */
    @Test
    void postAffiliate() {
        Affiliate affiliateMock = new Affiliate();
        when(affiliateServiceMock.post(affiliateMock)).thenReturn(affiliateMock);
        var response = affiliateController.post(affiliateMock);
        Assertions.assertEquals(201, response.getStatusCodeValue());
    }

    /**
     * Testea una excepcion al actualizar un affiliate
     */
    @Test
    void putAffiliateException() {
        Affiliate affiliateMock = new Affiliate();
        doThrow(new RuntimeException()).when(affiliateServiceMock).put(affiliateMock);
        var response = affiliateController.put(affiliateMock);
        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    /**
     * Testea una null al actualizar un affiliate
     */
    @Test
    void putAffiliateNull() {
        Affiliate affiliateMock = new Affiliate();
        when(affiliateServiceMock.put(affiliateMock)).thenReturn(Optional.empty());
        var response = affiliateController.put(affiliateMock);
        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    /**
     * Testea que se haya actualizado un affiliate
     */
    @Test
    void putAffiliate() {
        Affiliate affiliateMock = new Affiliate();
        when(affiliateServiceMock.put(affiliateMock)).thenReturn(Optional.of(affiliateMock));
        var response = affiliateController.put(affiliateMock);
        Assertions.assertEquals(201, response.getStatusCodeValue());
    }

    /**
     * Testea una exception al eliminar un affiliate
     */
    @Test
    void deleteException() {
        doThrow(new RuntimeException()).when(affiliateServiceMock).deleteById(anyInt());
        var response = affiliateController.delete(anyInt());
        Assertions.assertEquals(204, response.getStatusCodeValue());
    }

    /**
     * Testea que se haya eliminado un affiliate
     */
    @Test
    void deleteById() {
        doNothing().when(affiliateServiceMock).deleteById(anyInt());
        var response = affiliateController.delete(anyInt());
        Assertions.assertEquals(200, response.getStatusCodeValue());
    }
}