package com.bridgelabz.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class exampleAnnotation {

    @Override
    @information(author = "Harsh",date = "15-12-2023",comment = "New method")
    public String toString(){
        return " to string method";
    }

    @Deprecated
    @information(author = "Harsh",date = "15-12-2002",comment = "Old method")
    public static void old(){
        System.out.println("Old method");
    }

    public static void main(String[] args) {
            for (Method method : exampleAnnotation.class.getMethods()){
                if(method.isAnnotationPresent(information.class)){
                        for(Annotation annotation : method.getDeclaredAnnotations()){
                            System.out.println("Method: " + method + " : " + annotation);
                        }
                }
            }

            System.out.println(new exampleAnnotation().toString());
    }
}
