package com.spring.datat.rest.utils;

import com.github.javafaker.Faker;
import com.spring.datat.rest.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Pavel on 2017-07-08.
 */
@Service
public class DataPreloader {

    @Autowired
    private LibraryRepository libraryRepository;

    public void createLibraries(int number){
        for (int i = 0; i < number; i++) {
            libraryRepository.save(createLibrary());
        }
    }

    private Library createLibrary() {
        Faker faker = new Faker();
        Address address = new Address(faker.address().fullAddress());
        Library library = new Library(faker.commerce().department(), address, createBooks());
        return library;
    }

    private List<Book> createBooks(){
        Faker faker = new Faker();
        Random random = new Random();
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < random.nextInt(30); i++) {
            ArrayList<Author> authors = new ArrayList<>();
            for (int j = 0; j < (random.nextInt(3) + 1); j++) {
                authors.add(new Author(faker.book().author()));
            }
            Book book = new Book(faker.book().title(), authors);
            books.add(book);
        }
        return books;
    }


}

