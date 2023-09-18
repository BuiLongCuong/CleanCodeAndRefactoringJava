package Bai1;

public class StudentManager {
   private Student[] arrStudent;
   private int size;

    public StudentManager() {
        size =0;
        this.arrStudent = new Student[100];
    }

    public Student[] getArrStudent() {
        return arrStudent;
    }

    public int addStudents( Student sv,int size){
        arrStudent[size]=sv;
        this.size++;
        return size;
    }
    public int findStudentById(int id,int size){
        for (int i = 0; i < size; i++) {
            if(arrStudent[i].getId()== id){
                return i;
            }
        }
        return -1;
    }
    public void getInfo(int index){
        System.out.println(arrStudent[index]);
    }

    public Student findMaxAvg(int size){
        double maxAvg= arrStudent[0].avgScores();
        Student sinhVien = arrStudent[0];
        for (int i = 0; i < size; i++) {
            if(arrStudent[i].avgScores()>maxAvg){
                sinhVien=arrStudent[i];
                maxAvg = arrStudent[i].avgScores();
            }
        }
        return sinhVien;
    }

    public Student[] findStudentByName(String name) {
        Student[] temp = new Student[arrStudent.length];
        for (int i = 0; i < arrStudent.length; i++) {
            if (arrStudent[i] != null && arrStudent[i].getName()!=null && arrStudent[i].getName().toLowerCase().contains(name.toLowerCase())) {
                temp[i] = arrStudent[i];
            }
        }
        return temp;
    }

//
//    }
//    public void deleteStudent(String[] arr, String student,int size){
//        int index = findStudentById(arr,student,size);
//        for (int i = index; i < size-1; i++) {
//            arr[i]=arr[i+1];
//        }
//        arr[size-1]=null;
//        size--;
//        System.out.println(arr);
//
}
