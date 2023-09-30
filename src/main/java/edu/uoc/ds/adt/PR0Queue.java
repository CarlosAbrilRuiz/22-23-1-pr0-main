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


    //TODO
    public String clearFullQueue() {
        StringBuilder sb = new StringBuilder();
        // This is not used: char r;
        while (!queue.isEmpty()) {
            /// TEST
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM");
            //System.out.println(queue.poll().format(pattern));
            sb.append(queue.poll().format(pattern)).append(" ");
            ///
            // ORIGINAL: sb.append(queue.poll()).append(" ");
        }
        /// TEST
        System.out.println("clearFullQueue to return: " + sb.toString());
        ///
        return sb.toString();
    }

    //Changed to LocalDate
    public Queue<LocalDate> getQueue() {
        return this.queue;
    }

    //Changed parameter to LocalDate type
    public void add(LocalDate d) {
        ///
        System.out.println("Size before add: " + this.queue.size());
        ///
        this.queue.add(d);
        ///
        System.out.println("Size after add: " + this.queue.size());
        ///
    }
}
