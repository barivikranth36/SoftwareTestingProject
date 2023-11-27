package com.dd.eraktkendrabackend.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.DTO.LoginDTO;
import com.dd.eraktkendrabackend.Entity.User;
import com.dd.eraktkendrabackend.Repository.BLoodDonationRequestRepository;
import com.dd.eraktkendrabackend.Repository.UserRepository;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private BLoodDonationRequestRepository bLoodDonationRequestRepository;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#addUser(User)}
     */
    @Test
    void testAddUser() {
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
        when(userRepository.save(Mockito.<User>any())).thenReturn(user);

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
        assertSame(user, userServiceImpl.addUser(user2));
        verify(userRepository).save(Mockito.<User>any());
    }

    /**
     * Method under test: {@link UserServiceImpl#userLogin(LoginDTO)}
     */
    @Test
    void testUserLogin() {
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
        when(userRepository.findByEmailId(Mockito.<String>any())).thenReturn(user);
        assertSame(user, userServiceImpl.userLogin(new LoginDTO("janedoe", "iloveyou")));
        verify(userRepository).findByEmailId(Mockito.<String>any());
    }

    /**
     * Method under test: {@link UserServiceImpl#userLogin(LoginDTO)}
     */
    @Test
    void testUserLogin2() {
        User user = mock(User.class);
        when(user.getPassword()).thenReturn("foo");
        doNothing().when(user).setAddress(Mockito.<String>any());
        doNothing().when(user).setBloodType(Mockito.<String>any());
        doNothing().when(user).setCity(Mockito.<String>any());
        doNothing().when(user).setCredit(anyInt());
        doNothing().when(user).setDob(Mockito.<Date>any());
        doNothing().when(user).setEmailId(Mockito.<String>any());
        doNothing().when(user).setFirstName(Mockito.<String>any());
        doNothing().when(user).setGender(Mockito.<String>any());
        doNothing().when(user).setLastName(Mockito.<String>any());
        doNothing().when(user).setPassword(Mockito.<String>any());
        doNothing().when(user).setPhoneNumber(Mockito.<String>any());
        doNothing().when(user).setPincode(anyLong());
        doNothing().when(user).setTitle(Mockito.<String>any());
        doNothing().when(user).setUserId(anyLong());
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
        when(userRepository.findByEmailId(Mockito.<String>any())).thenReturn(user);
        assertNull(userServiceImpl.userLogin(new LoginDTO("janedoe", "iloveyou")));
        verify(userRepository).findByEmailId(Mockito.<String>any());
        verify(user).getPassword();
        verify(user).setAddress(Mockito.<String>any());
        verify(user).setBloodType(Mockito.<String>any());
        verify(user).setCity(Mockito.<String>any());
        verify(user).setCredit(anyInt());
        verify(user).setDob(Mockito.<Date>any());
        verify(user).setEmailId(Mockito.<String>any());
        verify(user).setFirstName(Mockito.<String>any());
        verify(user).setGender(Mockito.<String>any());
        verify(user).setLastName(Mockito.<String>any());
        verify(user).setPassword(Mockito.<String>any());
        verify(user).setPhoneNumber(Mockito.<String>any());
        verify(user).setPincode(anyLong());
        verify(user).setTitle(Mockito.<String>any());
        verify(user).setUserId(anyLong());
    }

    /**
     * Method under test: {@link UserServiceImpl#userLogin(LoginDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUserLogin3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.dd.eraktkendrabackend.DTO.LoginDTO.getUsername()" because "loginDTO" is null
        //       at com.dd.eraktkendrabackend.Service.ServiceImpl.UserServiceImpl.userLogin(UserServiceImpl.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getPassword()).thenReturn("iloveyou");
        doNothing().when(user).setAddress(Mockito.<String>any());
        doNothing().when(user).setBloodType(Mockito.<String>any());
        doNothing().when(user).setCity(Mockito.<String>any());
        doNothing().when(user).setCredit(anyInt());
        doNothing().when(user).setDob(Mockito.<Date>any());
        doNothing().when(user).setEmailId(Mockito.<String>any());
        doNothing().when(user).setFirstName(Mockito.<String>any());
        doNothing().when(user).setGender(Mockito.<String>any());
        doNothing().when(user).setLastName(Mockito.<String>any());
        doNothing().when(user).setPassword(Mockito.<String>any());
        doNothing().when(user).setPhoneNumber(Mockito.<String>any());
        doNothing().when(user).setPincode(anyLong());
        doNothing().when(user).setTitle(Mockito.<String>any());
        doNothing().when(user).setUserId(anyLong());
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
        when(userRepository.findByEmailId(Mockito.<String>any())).thenReturn(user);
        userServiceImpl.userLogin(null);
    }
}

