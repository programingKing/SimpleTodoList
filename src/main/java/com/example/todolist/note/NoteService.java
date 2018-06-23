package com.example.todolist.note;

import com.example.todolist.common.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note createNote(Note note) {
        return this.noteRepository.save(note);
    }

    public Note getNoteById(Long noteId) throws EntityNotFoundException{
        if(noteRepository.findById(noteId) == null) {
            throw new EntityNotFoundException(Note.class, "noteId", noteId.toString());
        }

        return noteRepository.findById(noteId);
    }

    public List<Note> getNoteList() {
        return noteRepository.findAll();
    }

    public Note updateNote(Note note) throws EntityNotFoundException {
        // TODO: 2018-06-11 유효성 검사 예외처리 
        if(noteRepository.findById(note.getId()) == null){
            throw new EntityNotFoundException(Note.class, "noteId" , note.getId().toString() );
        }
        return noteRepository.save(note);
    }

    public boolean deleteNote(Long noteId) throws EntityNotFoundException {

        if(noteRepository.findById(noteId) == null) {
            throw new EntityNotFoundException(Note.class, "noteId", noteId.toString());
        }
        noteRepository.delete(noteId);

        return true;
    }
}
