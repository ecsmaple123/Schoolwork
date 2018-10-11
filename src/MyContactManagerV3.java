
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/*
	MyFirstMenu is a skeleton example of a GUI Menu.
	
	Author: Mike King, 2013
*/

//Class definition, note it is an extension of JFrame (GUI) and implements the ActionListener (events)
public class MyContactManagerV3 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// declare the Container
	Container contentPane;

	// This is the constructor, when an object is created, this method is
	// called.
	public MyContactManagerV3() {
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
		menuItem = new JMenuItem("Save To File");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Read From File");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Quit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		// Initialize and add a new JMenu "Another Menu 1"
		menu = new JMenu("Edit");
		menuBar.add(menu);

		// Initialize and add new JMenuItem to JMenu "Another Menu 1"
		menuItem = new JMenuItem("Add a Contact");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Delete a Contact");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Edit a Contact");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		// Initialize and add new JMenu "Another Menu 2"
		menu = new JMenu("View");
		menuBar.add(menu);

		// Initialize and add new JMenuItem "Item" to JMenu "Another Menu 2"
		menuItem = new JMenuItem("View all Contacts");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Sort Contacts");
		menuItem.addActionListener(this);
		menu.add(menuItem);

	}

	// the menu items all call this function
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		// Menu Items
		if (event.equals("Quit")) {
			System.exit(0);
		} else if (event.equals("Save To File")) {
			
			
			

		} else if (event.equals("Read From File")) {
			
			
			

		} else if (event.equals("Add a Contact")) {
			
			
			

		} else if (event.equals("Delete a Contact")) {
			
			
			
			

		} else if (event.equals("Edit a Contact")) {

			
			
			
			
		} else if (event.equals("View all Contacts")) {

			
			
			
			
		} else if (event.equals("Sort Contacts")) {
			
			
			
			
		}

	}

	public static void main(String[] args) throws IOException {

		// Create new object of type 'You_Menu'
		MyContactManagerV3 window = new MyContactManagerV3();

		// Give window a title
		window.setTitle("You's First Menu");

		// Give it an initial size
		window.setSize(800, 600);

		// Show it
		window.setVisible(true);

	}

}
