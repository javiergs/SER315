import java.util.List;

public class DecoratorAbstract extends Decorator {
	
	protected Decorator student;
	
	public void add(Decorator student) {
		this.student = student;
	}

	@Override
	public String getID() {
		return student.getID();
	}

	@Override
	public String getFirstName() {
		return student.getFirstName();
	}

	@Override
	public String getLastName() {
		return student.getLastName();
	}

	@Override
	public String getProgram() {
		return student.getProgram();
	}

	@Override
	public String getLevel() {
		return student.getLevel();
	}

	@Override
	public String getAsurite() {
		return student.getAsurite();
	}

	@Override
	public List<DecoratorSingleGrade> getGrades() {
		return student.getGrades();
	}

	@Override
	public List<DecoratorSingleAttendance> getAttendance() {
		return student.getAttendance();
	}

	@Override
	public String toString() {
		String data = super.toString();
		return data + "\n" + getGrades() + "\n" + getAttendance().toString();
	}

}
