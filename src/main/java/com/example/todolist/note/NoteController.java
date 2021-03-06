package com.example.todolist.note;

import com.example.todolist.common.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object createNote(@RequestBody Note note){
        return noteService.createNote(note);
    }

    @GetMapping("/{id}")
    public Object getNote(@PathVariable(value = "id") Long noteId) throws EntityNotFoundException {
        return noteService.getNoteById(noteId);
    }

    @GetMapping("/list")
    public Object getNoteList(){
        return noteService.getNoteList();
    }

    @PutMapping("/{id}")
    public Object updateNote(@PathVariable(value = "id") Long noteId, @RequestBody Note note) throws EntityNotFoundException {
        note.setId(noteId);
        return noteService.updateNote(note);
    }

    @DeleteMapping("/{id}")
    public Object deleteNote(@PathVariable(value = "id") Long noteId) throws EntityNotFoundException {
        return noteService.deleteNote(noteId);
    }
}
