/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab04;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author mamto
 */
public class Person {
    private String name;
    private String address;
    private int YearOfBirth;

    public Person(){};
    public Person(String name, int YearOfBirth, String address) {
            this.name = name;
            this.YearOfBirth = YearOfBirth;
            this.address = address;
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public int getAge() {
            return YearOfBirth;
    }

    public void setAge(int age) {
            this.YearOfBirth = YearOfBirth;
    }

    public String getAddress() {
            return address;
    }

    public void setAddress(String address) {
            this.address = address;
    }

    void PersonInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name");
        this.name = sc.nextLine();
        
        System.out.println("Input address");
        this.address = sc.nextLine();
        
        System.out.println("Input Year");
        this.YearOfBirth = sc.nextInt();
    }
    
    void PersonDisplay() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + YearOfBirth);
            System.out.println("Address: " + address);
    }
}
