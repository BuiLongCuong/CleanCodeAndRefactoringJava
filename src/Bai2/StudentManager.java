package Bai2;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private Student[] listStudent;
    private int size;

    public StudentManager() {
        size =0;
        this.listStudent = new Student[100];
    }

    public Student[] getListStudent() {
        return listStudent;
    }
    public int getSize() {
        return size;
    }
    public void addStudents(Student student) {
        listStudent[size] = student;
        size++;
    }
    public void showAll(){
        for (int i = 0; i < size; i++) {
            System.out.println(listStudent[i]);
        }
    }
    public int findById(int id){
        for (int i = 0; i < getSize(); i++) {
            if(listStudent[i].getId()==id){
                return i;
            }
        }
        return -1;
    }
    public void delete(int id) {
        int index = findById(id);
        for (int i = index; i < getSize(); i++) {
            listStudent[i] = listStudent[i + 1];
        }
        size--;
    }
    public void edit(int id,String name, String sex, double[] arr){
        int index =findById(id);
        listStudent[index].setName(name);
        listStudent[index].setGender(sex);
        listStudent[index].setArrScores(arr);
    }
    public double avgOfClazz(){
        double avg;
        double sum=0;
        int count=0;
        for (int i = 0; i < getSize(); i++) {
            sum+= listStudent[i].avgScores();
            count++;
        }
        avg=sum/count;
        return (double) Math.round(avg*1000)/1000;
    }
    public double maxAvg(){
        double maxAvg = listStudent[0].avgScores();
        for (int i = 0; i < getSize(); i++) {
            if(listStudent[i].avgScores()>maxAvg){
                maxAvg= listStudent[i].avgScores();
            }
        }
        return (double) Math.round(maxAvg*1000)/1000;
    }
    public Student findStudentById(int id){
        for (Student student : this.listStudent) {
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }
    public ArrayList<Student> findStudentByName(String name) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < getSize(); i++) {
            if(listStudent[i].getName().toLowerCase().contains(name.toLowerCase())) {
                students.add(listStudent[i]);
            }
        }
        return students;
    }
    public Student findStudentHasMaxAvg(){
        double maxAvg= listStudent[0].avgScores();
        Student sinhVien = listStudent[0];
        for (int i = 0; i < getSize(); i++) {
            if(listStudent[i].avgScores()>maxAvg){
                sinhVien=listStudent[i];
                maxAvg = listStudent[i].avgScores();
            }
        }
        return sinhVien;
    }
}
