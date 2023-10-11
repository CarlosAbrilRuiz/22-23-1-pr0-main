package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Before;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR0QueueTest {

    // For setting initial date
    public final LocalDate INITDATE = LocalDate.of(2023, 9, 28);
    PR0Queue pr0q;

    // Changed to LocalDate
    private void fillQueue() {
        pr0q.add(INITDATE);
        for (int i = 1; i < pr0q.CAPACITY; i++) {
            pr0q.add(INITDATE.plusDays(2*i));
        }
    }

    @Before
    public void setUp() {
        this.pr0q = new PR0Queue();
        assertNotNull(this.pr0q.getQueue());
        fillQueue();
    }

    @After
    public void release() {
        this.pr0q = null;
    }

    @org.junit.Test
    public void queueTest() {
        // Changed to CAPACITY for working with 10 elements, not 9 as original
        assertEquals(this.pr0q.CAPACITY, this.pr0q.getQueue().size());

        // Changed string content to match dates
        assertEquals(this.pr0q.clearFullQueue(), new String(
                "28/09 30/09 02/10 04/10 06/10 08/10 10/10 12/10 14/10 16/10 "));

        assertEquals(0, this.pr0q.getQueue().size());
    }
}