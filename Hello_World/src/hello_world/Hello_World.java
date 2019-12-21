/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello_world;

/**
 *
 * @author Sophia
 */

class Animal{
    int age;
    public void printAge(){
        System.out.println(age);
    }
    public void speak(){}
}

class Dog extends Animal{
    public void speak(){
        System.out.println("Woof");
    }
}

class Cat extends Animal{
    public void speak(){
        System.out.println("Meow");
    }
}

class Rectangle{
    public static float area(float x){
        // if we have only one parameter, we say it is a square
        return x*x;
    }
    public static float area(float x, float y){
        // if we have 2 parameters we say is a general rectangle
        return x*y;
    }
}

class Student{
    private int age;
    private String schooltype;
    
    public void SetAge(int x){
        age = x;
        if (x < 13) {
            schooltype = "primary";
        } else {
            schooltype = "secondary";
        }
    }
    public int GetAge(){
        return age;
    }
    public String GetSchooltype(){
        return schooltype;
    }
}

public class Hello_World {
        
    static void use_animal(Animal a){
        a.speak();
    }
    public static void main(String[] args) {

        Animal d = new Dog();
        Animal c = new Cat();

        //inheritance
        //age is already implemented in Cat and Dog because we inherited from Animal
        //now need to write additional code
        d.age = 7;
        d.printAge();
        c.printAge();

        // runtime polymorphism
        use_animal(d);
        use_animal(c);

        // compile time polymorphism
        // same function name, but different parameters
        System.out.println(Rectangle.area(5));
        System.out.println(Rectangle.area(5,6));

        //Encapsulation
        Student s = new Student();
        //cannot access s.age = 5
        s.SetAge(14);
        System.out.println(s.GetAge());
        System.out.println(s.GetSchooltype());
        // Encapsulation protects info
        // Example makes sure you cannot set s.age = 14; s.schooltype = "primary"
    }
    
}
