package com.catsapi.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Accessors(chain = true)
public class CatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthDay;
    private LocalDateTime createdAt;


}
