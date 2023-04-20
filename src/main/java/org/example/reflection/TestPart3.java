package org.example.reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestPart3 {

    @Test
    public void InspectingConstructors() throws Exception {
        Class clazz = Class.forName("org.example.reflection.Person");
        Constructor<?>[] constructors = clazz.getConstructors();

        // Question: the number here is 2?
        Assertions.assertEquals(2, constructors.length);

        Constructor<?> cons1 = clazz.getConstructor();
        Constructor<?> cons2 = clazz.getConstructor(String.class);
        Constructor<?> cons3 = clazz.getDeclaredConstructor(String.class, boolean.class);

        Person p1 = (Person) cons1.newInstance();
        Person p2 = (Person) cons2.newInstance("Amy");

        // Why we do this?
        cons3.setAccessible(true);
        Person p3 = (Person) cons3.newInstance("Tom", true);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }

    @Test
    public void InspectingFields() throws Exception {
        Class clazz = Class.forName("org.example.reflection.Person");
        Person p = (Person) clazz.newInstance();

        Field worksField = clazz.getDeclaredField("works");
        worksField.set(p, true);

        System.out.println(worksField.get(p));

        // what if for private fields?
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(p, "Bob");
        System.out.println(p);
    }


    @Test
    public void InspectingMethods() throws Exception {
        Class clazz = Class.forName("org.example.reflection.Person");
        Person p = (Person) clazz.newInstance();

        Method showMethod = clazz.getMethod("show");
        showMethod.invoke(p);

        // call private method
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object nation = showNation.invoke(p, "Dutch");
        print(nation);
    }


    private void print(Object output) {
        System.out.println(output);
    }
}
