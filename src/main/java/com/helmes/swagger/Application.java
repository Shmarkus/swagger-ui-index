package com.helmes.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Component
    @EnableConfigurationProperties
    @ConfigurationProperties(prefix = "api")
    class Endpoints {

        private HashMap<String, String> endpoints;

        public HashMap<String, String> getEndpoints() {
            return endpoints;
        }

        public void setEndpoints(HashMap<String, String> endpoints) {
            this.endpoints = endpoints;
        }

    }
}
