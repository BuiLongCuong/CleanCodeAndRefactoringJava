package Bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager clazz = new StudentManager();
        Student sv1 = new Student("An","Nam",new double[]{6,7,8});
        Student sv2 = new Student("Dung","Nữ",new double[]{10,9,9});
        Student sv3 = new Student("My","Nữ",new double[]{10,9,10});
        Student sv4 = new Student("Phú","Nam",new double[]{8,9,6});
        Student sv5 = new Student("Ly","Nữ",new double[]{8,10,6});
        Student sv6 = new Student("Nhật","Nam",new double[]{9,9,7});
        Student sv7 = new Student("Nghi","Nam",new double[]{6,6,6});
        Student sv8 = new Student("Khang","Nam",new double[]{7,9,6});
        Student sv9 = new Student("Vy","Nữ",new double[]{9,6,9});
        Student sv10 = new Student("Bản","Nam",new double[]{9,9,6});
        System.out.println("Danh sách học sinh:");
        clazz.addStudents(sv1);
        clazz.addStudents(sv2);
        clazz.addStudents(sv3);
        clazz.addStudents(sv4);
        clazz.addStudents(sv5);
        clazz.addStudents(sv6);
        clazz.addStudents(sv7);
        clazz.addStudents(sv8);
        clazz.addStudents(sv9);
        clazz.addStudents(sv10);
        clazz.showAll();
        System.out.println("-------------------------------------------------");
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
            System.out.println("8.Exit.");
            choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Nhập tên:");
                    String name = input.nextLine();
                    System.out.println("Nhập giới tính:");
                    String sex= input.nextLine();
                    double[] arrScores = new double[3];
                    System.out.println("Nhập điểm môn Toán:");
                    arrScores[0]= input.nextDouble();
                    System.out.println("Nhập điểm môn Văn:");
                    arrScores[1]= input.nextDouble();
                    System.out.println("Nhập điểm môn Anh:");
                    arrScores[2]= input.nextDouble();
                    clazz.addStudents(new Student(name,sex,arrScores));
                    clazz.showAll();
                    break;
                case 2:
                    System.out.println("Nhập id của sinh viên bạn muốn xóa:");
                    int deleteStudent = input.nextInt();
                    int locaiton = clazz.findById(deleteStudent);
                    if (locaiton != -1){
                        clazz.delete(deleteStudent);
                        System.out.println("Xóa thành công");
                        clazz.showAll();
                    }else {
                        System.out.println("Không có sinh viên này!");
                    }
                    break;
                case 3:
                    System.out.println("Nhập sinh viên có số id bạn muốn sửa:");
                    int locationEdit= input.nextInt();
                    input.nextLine();
                    if(clazz.findById(locationEdit)!=-1){
                        System.out.println("Nhập tên:");
                        String editName = input.nextLine();
                        System.out.println("Nhập giới tính:");
                        String editSex= input.nextLine();
                        double[] editArrScores = new double[3];
                        System.out.println("Nhập điểm môn Toán:");
                        editArrScores[0]= input.nextDouble();
                        System.out.println("Nhập điểm môn Văn:");
                        editArrScores[1]= input.nextDouble();
                        System.out.println("Nhập điểm môn Anh:");
                        editArrScores[2]= input.nextDouble();
                        clazz.edit(locationEdit,editName,editSex,editArrScores);
                        System.out.println("Sửa thành công!!!");
                        clazz.showAll();
                    }else {
                        System.out.println("Không có sinh viên này!");
                    }
                    break;
                case 4:
                    System.out.println("Nhập id của sinh viên đó:");
                    int id = input.nextInt();
                    if(clazz.findById(id)!=-1){
                        System.out.println(clazz.findStudentById(id));
                    }else {
                        System.out.println("Không có sinh viên nào!");
                    }
                    break;
                case 5:
                    System.out.println("Nhập tên sinh viên:");
                    String searchName = input.nextLine();
                    if(clazz.findStudentByName(searchName).isEmpty()){
                        System.out.println("Không có sinh viên nào!");
                    }else {
                        System.out.println(clazz.findStudentByName(searchName));
                    }

                    break;
                case 6:
                    System.out.println("Sinh viên có điểm trung bình cao nhất: "+clazz.findStudentHasMaxAvg());
                    break;
                case 7:
                    clazz.showAll();
                    break;
                case 8:
                    System.out.println("Bye!!!");
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
                    break;
            }
        }while (choice!=0);
    }
}
