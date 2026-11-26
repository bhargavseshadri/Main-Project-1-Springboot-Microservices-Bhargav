package com.bhargavspring.demoApp.projectOne.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity    //Making this class as a data for the Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectProduct {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //This will generate the ID automatically
    private int id;
    private String name;
    private String desc;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private boolean available;
    private int quantity;
}
