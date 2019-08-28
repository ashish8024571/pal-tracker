package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Component
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long,TimeEntry> map = new HashMap<>();
    AtomicLong idObject = new AtomicLong();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        long id = idObject.incrementAndGet();
        TimeEntry timEntry = new TimeEntry(id,timeEntry);
        map.put(id,timEntry);
       return timEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return map.get(timeEntryId);

    }

    @Override
    public void delete(long id) {
        map.remove(id);

    }

    @Override
    public List list() {
        List<TimeEntry> list = map.values().stream()
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public TimeEntry update(long l, TimeEntry timeEntry) {
        TimeEntry value= map.get(l);
        TimeEntry newTimeEntry= null;
        if (value != null){
            newTimeEntry = new TimeEntry(l,timeEntry);
            map.replace(l,newTimeEntry);

        }

        return newTimeEntry;
    }
}
