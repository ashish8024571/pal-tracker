package io.pivotal.pal.tracker;

import java.util.List;

public interface   TimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry);

    public TimeEntry find(long timeEntryId) ;

    public void delete(long id) ;

    public List list();

    public TimeEntry update(long l, TimeEntry timeEntry);
}
