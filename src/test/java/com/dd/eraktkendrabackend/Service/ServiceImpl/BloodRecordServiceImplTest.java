package com.dd.eraktkendrabackend.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.DTO.AddBloodDTO;
import com.dd.eraktkendrabackend.DTO.BloodRecordDTO;
import com.dd.eraktkendrabackend.Entity.BloodBank;
import com.dd.eraktkendrabackend.Entity.BloodRecord;
import com.dd.eraktkendrabackend.Repository.BloodRecordRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BloodRecordServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BloodRecordServiceImplTest {
    @MockBean
    private BloodRecordRepository bloodRecordRepository;

    @Autowired
    private BloodRecordServiceImpl bloodRecordServiceImpl;

    /**
     * Method under test: {@link BloodRecordServiceImpl#addBlood(AddBloodDTO)}
     */
    @Test
    void testAddBlood() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

        BloodRecord bloodRecord = new BloodRecord();
        bloodRecord.setBloodBank(bloodBank);
        bloodRecord.setBloodRecordId(1L);
        bloodRecord.setBloodType("Blood Type");
        bloodRecord.setCostPerUnit(1L);
        bloodRecord.setQuantity(1L);

        BloodBank bloodBank2 = new BloodBank();
        bloodBank2.setAddress("42 Main St");
        bloodBank2.setBloodBankId(1L);
        bloodBank2.setCity("Oxford");

        BloodRecord bloodRecord2 = new BloodRecord();
        bloodRecord2.setBloodBank(bloodBank2);
        bloodRecord2.setBloodRecordId(1L);
        bloodRecord2.setBloodType("Blood Type");
        bloodRecord2.setCostPerUnit(1L);
        bloodRecord2.setQuantity(1L);
        when(bloodRecordRepository.save(Mockito.<BloodRecord>any())).thenReturn(bloodRecord2);
        when(bloodRecordRepository.findBloodRecordByBloodBank_BloodBankIdAndAndBloodType(anyLong(), Mockito.<String>any()))
                .thenReturn(bloodRecord);
        assertTrue(bloodRecordServiceImpl.addBlood(new AddBloodDTO(1L, "Blood Type")));
        verify(bloodRecordRepository).findBloodRecordByBloodBank_BloodBankIdAndAndBloodType(anyLong(),
                Mockito.<String>any());
        verify(bloodRecordRepository).save(Mockito.<BloodRecord>any());
    }

    /**
     * Method under test: {@link BloodRecordServiceImpl#addBlood(AddBloodDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddBlood2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.dd.eraktkendrabackend.DTO.AddBloodDTO.getBloodBankId()" because "addBloodDTO" is null
        //       at com.dd.eraktkendrabackend.Service.ServiceImpl.BloodRecordServiceImpl.addBlood(BloodRecordServiceImpl.java:28)
        //   See https://diff.blue/R013 to resolve this issue.

        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

        BloodRecord bloodRecord = new BloodRecord();
        bloodRecord.setBloodBank(bloodBank);
        bloodRecord.setBloodRecordId(1L);
        bloodRecord.setBloodType("Blood Type");
        bloodRecord.setCostPerUnit(1L);
        bloodRecord.setQuantity(1L);

        BloodBank bloodBank2 = new BloodBank();
        bloodBank2.setAddress("42 Main St");
        bloodBank2.setBloodBankId(1L);
        bloodBank2.setCity("Oxford");

        BloodRecord bloodRecord2 = new BloodRecord();
        bloodRecord2.setBloodBank(bloodBank2);
        bloodRecord2.setBloodRecordId(1L);
        bloodRecord2.setBloodType("Blood Type");
        bloodRecord2.setCostPerUnit(1L);
        bloodRecord2.setQuantity(1L);
        when(bloodRecordRepository.save(Mockito.<BloodRecord>any())).thenReturn(bloodRecord2);
        when(
                bloodRecordRepository.findBloodRecordByBloodBank_BloodBankIdAndAndBloodType(anyLong(), Mockito.<String>any()))
                .thenReturn(bloodRecord);
        bloodRecordServiceImpl.addBlood(null);
    }

    /**
     * Method under test: {@link BloodRecordServiceImpl#getBloodRecord(long)}
     */
    @Test
    void testGetBloodRecord() {
        when(bloodRecordRepository.findAllByBloodBank_BloodBankId(anyLong())).thenReturn(new ArrayList<>());
        assertTrue(bloodRecordServiceImpl.getBloodRecord(1L).isEmpty());
        verify(bloodRecordRepository).findAllByBloodBank_BloodBankId(anyLong());
    }

    /**
     * Method under test: {@link BloodRecordServiceImpl#getBloodRecord(long)}
     */
    @Test
    void testGetBloodRecord2() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

        BloodRecord bloodRecord = new BloodRecord();
        bloodRecord.setBloodBank(bloodBank);
        bloodRecord.setBloodRecordId(1L);
        bloodRecord.setBloodType("Getting all the blood records of a particular bank.");
        bloodRecord.setCostPerUnit(1L);
        bloodRecord.setQuantity(1L);

        ArrayList<BloodRecord> bloodRecordList = new ArrayList<>();
        bloodRecordList.add(bloodRecord);
        when(bloodRecordRepository.findAllByBloodBank_BloodBankId(anyLong())).thenReturn(bloodRecordList);
        List<BloodRecordDTO> actualBloodRecord = bloodRecordServiceImpl.getBloodRecord(1L);
        assertEquals(1, actualBloodRecord.size());
        BloodRecordDTO getResult = actualBloodRecord.get(0);
        assertEquals(1L, getResult.getBloodBankId());
        assertEquals(1L, getResult.getQuantity());
        assertEquals(1L, getResult.getCostPerUnit());
        assertEquals("Getting all the blood records of a particular bank.", getResult.getBloodType());
        verify(bloodRecordRepository).findAllByBloodBank_BloodBankId(anyLong());
    }
}

