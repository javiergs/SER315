import java.util.ArrayList;
import java.util.List;

public abstract class Decorator {
	public abstract String getID();
	public abstract String getFirstName();
	public abstract String getLastName();
	public abstract String getProgram();
	public abstract String getLevel();
	public abstract String getAsurite();

	public List<DecoratorSingleGrade> getGrades() {
		List<DecoratorSingleGrade> list = new ArrayList<>();
		return list;
	}

	public List<DecoratorSingleAttendance> getAttendance() {
		List<DecoratorSingleAttendance> list = new ArrayList<>();
		return list;
	}

	public String toString() {
	  return String.format(
		  "ID: " + getID() + 
		  ", Name: " + getFirstName() + " " + getLastName() + 
		  ", Program: " + getProgram() + 
		  ", Level: " + getLevel() + 
		  ", ASURITE: " + getAsurite());
	}
}
