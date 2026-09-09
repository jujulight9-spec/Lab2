public class Student {

    private String id;
    private String name;
    private double average;

    public Student(String id, String name, double average) {
        this.id = id;
        this.name = name;
        this.average = average;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        if (average >= 0.0 && average <= 100.0) {
            this.average = average;
        }
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + average;
    }

}