package swing;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class viewIssuedBooks {
	
	private static JFrame frame;
	private static JTable table;
	private static int number_of_books;
	private static Book[] list_books = new Book[100];
	private static Student[] list_students = new Student[100];
	
	viewIssuedBooks()
	{
		number_of_books = getBooks();
		
		frame = new JFrame();
				
		String names[] = {"Id", "Book Call No", "Student ID", "Student Name", "Student Contact", "Return Date"};
		String[][] body = new String[number_of_books][6];
		
		for(int i = 0; i < number_of_books; i++)
		{
			body[i][0] = Integer.toString(i+1);
			body[i][1] = list_books[i].getCall_no();
			body[i][2] = Integer.toString(list_students[i].getID());
			body[i][3] = list_students[i].getName();
			body[i][4] = list_students[i].getNumber();
			body[i][5] = list_books[i].getIssueDate();
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
	
	private int getBooks()
	{
		int count = 0;
		try{ 
			File books = new File("Issued Books.txt");
			Scanner stream = new Scanner(books);
			stream.useDelimiter(",");
			while(stream.hasNextLine()) {
				list_books[count] = new Book();
				list_students[count] = new Student();
				list_books[count].setCall_no(stream.next());
				list_students[count].setID(Integer.parseInt(stream.next()));
				list_students[count].setName(stream.next());
				list_students[count].setNumber(stream.next());
				list_books[count].setIssueDate(stream.next());
				
				stream.nextLine();
				count++;
			}
			stream.close();
		}
		catch(FileNotFoundException f) {
			System.out.println("File not found. No Issued books available.");
		}
		return count;
	}
}