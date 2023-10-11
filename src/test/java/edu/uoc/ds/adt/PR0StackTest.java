package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Before;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR0StackTest {

    // For setting initial date
    public final LocalDate INITDATE = LocalDate.of(2023, 9, 28);
    PR0Stack pr0q;

    // Changed filler loop to LocalDate
    private void fillStack() {
        pr0q.push(INITDATE);
        for (int i = 1; i < pr0q.CAPACITY; i++) {
            pr0q.push(INITDATE.plusDays(2*i));
        }
    }

    @Before
    public void setUp() {
        this.pr0q = new PR0Stack();

        assertNotNull(this.pr0q.getStack());
        this.fillStack();
    }

    @After
    public void release() {
        this.pr0q = null;
    }


    @org.junit.Test
    public void stackTest() {

        // Changed to CAPACITY for working with 10 elements, not 9 as original
        assertEquals(this.pr0q.CAPACITY, this.pr0q.getStack().size());

        // Changed string content to match expected result
        assertEquals(this.pr0q.clearAllStack(), new String(
                "16/10 14/10 12/10 10/10 08/10 06/10 04/10 02/10 30/09 28/09 "));

        assertEquals(0, this.pr0q.getStack().size());
    }
}