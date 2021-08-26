package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class studentSection {
	
	private static JPanel panel;
	private static JFrame frame;
	private static JFrame frame1;
	private static JLabel label_title;
	private static JLabel label_fail;
	private static JButton button_viewmybooks;
	private static JButton button_back;
	private static JTable table;
	private String student_name;
	private String student_password;
	private static Book[] list_books = new Book[100];
	private static Student[] list_students = new Student[100];
	
	studentSection()
	{
		
	}
	studentSection(String name, String password)
	{
		student_name = name;
		student_password = password;
		panel = new JPanel();
		frame = new JFrame();				
		frame.setSize(300,300);
		frame.add(panel);

		panel.setLayout(null);

		frame.pack();
		frame.setLocationRelativeTo(null);
		
		label_fail = new JLabel("");
		label_fail.setBounds(20, 220, 220, 50);
		label_fail.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		label_fail.setForeground(Color.RED);
		panel.add(label_fail);
		
		label_title = new JLabel("Student Account");
		label_title.setBounds(60,20,180,50);
		panel.add(label_title);
		label_title.setForeground(Color.CYAN);
		label_title.setFont(new Font("BankGothic Lt BT", Font.BOLD, 16));
		
		panel.setBackground(Color.DARK_GRAY);
		
		
		button_viewmybooks = new JButton("View My Books");
		button_viewmybooks.setFont(new Font("BankGothic Lt BT", Font.BOLD, 16));
		button_viewmybooks.setBounds(55, 100,180, 30);
		button_viewmybooks.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				viewmybooks_actionPerformed(e);
			}
		});
		panel.add(button_viewmybooks);
		
		
		button_back = new JButton("Back");
		button_back.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		button_back.setBounds(110, 200, 70, 25);
		button_back.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				back_actionPerformed(e);
			}
		});
		panel.add(button_back);
		
		frame.setSize(300,300);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	private void back_actionPerformed(java.awt.event.ActionEvent e) {
		frame.dispose();
		new libraryManagement();
	}
	private void viewmybooks_actionPerformed(java.awt.event.ActionEvent e) {
		
		int number_of_books = getBooks();
		int ID = Integer.parseInt(getID(student_name, student_password));		
		
		frame1 = new JFrame();
				
		String names[] = {"Id", "Book Call No", "Name", "Author", "Publisher", "Return Date"};
		String[][] body = new String[3][6];
		int j = 0;
		for(int i = 0; i < number_of_books; i++)
		{
			if(list_students[i].getID() == ID)
			{
				body[j][0] = Integer.toString(i+1);
				body[j][1] = list_books[i].getCall_no();
				body[j][2] = list_books[i].getName();
				body[j][3] = list_books[i].getAuthor();
				body[j][4] = list_books[i].getPublisher();
				body[j][5] = list_books[i].getIssueDate();
				j++;
			}
		}
		
	    table = new JTable(body, names);
	    table.setBackground(Color.YELLOW);
	    table.setPreferredScrollableViewportSize(new Dimension(700, 300));
	    table.setFillsViewportHeight(true);

	    frame1.add(new JScrollPane(table));
	
	    frame1.setSize(700,300);
	    frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame1.setVisible(true);
	}
	private int getBooks()
	{
		int count = 0;
		try{ 
			File issued_books = new File("Issued Books.txt");
			Scanner stream = new Scanner(issued_books);
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
			String call_no;
			String name;
			String author;
			String publisher;
			File books = new File("Books.txt");
			Scanner stream1 = new Scanner(books);
			stream1.useDelimiter(",");
			while(stream1.hasNextLine()) {
				call_no = stream1.next();
				name = stream1.next();
				author = stream1.next();
				publisher = stream1.next();
				for(int i = 0; i < count; i++)
				{
					if(list_books[i].getCall_no().equals(call_no))
					{
						list_books[i].setName(name);
						list_books[i].setAuthor(author);
						list_books[i].setPublisher(publisher);
					}
				}
				stream1.nextLine();
			}
			stream1.close();
		}
		catch(FileNotFoundException f) {
			System.out.println("File not found. No Issued books available.");
		}
		return count;
	}
	private String getID(String name, String password)
	{
		try{ 
			File students = new File("Students.txt");
			Scanner stream = new Scanner(students);
			stream.useDelimiter(",");
			while(stream.hasNextLine()) {
				if(name.equals(stream.next()) && password.equals(stream.next()))
				{
					stream.next();
					stream.next();
					stream.next();
					stream.next();
					String id = stream.next();
					stream.close();
					return id;
				}
				stream.nextLine();
			}
			stream.close();
			return null;
		}
		catch(FileNotFoundException f) {
			System.out.println("File not found. No Issued books available.");
			return null;
		}
	}
}
	
