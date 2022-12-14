package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Класс соотносит интерфейс с его реализацией на основе зависимостей
 */
public class Injector {

    /**
     * Метод инициализирует поля переданного объекта конкретными реализациями
     * @param obj передаваемый объект, поля которого необходимо определить
     * @return инициализироанный
     * @param <T>
     */
    public <T> T inject (T obj){
        File file = new File("test.properties");
        Properties property = new Properties();
        try {
            property.load(new FileReader(file));


    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Field[] publicFields=obj.getClass().getDeclaredFields();
        for(Field field:publicFields)
        {

            if(field.isAnnotationPresent(AutoInjectable.class)&&field.getType()== Interface1.class)
            {
                try{
                    field.set(obj,getObj(property, "Interface1"));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            if(field.isAnnotationPresent(AutoInjectable.class)&&field.getType()== Interface2.class)
            {
                try{
                    field.set(obj,getObj(property, "Interface2"));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }
    private Object getObj(Properties property,String s) {
    try {
        Object obj = null;
        Class<?> c = Class.forName(property.getProperty(s));
        obj = c.newInstance();
        return obj;
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    } catch (InstantiationException e) {
        throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    }
    }

}
