package com.bhargavspring.demoApp;

import org.springframework.stereotype.Component;


//Creating a Bean class which is managed by Spring
@Component  //by giving this annotation, we tell spring to create a object of this class in the IOC container, so spring can refer it later
public class Dev {

    //Normal example method
    public void build() {
        System.out.println("working on Awesome Project");
    }
}
