package com.tahauddin.syed.strings;


import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Set;

class StringTests {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Test
    void testOne(){
        String name = "Syed Tahauddin";
        StringBuilder syedTahauddin = new StringBuilder(name);
        StringBuilder reverse = syedTahauddin.reverse();
        System.out.println("Name is :: " + syedTahauddin);
        System.out.println("Name is :: " + reverse);
        System.out.println("Name is :: " + name);
    }

    @Test
    void testTwo(){

    }

}
