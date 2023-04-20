package org.example.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestPart1 {


    // for the picture of reflection
    @Test
    public void normalWay() {
        // instantiate person
        Person p = new Person();

        // set field
        p.works = true;
        print(String.valueOf(p.works()));

        // call the method
        p.show();
    }

    @Test
    public void reflectionWay() throws Exception{
        // Initialize person
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        System.out.println(p);

        // set field
        Field works = clazz.getField("works");
        works.set(p, true);
        System.out.println(works.get(p));

        // call method
        Method show = clazz.getMethod("show");
        show.invoke(p);
    }


    private void print(Object output) {
        System.out.println(output);
    }
}
