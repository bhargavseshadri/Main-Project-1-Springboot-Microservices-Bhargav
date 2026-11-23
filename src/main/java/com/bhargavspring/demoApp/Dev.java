package com.bhargavspring.demoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//Creating a Bean class which is managed by Spring
@Component  //by giving this annotation, we tell spring to create a object of this class in the IOC container, so spring can refer it later
public class Dev {


    //field injection
    @Autowired
    @Qualifier("laptop")  //Using the @Qualifier with instance name
    private Computer comp;


    //constructor injection
//    public Dev(Laptop laptop) {  //No need to use @Autowired because it is default for constructor.
//        this.laptop = laptop;
//    }


    //setter injection
//    @Autowired
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }



    //Normal example method
    public void build() {
        comp.compile();
        System.out.println("Bhargav - Printing from Main Class");
    }
}
