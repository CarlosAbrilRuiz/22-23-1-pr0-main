package edu.uoc.ds.adt;


import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PR0Stack {
    public final int CAPACITY = 10;

    private Stack<LocalDate> stack;

    public PR0Stack() {
        newStack();
    }

    // Changed from StackArrayImpl<Character>(CAPACITY) to StackArrayImpl<>(CAPACITY)
    public void newStack() {
        stack = new StackArrayImpl<>(CAPACITY);
    }

    public String clearAllStack() {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM");
            sb.append(stack.pop().format(pattern)).append(" ");
        }
        return sb.toString();
    }

    // Changed to LocalDate
    public Stack<LocalDate> getStack() {
        return this.stack;
    }

    //Changed parameter type to LocalDate
    public void push(LocalDate d) {
        this.stack.push(d);
    }
}