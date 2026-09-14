import java.util.Arrays;
import java.util.ArrayList;



//Part A:
//// Part A - Predict:
// int highest = 0; is wrong because the values are all lower than 0

// Part B:

// 1 & 2. What prints, and why?
// 99
// 99
// Because a and b are the same array with just a different name.

// 3. Are a and b two arrays?
// No, just one array with two names.

// 4. Draw a small reference diagram.
// [10, 20, 30]  <- both a and b point to this one array

// 5. How would you create an independent copy?
// int[] b = Arrays.copyOf(a, a.length);


// Part D
// Chose to ignore invalid averages (must be 0-100).

// Part E
// Searching V100002 finds Daniel and returns him.
// Searching V999999 returns null, since no student has that ID.

// Part G - Design Choice:

// G1: Array. The number of stations is fixed at exactly 30 and never changes,
// so there's no need for a structure that can grow or shrink.

// G2: ArrayList. The club's membership can grow or shrink at any time,
// so a structure that can resize itself fits better than a fixed array.

// G3: ArrayList. We don't know how many records will be entered before "DONE" is typed,
// so we need a structure that can grow as records come in.

// G4: Array. There are always exactly seven days in a week,
// so the size never needs to change.

// G5: ArrayList. The enrollment limit may change in the future,
// so using a resizable structure avoids having to rewrite the code if the limit changes.
// Part H - Object Reference Challenge

// 1 & 2. What is a.getAverage() and b.getAverage()?
// 95
// 95

// 3. Why?
// Because a and b are the same Student object with just a different name.

// 4. Are a and b two Student objects?
// No, just one object with two names.

// 5. How would you create an independent Student object?
// Student b = new Student(a.getId(), a.getName(), a.getAverage());

// Part J - Responsibility Challenge
// Putting the logic inside StudentRegistry keeps main() short and readable.
// If something needs to change (like how removeStudent works), you only edit it
// in one place (StudentRegistry) instead of hunting through a giant main() method.

// Part K - Tricky Removal Requirement
// removeStudent("V100001") should return true if that ID exists in the registry.
// removeStudent("V999999") should return false, since no student has that ID.
// My test used V200001 (true) and V999999 (false), confirming this behavior works.

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

        Student[] students = {
                new Student("V100001", "Amina", 86.5),
                new Student("V100002", "Daniel", 72.0),
                new Student("V100003", "Sofia", 91.0)
        };

        System.out.println(calculateAverage(students));

        Student found = findStudent(students, "V100002");
        System.out.println(found);

        Student notFound = findStudent(students, "V999999");
        System.out.println(notFound);

        ArrayList<Student> studentList = new ArrayList<>();

        studentList.add(new Student("V100001", "Amina", 86.5));
        studentList.add(new Student("V100002", "Daniel", 72.0));
        studentList.add(new Student("V100003", "Sofia", 91.0));
        studentList.add(new Student("V100004", "Marcus", 65.0));
        studentList.add(new Student("V100005", "Elena", 78.5));

        Student foundInList = findStudent(studentList, "V100004");
        System.out.println(foundInList);

        int above75 = countAbove(studentList, 75.0);
        System.out.println(above75);
        Student ha = new Student("V100001", "Amina", 80);

        Student hb = ha;

        hb.setAverage(95);

        System.out.println(ha.getAverage());
        System.out.println(hb.getAverage());

        Student hc = new Student("V100001", "Amina", 80);

        Student hd = new Student(hc.getId(), hc.getName(), hc.getAverage());

        hd.setAverage(95);

        System.out.println(hc.getAverage());
        System.out.println(hd.getAverage());
        StudentRegistry registry = new StudentRegistry();

        registry.addStudent(new Student("V200001", "Liam", 88.0));
        registry.addStudent(new Student("V200002", "Noor", 60.0));
        registry.addStudent(new Student("V200003", "Yuki", 95.0));

        System.out.println(registry);

        System.out.println(registry.calculateAverage());

        System.out.println(registry.findHighestAverage());

        System.out.println(registry.countAbove(70.0));

        boolean removed1 = registry.removeStudent("V200001");
        boolean removed2 = registry.removeStudent("V999999");

        System.out.println(removed1);
        System.out.println(removed2);

        System.out.println(registry);


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

    public static double calculateAverage(Student[] students) {

        double total = 0;

        for (int i = 0; i < students.length; i++) {
            total = total + students[i].getAverage();
        }

        return total / students.length;

    }

    public static Student findStudent(Student[] students, String id) {

        for (int i = 0; i < students.length; i++) {
            if (students[i].getId().equals(id)) {
                return students[i];
            }
        }

        return null;

    }

    public static Student findStudent(ArrayList<Student> students, String id) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                return students.get(i);
            }
        }

        return null;

    }

    public static int countAbove(ArrayList<Student> students, double threshold) {

        int count = 0;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverage() > threshold) {
                count = count + 1;
            }
        }

        return count;

    }

}