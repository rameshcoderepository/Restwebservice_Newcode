package com.uniqTechnologies.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uniqTechnologies.restfulwebservices.bean.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
