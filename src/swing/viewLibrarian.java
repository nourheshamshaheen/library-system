package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class viewLibrarian {
	private static JFrame frame;
	private static JTable table;
	private static int number_of_librarians;
	private static Librarian list[] = new Librarian[100];

	viewLibrarian()
	{
		number_of_librarians = getLibrarians();
		frame = new JFrame();
		
		String names[] = {"Id", "Name", "Password", "Email", "Address", "City", "Phone Number"};
		String[][] body = new String[number_of_librarians][7];
		
		for(int i = 0; i < number_of_librarians; i++)
		{
			body[i][0] = Integer.toString(i+1);
			body[i][1] = list[i].getName();
			body[i][2] = list[i].getPassword();
			body[i][3] = list[i].getEmail();
			body[i][4] = list[i].getAddress();
			body[i][5] = list[i].getCity();
			body[i][6] = list[i].getNumber();
		}
		
	    table = new JTable(body, names);
	    table.setBackground(Color.YELLOW);
	    table.setPreferredScrollableViewportSize(new Dimension(700, 300));
	    table.setFillsViewportHeight(true);

	    frame.add(new JScrollPane(table));
	
	    frame.setSize(700,300);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setVisible(true);

		
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
			System.out.println("File not found. No librarians available!");
		//	f.printStackTrace();
		}
		return count;
	}
}
