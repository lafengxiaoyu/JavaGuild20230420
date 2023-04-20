package org.example.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class TestJuiceFactory {
    String fruitName = null;

    @BeforeEach
    public void setup() throws Exception{
        Properties properties = new Properties();
        File file = new File("src/config.properties");
        FileInputStream fis = new FileInputStream(file);
        properties.load(fis);
        fruitName = properties.getProperty("fruitName");
    }

    @Test
    public void ShouldReturnAppleWithF1() {
        IJuice juice = JuiceFactory.createJuice(fruitName);
        System.out.println(juice.getJuice());
    }

    @Test
    public void ShouldReturnAppleWithF2() throws Exception{
        IJuice juice = JuiceFactory2.createJuice(fruitName);
        System.out.println(juice.getJuice());
    }

}
