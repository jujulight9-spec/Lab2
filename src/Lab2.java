// Part A:
//int highest = 0; is wrong because the values are all lower then 0 so the result will always be 0.

//Part B:
//Predictions:
//1. 99
//2. Because they are the same array with just a different name
//3. No, they are just one array.

//4. // Part B - Drawing.
//  a ──
//       ----- [10,20,30]
//  b ──
//  a and b are two names pointing to the same array
//5. To make an independent copy, use Arrays.copyOf(a, a.length).
//
// Part D:
// I would ignore the value

import java.util.Arrays;
public class Lab2 {

    public static void main(String[] args) {
        int[] test1 = {8, 3, 12, 5};
        int[] test2 = {5};
        int[] test3 = {-4, -8, -2};

        System.out.println(findHighest(test1));
        System.out.println(findHighest(test2));
        System.out.println(findHighest(test3));
        int[] a = {10, 20, 30};
        int[] b = a;

        b[0] = 99;

        System.out.println(a[0]);
        System.out.println(b[0]);

        int[] c = {10, 20, 30};
        int[] d = Arrays.copyOf(c, c.length);

        d[0] = 99;

        System.out.println(c[0]);
        System.out.println(d[0]);

        Student s1 = new Student("V123456", "Amina Rahman", 86.5);
        System.out.println(s1);
        s1.setAverage(105);
        System.out.println(s1);

        s1.setAverage(-5);
        System.out.println(s1);

        s1.setAverage(70.0);
        System.out.println(s1);

    }

    public static int findHighest(int[] values) {

        int highest = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] > highest) {
                highest = values[i];
            }
        }

        return highest;

    }
}