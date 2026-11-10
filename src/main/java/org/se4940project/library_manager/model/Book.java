package org.se4940project.library_manager.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String author;
        private String isbn;
        private String description;
        private int stock;
        private String imageUrl;
        private BigDecimal price;

}
