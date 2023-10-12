package org.example.streams;

import java.util.Comparator;

enum SUBJECT{
    MATH,SCIENCE,GEOGRAPHY,ENGLISH,LITERATURE
}
class Student implements Comparator<Student> {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SUBJECT getSubject() {
        return subject;
    }

    public void setSubject(SUBJECT subject) {
        this.subject = subject;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    SUBJECT subject;
    double note;

    public Student(String name, SUBJECT subject, double note) {
        this.name = name;
        this.subject = subject;
        this.note = note;
    }

    int compareLength(String s1,String s2){
        return s1.length()-s2.length()!=0?s1.length()-s2.length():s1.compareTo(s2);
    }
    @Override
    public int compare(Student o1, Student o2) {

        return compareLength(o1.name, o2.name);
    }
}