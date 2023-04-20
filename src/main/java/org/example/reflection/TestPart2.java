package org.example.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestPart2 {

    @Test
    public void getClassName() throws Exception{
        // If you know the type of the class, get it from the static field of runtime class
        Class<Person> clazz1 = Person.class;

        // If you have instance of an object, get it from the runtime object
        Person p = new Person();
        Class clazz2 = p.getClass();

        // If you know the class name, from the static method of Class
        String classname = "org.example.reflection.Person";
        Class clazz3 = Class.forName(classname);

        System.out.println("clazz1 equals to clazz2?: " + true);
        System.out.println("clazz1 equals to clazz3?: " + (clazz1 == clazz3));
    }

    @Test
    public void instantiateObject() throws Exception{
        Class<Person> clazz = Person.class;

//        // instantiate a Person object
//        Person p1 = clazz.newInstance();
//        System.out.println(p1);

        // question? are there any requirements?

        /** Requirement for the constructor?
         * 1. the constructor is there
         * 2. enough Controlling access
         **/

        Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        Person p2 = declaredConstructor.newInstance();

        System.out.println(p2);
    }


    //get all fields, methods and constructors
    @Test
    public void getToKnowTheClassStructure() throws Exception{
        Class clazz = Class.forName("org.example.reflection.Person");
        getAllFields(clazz);
        getMethods(clazz);
        getConstructors(clazz);
    }


    public void getAllFields(Class clazz) {
        System.out.println("**********  Print All fields  **********");
        Field fieldlist[] = clazz.getDeclaredFields();
        for (int i = 0; i < fieldlist.length; i++) {
            Field fld = fieldlist[i];
            System.out.println("name = " + fld.getName());
            System.out.println("type = " + fld.getType());
            int mod = fld.getModifiers();
            System.out.println("modifiers = " + Modifier.toString(mod));
            System.out.println("-----");
        }
    }

    public void getMethods(Class clazz) {
        System.out.println("\n**********  Print All Methods  **********");
        Method[] methodsList = clazz.getDeclaredMethods();
        for (int i = 0; i < methodsList.length; i++) {
            Method m = methodsList[i];
            System.out.println("name = " + m.getName());
            Class[] pvec = m.getParameterTypes();
            for (int j = 0; j < pvec.length; j++) System.out.println("param #" + j + ": " + pvec[j]);
            Class[] evec = m.getExceptionTypes();
            for (int j = 0; j < evec.length; j++)
                System.out.println("exc #" + j + " " + evec[j]);
            System.out.println("return type = " + m.getReturnType());
            System.out.println("-----");
        }
    }

    public void getConstructors(Class clazz) {
        System.out.println("\n**********  Print All Constructors  **********");
        Constructor[] ctorlist = clazz.getDeclaredConstructors();
        for (Constructor ct : ctorlist) {
            System.out.println("name = " + ct.getName());
            Class[] pvec = ct.getParameterTypes();
            for (int j = 0; j < pvec.length; j++)
                System.out.println("param #" + j + ": " + pvec[j]);
            Class[] evec = ct.getExceptionTypes();
            for (int j = 0; j < evec.length; j++)
                System.out.println("exc #" + j + ": " + evec[j]);
            System.out.println("-----");
        }
    }


}
