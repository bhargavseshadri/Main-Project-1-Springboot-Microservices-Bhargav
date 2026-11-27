package com.bhargavspring.demoApp.projectOne.model;

import jakarta.persistence.*;
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
    private Integer id;
    private String name;
    @Column(name = "description")
    private String desc;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private boolean available;
    private int quantity;


    //Image Details
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;  //Storing the image in a byte format
}
