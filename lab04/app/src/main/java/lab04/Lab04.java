/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab04;
import java.util.ArrayList;
import java.util.Scanner;


public class Lab04 {

    public static void main(String[] args) {
        
        // Nhập thông tin danh sách sinh viên
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of Student: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống
        Student list[] = new Student[n];


        for (int i = 0; i < n; i++) {
            System.out.println("Input student number " + (i + 1) + ":");
            list[i] = new Student();
            //Student student = new Student("", 0, "", "", "",0,0,0);
            list[i].StudentInput();
        }

        // Hiển thị danh sách sinh viên
        System.out.println("\nList of student:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student "+ i+1 + "===");                   
            list[i].StudentOutput();
            System.out.println("==============");
        }
        
        System.out.println("\nList of Excellent student:");
        for (int i = 0; i < n; i++){
            if(list[i].GetAcademicAbility() == "Excellent"){
                System.out.println("Student "+ i+1 + "===");
                list[i].StudentOutput();
            }    
        }
    }
}

class Student extends Person{
    private String id;
    private String ClassName;
    private double Mark1;
    private double Mark2;
    private double Mark3;
    private String AcademicAbility;
    
    public Student(){}
    public Student(String name, int YearOfBirth, String address, String id, String AcademicAbility, String ClassName, double Mark1, double Mark2, double Mark3) {
        super(name, YearOfBirth, address);
        this.id = id;
        this.ClassName = ClassName;
        this.Mark1 = Mark1;
        this.Mark2 = Mark2;
        this.Mark3 = Mark3;
        this.AcademicAbility = AcademicAbility;
    }
    
    void StudentInput(){
        super.PersonInput();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id");
        this.id = sc.nextLine();
        
        System.out.println("Class name:");
        this.ClassName = sc.nextLine();
        
        System.out.println("Input Mark1: ");
        this.Mark1 = sc.nextDouble();
        
        System.out.println("Input Mark2: ");
        this.Mark2 = sc.nextDouble();
        
        System.out.println("Input Mark3: ");
        this.Mark3 = sc.nextDouble();
        
        double AM = this.AverageMark(this.Mark1, this.Mark2, this.Mark3);
        if (AM >= 8) {
            this.AcademicAbility = "Excellent";
        } else {
            if (AM >= 7) {
                this.AcademicAbility = "Good";
            } else {
                if (AM >= 5) {
                    this.AcademicAbility = "Average";
                } else {
                    this.AcademicAbility = "Weak";
                }
            }
        }
    }
    
    public String GetAcademicAbility(){
        return this.AcademicAbility;
    } 
    
    void StudentOutput(){
        super.PersonDisplay();
        System.out.println("Id: " + this.id);
        System.out.println("Class name: " + this.ClassName);
        System.out.println("Mark1: " + this.Mark1);
        System.out.println("Mark2: " + this.Mark2);
        System.out.println("Mark3: " + this.Mark3);
        System.out.println("Average mark: " + this.AverageMark(this.Mark1, this.Mark2, this.Mark3));
        System.out.println("Academic ability: " + this.AcademicAbility);
    }
    
    double AverageMark(double Mark1, double Mark2, double Mark3){
        return (Mark1 + Mark2 + Mark3)/3;
    }
    
    
}

