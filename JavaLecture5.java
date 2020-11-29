// package com.rit;

public class JavaLecture5 {

    public static void main(String[] args) {
        // System.out.println("Hi Java");

        // Simplest "Procedural-style Programming" program should have at least one "class"
        // and the "main method" inside it to start the program.
        // The "main method" is the entry point for any applications.

        // public class JavaLecture5
        // Here is a class named "JavaLecture5". The class contains the "main method" for starting the program.
        // - "public" keyword is an access modifier
        // - "class" keyword is used to declare a class in java

        // public static void main(String[] args)
        // - The keyword "public" indicates that the method can be invoked from everywhere
        // - The keyword "static" indicates the method can be invoked without creating an instance of the class
        // - The keyword "void" indicates the method doesn't "return" any value
        // - The array variable "args" contains arguments entered at the "command line" if there are no arguments then the array is empty

        // Java Variables
        // DataType variableName = value;

        String msg;
        msg = "Hi Java";
        System.out.println(msg);

        int count = 5;
        System.out.println(count);

        boolean status = true;
        status = false;
        System.out.println(status);

        double x = 4.5, y = 6.8;
        System.out.println(x + y);

        float cgpa = 3.68f;
        System.out.println(cgpa);

        char grade = 'A';
        char grade_copy = grade;
        System.out.println(grade_copy);

        // Java Constants

        final float PI = 3.14f;
        // PI = 3;              // Error: Cannot assign a value to final variable 'PI'
        System.out.println(PI);


        // Types of Java Variables
        // - Local Variable     (within method or block)
        // - Instance Variable
        // - Static Variable
    }
}
