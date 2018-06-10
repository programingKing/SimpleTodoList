package com.example.todolist.note;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note createNote(Note note) {
        return this.noteRepository.save(note);
    }

    public Note getNoteById(Long noteId) {
        return noteRepository.findById(noteId);
    }

    public List<Note> getNoteList() {
        return noteRepository.findAll();
    }

    public Note updateNote(Note note){
        // TODO: 2018-06-11 유효성 검사 예외처리 
        if(noteRepository.findById(note.getId()) == null){
            return null; 
        }
        return noteRepository.save(note);
    }

    public ResponseEntity deleteNote(Long noteId) {
        noteRepository.delete(noteId);
        return ResponseEntity.ok().build();
    }
}
