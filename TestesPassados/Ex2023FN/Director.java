public class Director extends Monitor{
    private Course degreeName;
    private StudentAdm studentAdm;

    public Director (StudentAdm stud, Course degree) {
        this.degreeName = degree;
        // ...
        this.studentAdm = stud;
        stud.attach(this);

        if(degree != stud.getStudent().getCourse())
            System.err.println("Error: Director's course must be the same as student's course");
    }

    public Course getCourseName() {
        return degreeName;
    }

    @Override
    public void update() {
        System.out.println(getCourseName() + " director reports that student " + studentAdm.getStudent().getName() + " (" + studentAdm.getStudent().getId() + ") has changed the overall grade: " + studentAdm.getStudent().getOverallGrade());
    }
}
