package swing;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class returnBook {
	
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel label_title;
	private static JLabel label_book_no;
	private static JTextField book_no;
	private static JLabel label_id;
	private static JLabel label_error;
	private static JTextField id;
	private static JButton button_return;
	private static JButton button_back;

	private static Book[] list_books = new Book[100];
	private static Student[] list_students = new Student[100];
	private static String issue_date = null;
	
	
	

	returnBook()
	{
		panel = new JPanel();
		frame = new JFrame();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(300,300);
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		
		label_title = new JLabel("Return Book");
		label_title.setBounds(90,20,130,50);
		panel.add(label_title);
		label_title.setForeground(Color.CYAN);
		label_title.setFont(new Font("BankGothic Lt BT", Font.BOLD, 16));
		
		label_book_no = new JLabel("Call no:");
		label_book_no.setBounds(10,70,90,25);
		label_book_no.setForeground(Color.CYAN);
		label_book_no.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		panel.add(label_book_no);
		
		book_no = new JTextField(20);
		book_no.setBounds(110,70,165,25);
		panel.add(book_no);
		
		label_id = new JLabel("Student ID:");
		label_id.setBounds(10,110,110,25);
		label_id.setForeground(Color.CYAN);
		label_id.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		panel.add(label_id);
		
		label_error = new JLabel("");
		label_error.setBounds(10,200,270,50);
		label_error.setForeground(Color.RED);
		panel.add(label_error);
		
		id = new JTextField();
		id.setBounds(110,110,165,25);
		panel.add(id);
		
		button_return = new JButton("Return Book");
		button_return.setBounds(90, 150, 130, 25);
		button_return.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		button_return.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				returnb_actionPerformed(e);
			}
		});
		
		panel.add(button_return);
		

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


	private void returnb_actionPerformed(java.awt.event.ActionEvent e) {
		if(book_no.getText().isEmpty() || id.getText().isEmpty())
		{
			label_error.setText("Please fill all fields!");
		}
		else if(invalid_callno(book_no.getText()) && invalid_sid(id.getText()))
		{
			label_error.setText("<html>*Invalid Call NO. It should be letter @ number. <br/> *Invalid Student ID. Numbers only.</html>");
		}
		
		else if(invalid_callno(book_no.getText()))
		{
			label_error.setText("*Invalid Call NO. It should be letter @ number.");
		}
		else if(invalid_sid(id.getText()))
		{
			label_error.setText("*Invalid Student ID. Numbers only.");
		}
		else
		{
			if(Exists(book_no.getText(), id.getText()))
			{
				decrementIssued(book_no.getText());
				label_error.setText("");
				JFrame f = new JFrame();
				deleteentry(book_no.getText(), Integer.parseInt(id.getText()));
				if(isLate(issue_date))
					JOptionPane.showMessageDialog(f, "<html> Book Returned Late! <br/> Financial Penalty will be applied.");
				else
					JOptionPane.showMessageDialog(f, "Book Returned Successfully!");

				frame.dispose();
			}
			else
			{
				label_error.setText("");
				label_error.setText("");
				JFrame f = new JFrame();
				JOptionPane.showMessageDialog(f, "<html> Cannot Return Book! <br/> Check if book is issued! <br/> Check property of book!");
				frame.dispose();
				new returnBook();	
			}
				
		}

	}
	
	private void back_actionPerformed(java.awt.event.ActionEvent e) {
		frame.dispose();
		new librarianSection();

	}
	private boolean Exists(String call_no, String id)
	{
		String[] all_call_no = new String[100];
		String[] all_id = new String[100];
		int i = 0;
		try{ 
			File f1 = new File("Issued Books.txt");
			Scanner stream = new Scanner(f1);
			stream.useDelimiter(",");
			while(stream.hasNextLine()) {
				
				all_call_no[i] = stream.next();
				all_id[i] = stream.next();
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
			if(all_call_no[j].equalsIgnoreCase(call_no) && all_id[j].equals(id))
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean invalid_sid(String sid)
	{
		int n = sid.length();
		for(int i = 0; i < n; i++)
		{
			if (Character.isDigit(sid.charAt(i))) 
			{
				continue;
			}
	        else 
	        {
	        	return true;
	        }
		}
		return false;
	}
	
	private boolean invalid_callno(String call_no)
	{
		int n = call_no.length();
		if(call_no.isEmpty())
		{
			return false;
		}
		else if(Character.isLetter(call_no.charAt(0)) && call_no.charAt(1) == '@' && Character.isDigit(call_no.charAt(2)) && n == 3)
			return false;
		else return true;
	}
	
	private void deleteentry(String call_no, int id)
	{
		try  
		{         
			int number_of_issued = getBooks();
			File f1= new File("Issued Books.txt");                    
			f1.delete();
			for(int i = 0; i < number_of_issued; i++)
			{
				if(!(list_books[i].getCall_no().equals(call_no) && list_students[i].getID() == id))
				{
					addentrytofile("Issued Books.txt", list_books[i].getCall_no(), list_students[i].getID(), list_students[i].getName(), list_students[i].getNumber(), list_books[i].getIssueDate());					
				}
				else
				{
					issue_date = list_books[i].getIssueDate();
				}
								
			}
		}
		catch(Exception e)  
		{  
			e.printStackTrace();  
		}
		
	} 
	
	private void addentrytofile(String path, String book_no, int sid, String sname, String snumber, String issuedate)
	{
		try {
	         File f1 = new File(path);
	         if(!f1.exists()) {
	            f1.createNewFile();
	         }
	         PrintWriter stream = new PrintWriter(new BufferedWriter(new FileWriter("Issued Books.txt", true)));
	         stream.println(book_no + "," + sid + "," + sname + "," + snumber + "," + issuedate + ",");
	         stream.close();
	         System.out.println("Book added to file.");
	      }
		catch(IOException e){
	         e.printStackTrace();
	      }
	}
	private boolean decrementIssued(String call_no) // returns false if can't increment (max.books issued), returns true if increment is successful
	{
		Book list[] = new Book[100];
		int count = 0;
		try{ 
			File books = new File("Books.txt");
			Scanner stream = new Scanner(books);
			stream.useDelimiter(",");
			while(stream.hasNextLine()) {
				list[count] = new Book();
				list[count].setCall_no(stream.next());
				list[count].setName(stream.next());
				list[count].setAuthor(stream.next());
				list[count].setPublisher(stream.next());
				list[count].setQuantity(Integer.parseInt(stream.next()));
				list[count].setIssueNumber(Integer.parseInt(stream.next()));
				list[count].setAddedDate(stream.next());
				stream.nextLine();
				count++;
			}
			stream.close();
			for(int i = 0; i < count; i++)
			{
				if(list[i].getCall_no().equals(call_no))
				{
					if(list[i].getIssueNumber() == 0)
						return false;
					list[i].setIssueNumber(list[i].getIssueNumber()-1);
				}		
			}
			books.delete();
			for(int i = 0; i < count; i++)
			{
				Book obj = new Book(list[i].getCall_no(), list[i].getName(), list[i].getAuthor(), list[i].getPublisher(), list[i].getQuantity());
				obj.setIssueNumber(list[i].getIssueNumber());
				obj.setAddedDate(list[i].getAddedDate());
				obj.addbooktofile("Books.txt");
			}
			return true;
		}
		catch(FileNotFoundException f) {
			System.out.println("File not found. No books available!");
			return false;
		//	f.printStackTrace();
		}
	}
	private boolean isLate(String date)
	{  
	    Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Date in = new Date();
			LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
			Date now = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		    if(date1.compareTo(now) < 0)
		    {
		    	return true;
		    }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return false;
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
			System.out.println("Error occured.");
			f.printStackTrace();
		}
		return count;
	}
}
