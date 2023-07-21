package com.yanelinramos.SOVBackend.repository;

import com.yanelinramos.SOVBackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
