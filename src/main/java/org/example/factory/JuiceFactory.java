package org.example.factory;

class JuiceFactory {
    static public IJuice createJuice(String name) {
        IJuice iJuice;
        switch (name) {
            case "Apple":
                iJuice = new Apple();
                break;
            case "Orange":
                iJuice = new Orange();
                break;
            case "Banana":
                iJuice = new Banana();
                break;
            default:
                iJuice = new Others();
        }
        return iJuice;
    }
    /** do you see any issue with this class?
     The Open Closed Principle is a design principle
     that states that software components
     (such as classes and methods) should be open for
     extension but closed for modification.
     In other words, it means that you can add
     new functionality to your software without
     having to change the existing code.
     */
}
