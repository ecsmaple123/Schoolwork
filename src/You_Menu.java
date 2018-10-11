
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/*
	MyFirstMenu is a skeleton example of a GUI Menu.
	
	Author: Mike King, 2013
*/

//Class definition, note it is an extension of JFrame (GUI) and implements the ActionListener (events)
public class You_Menu extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// declare the Container
	Container contentPane;

	// This is the constructor, when an object is created, this method is
	// called.
	public You_Menu() {
		// declare JMenuBar, JMenu and JMenuItem
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;

		// Initialize and set the JMenuBar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Initialize and add a new JMenu "File"
		menu = new JMenu("File");
		menuBar.add(menu);

		// Initialize and add new JMenuItems to JMenu "File"
		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Close");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Quit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		// Initialize and add a new JMenu "Another Menu 1"
		menu = new JMenu("Edit");
		menuBar.add(menu);

		// Initialize and add new JMenuItem to JMenu "Another Menu 1"
		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Find");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		// Initialize and add new JMenu "Another Menu 2"
		menu = new JMenu("Insert");
		menuBar.add(menu);

		// Initialize and add new JMenuItem "Item" to JMenu "Another Menu 2"
		menuItem = new JMenuItem("Image");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu = new JMenu("Tools");
		menuBar.add(menu);

		menuItem = new JMenuItem("Spelling");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Word Count");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Options");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu = new JMenu("Help");
		menuBar.add(menu);

		menuItem = new JMenuItem("About");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Help");
		menuItem.addActionListener(this);
		menu.add(menuItem);

	}

	// the menu items all call this function
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		// Menu Items
		if (event.equals("Quit")) {
			System.exit(0);
		} else if (event.equals("Open")) {
			System.out.println("You chose Open");
		} else if (event.equals("Close")) {
			System.out.println("You chose Close");
		} else if (event.equals("Undo")) {
			System.out.println("You chose Undo");
		} else if (event.equals("Cut")) {
			System.out.println("You chose Cut");
		} else if (event.equals("Copy")) {
			System.out.println("You chose Copy");
		} else if (event.equals("Paste")) {
			System.out.println("You chose Paste");
		} else if (event.equals("Find")) {
			System.out.println("You chose Find");
		} else if (event.equals("Image")) {
			System.out.println("You chose Image");
		} else if (event.equals("Spelling")) {
			System.out.println("You chose Spelling");
		} else if (event.equals("Word Count")) {
			System.out.println("You chose Word Count");
		} else if (event.equals("Options")) {
			System.out.println("You chose Options");
		} else if (event.equals("About")) {
			System.out.println("You chose About");
		} else if (event.equals("Help")) {
			System.out.println("You chose Help");
		}
	}

	public static void main(String[] args) throws IOException {

		// Create new object of type 'You_Menu'
		You_Menu window = new You_Menu();

		// Give window a title
		window.setTitle("You's First Menu");

		// Give it an initial size
		window.setSize(800, 600);

		// Show it
		window.setVisible(true);

	}

}
