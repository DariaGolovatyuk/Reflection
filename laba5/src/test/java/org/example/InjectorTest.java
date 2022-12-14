package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InjectorTest {

    @BeforeEach
    void setValue()
    {
       str="13";

    }
    String str;
    @Test
    void injectTest()
    {
        SomeClass myClass = new SomeClass();
        Injector injector = new Injector();
        injector.inject(myClass);
        assertEquals(str, myClass.someFunc());
    }
}