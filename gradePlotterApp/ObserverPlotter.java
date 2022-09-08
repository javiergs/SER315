
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ObserverPlotter extends JPanel implements Observer {

    private Repository repository;
    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    public ObserverPlotter(Repository subject) {
        this.repository = subject;
        JFreeChart barChart = ChartFactory.createBarChart(
                "Grades for students",
                "Assignments",
                "Grade",
                createDataset(), PlotOrientation.VERTICAL,
                true,
                true,
                false);
        ChartPanel panelBarChart = new ChartPanel(barChart);
        add(panelBarChart);
    }
    
    public CategoryDataset createDataset() {

        RepositoryIterator iterator = repository.getIterator();

        while (iterator.hasNext()){
            Decorator student = iterator.next();
            List<DecoratorSingleGrade> grades = student.getGrades();
            for (DecoratorSingleGrade grade : grades) {
                dataset.addValue(grade.getGrade(), student.getLastName(), grade.getAssignmentName());
            }
        }
        return dataset;
    }

    public void setDataset(CategoryDataset categoryDataset) {
        this.dataset = (DefaultCategoryDataset) categoryDataset;
    }


    @Override
    public void update(Observable o, Object arg) {
        setDataset(createDataset());
    }
}
