package edu.miu.cs.cs489.adsmgtcliapp.service;

import edu.miu.cs.cs489.adsmgtcliapp.dto.AddressDTO;
import edu.miu.cs.cs489.adsmgtcliapp.model.Address;
import edu.miu.cs.cs489.adsmgtcliapp.repository.AddressRepository;
import edu.miu.cs.cs489.adsmgtcliapp.service.implementation.AddressService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.*;


public class AddressServiceTest {




    @Mock
    AddressService addressService;

    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.initMocks(this);

        addressService = new AddressService(mock(AddressRepository.class), mock(ModelMapper.class));

    }


    @Test
    public void  verifyAddAddressIsCalled(){
        addressService=Mockito.mock(AddressService.class);
        when(addressService.addAddress(Mockito.any(Address.class))).thenReturn(Mockito.any(AddressDTO.class));
        verify(addressService, times(1)).addAddress(Mockito.any(Address.class));

        //assertInstanceOf(AddressDTO.class, addressService.addAddress(Mockito.any(Address.class)));
    }

}
