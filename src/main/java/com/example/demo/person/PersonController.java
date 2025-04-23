package com.example.demo.person;

import com.example.demo.db.primary.Person;
import com.example.demo.exception.EmptyResponseException;
import com.example.demo.exception.SomeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getListOfAllPerson() {
        var list = personService.getListOfAllPersons();
        if (list.isEmpty()) throw new EmptyResponseException("No Person in database");
        return ResponseEntity.ok(list);
    }

    @ExceptionHandler(value = SomeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleSomeException(SomeException exception) {
        return ErrorResponse.builder(exception, HttpStatus.BAD_REQUEST, exception.getMessage())
                .type(URI.create(exception.getClass().getSimpleName()))
                .build();

    }

}
