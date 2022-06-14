package com.demo.mp3reader;

import org.apache.tika.exception.TikaException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;


import java.io.IOException;

@SpringBootApplication
public class Mp3ReaderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Mp3ReaderApplication.class, args);

    }

}
