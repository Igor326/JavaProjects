package com.company;

import java.lang.reflect.Method;

public class Main {

    @Test(a = 2, b = 5)
    public static void test(int a, int b) {
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        try {
            Class<?> mainClass = Main.class;
            Method method = mainClass.getMethod("test", int.class, int.class);

            if (method.isAnnotationPresent(Test.class)) {

                Test test = method.getAnnotation(Test.class);
                method.invoke(null, test.a(), test.b());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}