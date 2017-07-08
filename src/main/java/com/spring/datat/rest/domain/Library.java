package com.spring.datat.rest.domain;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

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

    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Library() {
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
