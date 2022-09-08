

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class ObserverTable extends JPanel implements Observer {
    private Repository repository;
    private String[][] blankData = {{"","","","","",""}};
    private String[] colHeaders = {"id", "first name", "last name", "program", "level", "asurite"};
    private JTable table = new JTable(blankData, colHeaders);
    private JScrollPane scrollPane;

    public ObserverTable(Repository repository){
        this.repository = repository;
        refreshPanel(blankData);
    }

    private static final long serialVersionUID = 1L;
    ArrayList<String[]> data = new ArrayList<String[]>();

    public void refreshPanel(String[][] tableContent) {
        table = new JTable(tableContent, colHeaders);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        this.add(scrollPane);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        this.remove(scrollPane);
        data.clear();
        RepositoryIterator iterator = repository.getIterator();
        while(iterator.hasNext()){
            Decorator student = iterator.next();
            String[] studentData = {student.getID(), student.getFirstName(), student.getLastName(), student.getProgram(), student.getLevel(), student.getAsurite()};
            data.add(studentData);
        }
        String[][] tableContent = new String[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            tableContent[i] = data.get(i);
        }

        refreshPanel(tableContent);
    }

}