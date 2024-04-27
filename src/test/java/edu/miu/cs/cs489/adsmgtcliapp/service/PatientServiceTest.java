package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsmgtcliapp.model.Patient;
import edu.miu.cs.cs489.adsmgtcliapp.model.PatientDTO;
import edu.miu.cs.cs489.adsmgtcliapp.repository.PatientRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.implementation.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class PatientServiceTest {

    PatientService patientService;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ModelMapper modelMapper;



    @BeforeEach
    public void setUp() {
        patientService = new PatientService(patientRepository, modelMapper);
    }


    @Test
    public void testAddPatientReturnsDTO() {
        Patient patient = new Patient(1, "chris", "afans", "c.a@gmail.com", "768-786-9090", LocalDate.of(2000, 9,9), null, null);
        PatientDTO patientDTO = patientService.addPatient(patient);
        System.out.println(patientDTO.toString());
        assertInstanceOf(PatientDTO.class, patientDTO);
    }

//    @Test
//    public void testFindPatientReturnsRightPatientDTO() throws PatientNotFoundException {
//        Integer patientId = 1;
//        PatientDTO patientDTO = patientService.searchPatientById(patientId);
//        assertEquals(patientId, patientDTO.getPatient_id());
//    }
}
