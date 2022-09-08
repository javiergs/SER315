import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class RepositoryFileHelper {

	private static final String DELIMITER = ",";
	private static final int studentIdIDX = 0;
	private static final int firstNameIDX = 1;
	private static final int lastNameIDX = 2;
	private static final int programPlanIDX = 3;
	private static final int academicLevelIDX = 4;
	private static final int asuriteIdIDX = 5;

	public static Map<String, Decorator> readCSV(String filePath) {

		Map<String, Decorator> studentList = new HashMap<>();
		System.out.println(filePath);

		try (BufferedReader fileReader = new BufferedReader(new java.io.FileReader(filePath))){
			String fileRow ="";
			fileReader.readLine();
			while((fileRow = fileReader.readLine()) != null) {
				String[] tokens = fileRow.split(DELIMITER);
				if(tokens.length == 6){
					Decorator student = new DecoratorStudentCoreData(tokens[studentIdIDX], tokens[firstNameIDX], tokens[lastNameIDX], tokens[programPlanIDX], tokens[academicLevelIDX], tokens[asuriteIdIDX]);
					studentList.put(tokens[asuriteIdIDX],student);
				}
			}
			fileReader.close();
			return studentList;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return studentList;
	}
}
