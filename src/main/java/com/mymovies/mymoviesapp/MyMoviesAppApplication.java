package com.mymovies.mymoviesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MyMoviesAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyMoviesAppApplication.class, args);
    }

}
