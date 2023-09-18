package Bai3;

import Bai2.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager clazz = new StudentManager();
        Bai3.Student sv1 = new Bai3.Student("An","Nam",new double[]{9,9,8});
        Bai3.Student sv2 = new Bai3.Student("Dung","Nữ",new double[]{10,9,9});
        Bai3.Student sv3 = new Bai3.Student("My","Nữ",new double[]{10,9,10});
        Bai3.Student sv4 = new Bai3.Student("Phú","Nam",new double[]{8,9,6});
        Bai3.Student sv5 = new Bai3.Student("Ly","Nữ",new double[]{8,10,6});
        Bai3.Student sv6 = new Bai3.Student("Nhật","Nam",new double[]{9,9,7});
        Bai3.Student sv7 = new Bai3.Student("Nghi","Nam",new double[]{6,6,6});
        Bai3.Student sv8 = new Bai3.Student("Khang","Nam",new double[]{7,9,6});
        Bai3.Student sv9 = new Bai3.Student("Vy","Nữ",new double[]{9,6,9});
        Bai3.Student sv10 = new Bai3.Student("Bản","Nam",new double[]{9,9,6});
        System.out.println("Danh sách học sinh:");
        clazz.addStudent(sv1);
        clazz.addStudent(sv2);
        clazz.addStudent(sv3);
        clazz.addStudent(sv4);
        clazz.addStudent(sv5);
        clazz.addStudent(sv6);
        clazz.addStudent(sv7);
        clazz.addStudent(sv8);
        clazz.addStudent(sv9);
        clazz.addStudent(sv10);
        clazz.showAll();
        System.out.println("----------------------------------------------------------------------------------");
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu quản lí học sinh:");
            System.out.println("1.Thêm mới sinh viên.");
            System.out.println("2.Xóa sinh viên.");
            System.out.println("3.Sửa sinh viên.");
            System.out.println("4.Tìm kiếm sinh viên.");
            System.out.println("5.Danh sách học viên bạn cần tìm.");
            System.out.println("6.Học viên ĐTB cao nhất.");
            System.out.println("7.Danh sách sinh viên.");
            choice =input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Nhập tên sinh viên:");
                    String name = input.nextLine();
                    System.out.println("Nhập giới tính");
                    String sex = input.nextLine();
                    double[] arrScores = new double[3];
                    System.out.println("Nhập điểm môn Toán");
                    arrScores[0]= input.nextDouble();
                    System.out.println("Nhập điểm môn Văn");
                    arrScores[1]= input.nextDouble();
                    System.out.println("Nhập điểm môn Anh");
                    arrScores[2]= input.nextDouble();
                    clazz.addStudent(new Bai3.Student(name,sex,arrScores));
                    clazz.showAll();
                    break;
                case 2:
                    System.out.println("Nhập số id của sinh viên bạn muốn xóa:");
                    int id = input.nextInt();
                    if(clazz.findById(id)!=-1){
                        clazz.deleteStudent(id-1);
                        System.out.println("Xóa thành công");
                        clazz.showAll();
                    }else {
                        System.out.println("Không có sinh viên nào!!");
                    }
                    break;
                case 3:
                    System.out.println("Nhập số id của sinh viên bạn muốn sửa:");
                    int editId = input.nextInt();
                    input.nextLine();
                    if(clazz.findById(editId)!=-1){
                        System.out.println("Nhập tên sinh viên:");
                        String editName = input.nextLine();
                        System.out.println("Nhập giới tính");
                        String editSex = input.nextLine();
                        double[] editArrScores = new double[3];
                        System.out.println("Nhập điểm môn Toán");
                        editArrScores[0]= input.nextDouble();
                        System.out.println("Nhập điểm môn Văn");
                        editArrScores[1]= input.nextDouble();
                        System.out.println("Nhập điểm môn Anh");
                        editArrScores[2]= input.nextDouble();
                        clazz.edit(editId-1,editName,editSex,editArrScores);
                        clazz.showAll();
                    }else {
                        System.out.println("Không có sinh viên nào cả!!");
                    }
                    break;
                case 4:
                    System.out.println("Nhập số id của sinh viên:");
                    int searchId = input.nextInt();
                    if(clazz.findById(searchId)!=-1){
                        System.out.println(clazz.findStudentById(searchId));
                    }else {
                        System.out.println("Không có sinh viên nào!!");
                    }
                    break;
                case 5:
                    System.out.println("Nhập tên sinh viên:");
                    String searchName =input.nextLine();
                    if(clazz.findStudentByName(searchName).isEmpty()){
                        System.out.println("Không có sinh viên nào!!");
                    }else {
                        System.out.println(clazz.findStudentByName(searchName));
                    }
                    break;
                case 6:
                    System.out.println(clazz.findStudentHasMaxAvg());
                    break;
                case 7:
                    clazz.showAll();
                    break;
            }
        }while (choice!=0);
    }
}
