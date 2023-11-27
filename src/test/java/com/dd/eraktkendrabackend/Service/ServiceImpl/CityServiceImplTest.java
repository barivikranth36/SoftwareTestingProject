package com.dd.eraktkendrabackend.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dd.eraktkendrabackend.Entity.City;
import com.dd.eraktkendrabackend.Repository.CityRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CityServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CityServiceImplTest {
    @MockBean
    private CityRepository cityRepository;

    @Autowired
    private CityServiceImpl cityServiceImpl;

    /**
     * Method under test: {@link CityServiceImpl#getAllCities()}
     */
    @Test
    void testGetAllCities() {
        when(cityRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(cityServiceImpl.getAllCities().isEmpty());
        verify(cityRepository).findAll();
    }

    /**
     * Method under test: {@link CityServiceImpl#getAllCities()}
     */
    @Test
    void testGetAllCities2() {
        City city = new City();
        city.setCityId(1L);
        city.setCityName("Oxford");
        city.setVacant(true);

        ArrayList<City> cityList = new ArrayList<>();
        cityList.add(city);
        when(cityRepository.findAll()).thenReturn(cityList);
        List<String> actualAllCities = cityServiceImpl.getAllCities();
        assertEquals(1, actualAllCities.size());
        assertEquals("Oxford", actualAllCities.get(0));
        verify(cityRepository).findAll();
    }
}

