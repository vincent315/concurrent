package com.atomic2;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicRefenceDemo {
    public static void main(String[] args) {
        AtomicReference<Students> studentsAtomicReference = new AtomicReference<>();
        Students student = new Students(1L, "abc");
        Students student1 = new Students(1L, "def");
        studentsAtomicReference.set(student);
        studentsAtomicReference.compareAndSet(student,student1);
        Students students = studentsAtomicReference.get();
        System.out.println(students.getName());
    }
}
class Students{
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Students(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

