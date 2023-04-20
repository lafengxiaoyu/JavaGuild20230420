package org.example.reflection;

public class Person {
    //Fields
    //private string field
    private String name = "No Name";
    //public boolean field
    public boolean works = false;

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean works() {
        return works;
    }

    public void setWorks(boolean works) {
        this.works = works;
    }

    //Constructors
    // nullary Constructor
    public Person() {
        System.out.println("Nullary Constructor: Person()...");
    }

    // public constructor with one argument
    public Person(String name) {
        setName(name);
    }

    // private constructor with two arguments
    private Person (String name, boolean works) {
        setName(name);
        setWorks(works);
    }

    // Methods
    public void show() {
        System.out.println("I am a person!");
    }

    private String showNation (String nation) {
        return "my nationality is: " + nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", works=" + works +
                '}';
    }
}
