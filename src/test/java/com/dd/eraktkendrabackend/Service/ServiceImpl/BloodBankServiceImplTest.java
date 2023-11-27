package com.dd.eraktkendrabackend.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.DTO.BloodBankCityAndIdDTO;
import com.dd.eraktkendrabackend.Entity.BloodBank;
import com.dd.eraktkendrabackend.Repository.BloodBankRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BloodBankServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BloodBankServiceImplTest {
    @MockBean
    private BloodBankRepository bloodBankRepository;

    @Autowired
    private BloodBankServiceImpl bloodBankServiceImpl;

    /**
     * Method under test: {@link BloodBankServiceImpl#getBloodBankCities()}
     */
    @Test
    void testGetBloodBankCities() {
        when(bloodBankRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(bloodBankServiceImpl.getBloodBankCities().isEmpty());
        verify(bloodBankRepository).findAll();
    }

    /**
     * Method under test: {@link BloodBankServiceImpl#getBloodBankCities()}
     */
    @Test
    void testGetBloodBankCities2() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

        ArrayList<BloodBank> bloodBankList = new ArrayList<>();
        bloodBankList.add(bloodBank);
        when(bloodBankRepository.findAll()).thenReturn(bloodBankList);
        List<BloodBankCityAndIdDTO> actualBloodBankCities = bloodBankServiceImpl.getBloodBankCities();
        assertEquals(1, actualBloodBankCities.size());
        BloodBankCityAndIdDTO getResult = actualBloodBankCities.get(0);
        assertEquals(1L, getResult.getBankId());
        assertEquals("Oxford", getResult.getCity());
        verify(bloodBankRepository).findAll();
    }
}

