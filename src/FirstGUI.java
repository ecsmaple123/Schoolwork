import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class FirstGUI extends JFrame implements ActionListener
{
    public FirstGUI()
    {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu = new JMenu("File");
        menuBar.add(menu);

        menuItem = new JMenuItem("Quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Load");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu = new JMenu("Player Menu");
        menuBar.add(menu);

        menuItem = new JMenuItem("Add a Player");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu = new JMenu("Display Menu");
        menuBar.add(menu);

        menuItem = new JMenuItem("Display all Players");
        menuItem.addActionListener(this);
        menu.add(menuItem);
    }
    public static void main(String[] args) throws IOException
    {
        FirstGUI window = new FirstGUI();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Toronto Blue Jays Draft Choices");
        window.setSize(800,600);
        window.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}