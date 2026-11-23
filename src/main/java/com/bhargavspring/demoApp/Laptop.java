package com.bhargavspring.demoApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //use of this is when we have multiple classes implementing the same interface, then the preference goes to this class with this annotation.
public class Laptop implements Computer {
    public void compile() {
        System.out.println("Printing From Laptop class");
    }
}
