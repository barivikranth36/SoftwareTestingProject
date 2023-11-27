package com.dd.eraktkendrabackend.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.DTO.FieldWorkerDTO;
import com.dd.eraktkendrabackend.DTO.LoginDTO;
import com.dd.eraktkendrabackend.Entity.BloodBank;
import com.dd.eraktkendrabackend.Entity.FieldWorker;
import com.dd.eraktkendrabackend.Repository.BloodBankRepository;
import com.dd.eraktkendrabackend.Repository.FieldWorkerRepository;

import java.time.LocalDate;
import java.time.ZoneOffset;
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

@ContextConfiguration(classes = {FieldWorkerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class FieldWorkerServiceImplTest {
    @MockBean
    private BloodBankRepository bloodBankRepository;

    @MockBean
    private FieldWorkerRepository fieldWorkerRepository;

    @Autowired
    private FieldWorkerServiceImpl fieldWorkerServiceImpl;

    /**
     * Method under test: {@link FieldWorkerServiceImpl#registerFieldWorker(FieldWorkerDTO)}
     */
    @Test
    void testRegisterFieldWorker() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");
        Optional<BloodBank> ofResult = Optional.of(bloodBank);
        when(bloodBankRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        BloodBank bloodBank2 = new BloodBank();
        bloodBank2.setAddress("42 Main St");
        bloodBank2.setBloodBankId(1L);
        bloodBank2.setCity("Oxford");

        FieldWorker fieldWorker = new FieldWorker();
        fieldWorker.setAddress("42 Main St");
        fieldWorker.setBloodBank(bloodBank2);
        fieldWorker.setCity("Oxford");
        fieldWorker.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        fieldWorker.setEmailId("42");
        fieldWorker.setFirstName("Jane");
        fieldWorker.setGender("Gender");
        fieldWorker.setLastName("Doe");
        fieldWorker.setPassword("iloveyou");
        fieldWorker.setPhoneNumber("6625550144");
        fieldWorker.setPincode(1L);
        fieldWorker.setTitle("Dr");
        fieldWorker.setWorkerId(1L);
        when(fieldWorkerRepository.save(Mockito.<FieldWorker>any())).thenReturn(fieldWorker);
        FieldWorkerDTO fieldWorkerDTO = new FieldWorkerDTO();
        assertSame(fieldWorkerDTO, fieldWorkerServiceImpl.registerFieldWorker(fieldWorkerDTO));
        verify(bloodBankRepository).findById(Mockito.<Long>any());
        verify(fieldWorkerRepository).save(Mockito.<FieldWorker>any());
    }

    /**
     * Method under test: {@link FieldWorkerServiceImpl#registerFieldWorker(FieldWorkerDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterFieldWorker2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.dd.eraktkendrabackend.Service.ServiceImpl.FieldWorkerServiceImpl.registerFieldWorker(FieldWorkerServiceImpl.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        when(bloodBankRepository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());

        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

        FieldWorker fieldWorker = new FieldWorker();
        fieldWorker.setAddress("42 Main St");
        fieldWorker.setBloodBank(bloodBank);
        fieldWorker.setCity("Oxford");
        fieldWorker.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        fieldWorker.setEmailId("42");
        fieldWorker.setFirstName("Jane");
        fieldWorker.setGender("Gender");
        fieldWorker.setLastName("Doe");
        fieldWorker.setPassword("iloveyou");
        fieldWorker.setPhoneNumber("6625550144");
        fieldWorker.setPincode(1L);
        fieldWorker.setTitle("Dr");
        fieldWorker.setWorkerId(1L);
        when(fieldWorkerRepository.save(Mockito.<FieldWorker>any())).thenReturn(fieldWorker);
        fieldWorkerServiceImpl.registerFieldWorker(new FieldWorkerDTO());
    }

    /**
     * Method under test: {@link FieldWorkerServiceImpl#registerFieldWorker(FieldWorkerDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterFieldWorker3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.dd.eraktkendrabackend.DTO.FieldWorkerDTO.getBloodBankId()" because "fieldWorkerDTO" is null
        //       at com.dd.eraktkendrabackend.Service.ServiceImpl.FieldWorkerServiceImpl.registerFieldWorker(FieldWorkerServiceImpl.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");
        Optional<BloodBank> ofResult = Optional.of(bloodBank);
        when(bloodBankRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        BloodBank bloodBank2 = new BloodBank();
        bloodBank2.setAddress("42 Main St");
        bloodBank2.setBloodBankId(1L);
        bloodBank2.setCity("Oxford");

        FieldWorker fieldWorker = new FieldWorker();
        fieldWorker.setAddress("42 Main St");
        fieldWorker.setBloodBank(bloodBank2);
        fieldWorker.setCity("Oxford");
        fieldWorker.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        fieldWorker.setEmailId("42");
        fieldWorker.setFirstName("Jane");
        fieldWorker.setGender("Gender");
        fieldWorker.setLastName("Doe");
        fieldWorker.setPassword("iloveyou");
        fieldWorker.setPhoneNumber("6625550144");
        fieldWorker.setPincode(1L);
        fieldWorker.setTitle("Dr");
        fieldWorker.setWorkerId(1L);
        when(fieldWorkerRepository.save(Mockito.<FieldWorker>any())).thenReturn(fieldWorker);
        fieldWorkerServiceImpl.registerFieldWorker(null);
    }

    /**
     * Method under test: {@link FieldWorkerServiceImpl#registerFieldWorker(FieldWorkerDTO)}
     */
    @Test
    void testRegisterFieldWorker4() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");
        Optional<BloodBank> ofResult = Optional.of(bloodBank);
        when(bloodBankRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        BloodBank bloodBank2 = new BloodBank();
        bloodBank2.setAddress("42 Main St");
        bloodBank2.setBloodBankId(1L);
        bloodBank2.setCity("Oxford");

        FieldWorker fieldWorker = new FieldWorker();
        fieldWorker.setAddress("42 Main St");
        fieldWorker.setBloodBank(bloodBank2);
        fieldWorker.setCity("Oxford");
        fieldWorker.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        fieldWorker.setEmailId("42");
        fieldWorker.setFirstName("Jane");
        fieldWorker.setGender("Gender");
        fieldWorker.setLastName("Doe");
        fieldWorker.setPassword("iloveyou");
        fieldWorker.setPhoneNumber("6625550144");
        fieldWorker.setPincode(1L);
        fieldWorker.setTitle("Dr");
        fieldWorker.setWorkerId(1L);
        when(fieldWorkerRepository.save(Mockito.<FieldWorker>any())).thenReturn(fieldWorker);
        FieldWorkerDTO fieldWorkerDTO = mock(FieldWorkerDTO.class);
        when(fieldWorkerDTO.getAddress()).thenReturn("42 Main St");
        when(fieldWorkerDTO.getCity()).thenReturn("Oxford");
        when(fieldWorkerDTO.getEmailId()).thenReturn("42");
        when(fieldWorkerDTO.getFirstName()).thenReturn("Jane");
        when(fieldWorkerDTO.getGender()).thenReturn("Gender");
        when(fieldWorkerDTO.getLastName()).thenReturn("Doe");
        when(fieldWorkerDTO.getPassword()).thenReturn("iloveyou");
        when(fieldWorkerDTO.getPhoneNumber()).thenReturn("6625550144");
        when(fieldWorkerDTO.getTitle()).thenReturn("Dr");
        when(fieldWorkerDTO.getDob())
                .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(fieldWorkerDTO.getBloodBankId()).thenReturn(1L);
        when(fieldWorkerDTO.getPincode()).thenReturn(1L);
        assertSame(fieldWorkerDTO, fieldWorkerServiceImpl.registerFieldWorker(fieldWorkerDTO));
        verify(bloodBankRepository).findById(Mockito.<Long>any());
        verify(fieldWorkerRepository).save(Mockito.<FieldWorker>any());
        verify(fieldWorkerDTO).getAddress();
        verify(fieldWorkerDTO).getCity();
        verify(fieldWorkerDTO).getEmailId();
        verify(fieldWorkerDTO).getFirstName();
        verify(fieldWorkerDTO).getGender();
        verify(fieldWorkerDTO).getLastName();
        verify(fieldWorkerDTO).getPassword();
        verify(fieldWorkerDTO).getPhoneNumber();
        verify(fieldWorkerDTO).getTitle();
        verify(fieldWorkerDTO).getDob();
        verify(fieldWorkerDTO).getBloodBankId();
        verify(fieldWorkerDTO).getPincode();
    }

    /**
     * Method under test: {@link FieldWorkerServiceImpl#fieldWorkerLogin(LoginDTO)}
     */
    @Test
    void testFieldWorkerLogin() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

        FieldWorker fieldWorker = new FieldWorker();
        fieldWorker.setAddress("42 Main St");
        fieldWorker.setBloodBank(bloodBank);
        fieldWorker.setCity("Oxford");
        Date dob = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        fieldWorker.setDob(dob);
        fieldWorker.setEmailId("42");
        fieldWorker.setFirstName("Jane");
        fieldWorker.setGender("Gender");
        fieldWorker.setLastName("Doe");
        fieldWorker.setPassword("iloveyou");
        fieldWorker.setPhoneNumber("6625550144");
        fieldWorker.setPincode(1L);
        fieldWorker.setTitle("Dr");
        fieldWorker.setWorkerId(1L);
        when(fieldWorkerRepository.findByEmailId(Mockito.<String>any())).thenReturn(fieldWorker);
        FieldWorkerDTO actualFieldWorkerLoginResult = fieldWorkerServiceImpl
                .fieldWorkerLogin(new LoginDTO("janedoe", "iloveyou"));
        assertEquals("42 Main St", actualFieldWorkerLoginResult.getAddress());
        assertEquals(1L, actualFieldWorkerLoginResult.getWorkerId());
        assertEquals("Dr", actualFieldWorkerLoginResult.getTitle());
        assertEquals(1L, actualFieldWorkerLoginResult.getPincode());
        assertEquals("6625550144", actualFieldWorkerLoginResult.getPhoneNumber());
        assertEquals("Doe", actualFieldWorkerLoginResult.getLastName());
        assertEquals("Gender", actualFieldWorkerLoginResult.getGender());
        assertEquals("Jane", actualFieldWorkerLoginResult.getFirstName());
        assertEquals("42", actualFieldWorkerLoginResult.getEmailId());
        assertSame(dob, actualFieldWorkerLoginResult.getDob());
        assertEquals("Oxford", actualFieldWorkerLoginResult.getCity());
        assertEquals(1L, actualFieldWorkerLoginResult.getBloodBankId());
        verify(fieldWorkerRepository).findByEmailId(Mockito.<String>any());
    }

    /**
     * Method under test: {@link FieldWorkerServiceImpl#fieldWorkerLogin(LoginDTO)}
     */
    @Test
    void testFieldWorkerLogin2() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

        BloodBank bloodBank2 = new BloodBank();
        bloodBank2.setAddress("42 Main St");
        bloodBank2.setBloodBankId(1L);
        bloodBank2.setCity("Oxford");
        FieldWorker fieldWorker = mock(FieldWorker.class);
        when(fieldWorker.getBloodBank()).thenReturn(bloodBank2);
        when(fieldWorker.getAddress()).thenReturn("42 Main St");
        when(fieldWorker.getCity()).thenReturn("Oxford");
        when(fieldWorker.getEmailId()).thenReturn("42");
        when(fieldWorker.getFirstName()).thenReturn("Jane");
        when(fieldWorker.getGender()).thenReturn("Gender");
        when(fieldWorker.getLastName()).thenReturn("Doe");
        when(fieldWorker.getPhoneNumber()).thenReturn("6625550144");
        when(fieldWorker.getTitle()).thenReturn("Dr");
        Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        when(fieldWorker.getDob()).thenReturn(fromResult);
        when(fieldWorker.getPincode()).thenReturn(1L);
        when(fieldWorker.getWorkerId()).thenReturn(1L);
        when(fieldWorker.getPassword()).thenReturn("iloveyou");
        doNothing().when(fieldWorker).setAddress(Mockito.<String>any());
        doNothing().when(fieldWorker).setBloodBank(Mockito.<BloodBank>any());
        doNothing().when(fieldWorker).setCity(Mockito.<String>any());
        doNothing().when(fieldWorker).setDob(Mockito.<Date>any());
        doNothing().when(fieldWorker).setEmailId(Mockito.<String>any());
        doNothing().when(fieldWorker).setFirstName(Mockito.<String>any());
        doNothing().when(fieldWorker).setGender(Mockito.<String>any());
        doNothing().when(fieldWorker).setLastName(Mockito.<String>any());
        doNothing().when(fieldWorker).setPassword(Mockito.<String>any());
        doNothing().when(fieldWorker).setPhoneNumber(Mockito.<String>any());
        doNothing().when(fieldWorker).setPincode(anyLong());
        doNothing().when(fieldWorker).setTitle(Mockito.<String>any());
        doNothing().when(fieldWorker).setWorkerId(anyLong());
        fieldWorker.setAddress("42 Main St");
        fieldWorker.setBloodBank(bloodBank);
        fieldWorker.setCity("Oxford");
        fieldWorker.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        fieldWorker.setEmailId("42");
        fieldWorker.setFirstName("Jane");
        fieldWorker.setGender("Gender");
        fieldWorker.setLastName("Doe");
        fieldWorker.setPassword("iloveyou");
        fieldWorker.setPhoneNumber("6625550144");
        fieldWorker.setPincode(1L);
        fieldWorker.setTitle("Dr");
        fieldWorker.setWorkerId(1L);
        when(fieldWorkerRepository.findByEmailId(Mockito.<String>any())).thenReturn(fieldWorker);
        FieldWorkerDTO actualFieldWorkerLoginResult = fieldWorkerServiceImpl
                .fieldWorkerLogin(new LoginDTO("janedoe", "iloveyou"));
        assertEquals("42 Main St", actualFieldWorkerLoginResult.getAddress());
        assertEquals(1L, actualFieldWorkerLoginResult.getWorkerId());
        assertEquals("Dr", actualFieldWorkerLoginResult.getTitle());
        assertEquals(1L, actualFieldWorkerLoginResult.getPincode());
        assertEquals("6625550144", actualFieldWorkerLoginResult.getPhoneNumber());
        assertEquals("Doe", actualFieldWorkerLoginResult.getLastName());
        assertEquals("Gender", actualFieldWorkerLoginResult.getGender());
        assertEquals("Jane", actualFieldWorkerLoginResult.getFirstName());
        assertEquals("42", actualFieldWorkerLoginResult.getEmailId());
        assertSame(fromResult, actualFieldWorkerLoginResult.getDob());
        assertEquals("Oxford", actualFieldWorkerLoginResult.getCity());
        assertEquals(1L, actualFieldWorkerLoginResult.getBloodBankId());
        verify(fieldWorkerRepository).findByEmailId(Mockito.<String>any());
        verify(fieldWorker).getBloodBank();
        verify(fieldWorker).getAddress();
        verify(fieldWorker).getCity();
        verify(fieldWorker).getEmailId();
        verify(fieldWorker).getFirstName();
        verify(fieldWorker).getGender();
        verify(fieldWorker).getLastName();
        verify(fieldWorker).getPassword();
        verify(fieldWorker).getPhoneNumber();
        verify(fieldWorker).getTitle();
        verify(fieldWorker).getDob();
        verify(fieldWorker).getPincode();
        verify(fieldWorker).getWorkerId();
        verify(fieldWorker).setAddress(Mockito.<String>any());
        verify(fieldWorker).setBloodBank(Mockito.<BloodBank>any());
        verify(fieldWorker).setCity(Mockito.<String>any());
        verify(fieldWorker).setDob(Mockito.<Date>any());
        verify(fieldWorker).setEmailId(Mockito.<String>any());
        verify(fieldWorker).setFirstName(Mockito.<String>any());
        verify(fieldWorker).setGender(Mockito.<String>any());
        verify(fieldWorker).setLastName(Mockito.<String>any());
        verify(fieldWorker).setPassword(Mockito.<String>any());
        verify(fieldWorker).setPhoneNumber(Mockito.<String>any());
        verify(fieldWorker).setPincode(anyLong());
        verify(fieldWorker).setTitle(Mockito.<String>any());
        verify(fieldWorker).setWorkerId(anyLong());
    }

    /**
     * Method under test: {@link FieldWorkerServiceImpl#fieldWorkerLogin(LoginDTO)}
     */
    @Test
    void testFieldWorkerLogin3() {
        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

        BloodBank bloodBank2 = new BloodBank();
        bloodBank2.setAddress("42 Main St");
        bloodBank2.setBloodBankId(1L);
        bloodBank2.setCity("Oxford");
        FieldWorker fieldWorker = mock(FieldWorker.class);
        when(fieldWorker.getBloodBank()).thenReturn(bloodBank2);
        when(fieldWorker.getAddress()).thenReturn("42 Main St");
        when(fieldWorker.getCity()).thenReturn("Oxford");
        when(fieldWorker.getEmailId()).thenReturn("42");
        when(fieldWorker.getFirstName()).thenReturn("Jane");
        when(fieldWorker.getGender()).thenReturn("Gender");
        when(fieldWorker.getLastName()).thenReturn("Doe");
        when(fieldWorker.getPhoneNumber()).thenReturn("6625550144");
        when(fieldWorker.getTitle()).thenReturn("Dr");
        when(fieldWorker.getDob())
                .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(fieldWorker.getPincode()).thenReturn(1L);
        when(fieldWorker.getWorkerId()).thenReturn(1L);
        when(fieldWorker.getPassword()).thenReturn("foo");
        doNothing().when(fieldWorker).setAddress(Mockito.<String>any());
        doNothing().when(fieldWorker).setBloodBank(Mockito.<BloodBank>any());
        doNothing().when(fieldWorker).setCity(Mockito.<String>any());
        doNothing().when(fieldWorker).setDob(Mockito.<Date>any());
        doNothing().when(fieldWorker).setEmailId(Mockito.<String>any());
        doNothing().when(fieldWorker).setFirstName(Mockito.<String>any());
        doNothing().when(fieldWorker).setGender(Mockito.<String>any());
        doNothing().when(fieldWorker).setLastName(Mockito.<String>any());
        doNothing().when(fieldWorker).setPassword(Mockito.<String>any());
        doNothing().when(fieldWorker).setPhoneNumber(Mockito.<String>any());
        doNothing().when(fieldWorker).setPincode(anyLong());
        doNothing().when(fieldWorker).setTitle(Mockito.<String>any());
        doNothing().when(fieldWorker).setWorkerId(anyLong());
        fieldWorker.setAddress("42 Main St");
        fieldWorker.setBloodBank(bloodBank);
        fieldWorker.setCity("Oxford");
        fieldWorker.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        fieldWorker.setEmailId("42");
        fieldWorker.setFirstName("Jane");
        fieldWorker.setGender("Gender");
        fieldWorker.setLastName("Doe");
        fieldWorker.setPassword("iloveyou");
        fieldWorker.setPhoneNumber("6625550144");
        fieldWorker.setPincode(1L);
        fieldWorker.setTitle("Dr");
        fieldWorker.setWorkerId(1L);
        when(fieldWorkerRepository.findByEmailId(Mockito.<String>any())).thenReturn(fieldWorker);
        assertNull(fieldWorkerServiceImpl.fieldWorkerLogin(new LoginDTO("janedoe", "iloveyou")));
        verify(fieldWorkerRepository).findByEmailId(Mockito.<String>any());
        verify(fieldWorker).getPassword();
        verify(fieldWorker).setAddress(Mockito.<String>any());
        verify(fieldWorker).setBloodBank(Mockito.<BloodBank>any());
        verify(fieldWorker).setCity(Mockito.<String>any());
        verify(fieldWorker).setDob(Mockito.<Date>any());
        verify(fieldWorker).setEmailId(Mockito.<String>any());
        verify(fieldWorker).setFirstName(Mockito.<String>any());
        verify(fieldWorker).setGender(Mockito.<String>any());
        verify(fieldWorker).setLastName(Mockito.<String>any());
        verify(fieldWorker).setPassword(Mockito.<String>any());
        verify(fieldWorker).setPhoneNumber(Mockito.<String>any());
        verify(fieldWorker).setPincode(anyLong());
        verify(fieldWorker).setTitle(Mockito.<String>any());
        verify(fieldWorker).setWorkerId(anyLong());
    }

    /**
     * Method under test: {@link FieldWorkerServiceImpl#fieldWorkerLogin(LoginDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFieldWorkerLogin4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null
        //       at com.dd.eraktkendrabackend.Service.ServiceImpl.FieldWorkerServiceImpl.fieldWorkerLogin(FieldWorkerServiceImpl.java:49)
        //   See https://diff.blue/R013 to resolve this issue.

        BloodBank bloodBank = new BloodBank();
        bloodBank.setAddress("42 Main St");
        bloodBank.setBloodBankId(1L);
        bloodBank.setCity("Oxford");

        BloodBank bloodBank2 = new BloodBank();
        bloodBank2.setAddress("42 Main St");
        bloodBank2.setBloodBankId(1L);
        bloodBank2.setCity("Oxford");
        FieldWorker fieldWorker = mock(FieldWorker.class);
        when(fieldWorker.getBloodBank()).thenReturn(bloodBank2);
        when(fieldWorker.getAddress()).thenReturn("42 Main St");
        when(fieldWorker.getCity()).thenReturn("Oxford");
        when(fieldWorker.getEmailId()).thenReturn("42");
        when(fieldWorker.getFirstName()).thenReturn("Jane");
        when(fieldWorker.getGender()).thenReturn("Gender");
        when(fieldWorker.getLastName()).thenReturn("Doe");
        when(fieldWorker.getPhoneNumber()).thenReturn("6625550144");
        when(fieldWorker.getTitle()).thenReturn("Dr");
        when(fieldWorker.getDob())
                .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(fieldWorker.getPincode()).thenReturn(1L);
        when(fieldWorker.getWorkerId()).thenReturn(1L);
        when(fieldWorker.getPassword()).thenReturn(null);
        doNothing().when(fieldWorker).setAddress(Mockito.<String>any());
        doNothing().when(fieldWorker).setBloodBank(Mockito.<BloodBank>any());
        doNothing().when(fieldWorker).setCity(Mockito.<String>any());
        doNothing().when(fieldWorker).setDob(Mockito.<Date>any());
        doNothing().when(fieldWorker).setEmailId(Mockito.<String>any());
        doNothing().when(fieldWorker).setFirstName(Mockito.<String>any());
        doNothing().when(fieldWorker).setGender(Mockito.<String>any());
        doNothing().when(fieldWorker).setLastName(Mockito.<String>any());
        doNothing().when(fieldWorker).setPassword(Mockito.<String>any());
        doNothing().when(fieldWorker).setPhoneNumber(Mockito.<String>any());
        doNothing().when(fieldWorker).setPincode(anyLong());
        doNothing().when(fieldWorker).setTitle(Mockito.<String>any());
        doNothing().when(fieldWorker).setWorkerId(anyLong());
        fieldWorker.setAddress("42 Main St");
        fieldWorker.setBloodBank(bloodBank);
        fieldWorker.setCity("Oxford");
        fieldWorker.setDob(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        fieldWorker.setEmailId("42");
        fieldWorker.setFirstName("Jane");
        fieldWorker.setGender("Gender");
        fieldWorker.setLastName("Doe");
        fieldWorker.setPassword("iloveyou");
        fieldWorker.setPhoneNumber("6625550144");
        fieldWorker.setPincode(1L);
        fieldWorker.setTitle("Dr");
        fieldWorker.setWorkerId(1L);
        when(fieldWorkerRepository.findByEmailId(Mockito.<String>any())).thenReturn(fieldWorker);
        fieldWorkerServiceImpl.fieldWorkerLogin(new LoginDTO("janedoe", "iloveyou"));
    }
}

