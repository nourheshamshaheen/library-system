package swing;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class deleteLibrarian {
	
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel label_title;
	private static JLabel label_name;
	private static JTextField name;
	private static JLabel label_error;
	private static JButton button_delete;
	private static JButton button_back;
	private Librarian[] list = new Librarian[100];
	
	
	deleteLibrarian()
	{
		panel = new JPanel();
		frame = new JFrame();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(300,300);
		frame.add(panel);

		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		
		label_error = new JLabel("");
		label_error.setBounds(10,200, 350, 25);
		panel.add(label_error);
		label_error.setForeground(Color.RED);
		
		label_title = new JLabel("Delete Librarian");
		label_title.setBounds(70,30,200,50);
		panel.add(label_title);
		label_title.setForeground(Color.CYAN);
		label_title.setFont(new Font("BankGothic Lt BT", Font.BOLD, 15));
		
		label_name = new JLabel("Enter Librarian's Name:");
		label_name.setBounds(30,80,190,25);
		label_name.setForeground(Color.CYAN);
		label_name.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		panel.add(label_name);
		
		name = new JTextField(20);
		name.setBounds(40, 110, 190, 25);
		panel.add(name);
		
		button_delete = new JButton("Delete Librarian");
		button_delete.setBounds(80, 150, 160, 25);
		button_delete.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		button_delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				deletel_actionPerformed(e);
			}
		});
		panel.add(button_delete);
		
		button_back = new JButton("Back");
		button_back.setBounds(110, 180, 80, 25);
		button_back.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		button_back.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				back_actionPerformed(e);
			}
		});
		panel.add(button_back);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void deletel_actionPerformed(java.awt.event.ActionEvent e) {
		
		if(name.getText().isEmpty())
		{
			label_error.setText("Please enter a name.");
		}
		else if(!Exists(name.getText()))
		{
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Cannot delete! Librarian does not exist!");
			frame.dispose();
			new deleteLibrarian();		
		}
		else
		{
			deleteentry(name.getText());
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Librarian Deleted Successfully!");
			frame.dispose();
			new adminSection();
		}
		
	}
	private void back_actionPerformed(java.awt.event.ActionEvent e) 
	{
		frame.dispose();
		new adminSection();
	}
	private boolean Exists(String name)
	{
		String[] all_names = new String[100];
		int i = 0;
		try{ 
			File f1 = new File("Librarians.txt");
			Scanner stream = new Scanner(f1);
			stream.useDelimiter(",");
			while(stream.hasNextLine()) {
				
				all_names[i] = stream.next();
				stream.nextLine();
				i++;
			}
			stream.close();
		}
		catch(FileNotFoundException f) {
			System.out.println("Error occured.");
			f.printStackTrace();
		}
		for(int j = 0; j < i; j++)
		{
			if(all_names[j].equalsIgnoreCase(name))
			{
				return true;
			}
		}
		return false;
	}
	
	private void deleteentry(String name)
	{
		try  
		{         
			int number_of_librarians = getLibrarians();
			File f1= new File("Librarians.txt");                    
			f1.delete();
			for(int i = 0; i < number_of_librarians; i++)
			{
				if(!(list[i].getName().equals(name)))
				{
					list[i].addlibrariantofile("Librarians.txt");			
				}
			}
		}
		catch(Exception e)  
		{  
			e.printStackTrace();  
		}
		
	}
	
	private int getLibrarians()
	{
		int count = 0;
		try{ 
			File librarians = new File("Librarians.txt");
			Scanner stream = new Scanner(librarians);
			stream.useDelimiter(",");
			while(stream.hasNextLine()) {
				list[count] = new Librarian();
				list[count].setName(stream.next());
				list[count].setPassword(stream.next());
				list[count].setEmail(stream.next());
				list[count].setAddress(stream.next());
				list[count].setCity(stream.next());
				list[count].setNumber(stream.next());
				stream.nextLine();
				count++;
			}
			stream.close();
		}
		catch(FileNotFoundException f) {
			System.out.println("Error occured.");
			f.printStackTrace();
		}
		return count;		
	}
	
}

