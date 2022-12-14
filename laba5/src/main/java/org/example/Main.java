package org.example;

public class Main {
    public static void main(String[] args) {
        SomeClass someBean = new SomeClass();
        Injector injector = new Injector();
        injector.inject(someBean);
        System.out.println(someBean.someFunc());
    }
}