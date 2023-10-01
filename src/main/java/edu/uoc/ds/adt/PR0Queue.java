package edu.uoc.ds.adt;


import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PR0Queue {

    public final int CAPACITY = 10;

   //Changed to LocalDate
    private Queue<LocalDate> queue;

    public PR0Queue() {
        newQueue();
    }
    public void newQueue() {
        queue = new QueueArrayImpl<>(CAPACITY);
    }

    public String clearFullQueue() {
        StringBuilder sb = new StringBuilder();
        // This is not used: char r;
        while (!queue.isEmpty()) {
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM");
            sb.append(queue.poll().format(pattern)).append(" ");
        }
        return sb.toString();
    }

    //Changed to LocalDate
    public Queue<LocalDate> getQueue() {
        return this.queue;
    }

    //Changed parameter to LocalDate type
    public void add(LocalDate d) {
        this.queue.add(d);
    }
}