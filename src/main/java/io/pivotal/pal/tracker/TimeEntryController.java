package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Time;
import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository rep ;
    public TimeEntryController(  TimeEntryRepository rep) {
        this.rep = rep;
    }

    @RequestMapping(path = "/time-entries" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity create(  @RequestBody TimeEntry timeEntryToCreate) {
       TimeEntry timeEntry = rep.create(timeEntryToCreate);
        return new ResponseEntity(timeEntry,HttpStatus.CREATED);
    }

    @RequestMapping(path = "/time-entries/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long id) {
        TimeEntry timeEntry = rep.find(id);
        if(timeEntry==null)
            return new ResponseEntity(timeEntry,HttpStatus.NOT_FOUND);
        return new ResponseEntity(timeEntry,HttpStatus.OK);
    }

    @RequestMapping(path = "/time-entries" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> list = rep.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    @RequestMapping(path = "/time-entries/{timeEntryId}" , method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("timeEntryId")long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry timeEntry = rep.update(timeEntryId,expected);
        if(timeEntry==null)
            return new ResponseEntity(timeEntry,HttpStatus.NOT_FOUND);
        return new ResponseEntity(timeEntry,HttpStatus.OK);
    }


    @RequestMapping(path = "/time-entries/{timeEntryId}" , method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("timeEntryId")long timeEntryId) {
        rep.delete(timeEntryId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
