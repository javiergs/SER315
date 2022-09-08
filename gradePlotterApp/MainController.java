import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    private Repository repository11;
    private Grader grader13;
    private Reporter reporter14;
    private MainUI main17UI;

    public MainController(Repository repository11, Grader grader13, Reporter reporter14, MainUI main17UI) {
        main17UI.createUI();
        this.repository11 = repository11;
        this.grader13 = grader13;
        this.reporter14 = reporter14;
        this.main17UI = main17UI;
        this.main17UI.addRepoClickListener(new ButtonClickListener());
        this.main17UI.addGradeClickListener(new ButtonClickListener());
        this.main17UI.addAttendanceClickListener(new ButtonClickListener());
    }

    private void loadRoster() {
        String filePath = main17UI.selectFile();
        repository11.loadRoster(filePath);
    }

    public void loadGrades() {
        String filePath = main17UI.selectFile();
        grader13.loadGrades(filePath);
    }

    public void loadAttendance() {
        String filePath = main17UI.selectFile();
        reporter14.loadAttendance(filePath);
    }

    public class ButtonClickListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                String command = e.getActionCommand();
                switch (command) {
                    case "Open Student File":
                        loadRoster();
                        break;
                    case "Open Grade File":
                        loadGrades();
                        break;
                    case "Open Attendance File":
                        loadAttendance();
                        break;
                }
            } catch (Exception ex) {
            }
        }

    }


}
