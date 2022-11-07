package com.example.transport;

import com.example.transport.domain.Person;
import com.example.transport.repository.PersonRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class SpringbootTestcontainersDemoApplicationTests extends AbstractContainerBaseTest{

    @Autowired
    private PersonRepository repository;

    @Autowired
    private MockMvc mockMvc;

    // given/when/then format - BDD style
    @Test
    public void givenPerson() throws Exception {
        // given - setup or precondition
        List<Person> person =
                List.of(Person.builder().fio("Ramesh").date("faadatare").address("ramesh@gmail.com").build(),
                        Person.builder().fio("Ramesh").date("faadatare").address("ramesh@gmail.com").build());
        repository.saveAll(person);

        // when - action
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/students"));

        // then - verify the output
        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(person.size())));
    }

}