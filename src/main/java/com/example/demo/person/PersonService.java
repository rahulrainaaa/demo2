package com.example.demo.person;

import com.example.demo.db.primary.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    public List<Person> getListOfAllPersons() {
        return List.of();
    }
}
