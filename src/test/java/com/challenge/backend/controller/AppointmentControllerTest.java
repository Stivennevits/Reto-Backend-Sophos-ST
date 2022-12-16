package com.challenge.backend.controller;

import com.challenge.backend.entity.Appointment;
import com.challenge.backend.service.interfaces.IAppointment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * ExtendWith necesario para inyectar el Mock a la dependencia que queremos Testear
 */
@ExtendWith(MockitoExtension.class)
class AppointmentControllerTest {

    /**
     * InjectMocks prepara al objeto real para inyectarle un mock en ese caso el objeto real (AppointmentController)
     * y el mock viene a ser el AffiliateService
     */
    @InjectMocks
    private AppointmentController appointmentController = new AppointmentController();

    /**
     * Se hace con interface para que pueda ser un codigo testeable y poderlo convertir en un Mock (un objeto NO real)
     */
    @Mock
    private IAppointment appointmentServiceMock;

    /**
     * Testear una lista vacia de appointments
     */
    @Test
    void getListAppointmentEmpty() {
        when(appointmentServiceMock.getList()).thenReturn(Collections.emptyList());
        var response = appointmentController.getList();
        Assertions.assertEquals(204, response.getStatusCodeValue());
    }

    /**
     * Testear una lista de appointments
     */
    @Test
    void getListAppointments() {
        List<Appointment> appointmentListMock = new ArrayList<>();
        appointmentListMock.add(new Appointment());
        when(appointmentServiceMock.getList()).thenReturn(appointmentListMock);
        var response = appointmentController.getList();
        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    /**
     * Testear una appointment por id vacio
     */
    @Test
    void getByIdEmpty() {
        when(appointmentServiceMock.getById(anyInt())).thenReturn(Optional.empty());
        var response = appointmentController.getById(anyInt());
        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    /**
     * Testear un appointment por id
     */
    @Test
    void getByIdAppointment() {
        Appointment appointmentMock = new Appointment();
        when(appointmentServiceMock.getById(anyInt())).thenReturn(Optional.of(appointmentMock));
        var response = appointmentController.getById(anyInt());
        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    /**
     * Testea un appointment cuando es null
     */
    @Test
    void postAppoinmentNull() {
        Appointment appointmentMock = new Appointment();
        when(appointmentServiceMock.post(appointmentMock)).thenReturn(null);
        var response = appointmentController.post(appointmentMock);
        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    /**
     * Testea que se haya creado un appointment
     */
    @Test
    void postAppointment() {
        Appointment appointmentMock = new Appointment();
        when(appointmentServiceMock.post(appointmentMock)).thenReturn(appointmentMock);
        var response = appointmentController.post(appointmentMock);
        Assertions.assertEquals(201, response.getStatusCodeValue());
    }

    /**
     * Testea una appointment si es null
     */
    @Test
    void putAppointmentNull() {
        Appointment appointmentMock = new Appointment();
        when(appointmentServiceMock.put(appointmentMock)).thenReturn(Optional.empty());
        var response = appointmentController.put(appointmentMock);
        Assertions.assertEquals(404, response.getStatusCodeValue());
    }

    /**
     * Testea que se haya actualizado un appointment
     */
    @Test
    void putAppointment() {
        Appointment appointmentMock = new Appointment();
        when(appointmentServiceMock.put(appointmentMock)).thenReturn(Optional.of(appointmentMock));
        var response = appointmentController.put(appointmentMock);
        Assertions.assertEquals(201, response.getStatusCodeValue());
    }

    /**
     * Testea una exception al eliminar un appointment
     */
    @Test
    void deleteException() {
        doThrow(new RuntimeException()).when(appointmentServiceMock).deleteById(anyInt());
        var response = appointmentController.delete(anyInt());
        Assertions.assertEquals(204, response.getStatusCodeValue());
    }

    /**
     * Testea que se haya eliminado un appointment
     */
    @Test
    void deleteById() {
        doNothing().when(appointmentServiceMock).deleteById(anyInt());
        var response = appointmentController.delete(anyInt());
        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    /**
     * Testea un appointment por affiliate
     */
    @Test
    void getByAffiliate() {
        List<Appointment> appointmentListMock = new ArrayList<>();
        appointmentListMock.add(new Appointment());
        when(appointmentServiceMock.getByAffiliate(anyInt())).thenReturn(appointmentListMock);
        var response = appointmentController.getByAffiliates(anyInt());
        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    /**
     * Testea una  appointment null al buscar por affiliate
     */
    @Test
    void getByAffiliateNull() {
        List<Appointment> appointmentListMock = new ArrayList<>();
        appointmentListMock.add(new Appointment());
        when(appointmentServiceMock.getByAffiliate(anyInt())).thenReturn(null);
        var response = appointmentController.getByAffiliates(anyInt());
        Assertions.assertEquals(204, response.getStatusCodeValue());

    }

    /**
     * Testea una  appointment vacia al buscar por affiliate
     */
    @Test
    void getByAffiliateEmpty() {
        List<Appointment> appointmentListMock = new ArrayList<>();
        appointmentListMock.add(new Appointment());
        when(appointmentServiceMock.getByAffiliate(anyInt())).thenReturn(Collections.emptyList());
        var response = appointmentController.getByAffiliates(anyInt());
        Assertions.assertEquals(204, response.getStatusCodeValue());

    }

    /**
     * Testea un appointment por fecha
     */
    @Test
    void getByDate() {
        Random random = new Random();
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(30) + 1;
        int year = random.nextInt(20) + 2000;
        LocalDate dateMock = LocalDate.of(year, month, day);
        List<Appointment> appointmentListMock = new ArrayList<>();
        appointmentListMock.add(new Appointment());
        when(appointmentServiceMock.getByDate(dateMock)).thenReturn(appointmentListMock);
        var response = appointmentController.getByDate(day, month, year);
        Assertions.assertEquals(200, response.getStatusCodeValue());
    }

    /**
     * Testea un appointment por una fecha null
     */
    @Test
    void getByDateEmpty() {
        Random random = new Random();
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(30) + 1;
        int year = random.nextInt(20) + 2000;
        LocalDate dateMock = LocalDate.of(year, month, day);
        when(appointmentServiceMock.getByDate(dateMock)).thenReturn(Collections.emptyList());
        var response = appointmentController.getByDate(day, month, year);
        Assertions.assertEquals(204, response.getStatusCodeValue());
    }

    /**
     * Testea una exception al buscar un appointment por fecha
     */
    @Test
    void getByDateExeption() {
        Random random = new Random();
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(30) + 1;
        int year = random.nextInt(20) + 2000;
        LocalDate dateMock = LocalDate.of(year, month, day);
        doThrow(new RuntimeException()).when(appointmentServiceMock).getByDate(dateMock);
        var response = appointmentController.getByDate(day, month, year);
        Assertions.assertEquals(204, response.getStatusCodeValue());
    }
}

