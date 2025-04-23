package com.example.demo.notes;

import com.example.demo.db.secondary.Notes;
import com.example.demo.exception.EmptyResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping
    public ResponseEntity<List<Notes>> getAllNotes() {
        var list = notesService.getAllNotes();
        if (list.isEmpty()) throw new EmptyResponseException("Empty Notes");
        return ResponseEntity.ok(list);
    }
}
