package com.challenge.backend.controller;

import com.challenge.backend.entity.Tests;
import com.challenge.backend.service.interfaces.ITest;
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
 * ExtendWith necesario para inyectar el Mock a la dependencia que queremos Testear
 */
@ExtendWith(MockitoExtension.class)
class TestControllerTest {

    /**
     * InjectMocks prepara al objeto real para inyectarle un mock en ese caso el objeto real (TestController)
     * y el mock viene a ser el TestService
     */
    @InjectMocks
    private TestController testController = new TestController();

    /**
     * Se hace con interface para que pueda ser un codigo testeable y poderlo convertir en un Mock (un objeto NO real)
     */
    @Mock
    private ITest testServiceMock;

    /**
     * Testear una lista vacia de tests
     */
    @Test
    void getListTestEmpty() {
        when(testServiceMock.getList()).thenReturn(Collections.emptyList());
        var response = testController.getList();
        Assertions.assertEquals(204, response.getStatusCodeValue());
    }

    /**
     * Testear una lista de tests
     */
    @Test
    void getListTests() {
        List<Tests> testsListMock = new ArrayList<>();
        testsListMock.add(new Tests());
        when(testServiceMock.getList()).thenReturn(testsListMock);
        var response = testController.getList();
        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    /**
     * Testear una id vacio de test
     */
    @Test
    void getByIdEmpty() {
        when(testServiceMock.getById(anyInt())).thenReturn(Optional.empty());
        var response = testController.getById(anyInt());
        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    /**
     * Testear un test por id
     */
    @Test
    void getByIdTest() {
        Tests testMock = new Tests();
        when(testServiceMock.getById(anyInt())).thenReturn(Optional.of(testMock));
        var response = testController.getById(anyInt());
        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    /**
     * Testea una exception al crear un test
     */
    @Test
    void postTestException() {
        Tests testsMock = new Tests();
        doThrow(new RuntimeException()).when(testServiceMock).post(testsMock);
        var response = testController.post(testsMock);
        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    /**
     * Testea que se haya creado un test
     */
    @Test
    void postTest() {
        Tests testsMock = new Tests();
        when(testServiceMock.post(testsMock)).thenReturn(testsMock);
        var response = testController.post(testsMock);
        Assertions.assertEquals(201, response.getStatusCodeValue());
    }

    /**
     * Testea que una excepcion al crear un test
     */
    @Test
    void putTestException() {
        Tests testsMock = new Tests();
        doThrow(new RuntimeException()).when(testServiceMock).put(testsMock);
        var response = testController.put(testsMock);
        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    /**
     * Testea una null al actualizar un test
     */
    @Test
    void putTestNull() {
        Tests testsMock = new Tests();
        when(testServiceMock.put(testsMock)).thenReturn(Optional.empty());
        var response = testController.put(testsMock);
        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    /**
     * Testea que se haya actualizado un test
     */
    @Test
    void putTest() {
        Tests testsMock = new Tests();
        when(testServiceMock.put(testsMock)).thenReturn(Optional.of(testsMock));
        var response = testController.put(testsMock);
        Assertions.assertEquals(201, response.getStatusCodeValue());
    }

    /**
     * Testea una exception al eliminar un test
     */
    @Test
    void deleteException() {
        doThrow(new RuntimeException()).when(testServiceMock).deleteById(anyInt());
        var response = testController.delete(anyInt());
        Assertions.assertEquals(204, response.getStatusCodeValue());
    }

    /**
     * Testea que se haya eliminado un test
     */
    @Test
    void deleteById() {
        doNothing().when(testServiceMock).deleteById(anyInt());
        var response = testController.delete(anyInt());
        Assertions.assertEquals(200, response.getStatusCodeValue());
    }
}