package org.se4940project.library_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String title;
        private String author;
        private double isbn;
        private String description;
        private int stock;

}
