package com.spring.datat.rest.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 2017-07-09.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String label;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private List<Author> authors;

    public Book() {
    }

    public Book(String title, ArrayList<Author> authors) {
        this.label = title;
        this.authors = authors;
        authors.forEach(author -> author.addBook(this));
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
