package note;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NoteService {

    private final Map<Long,Note> notes = new HashMap<>();

    private static long notesId = 1L;

    public Note add(Note note) {
        note.setId(notesId++);
        notes.put(note.getId(),note);
        return note;
    }

    public void deleteById(long id) {
        if(!notes.containsKey(id)) {
            throw new NullPointerException("This note does not exist!");
        }
        notes.remove(id);
    }

    public Note getById(long id) {
        if (!notes.containsKey(id)) {
            throw new NullPointerException("this note does not exist!");
        }
        return notes.get(id);
    }

    public Map<Long,Note> listAll(){
        return notes;
    }

    public void update(Note note) {
        if(!notes.containsKey(note.getId())) {
            throw new NullPointerException("This note does not exist!");
        }
        notes.put(note.getId(),note);
    }
}
