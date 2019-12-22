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
    public void speak(){
        System.out.println("<Generic animal sound>");
    }
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

// Interfances
// Interfances are completely abstract classes
// A class can only have one parent but can inherit multiple interfaces

interface Flying {
    public String Takeoff();
    public String Land();
}

interface Swimming  {
    public String Swim();
    public String Dive();
    public String Surface();
}

class Duck extends Animal implements Flying, Swimming {
    public String Takeoff(){ return "Takeoff";} 
    public String Land(){ return "Land";} 
    public String Swim(){ return "Swim";} 
    public String Dive(){ return "Dive";} 
    public String Surface(){ return "Surface";} 
}

//===================================================================

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

// Abstraction classes ======================================================

abstract class Shape { 
    // these are abstract methods 
    abstract double area(); 
    // We can have public methods in an abstract class
    public String name(){
        return "This class used the Shape abstraction";
    }
}

class Circle extends Shape { 
    double radius; 
    public Circle(double radius) { 
        this.radius = radius; 
    } 
  
    @Override
    double area() { 
        return Math.PI * Math.pow(radius, 2); 
    } 
  
} 
class Rect extends Shape{ 
    double length; 
    double width; 
      
    public Rect(double length,double width) { 
        this.length = length; 
        this.width = width; 
    } 
      
    @Override
    double area() { 
        return length*width; 
    } 
} 

public class Hello_World {
        
    static void use_animal(Animal animal_dynamic){
        Animal animal_static = new Animal();        
        System.out.println("Both static and dynamic instance are of type animal");
        System.out.println("But the result of method calls are different because of dynamic method dispatch");
        animal_static.speak();
        animal_dynamic.speak();
    }
    public static void main(String[] args) {

        System.out.println("\n Upcasting ===========================");
        System.out.println("the Dog and Cat instances are upcasted to the Animal type");
        Animal d = new Dog();
        Animal c = new Cat();

        //Inheritance
        System.out.println("\n Inheritance ===========================");
        System.out.println("Dog and Cat classes use methods implemented in animal");
        d.age = 7;
        d.printAge();
        c.printAge();
        
        // runtime polymorphism
        System.out.println("\n Runtime polymorphism ===================");
        use_animal(d);
        use_animal(c);

        // Compile time polymorphism
        System.out.println("\n Compile time polymorphism ===============");
        System.out.println("Both cases call the 'area' function but the actual function used depends on the parameter types");
        System.out.println(Rectangle.area(5));
        System.out.println(Rectangle.area(5,6));

        //Encapsulation
        System.out.println("\n Encapsulation ===========================");
        System.out.println("Data is private and internal code ensure some data properties");
        Student s = new Student();
        //cannot access s.age
        s.SetAge(14);
        System.out.println(s.GetAge());
        System.out.println(s.GetSchooltype());
        
        // Abstraction
        // We cannot create a Shape object as Shape is abstract. Error on:
        // Shape s = new Shape();
        // Shape is used to define interface while hiding implementation details
        System.out.println("\n Abstraction ===========================");
        System.out.println("Abstract classes are used to define interfaces. They cannot be istantiated");
        Circle c_shape = new Circle(5);
        Rect r_shape = new Rect(5,6);
        System.out.println(r_shape.area());
        System.out.println(r_shape.name());        
    
        // Interfaces
        System.out.println("\n Interfaces ===========================");
        System.out.println("Interfances allow multiple inheritance. They are purely abstract classes");
        Duck duck = new Duck();
        System.out.println(duck.Takeoff());
        System.out.println(duck.Dive());
    }
}
