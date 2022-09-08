import java.util.List;

public class DecoratorGrades extends DecoratorAbstract {
	
	private String assignmentName;
	private float score;
	private float maxScore;
	
	public DecoratorGrades(String assignmentName, float score, float maxScore) {
		this.assignmentName = assignmentName;
		this.maxScore = maxScore;
		this.score = score;
	}
	
	@Override
	public void add(Decorator student) {
		super.add(student);
	}

	@Override
	public List<DecoratorSingleGrade> getGrades() {
		List<DecoratorSingleGrade> list = super.getGrades();
		list.add(new DecoratorSingleGrade(assignmentName, (score/maxScore)*100));
		return list;
	}

	@Override
	public List<DecoratorSingleAttendance> getAttendance() {
		return super.getAttendance();
	}

}
