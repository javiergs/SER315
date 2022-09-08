
public class DecoratorSingleGrade {
    private String assignmentName;
    private float grade;

    public DecoratorSingleGrade(String assignmentName, float grade) {
        this.assignmentName = assignmentName;
        this.grade = grade;
    }

    public float getGrade() {
        return grade;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    @Override
    public String toString() {
        return "Decorator12SingleGrade{" +
                "assignmentName='" + assignmentName + '\'' +
                ", grade=" + grade +
                '}';
    }
}