package org.example;

/**
 * Класс, содержащий два поля, которые имеют тип Interface1, Interface2 и выполненяющий с ними определенные действия
 */
public class SomeClass {
    @AutoInjectable
    public Interface1 field1;
    @AutoInjectable
    public Interface2 field2;

    /**
     * Метод класса, возвращающий значения функций, принадлежащих разным полям класса
     * @returnи строка
     */
    public String someFunc(){
        String str=field1.func1()+field2.func2();
        return str;
    }

}
