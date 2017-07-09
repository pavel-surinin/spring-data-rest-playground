package com.spring.datat.rest.domain;

import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pavel on 2017-07-08.
 */
@Entity
public class Library {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="address_id")
    @RestResource(path="libraryAddress", rel = "address")
    private Address address;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List<Book> books;

    public Library(String name, Address address, List<Book> books) {
        this.name = name;
        this.address = address;
        this.books = books;
        books.forEach(book -> book.setLibrary(this));
    }

    public Library() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
