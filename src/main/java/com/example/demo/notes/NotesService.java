package com.example.demo.notes;

import com.example.demo.db.secondary.Notes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    public List<Notes> getAllNotes() {
        return List.of();
    }
}
