package com.spring.datat.rest.utils;

import com.github.javafaker.Faker;
import com.spring.datat.rest.domain.Address;
import com.spring.datat.rest.domain.Library;
import com.spring.datat.rest.domain.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pavel on 2017-07-08.
 */
@Service
public class DataPreloader {

    @Autowired
    private LibraryRepository libraryRepository;

    public void createLibraries(int number){
        for (int i = 0; i < number; i++) {
            libraryRepository.save(createLibraty());
        }
    }

    private Library createLibraty() {
        Faker faker = new Faker();
        Address address = new Address(faker.address().fullAddress());
        return new Library(faker.commerce().department(), address);
    }
}
