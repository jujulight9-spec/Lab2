import java.util.ArrayList;

public class StudentRegistry {

    private ArrayList<Student> students;

    public StudentRegistry() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudent(String id) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                return students.get(i);
            }
        }

        return null;

    }

    public boolean removeStudent(String id) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                return true;
            }
        }

        return false;

    }

    public double calculateAverage() {

        double total = 0;

        for (int i = 0; i < students.size(); i++) {
            total = total + students.get(i).getAverage();
        }

        return total / students.size();

    }

    public Student findHighestAverage() {

        Student highest = students.get(0);

        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverage() > highest.getAverage()) {
                highest = students.get(i);
            }
        }

        return highest;

    }

    public int countAbove(double threshold) {

        int count = 0;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverage() > threshold) {
                count = count + 1;
            }
        }

        return count;

    }

    @Override
    public String toString() {

        String result = "";

        for (int i = 0; i < students.size(); i++) {
            result = result + students.get(i).toString() + "\n";
        }

        return result;

    }

}