package Bai3;

import java.util.ArrayList;

public class StudentManager {
    private Student[] listStudents;
    private int size;

    public StudentManager() {
        this.listStudents = new Student[100];
        size=0;
    }

    public Student[] getStudents() {
        return listStudents;
    }
    public int getSize() {
        return size;
    }
    public void showAll(){
        for (int i = 0; i < getSize(); i++) {
            System.out.println(listStudents[i]);
        }
    }
    public void addStudent(Student student){
        listStudents[size]= student;
        size++;
    }
    public int findById(int id){
        for (int i = 0; i < getSize(); i++) {
            if(listStudents[i].getId()==id){
                return listStudents[i].getId();
            }
        }
        return -1;
    }
    public void deleteStudent(int id){
        int index = findById(id);
        for (int i = index; i < getSize(); i++) {
            listStudents[i] = listStudents[i + 1];
        }
        size--;
    }
    public void edit(int id,String name,String sex, double[] arr){
        int index = findById(id);
        listStudents[index].setName(name);
        listStudents[index].setGender(sex);
        listStudents[index].setArrScores(arr);
    }
    public double avgOfClass(){
        double sum=0;
        int count=0;
        for (int i = 0; i < getSize(); i++) {
            sum+=listStudents[i].avgArrScores();
            count++;
        }
        double avg = sum/count;
        return avg;
    }
    public double maxAvg(){
        double maxAvg = listStudents[0].avgArrScores();
        for (int i = 0; i < getSize(); i++) {
            if(listStudents[i].avgArrScores()>maxAvg){
                maxAvg= listStudents[i].avgArrScores();
            }
        }
        return (double) Math.round(maxAvg*1000)/1000;
    }
  public Student findStudentById(int id){
      for (Student student: this.listStudents) {
          if(student.getId()==id){
              return student;
          }
      }
      return null;
  }
  public ArrayList<Student> findStudentByName(String name){
        ArrayList<Student> students = new ArrayList<>();
      for (int i = 0; i < getSize(); i++) {
          if(listStudents[i].getName().toLowerCase().contains(name.toLowerCase())){
              students.add(listStudents[i]);
          }
      }
      return students;
  }
  public Student findStudentHasMaxAvg(){
      double maxAvg = listStudents[0].avgArrScores();
      Student student = listStudents[0];
      for (int i = 0; i < getSize(); i++) {
          if(listStudents[i].avgArrScores()>maxAvg){
              maxAvg= listStudents[i].avgArrScores();
              student=listStudents[i];
          }
      }
      return student;
  }
}
