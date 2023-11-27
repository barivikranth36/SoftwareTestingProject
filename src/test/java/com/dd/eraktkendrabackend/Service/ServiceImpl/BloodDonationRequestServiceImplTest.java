package com.dd.eraktkendrabackend.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.DTO.AddBloodDTO;
import com.dd.eraktkendrabackend.DTO.BloodDonationRecordDTO;
import com.dd.eraktkendrabackend.DTO.BloodDonationRequestDTO;
import com.dd.eraktkendrabackend.Entity.BloodDonationRecord;
import com.dd.eraktkendrabackend.Entity.BloodDonationRequest;
import com.dd.eraktkendrabackend.Entity.User;
import com.dd.eraktkendrabackend.Repository.BLoodDonationRequestRepository;
import com.dd.eraktkendrabackend.Repository.BloodDonationRecordRepository;
import com.dd.eraktkendrabackend.Repository.UserRepository;
import com.dd.eraktkendrabackend.Service.BloodRecordService;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BloodDonationRequestServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BloodDonationRequestServiceImplTest {
    @MockBean
    private BLoodDonationRequestRepository bLoodDonationRequestRepository;

    @MockBean
    private BloodDonationRecordRepository bloodDonationRecordRepository;

    @Autowired
    private BloodDonationRequestServiceImpl bloodDonationRequestServiceImpl;

    @MockBean
    private BloodRecordService bloodRecordService;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link BloodDonationRequestServiceImpl#bloodDonationRequest(BloodDonationRequestDTO)}
     */
    @Test
    void testBloodDonationRequest() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setBloodType("Blood Type");
        user.setCity("Oxford");
        user.setCredit(1);
        user.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setPincode(1L);
        user.setTitle("Dr");
        user.setUserId(1L);

        BloodDonationRequest bloodDonationRequest = new BloodDonationRequest();
        bloodDonationRequest.setBankId(1L);
        bloodDonationRequest.setBloodType("Blood Type");
        bloodDonationRequest.setDonationRequestId(1L);
        bloodDonationRequest.setUser(user);
        when(bLoodDonationRequestRepository.save(Mockito.<BloodDonationRequest>any())).thenReturn(bloodDonationRequest);

        User user2 = new User();
        user2.setAddress("42 Main St");
        user2.setBloodType("Blood Type");
        user2.setCity("Oxford");
        user2.setCredit(1);
        user2.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setEmailId("42");
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setPincode(1L);
        user2.setTitle("Dr");
        user2.setUserId(1L);
        Optional<User> ofResult = Optional.of(user2);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertTrue(
                bloodDonationRequestServiceImpl.bloodDonationRequest(new BloodDonationRequestDTO(1L, "Blood Type", 1L)));
        verify(bLoodDonationRequestRepository).save(Mockito.<BloodDonationRequest>any());
        verify(userRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BloodDonationRequestServiceImpl#acceptBloodDonationRequest(long)}
     */
    @Test
    void testAcceptBloodDonationRequest() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setBloodType("Blood Type");
        user.setCity("Oxford");
        user.setCredit(1);
        user.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setPincode(1L);
        user.setTitle("Dr");
        user.setUserId(1L);

        BloodDonationRequest bloodDonationRequest = new BloodDonationRequest();
        bloodDonationRequest.setBankId(1L);
        bloodDonationRequest.setBloodType("Blood Type");
        bloodDonationRequest.setDonationRequestId(1L);
        bloodDonationRequest.setUser(user);
        Optional<BloodDonationRequest> ofResult = Optional.of(bloodDonationRequest);
        doNothing().when(bLoodDonationRequestRepository).delete(Mockito.<BloodDonationRequest>any());
        when(bLoodDonationRequestRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        User user2 = new User();
        user2.setAddress("42 Main St");
        user2.setBloodType("Blood Type");
        user2.setCity("Oxford");
        user2.setCredit(1);
        user2.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setEmailId("42");
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setPincode(1L);
        user2.setTitle("Dr");
        user2.setUserId(1L);

        BloodDonationRecord bloodDonationRecord = new BloodDonationRecord();
        bloodDonationRecord.setBloodBankId(1L);
        bloodDonationRecord.setBloodType("Blood Type");
        bloodDonationRecord
                .setDateOfDonation(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        bloodDonationRecord.setDonationRecordId(1L);
        bloodDonationRecord.setUser(user2);
        when(bloodDonationRecordRepository.save(Mockito.<BloodDonationRecord>any())).thenReturn(bloodDonationRecord);
        when(bloodRecordService.addBlood(Mockito.<AddBloodDTO>any())).thenReturn(true);

        User user3 = new User();
        user3.setAddress("42 Main St");
        user3.setBloodType("Blood Type");
        user3.setCity("Oxford");
        user3.setCredit(1);
        user3.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user3.setEmailId("42");
        user3.setFirstName("Jane");
        user3.setGender("Gender");
        user3.setLastName("Doe");
        user3.setPassword("iloveyou");
        user3.setPhoneNumber("6625550144");
        user3.setPincode(1L);
        user3.setTitle("Dr");
        user3.setUserId(1L);
        when(userRepository.save(Mockito.<User>any())).thenReturn(user3);
        assertTrue(bloodDonationRequestServiceImpl.acceptBloodDonationRequest(1L));
        verify(bLoodDonationRequestRepository).findById(Mockito.<Long>any());
        verify(bLoodDonationRequestRepository).delete(Mockito.<BloodDonationRequest>any());
        verify(bloodDonationRecordRepository).save(Mockito.<BloodDonationRecord>any());
        verify(bloodRecordService).addBlood(Mockito.<AddBloodDTO>any());
        verify(userRepository).save(Mockito.<User>any());
    }

    /**
     * Method under test: {@link BloodDonationRequestServiceImpl#revokeBloodDonationRequest(long)}
     */
    @Test
    void testRevokeBloodDonationRequest() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setBloodType("Blood Type");
        user.setCity("Oxford");
        user.setCredit(1);
        user.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setPincode(1L);
        user.setTitle("Dr");
        user.setUserId(1L);

        BloodDonationRequest bloodDonationRequest = new BloodDonationRequest();
        bloodDonationRequest.setBankId(1L);
        bloodDonationRequest.setBloodType("Blood Type");
        bloodDonationRequest.setDonationRequestId(1L);
        bloodDonationRequest.setUser(user);
        when(bLoodDonationRequestRepository.findByUser_UserId(anyLong())).thenReturn(bloodDonationRequest);
        doNothing().when(bLoodDonationRequestRepository).delete(Mockito.<BloodDonationRequest>any());
        assertTrue(bloodDonationRequestServiceImpl.revokeBloodDonationRequest(1L));
        verify(bLoodDonationRequestRepository).findByUser_UserId(anyLong());
        verify(bLoodDonationRequestRepository).delete(Mockito.<BloodDonationRequest>any());
    }

    /**
     * Method under test: {@link BloodDonationRequestServiceImpl#checkBloodDonationRequest(long)}
     */
    @Test
    void testCheckBloodDonationRequest() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setBloodType("Blood Type");
        user.setCity("Oxford");
        user.setCredit(1);
        user.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setPincode(1L);
        user.setTitle("Dr");
        user.setUserId(1L);

        BloodDonationRequest bloodDonationRequest = new BloodDonationRequest();
        bloodDonationRequest.setBankId(1L);
        bloodDonationRequest.setBloodType("Blood Type");
        bloodDonationRequest.setDonationRequestId(1L);
        bloodDonationRequest.setUser(user);
        when(bLoodDonationRequestRepository.findByUser_UserId(anyLong())).thenReturn(bloodDonationRequest);
        assertTrue(bloodDonationRequestServiceImpl.checkBloodDonationRequest(1L));
        verify(bLoodDonationRequestRepository).findByUser_UserId(anyLong());
    }

    /**
     * Method under test: {@link BloodDonationRequestServiceImpl#getAllBloodDonationRequests(long)}
     */
    @Test
    void testGetAllBloodDonationRequests() {
        when(bLoodDonationRequestRepository.findAllByBankId(anyLong())).thenReturn(new ArrayList<>());
        assertTrue(bloodDonationRequestServiceImpl.getAllBloodDonationRequests(1L).isEmpty());
        verify(bLoodDonationRequestRepository).findAllByBankId(anyLong());
    }

    /**
     * Method under test: {@link BloodDonationRequestServiceImpl#getAllBloodDonationRequests(long)}
     */
    @Test
    void testGetAllBloodDonationRequests2() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setBloodType("Get all the blood donation request for the  particular bank");
        user.setCity("Oxford");
        user.setCredit(1);
        user.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Get all the blood donation request for the  particular bank");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setPincode(1L);
        user.setTitle("Dr");
        user.setUserId(1L);

        BloodDonationRequest bloodDonationRequest = new BloodDonationRequest();
        bloodDonationRequest.setBankId(1L);
        bloodDonationRequest.setBloodType("Get all the blood donation request for the  particular bank");
        bloodDonationRequest.setDonationRequestId(1L);
        bloodDonationRequest.setUser(user);

        ArrayList<BloodDonationRequest> bloodDonationRequestList = new ArrayList<>();
        bloodDonationRequestList.add(bloodDonationRequest);
        when(bLoodDonationRequestRepository.findAllByBankId(anyLong())).thenReturn(bloodDonationRequestList);
        List<BloodDonationRequestDTO> actualAllBloodDonationRequests = bloodDonationRequestServiceImpl
                .getAllBloodDonationRequests(1L);
        assertEquals(1, actualAllBloodDonationRequests.size());
        BloodDonationRequestDTO getResult = actualAllBloodDonationRequests.get(0);
        assertEquals(1L, getResult.getBankId());
        assertEquals(1L, getResult.getUserId());
        assertEquals("Get all the blood donation request for the  particular bank", getResult.getBloodType());
        assertEquals(1L, getResult.getBloodDonationRequestId());
        verify(bLoodDonationRequestRepository).findAllByBankId(anyLong());
    }

    /**
     * Method under test: {@link BloodDonationRequestServiceImpl#getBloodDonationHistory(long)}
     */
    @Test
    void testGetBloodDonationHistory() {
        when(bloodDonationRecordRepository.findAllByUser_UserId(anyLong())).thenReturn(new ArrayList<>());
        assertTrue(bloodDonationRequestServiceImpl.getBloodDonationHistory(1L).isEmpty());
        verify(bloodDonationRecordRepository).findAllByUser_UserId(anyLong());
    }

    /**
     * Method under test: {@link BloodDonationRequestServiceImpl#getBloodDonationHistory(long)}
     */
    @Test
    void testGetBloodDonationHistory2() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setBloodType("user requesting for his/her blood donation history...");
        user.setCity("Oxford");
        user.setCredit(1);
        user.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("user requesting for his/her blood donation history...");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setPincode(1L);
        user.setTitle("Dr");
        user.setUserId(1L);

        BloodDonationRecord bloodDonationRecord = new BloodDonationRecord();
        bloodDonationRecord.setBloodBankId(1L);
        bloodDonationRecord.setBloodType("user requesting for his/her blood donation history...");
        Date dateOfDonation = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        bloodDonationRecord.setDateOfDonation(dateOfDonation);
        bloodDonationRecord.setDonationRecordId(1L);
        bloodDonationRecord.setUser(user);

        ArrayList<BloodDonationRecord> bloodDonationRecordList = new ArrayList<>();
        bloodDonationRecordList.add(bloodDonationRecord);
        when(bloodDonationRecordRepository.findAllByUser_UserId(anyLong())).thenReturn(bloodDonationRecordList);
        List<BloodDonationRecordDTO> actualBloodDonationHistory = bloodDonationRequestServiceImpl
                .getBloodDonationHistory(1L);
        assertEquals(1, actualBloodDonationHistory.size());
        BloodDonationRecordDTO getResult = actualBloodDonationHistory.get(0);
        assertEquals(1L, getResult.getBloodBankId());
        assertEquals(1L, getResult.getUserId());
        assertEquals(1L, getResult.getDonationRecordId());
        assertSame(dateOfDonation, getResult.getDateOfDonation());
        assertEquals("user requesting for his/her blood donation history...", getResult.getBloodType());
        verify(bloodDonationRecordRepository).findAllByUser_UserId(anyLong());
    }

    /**
     * Method under test: {@link BloodDonationRequestServiceImpl#getBloodDonationHistory(long)}
     */
    @Test
    void testGetBloodDonationHistory3() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setBloodType("user requesting for his/her blood donation history...");
        user.setCity("Oxford");
        user.setCredit(1);
        user.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("user requesting for his/her blood donation history...");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setPincode(1L);
        user.setTitle("Dr");
        user.setUserId(1L);

        User user2 = new User();
        user2.setAddress("42 Main St");
        user2.setBloodType("Blood Type");
        user2.setCity("Oxford");
        user2.setCredit(1);
        user2.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setEmailId("42");
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setPincode(1L);
        user2.setTitle("Dr");
        user2.setUserId(1L);
        BloodDonationRecord bloodDonationRecord = mock(BloodDonationRecord.class);
        when(bloodDonationRecord.getBloodType()).thenReturn("Blood Type");
        Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        when(bloodDonationRecord.getDateOfDonation()).thenReturn(fromResult);
        when(bloodDonationRecord.getBloodBankId()).thenReturn(1L);
        when(bloodDonationRecord.getUser()).thenReturn(user2);
        when(bloodDonationRecord.getDonationRecordId()).thenReturn(1L);
        doNothing().when(bloodDonationRecord).setBloodBankId(anyLong());
        doNothing().when(bloodDonationRecord).setBloodType(Mockito.<String>any());
        doNothing().when(bloodDonationRecord).setDateOfDonation(Mockito.<Date>any());
        doNothing().when(bloodDonationRecord).setDonationRecordId(anyLong());
        doNothing().when(bloodDonationRecord).setUser(Mockito.<User>any());
        bloodDonationRecord.setBloodBankId(1L);
        bloodDonationRecord.setBloodType("user requesting for his/her blood donation history...");
        bloodDonationRecord
                .setDateOfDonation(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        bloodDonationRecord.setDonationRecordId(1L);
        bloodDonationRecord.setUser(user);

        ArrayList<BloodDonationRecord> bloodDonationRecordList = new ArrayList<>();
        bloodDonationRecordList.add(bloodDonationRecord);
        when(bloodDonationRecordRepository.findAllByUser_UserId(anyLong())).thenReturn(bloodDonationRecordList);
        List<BloodDonationRecordDTO> actualBloodDonationHistory = bloodDonationRequestServiceImpl
                .getBloodDonationHistory(1L);
        assertEquals(1, actualBloodDonationHistory.size());
        BloodDonationRecordDTO getResult = actualBloodDonationHistory.get(0);
        assertEquals(1L, getResult.getBloodBankId());
        assertEquals(1L, getResult.getUserId());
        assertEquals(1L, getResult.getDonationRecordId());
        assertSame(fromResult, getResult.getDateOfDonation());
        assertEquals("Blood Type", getResult.getBloodType());
        verify(bloodDonationRecordRepository).findAllByUser_UserId(anyLong());
        verify(bloodDonationRecord).getUser();
        verify(bloodDonationRecord).getBloodType();
        verify(bloodDonationRecord).getDateOfDonation();
        verify(bloodDonationRecord).getBloodBankId();
        verify(bloodDonationRecord).getDonationRecordId();
        verify(bloodDonationRecord).setBloodBankId(anyLong());
        verify(bloodDonationRecord).setBloodType(Mockito.<String>any());
        verify(bloodDonationRecord).setDateOfDonation(Mockito.<Date>any());
        verify(bloodDonationRecord).setDonationRecordId(anyLong());
        verify(bloodDonationRecord).setUser(Mockito.<User>any());
    }
}

