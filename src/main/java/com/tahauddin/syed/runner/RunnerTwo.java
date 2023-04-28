package com.tahauddin.syed.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

//@Component
@Slf4j
@RequiredArgsConstructor
public class RunnerTwo implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Method[] declaredMethods = this.getClass().getDeclaredMethods();
        Method method = Arrays.stream(declaredMethods).findFirst().get();
        log.info("Method is :: {}", method);
        log.info("Method[] is :: {}", declaredMethods);
        Arrays.stream(declaredMethods).toList().forEach(l -> log.info(l.getName()));
    }

    public void m1(String message){
        log.info("In M1()");
    }

    public void m2(){
        log.info("In M2()");
    }
}
