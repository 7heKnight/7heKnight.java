/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0068;

/**
 *
 * @author ASUS
 */
public class Student implements Comparable<Student>{
    private String name;
    private String classes;
    private float mark;

    public Student(String name, String classes, float mark) {
        this.name = name;
        this.classes = classes;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nClasses: " + classes + "\nMark: " + mark;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }
    
}
