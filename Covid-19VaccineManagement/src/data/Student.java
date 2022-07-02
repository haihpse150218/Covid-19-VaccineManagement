/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Student implements Comparable<Student>, Serializable{
    private String studentId, name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", name=" + name + '}';
    }

    @Override
    public int compareTo(Student o) {
        return (this.studentId.compareToIgnoreCase(o.studentId));
    }
}
