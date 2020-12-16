package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private final TimeEntryRepository repo;

    public TimeEntryController(TimeEntryRepository repo){
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate){
        TimeEntry result = repo.create(timeEntryToCreate);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id){
        TimeEntry result = repo.find(id);
        HttpStatus code = (result == null)? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(result, code);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list(){
        List<TimeEntry> results = repo.list();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable long id, @RequestBody TimeEntry timeEntryToUpdate){
        TimeEntry result = repo.update(id, timeEntryToUpdate);
        HttpStatus code = (result == null)? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(result, code);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        repo.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
