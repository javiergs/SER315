import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

/**
 * @author Van Park
 * @author Cole Park
 * @author Jacob Shapero
 * Assignment #2
 */
public class Main extends JFrame implements ActionListener {

    private DrawPanel cPanel;
    private boolean clusterBool = false;
    private boolean neighborBool = false;

    public Main(){
        super("Project 2");

        JPanel wPanel = new JPanel();


        JCheckBox cluster = new JCheckBox("Cluster");
        cluster.setOpaque(false);
        wPanel.add(cluster);
        JCheckBox neighbor = new JCheckBox("Line");
        neighbor.setOpaque(false);
        wPanel.add(neighbor);
        JButton run = new JButton("Run");
        run.setOpaque(false);
        cluster.addActionListener(this);
        neighbor.addActionListener(this);
        run.addActionListener(this);

        cPanel = new DrawPanel();
        cPanel.setBackground(new Color(90, 90, 90));
        wPanel.setVisible(true);
        cPanel.setVisible(true);

        GridLayout grid = new GridLayout(8, 1);
        wPanel.setLayout(grid);
        wPanel.add(cluster);
        wPanel.add(neighbor);
        wPanel.add(run);

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(wPanel, BorderLayout.WEST);
        add(cPanel, BorderLayout.CENTER);


    }

    /**
     * This constructor builds the main window for the program while also maintaining the layout and creating
     * the two panels. One for the check boxes and run button and the other for the main functioning panel.
     */
    public static void main(String[] args){
        Main m = new Main();
        m.setSize(600, 600);
        m.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        m.setVisible(true);
    }
    /**
     * This function takes care of the actionListeners and does the correct command depending on what called the method.
     * @param e this is the action that called the method.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Cluster")) {
            if (!clusterBool) {
                clusterBool = true;
                System.out.println("Cluster checked");
            }
            else {
                clusterBool = false;
                System.out.println("Cluster unchecked");
            }
        }
        if(e.getActionCommand().equals("Line")) {
            if (!neighborBool) {
                neighborBool = true;
                System.out.println("Neighbor checked");
            }
            else {
                neighborBool = false;
                System.out.println("Neighbor unchecked");
            }
        }
        if(e.getActionCommand().equals("Run"))
        {
            if(clusterBool)
            {
                Cluster q = new Cluster();
                int avgX = 0, avgY = 0;
                for(Circle c: cPanel.getStack()){
                    avgX += c.getX();
                    avgY += c.getY();
                }
                avgX = avgX/cPanel.getStack().size();
                avgY = avgY/cPanel.getStack().size();
                q = q.makeCluster(cPanel.getStack(), Color.RED, Color.BLUE, new Circle(avgX+1,
                        avgY-1, Color.BLACK), new Circle(avgY-1, avgY+1, Color.BLACK));
                if(q.stack2.size() == 0 || q.stack1.size() == 0){
                    q = q.makeCluster(cPanel.getStack(), Color.RED, Color.BLUE, new Circle(avgX,
                            500, Color.BLACK), new Circle(avgY, 0, Color.BLACK));
                    if(q.stack2.size() == 0 || q.stack1.size() == 0){
                        q = q.makeCluster(cPanel.getStack(), Color.RED, Color.BLUE, new Circle(0,
                                avgY, Color.BLACK), new Circle(500, avgY, Color.BLACK));
                    }
                }
                Stack<Circle> pog = new Stack<Circle>();
                pog = q.kMean(q);
                cPanel.setStack(pog);
            }
            if(neighborBool)
            {
                Line line = new Line();
                cPanel.setStack(line.nearestNeighbors(cPanel.getStack()));

            }
            repaint();
        }
    }
}
