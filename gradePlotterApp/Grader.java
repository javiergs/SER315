import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Grader {

    private Repository repository;

    public Grader(Repository repository) {
        this.repository = repository;
    }

    public int loadGrades(String filename) {
        int unknownStudents = 0;
        Map<String, List<String>> studentGrades = new HashMap<>();
        List<String> headers = new ArrayList<>();

        String csvLine;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((csvLine = br.readLine()) != null) {
                String[] split = csvLine.split(",");
                if (csvLine.length() < 1 || split.length < 1) {
                    continue;
                }
                if (csvLine.startsWith("SIS Login ID")) {
                    headers.addAll(Arrays.asList(csvLine.split(",")));
                } else {
                    String[] gradesOfAStudent = csvLine.split(",");
                    List<String> grades = new ArrayList<>();
                    for (int i = 1; i < gradesOfAStudent.length; i++) {
                        grades.add(gradesOfAStudent[i]);
                    }
                    studentGrades.put(gradesOfAStudent[0], grades);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        RepositoryIterator itr = repository.getIterator();
        while (itr.hasNext()) {
            Decorator student = itr.next();
            List<String> currentStudentGrades = studentGrades.get(student.getAsurite());
            if (currentStudentGrades == null) {
                unknownStudents++;
            } else {
                for (int i = 0; i < currentStudentGrades.size(); i++) {
                    DecoratorGrades gradeCard = new DecoratorGrades(headers.get(i + 1), Float.parseFloat(currentStudentGrades.get(i)), 100);
                    gradeCard.add(student);
                    student = gradeCard;
                }
                repository.updateStudent(student.getAsurite(), student);
            }
        }
        return unknownStudents;
    }

}
