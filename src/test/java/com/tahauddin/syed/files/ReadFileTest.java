package com.tahauddin.syed.files;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReadFileTest {

    @Autowired
    ResourceLoader resourceLoader;

    @Test
    void testOne() throws IOException {

        Resource classPathResource = new ClassPathResource("hello.txt");
        InputStream inputStream = classPathResource.getInputStream();
        byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
        String fileText = new String(bytes);
        System.out.println(fileText);
        assertNotNull(fileText);
        assertDoesNotThrow( () -> FileNotFoundException.class);
    }

    @Test
    void testTwo()  {
        assertThrows(FileNotFoundException.class ,  () -> {
            System.out.println("Class Path Resource..");
            System.out.println("This File Does Not Exists Hence Throwing Exception");
            Resource classPathResource = new ClassPathResource("hello1.txt");
            InputStream inputStream = classPathResource.getInputStream();
        });
    }

    @Test
    void testThree()  {
        assertDoesNotThrow(() -> {
            System.out.println("Class Path Resource..");
            System.out.println("This File Does Exists Hence Not Throwing Exception");
            Resource classPathResource = new ClassPathResource("hello.txt");
            InputStream inputStream = classPathResource.getInputStream();
        });
    }

    @Test
    void testFour() {
        assertDoesNotThrow(() -> {
            System.out.println("File System Resource..");
            System.out.println("This File Does Exists Hence Not Throwing Exception");
            Resource classPathResource = new FileSystemResource("{SOME FILE PATH IN FILE SYSTEM}");
            InputStream inputStream = classPathResource.getInputStream();
        });
    }

    // test case reading data from file using resource loader,
    // which requires spring boot test context to run.
    @Test
    void testFive() throws IOException {
        assertNotNull(resourceLoader);
        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
        String s = new String(bytes);
        System.out.println(s);
    }



}
