// package com.rit;

public class JavaLecture6 {

    public static void main(String[] args) {

        // Types of Languages
        // 1 - Statically-typed Languages (C/C++, Java, Scala, C#, Go, Rust, Dart, TS, Kotlin, ...)
        //   - Type checking at compile time
        // 2 - Dynamically-typed Languages (PHP, Perl, Lua, R, Ruby, JS, Python, Julia, ...)
        //   - Type checking at runtime

        // Java Data Types
        // All Java Data-Types are separated into two groups:
        // 1 - Primitive types  or Value types or Simple types
        // 2 - References types or Non-Primitive types or Object types or Complex types

        // 1 - Primitive types    (storing simple values)
        //   - Java has 8 primitive data types. They can be divided into 4 groups:
        //   - Integer Numbers:          byte, short, int, long
        //   - Floating-Point Numbers:   float, double
        //   - Logical Type:             boolean
        //   - Characters:               char
        //   - The most used primitive types are "int", "long", "double", "boolean", and "char".

        // 2 - References types   (storing complex structure/objects)
        //   - String
        //   - Objects
        //   - Arrays
        //   - Classes
        //   - Interfaces

        // Sizes and Ranges of Primitive types
        // boolean: It represents only 1-bit of information, but its size is not something that's precisely defined. true or false
        // byte:    the size is 08-bits (1 byte ), the range is from -128 to 127
        // char:    the size is 16-bits (2 bytes), the range is from 0 to 65536 (unsigned)
        // short:   the size is 16-bits (2 bytes), the range is from -32768 to 32767
        // int:     the size is 32-bits (4 bytes),
        // long:    the size is 64-bits (8 bytes),
        // float:   the size is 32-bits (4 bytes), approximately 6-7 significant decimal digits
        // double:  the size is 64-bits (8 bytes), approximately 14-16 significant decimal digits

        // Default Values of Primitive types
        // boolean - false
        // char    - \u0000
        // byte, short, int, long   - 0
        // float, double            - 0.0

        // Primitive types Variables
        byte age = 26;
        short s = 5569;
        int v1 = 712928;
        long v2 = 32_754_921L;
        long v3 = 4242L;

        int decNum = 190;
        int octNum = 0457;
        int hexNum = 0xFA;
        int binNum = 0b1101;

        int minInt = Integer.MIN_VALUE;
        int maxInt = Integer.MAX_VALUE;

        float p1 = 424.42F;
        double p2 = 3523184.428d;
        double eps = 5e-3;                  // 5 * 10^(-3) = 0.0005
        // System.out.println(Double.SIZE); // 64-bits
        double minDbl = Double.MIN_VALUE;
        double maxDbl = Double.MAX_VALUE;

        char ch = 'C';
        char b = 'a' + 1;    // the 'b' character
        char d = 'b' + 2;    // the 'd' character
        char ch1 = 101;      // the 'e' character
        char ch2 = '\u0040'; // the '@' character

        boolean r1 = true;
        boolean r2 = false;
        boolean r3 = 5 > 2;

        // References types Variables
        String msg1 = "Java Programming ";
        String msg2 = new String("Hi Java String");
        String newStr = msg1.concat("for Android");
        System.out.println(newStr);

        // Happy Learning :)
    }
}
