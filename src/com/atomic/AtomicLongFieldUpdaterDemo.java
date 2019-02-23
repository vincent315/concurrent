package com.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicLongFieldUpdaterDemo {

    public static void main(String[] args) {
        AtomicLongFieldUpdater<Student> longFieldUpdater = AtomicLongFieldUpdater.newUpdater(Student.class, "id");
        Student student = new Student(1L, "abc");
        longFieldUpdater.compareAndSet(student,1L,10L);
        System.out.println("修改之后的id" + student.getId());

        AtomicReferenceFieldUpdater<Student, String> hello = AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");
        hello.compareAndSet(student, "abc", "hello");
        System.out.println("修改后的name为" + student.getName());
    }

}
 class Student{
    volatile long id;
    volatile String name;

    public Student(Long id,String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}