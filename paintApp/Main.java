import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
	DrawPanel dp;
	
	public Main() {
		super("Shape Drawing");
		JComboBox colorMenu;
		setLayout(new BorderLayout());
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(6,1));
		String[] colors = {"Black", "Red", "Blue", "Green", "Yellow", "Orange", "Pink"};
		colorMenu = new JComboBox(colors);
		colorMenu.addActionListener(this);
		menu.add(colorMenu);
		JRadioButton rect = new JRadioButton("Rectangle");
		JRadioButton circ = new JRadioButton("Circle");
		JRadioButton arc = new JRadioButton("Arc");
		ButtonGroup bg = new ButtonGroup();
		rect.addActionListener(this);
		circ.addActionListener(this);
		arc.addActionListener(this);
		rect.setSelected(true);
		bg.add(rect);
		bg.add(circ);
		bg.add(arc);
		menu.add(rect);
		menu.add(circ);
		menu.add(arc);
		menu.add(new JLabel(""));
		menu.add(new JLabel(""));	
		menu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(menu,BorderLayout.WEST);
		dp = new DrawPanel();
		add(dp,BorderLayout.CENTER);
		JPanel bottomBar = new JPanel();
		bottomBar.setLayout(new BorderLayout());
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		JButton undo = new JButton("Undo");
		JButton erase = new JButton("Erase");
		undo.addActionListener(this);
		erase.addActionListener(this);
		buttons.add(undo);
		buttons.add(erase);
		bottomBar.add(buttons);
		bottomBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(bottomBar,BorderLayout.SOUTH);
		dp.setShape (rect.getText());
		dp.setColor((String) colorMenu.getSelectedItem());
	}

	public static void main(String[] args) {
		Main app = new Main();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(600,400);
		app.setVisible(true);
		app.setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().getClass().getName().equals("javax.swing.JButton")) {
			if( ((JButton) e.getSource()).getText().equals("Erase")) {
				dp.erase();
			} else {
				dp.undo();
			}
		} else if(e.getSource().getClass().getName().equals("javax.swing.JRadioButton")) {
			dp.setShape (((JRadioButton)e.getSource()).getText());
		} else if(e.getSource().getClass().getName().equals("javax.swing.JComboBox")) {
			dp.setColor((String)((JComboBox)e.getSource()).getSelectedItem());
		}
	}

}
