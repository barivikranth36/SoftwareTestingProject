package com.dd.eraktkendrabackend.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.DTO.BloodRecordDTO;
import com.dd.eraktkendrabackend.DTO.BloodRequestDTO;
import com.dd.eraktkendrabackend.Entity.BloodBank;
import com.dd.eraktkendrabackend.Entity.BloodRecord;
import com.dd.eraktkendrabackend.Entity.BloodRequest;
import com.dd.eraktkendrabackend.Entity.BloodRequestRecord;
import com.dd.eraktkendrabackend.Entity.User;
import com.dd.eraktkendrabackend.Repository.BloodBankRepository;
import com.dd.eraktkendrabackend.Repository.BloodRecordRepository;
import com.dd.eraktkendrabackend.Repository.BloodRequestRecordRepository;
import com.dd.eraktkendrabackend.Repository.BloodRequestRepository;
import com.dd.eraktkendrabackend.Repository.UserRepository;
import com.dd.eraktkendrabackend.Service.BloodRecordService;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BloodRequestServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BloodRequestServiceImplTest {
    @MockBean
    private BloodBankRepository bloodBankRepository;

    @MockBean
    private BloodRecordRepository bloodRecordRepository;

    @MockBean
    private BloodRecordService bloodRecordService;

    @MockBean
    private BloodRequestRecordRepository bloodRequestRecordRepository;

    @MockBean
    private BloodRequestRepository bloodRequestRepository;

    @Autowired
    private BloodRequestServiceImpl bloodRequestServiceImpl;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link BloodRequestServiceImpl#bloodRequestByUser(BloodRequestDTO)}
     */
    @Test
    void testBloodRequestByUser() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");
        Optional<BloodBank> ofResult = Optional.of(bloodBank);
        when(bloodBankRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        when(bloodRecordService.getBloodRecord(anyLong())).thenReturn(new ArrayList<>());

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
        Optional<User> ofResult2 = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);
        assertFalse(bloodRequestServiceImpl.bloodRequestByUser(new BloodRequestDTO(1L, "Blood Type", 1L, 1L)));
        verify(bloodBankRepository).findById(Mockito.<Long>any());
        verify(bloodRecordService).getBloodRecord(anyLong());
        verify(userRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BloodRequestServiceImpl#bloodRequestByUser(BloodRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBloodRequestByUser2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.dd.eraktkendrabackend.Service.ServiceImpl.BloodRequestServiceImpl.bloodRequestByUser(BloodRequestServiceImpl.java:46)
        //   See https://diff.blue/R013 to resolve this issue.

        when(bloodBankRepository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        when(bloodRecordService.getBloodRecord(anyLong())).thenReturn(new ArrayList<>());

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
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        bloodRequestServiceImpl.bloodRequestByUser(new BloodRequestDTO(1L, "Blood Type", 1L, 1L));
    }

    /**
     * Method under test: {@link BloodRequestServiceImpl#bloodRequestByUser(BloodRequestDTO)}
     */
    @Test
    void testBloodRequestByUser3() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");
        Optional<BloodBank> ofResult = Optional.of(bloodBank);
        when(bloodBankRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        ArrayList<BloodRecordDTO> bloodRecordDTOList = new ArrayList<>();
        bloodRecordDTOList.add(new BloodRecordDTO("User is requesting for some blood units...", 1L, 1L, 1L));
        when(bloodRecordService.getBloodRecord(anyLong())).thenReturn(bloodRecordDTOList);

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
        Optional<User> ofResult2 = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);
        assertFalse(bloodRequestServiceImpl.bloodRequestByUser(new BloodRequestDTO(1L, "Blood Type", 1L, 1L)));
        verify(bloodBankRepository).findById(Mockito.<Long>any());
        verify(bloodRecordService).getBloodRecord(anyLong());
        verify(userRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BloodRequestServiceImpl#bloodRequestByUser(BloodRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBloodRequestByUser4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.dd.eraktkendrabackend.Service.ServiceImpl.BloodRequestServiceImpl.bloodRequestByUser(BloodRequestServiceImpl.java:48)
        //   See https://diff.blue/R013 to resolve this issue.

        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");
        Optional<BloodBank> ofResult = Optional.of(bloodBank);
        when(bloodBankRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        when(bloodRecordService.getBloodRecord(anyLong())).thenReturn(new ArrayList<>());
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        bloodRequestServiceImpl.bloodRequestByUser(new BloodRequestDTO(1L, "Blood Type", 1L, 1L));
    }

    /**
     * Method under test: {@link BloodRequestServiceImpl#bloodRequestByUser(BloodRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBloodRequestByUser5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.dd.eraktkendrabackend.DTO.BloodRequestDTO.getBloodBankId()" because "bloodRequestDTO" is null
        //       at com.dd.eraktkendrabackend.Service.ServiceImpl.BloodRequestServiceImpl.bloodRequestByUser(BloodRequestServiceImpl.java:44)
        //   See https://diff.blue/R013 to resolve this issue.

        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");
        Optional<BloodBank> ofResult = Optional.of(bloodBank);
        when(bloodBankRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        when(bloodRecordService.getBloodRecord(anyLong())).thenReturn(new ArrayList<>());

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
        Optional<User> ofResult2 = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);
        bloodRequestServiceImpl.bloodRequestByUser(null);
    }

    /**
     * Method under test: {@link BloodRequestServiceImpl#bloodRequestByUser(BloodRequestDTO)}
     */
    @Test
    void testBloodRequestByUser6() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");
        Optional<BloodBank> ofResult = Optional.of(bloodBank);
        when(bloodBankRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        when(bloodRecordService.getBloodRecord(anyLong())).thenReturn(new ArrayList<>());

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
        Optional<User> ofResult2 = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);
        BloodRequestDTO bloodRequestDTO = mock(BloodRequestDTO.class);
        when(bloodRequestDTO.getBloodBankId()).thenReturn(1L);
        when(bloodRequestDTO.getUserId()).thenReturn(1L);
        assertFalse(bloodRequestServiceImpl.bloodRequestByUser(bloodRequestDTO));
        verify(bloodBankRepository).findById(Mockito.<Long>any());
        verify(bloodRecordService).getBloodRecord(anyLong());
        verify(userRepository).findById(Mockito.<Long>any());
        verify(bloodRequestDTO, atLeast(1)).getBloodBankId();
        verify(bloodRequestDTO).getUserId();
    }

    /**
     * Method under test: {@link BloodRequestServiceImpl#bloodRequestByUser(BloodRequestDTO)}
     */
    @Test
    void testBloodRequestByUser7() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");
        Optional<BloodBank> ofResult = Optional.of(bloodBank);
        when(bloodBankRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        ArrayList<BloodRecordDTO> bloodRecordDTOList = new ArrayList<>();
        bloodRecordDTOList.add(new BloodRecordDTO("User is requesting for some blood units...", 1L, 1L, 1L));
        when(bloodRecordService.getBloodRecord(anyLong())).thenReturn(bloodRecordDTOList);

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
        Optional<User> ofResult2 = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);
        BloodRequestDTO bloodRequestDTO = mock(BloodRequestDTO.class);
        when(bloodRequestDTO.getBloodType()).thenReturn("Blood Type");
        when(bloodRequestDTO.getBloodBankId()).thenReturn(1L);
        when(bloodRequestDTO.getUserId()).thenReturn(1L);
        assertFalse(bloodRequestServiceImpl.bloodRequestByUser(bloodRequestDTO));
        verify(bloodBankRepository).findById(Mockito.<Long>any());
        verify(bloodRecordService).getBloodRecord(anyLong());
        verify(userRepository).findById(Mockito.<Long>any());
        verify(bloodRequestDTO).getBloodType();
        verify(bloodRequestDTO, atLeast(1)).getBloodBankId();
        verify(bloodRequestDTO).getUserId();
    }

    /**
     * Method under test: {@link BloodRequestServiceImpl#checkBloodRequest(long)}
     */
    @Test
    void testCheckBloodRequest() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

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

        BloodRequest bloodRequest = new BloodRequest();
        bloodRequest.setBloodBank(bloodBank);
        bloodRequest.setBloodRequestId(1L);
        bloodRequest.setBloodType("Blood Type");
        bloodRequest.setQuantity(1L);
        bloodRequest.setTotalCost(1L);
        bloodRequest.setUser(user);
        when(bloodRequestRepository.findBloodRequestByUser_UserId(anyLong())).thenReturn(bloodRequest);
        assertTrue(bloodRequestServiceImpl.checkBloodRequest(1L));
        verify(bloodRequestRepository).findBloodRequestByUser_UserId(anyLong());
    }

    /**
     * Method under test: {@link BloodRequestServiceImpl#revokeBloodRequest(long)}
     */
    @Test
    void testRevokeBloodRequest() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

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

        BloodRequest bloodRequest = new BloodRequest();
        bloodRequest.setBloodBank(bloodBank);
        bloodRequest.setBloodRequestId(1L);
        bloodRequest.setBloodType("Blood Type");
        bloodRequest.setQuantity(1L);
        bloodRequest.setTotalCost(1L);
        bloodRequest.setUser(user);
        when(bloodRequestRepository.findBloodRequestByUser_UserId(anyLong())).thenReturn(bloodRequest);
        doNothing().when(bloodRequestRepository).delete(Mockito.<BloodRequest>any());
        assertTrue(bloodRequestServiceImpl.revokeBloodRequest(1L));
        verify(bloodRequestRepository).findBloodRequestByUser_UserId(anyLong());
        verify(bloodRequestRepository).delete(Mockito.<BloodRequest>any());
    }

    /**
     * Method under test: {@link BloodRequestServiceImpl#acceptBloodRequest(long)}
     */
    @Test
    void testAcceptBloodRequest() {
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

        BloodRequestRecord bloodRequestRecord = new BloodRequestRecord();
        bloodRequestRecord.setBankId(1L);
        bloodRequestRecord.setBloodType("Blood Type");
        bloodRequestRecord.setQuantity(1L);
        bloodRequestRecord.setRequestRecordId(1L);
        bloodRequestRecord.setTotalCost(1L);
        bloodRequestRecord.setUser(user);
        when(bloodRequestRecordRepository.save(Mockito.<BloodRequestRecord>any())).thenReturn(bloodRequestRecord);

        BloodBank bloodBank3 = new BloodBank();
        bloodBank3.setAddress("42 Main St");
        bloodBank3.setBloodBankId(1L);
        bloodBank3.setCity("Oxford");

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

        BloodRequest bloodRequest = new BloodRequest();
        bloodRequest.setBloodBank(bloodBank3);
        bloodRequest.setBloodRequestId(1L);
        bloodRequest.setBloodType("Blood Type");
        bloodRequest.setQuantity(1L);
        bloodRequest.setTotalCost(1L);
        bloodRequest.setUser(user2);
        Optional<BloodRequest> ofResult = Optional.of(bloodRequest);
        doNothing().when(bloodRequestRepository).delete(Mockito.<BloodRequest>any());
        when(bloodRequestRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertTrue(bloodRequestServiceImpl.acceptBloodRequest(1L));
        verify(bloodRecordRepository).findBloodRecordByBloodBank_BloodBankIdAndAndBloodType(anyLong(),
                Mockito.<String>any());
        verify(bloodRecordRepository).save(Mockito.<BloodRecord>any());
        verify(bloodRequestRecordRepository).save(Mockito.<BloodRequestRecord>any());
        verify(bloodRequestRepository).findById(Mockito.<Long>any());
        verify(bloodRequestRepository).delete(Mockito.<BloodRequest>any());
    }

    /**
     * Method under test: {@link BloodRequestServiceImpl#getAllBloodRequests(long)}
     */
    @Test
    void testGetAllBloodRequests() {
        when(bloodRequestRepository.findAllByBloodBank_BloodBankId(anyLong())).thenReturn(new ArrayList<>());
        assertTrue(bloodRequestServiceImpl.getAllBloodRequests(1L).isEmpty());
        verify(bloodRequestRepository).findAllByBloodBank_BloodBankId(anyLong());
    }

    /**
     * Method under test: {@link BloodRequestServiceImpl#getAllBloodRequests(long)}
     */
    @Test
    void testGetAllBloodRequests2() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

        User user = new User();
        user.setAddress("42 Main St");
        user.setBloodType("Fieldworker requests all the bloodreqeust of that particular bank...");
        user.setCity("Oxford");
        user.setCredit(1);
        user.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Fieldworker requests all the bloodreqeust of that particular bank...");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setPincode(1L);
        user.setTitle("Dr");
        user.setUserId(1L);

        BloodRequest bloodRequest = new BloodRequest();
        bloodRequest.setBloodBank(bloodBank);
        bloodRequest.setBloodRequestId(1L);
        bloodRequest.setBloodType("Fieldworker requests all the bloodreqeust of that particular bank...");
        bloodRequest.setQuantity(1L);
        bloodRequest.setTotalCost(1L);
        bloodRequest.setUser(user);

        ArrayList<BloodRequest> bloodRequestList = new ArrayList<>();
        bloodRequestList.add(bloodRequest);
        when(bloodRequestRepository.findAllByBloodBank_BloodBankId(anyLong())).thenReturn(bloodRequestList);
        assertEquals(1, bloodRequestServiceImpl.getAllBloodRequests(1L).size());
        verify(bloodRequestRepository).findAllByBloodBank_BloodBankId(anyLong());
    }

    /**
     * Method under test: {@link BloodRequestServiceImpl#getAllBloodRequests(long)}
     */
    @Test
    void testGetAllBloodRequests3() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

        User user = new User();
        user.setAddress("42 Main St");
        user.setBloodType("Fieldworker requests all the bloodreqeust of that particular bank...");
        user.setCity("Oxford");
        user.setCredit(1);
        user.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setEmailId("42");
        user.setFirstName("Jane");
        user.setGender("Fieldworker requests all the bloodreqeust of that particular bank...");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setPincode(1L);
        user.setTitle("Dr");
        user.setUserId(1L);

        BloodBank bloodBank2 = new BloodBank();
        bloodBank2.setAddress("42 Main St");
        bloodBank2.setBloodBankId(1L);
        bloodBank2.setCity("Oxford");

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
        BloodRequest bloodRequest = mock(BloodRequest.class);
        when(bloodRequest.getQuantity()).thenReturn(1L);
        when(bloodRequest.getTotalCost()).thenReturn(1L);
        when(bloodRequest.getUser()).thenReturn(user2);
        when(bloodRequest.getBloodType()).thenReturn("Blood Type");
        when(bloodRequest.getBloodBank()).thenReturn(bloodBank2);
        when(bloodRequest.getBloodRequestId()).thenReturn(1L);
        doNothing().when(bloodRequest).setBloodBank(Mockito.<BloodBank>any());
        doNothing().when(bloodRequest).setBloodRequestId(anyLong());
        doNothing().when(bloodRequest).setBloodType(Mockito.<String>any());
        doNothing().when(bloodRequest).setQuantity(anyLong());
        doNothing().when(bloodRequest).setTotalCost(anyLong());
        doNothing().when(bloodRequest).setUser(Mockito.<User>any());
        bloodRequest.setBloodBank(bloodBank);
        bloodRequest.setBloodRequestId(1L);
        bloodRequest.setBloodType("Fieldworker requests all the bloodreqeust of that particular bank...");
        bloodRequest.setQuantity(1L);
        bloodRequest.setTotalCost(1L);
        bloodRequest.setUser(user);

        ArrayList<BloodRequest> bloodRequestList = new ArrayList<>();
        bloodRequestList.add(bloodRequest);
        when(bloodRequestRepository.findAllByBloodBank_BloodBankId(anyLong())).thenReturn(bloodRequestList);
        assertEquals(1, bloodRequestServiceImpl.getAllBloodRequests(1L).size());
        verify(bloodRequestRepository).findAllByBloodBank_BloodBankId(anyLong());
        verify(bloodRequest).getBloodBank();
        verify(bloodRequest).getUser();
        verify(bloodRequest).getBloodType();
        verify(bloodRequest).getBloodRequestId();
        verify(bloodRequest).getQuantity();
        verify(bloodRequest).getTotalCost();
        verify(bloodRequest).setBloodBank(Mockito.<BloodBank>any());
        verify(bloodRequest).setBloodRequestId(anyLong());
        verify(bloodRequest).setBloodType(Mockito.<String>any());
        verify(bloodRequest).setQuantity(anyLong());
        verify(bloodRequest).setTotalCost(anyLong());
        verify(bloodRequest).setUser(Mockito.<User>any());
    }
}

