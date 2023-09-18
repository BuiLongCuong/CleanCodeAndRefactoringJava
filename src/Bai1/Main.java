package Bai1;

import java.util.Scanner;

public class Main {

    static int size=0;
    public static void main(String[] args) {
        StudentManager arrSv = new StudentManager();
        Student sv1 = new Student("An","Nam",new double[] {6,7,8});
        Student sv2 = new Student("Nam","Nam",new double[] {5,6,7});
        Student sv3 = new Student("Lan","Nữ",new double[] {9,8,7});
        StudentManager studentManager = new StudentManager();
        size=arrSv.addStudents(sv1,size);
        size=arrSv.addStudents(sv2,size);
        size=arrSv.addStudents(sv3,size);

        for (Student student : arrSv.findStudentByName("a")) {
            if(student!= null) {
                System.out.println(student.getId()+", Name: "+ student.getName() + ", Gender: "+ student.getGender());
            }
        }



        //showAll(arrSv.getArrStudent(), size);
        System.out.println("---------------------------------------");

        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Tìm kiếm thông tin sinh viên bằng cách nhập id.");
            System.out.println("2.Tìm kiếm thông tin sinh viên có điểm trung bình lớn nhất.");
            System.out.println("3.Tìm kiếm thông tin học sinh bằng tên.");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập số id của sinh viên bạn muốn tìm:");
                    int id = input.nextInt();
                    int index = arrSv.findStudentById(id, size);
                    arrSv.getInfo(index);
                    break;
                case 2:
                    Student sv = arrSv.findMaxAvg(size);
                    System.out.println(sv);
                    break;
                case 3:
                    showSearch();
                default:
                    System.out.println("Mời bạn nhập lại!!");
            }
        } while (choice != 0);

    }
    public static void showAll(Student[] listStudents,int size){
        for (int i = 0; i < size; i++) {
            System.out.println(listStudents[i]);
        }
    }

    public static void showSearch(){
/*//        Bai1.Student sinhVien = new Bai1.Student();
//        Scanner input = new Scanner(System.in);
//        String name = input.nextLine();
//        Bai1.Student[] s = arrSv.findStudentByName(name);
//        System.out.println(s);*/
    }

}