import java.util.ArrayList;
public class StudentAdm {
    private Student student;
    private ArrayList<Monitor> observers = new ArrayList<>();

    public StudentAdm(Student s) {
        this.student = s;
    }

    public void addScore(String className, double score) {
        student.addScore(className, (Double) score);
        // ...
        notifyMonitor();
    }

    public Student getStudent() {
        return student;
    }

    public void attach(Monitor o) {
        observers.add(o);
    }

    private void notifyMonitor() {
        for (Monitor obs : observers) {
            obs.update();
        }
    }

    public String toString() {
        return student.toString();
    }
}







