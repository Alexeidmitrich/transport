package com.example.transport;

import com.example.transport.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
@ContextConfiguration(initializers = {PersonApplicationTest.Initializer.class})
public class PersonApplicationTest {

    @Container
    private static MySQLContainer mySQLContainer = new MySQLContainer("mysql:latest");

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MockMvc mockMvc;

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + mySQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + mySQLContainer.getUsername(),
                    "spring.datasource.password=" + mySQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Test
    public void test() {
        System.out.println(mySQLContainer.getJdbcUrl());
        System.out.println(mySQLContainer.getDatabaseName());
        System.out.println(mySQLContainer.getUsername());
        System.out.println(mySQLContainer.getPassword());
        System.out.println("=================0");
        System.out.println();
        Assertions.assertEquals(2, 2);
        Assertions.assertEquals(0, personRepository.findAll().size());
    }
}
