import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reporter {

    private Repository repository;

    public Reporter(Repository repository) {
        this.repository = repository;
    }

    public int loadAttendance(String filename) {
        int unknownStudents = 0;
        Map<String, List<String>> studentAttendance = new HashMap<>();
        List<String> headers = new ArrayList<>();

        String csvLine;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((csvLine = br.readLine()) != null) {
                if (csvLine.length() < 1) {
                    continue;
                }
                if (csvLine.contains("User Email")) {
                    headers.addAll(Arrays.asList(csvLine.split(",")));
                } else {
                    List<String> attendance = new ArrayList<>();
                    String[] values = csvLine.split(",");
                    for (int i = 1; i < values.length; i++) {
                        attendance.add(values[i]);
                    }
                    String[] id = values[0].split("@");
                    studentAttendance.put(id[0], attendance);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        RepositoryIterator itr = repository.getIterator();
        while (itr.hasNext()) {
            Decorator student = itr.next();
            List<String> currentStudentAttendance = studentAttendance.get(student.getAsurite());

            if (currentStudentAttendance == null) {
                unknownStudents++;
            } else {
                DecoratorAttendance attendanceCard;
                for (int i = 0; i < currentStudentAttendance.size(); i++) {
                    attendanceCard = new DecoratorAttendance(headers.get(i+1), Float.parseFloat(currentStudentAttendance.get(i)));
                    attendanceCard.add(student);
                    student = attendanceCard;
                }
                repository.updateStudent(student.getAsurite(), student);
            }
        }
        return unknownStudents;
    }
}