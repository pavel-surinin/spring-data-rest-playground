package com.spring.datat.rest.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pavel on 2017-07-09.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
