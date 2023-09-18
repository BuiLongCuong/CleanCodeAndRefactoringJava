package Bai3;

import java.util.Arrays;

public class Student {
    public int id;
    public static int idIncrements=1;
    public String name;
    public String gender;
    public double[] arrScores;

    public Student( String name, String gender, double[] arrScores) {
        this.id = idIncrements;
        this.name = name;
        this.gender = gender;
        this.arrScores = arrScores;
        idIncrements++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double[] getArrScores() {
        return arrScores;
    }

    public void setArrScores(double[] arrScores) {
        this.arrScores = arrScores;
    }
    public double avgArrScores(){
        double sum =0;
        int count=0;
        for (int i = 0; i < arrScores.length; i++) {
            sum+=arrScores[i];
            count++;
        }
        double avg = sum/count;
        return avg;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + ", gender='" + gender + ", arrScores=" + Arrays.toString(arrScores) + ", avg= " + (double) Math.round(avgArrScores() * 1000) / 1000 + '}';
    }
}
