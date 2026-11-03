package org.se4940project.library_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.se4940project.library_manager.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
