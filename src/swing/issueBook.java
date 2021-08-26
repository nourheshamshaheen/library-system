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
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class issueBook {
	
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel label_title;
	private static JLabel label_book_no;
	private static JTextField book_no;
	private static JLabel label_sid;
	private static JTextField sid;
	private static JLabel label_sname;
	private static JTextField sname;
	private static JLabel label_snumber;
	private static JTextField snumber;
	private static JLabel label_issuedate;
	private static JTextField issuedate;
	private static JButton button_add;
	private static JButton button_back;
	private static JLabel label_error;
	private static JLabel label_error1;
	private static JLabel label_error2;
	private static JLabel label_error3;
	
	issueBook()
	{
		panel = new JPanel();
		frame = new JFrame();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(340,390);
		frame.add(panel);

		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		
		label_error = new JLabel("");
		label_error.setBounds(10,250, 300, 25);
		panel.add(label_error);
		label_error.setForeground(Color.RED);
		
		label_error1 = new JLabel("");
		label_error1.setBounds(10,275, 300, 25);
		panel.add(label_error1);
		label_error1.setForeground(Color.RED);
		
		label_error2 = new JLabel("");
		label_error2.setBounds(10,300, 300, 25);
		panel.add(label_error2);
		label_error2.setForeground(Color.RED);
		
		label_error3 = new JLabel("");
		label_error3.setBounds(10,325, 300, 25);
		panel.add(label_error3);
		label_error3.setForeground(Color.RED);
		
		
		label_title = new JLabel("Issue Books");
		label_title.setBounds(120,03,130,50);
		panel.add(label_title);
		label_title.setForeground(Color.CYAN);
		label_title.setFont(new Font("BankGothic Lt BT", Font.BOLD, 15));
		
		label_book_no = new JLabel("Call no:");
		label_book_no.setBounds(10,40,100,25);
		panel.add(label_book_no);
		label_book_no.setForeground(Color.CYAN);
		label_book_no.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		book_no = new JTextField(20);
		book_no.setBounds(130,40,155,25);
		panel.add(book_no);
		
		label_sid = new JLabel("Student ID:");
		label_sid.setBounds(10,70,110,25);
		panel.add(label_sid);
		label_sid.setForeground(Color.CYAN);
		label_sid.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		sid = new JTextField(40);
		sid.setBounds(130,70,155,25);
		panel.add(sid);
		
		label_sname = new JLabel("Student Name:");
		label_sname.setBounds(10,100,110,25);
		panel.add(label_sname);
		label_sname.setForeground(Color.CYAN);
		label_sname.setFont(new Font("BankGothic Lt BT", Font.BOLD, 12));
		
		sname = new JTextField(20);
		sname.setBounds(130,100,155,25);
		panel.add(sname);
		
		label_snumber = new JLabel("Student Number:");
		label_snumber.setBounds(10,130,110,25);
		panel.add(label_snumber);
		label_snumber.setForeground(Color.CYAN);
		label_snumber.setFont(new Font("BankGothic Lt BT", Font.BOLD, 11));
		
		snumber = new JTextField(20);
		snumber.setBounds(130,130,155,25);
		panel.add(snumber);
		
		label_issuedate = new JLabel("Issue Date:");
		label_issuedate.setBounds(10,160,100,25);
		panel.add(label_issuedate);
		label_issuedate.setForeground(Color.CYAN);
		label_issuedate.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		issuedate = new JTextField(20);
		issuedate.setBounds(130,160,155,25);
		panel.add(issuedate);
				
		button_add = new JButton("Issue Book");
		button_add.setBounds(105, 190, 120, 25);
		button_add.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		button_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				issue_actionPerformed(e);
			}
		});
		panel.add(button_add);
		
		button_back = new JButton("Back");
		button_back.setBounds(120, 220, 80, 25);
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

	private void issue_actionPerformed(java.awt.event.ActionEvent e) {
		if(isfieldempty())
		{
			label_error.setText("Please fill all fields.");			
		}
		else if(invalid_callno(book_no.getText()) || invalid_sid(sid.getText()) || invalid_number(snumber.getText()) || invalid_date(issuedate.getText()))
		{
			if(invalid_callno(book_no.getText()))
			{
				label_error.setText("*Invalid Call NO. It should be letter @ number.");
			}
			else
			{
				label_error.setText("");
				label_error1.setText("");
				label_error2.setText("");
				label_error3.setText("");
			}
			if(invalid_sid(sid.getText()))
			{
				if(label_error.getText().isEmpty())
					label_error.setText("*Invalid Student ID. Numbers only.");
				else label_error1.setText("*Invalid Student ID. Numbers only.");
			}
			else
			{
				label_error1.setText("");
				label_error2.setText("");
				label_error3.setText("");
			}
			if(invalid_number(snumber.getText()))
			{
				if(label_error.getText().isEmpty())
					label_error.setText("*Invalid Phone number. Correct it.");
				else if(label_error1.getText().isEmpty())
					label_error1.setText("*Invalid Phone number. Correct it.");
				else label_error2.setText("*Invalid Phone number. Correct it.");
			}
			else
			{
				label_error2.setText("");
				label_error3.setText("");
			}
			if(invalid_date(issuedate.getText()))
			{
				if(label_error.getText().isEmpty())
					label_error.setText("*Invalid Date: should be YYYY-MM-DD & in the future!");
				else if(label_error1.getText().isEmpty())	
					label_error1.setText("*Invalid Date: should be YYYY-MM-DD & in the future!");
				else if(label_error2.getText().isEmpty())	
					label_error2.setText("*Invalid Date: should be YYYY-MM-DD & in the future!");
				else label_error3.setText("*Invalid Date: should be YYYY-MM-DD & in the future!");
			}
			else
			{
				label_error3.setText("");
			}
		}
		else
		{
			label_error1.setText("");
			label_error2.setText("");
			label_error3.setText("");
			
			if(!Exists(book_no.getText()))
			{
				label_error.setText("<html> *Book call no doesn't exist in database. <br/> Please issue available books.");
			}
			else
			{
				if(hasTwoCopies(book_no.getText(), sid.getText()))
				{
					label_error.setText("");
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Student already issued this book before!");
				}
				else if(!canStudentBorrow(sid.getText()))
				{
					label_error.setText("");
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "<html> *Student has max. number of books borrowed. <br/> Please return book before borrowing again.");
				}
				else if(!studentExists(sid.getText()))
				{
					label_error.setText("");
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "<html> *Student ID does not exist in Student database. <br/> Check ID.");
				}
				else if(!incrementIssued(book_no.getText()))
				{
					label_error.setText("<html>Cannot issue this book!<br/> All copies are already issued!");					
				}
				else
				{
					addtofile();
					label_error.setText("");
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Book Issued Successfully!");
					frame.dispose();
					new librarianSection();
				}				
			}
		}
	}
	
	private void back_actionPerformed(java.awt.event.ActionEvent e) {
		frame.dispose();
		new librarianSection();

	}
	
	private boolean hasTwoCopies(String call_no, String ID)
	{
		try {
			File f1 = new File("Issued Books.txt");
			 if(!f1.exists()) {
			    return false;
			 }
			 Scanner stream;
			 stream = new Scanner(f1);
			 int i = 0;
			 String[] all_call_no = new String[100];
			 String[] all_ids = new String[100];
			 stream.useDelimiter(",");
			 while(stream.hasNextLine())
			 {
				 all_call_no[i] = stream.next();
				 all_ids[i] = stream.next();
				 stream.nextLine();
				 i++;
			 }
			 stream.close();
			 for(int j = 0; j < i; j++)
			 {
				 if(ID.equals(all_ids[j]) && call_no.equals(all_call_no[j]))
					 return true;
			 }
			 return false;
		}
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
		}
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
	private boolean isfieldempty()
	{
		if(book_no.getText().isEmpty() || sid.getText().isEmpty() || sname.getText().isEmpty() || snumber.getText().isEmpty() || issuedate.getText().isEmpty())
			return true;
		else return false;
	}
	private boolean invalid_number(String number)
	{
		int n = number.length();
		if((n != 11) || (number.charAt(0) !=  '0' ) || (number.charAt(1) != '1' ) || ((number.charAt(2) != '0') && (number.charAt(2) != '1') && (number.charAt(2) != '2') && (number.charAt(2) != '5')))
			return true;
		
		else return false;
	}
	private boolean invalid_date(String date)
	{
		int day;
		int month;
		int year;
		if(date.length() < 10)
		{
			return true;
		}
		else if(date.charAt(4) == date.charAt(7) && date.charAt(7) == '-')
		{
			String[] array = date.split("-", 4);
			year = Integer.parseInt(array[0]);
			month = Integer.parseInt(array[1]);
			day = Integer.parseInt(array[2]);
			
			if((month>12 || year>Calendar.getInstance().get(Calendar.YEAR)) || 
				    ((month==1||month==3||month==5||month==7||month==8||month==10||month==12) && (day>31)) 
				    || ((month==4 || month==6 || month==9 || month==11) && (day>30)) 
				    || ((month==2) && ((year%4==0 && year%100==0 && year%400!=0) || (year%4!=0) ) && day>28)
				    || ((month==2) && ((year%4==0 && year%100!=0) || (year%4==0 && year%100==0 && year%400==0)) && (day>29)))
			{
				return true;
			}
			else
			{
				Date date1;
				try {
					date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
					Date in = new Date();
					LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
					Date now = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
				    if(date1.compareTo(now) < 0)
				    	return true;
				    else
				    	return false;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return true;
				}
			}
		}
		else return true;
	}
	
	private boolean Exists(String call_no)
	{
		String[] all_call_no = new String[100];
		int i = 0;
		try{ 
			File f1 = new File("Books.txt");
			Scanner stream = new Scanner(f1);
			stream.useDelimiter(",");
			while(stream.hasNextLine()) {
				
				all_call_no[i] = stream.next();
				stream.nextLine();
				i++;
			}
			stream.close();
		}
		catch(FileNotFoundException f) {
			System.out.println("File not found."); 
		//	f.printStackTrace();
		}
		for(int j = 0; j < i; j++)
		{
			if(all_call_no[j].equalsIgnoreCase(call_no))
			{
				return true;
			}
		}
		return false;
	}
	private boolean studentExists(String sid)
	{
		try {
			File f1 = new File("Students.txt");
			 if(!f1.exists()) {
			    return true;
			 }
			 Scanner stream;
			 stream = new Scanner(f1);
			 int i = 0;
			 String[] all_ids = new String[100];
			 stream.useDelimiter(",");
			 if(!stream.hasNext())
			 {
				 stream.close();
				 return false;
			 }
			 while(stream.hasNextLine())
			 {
				 stream.next();
				 stream.next();
				 stream.next();
				 stream.next();
				 stream.next();
				 stream.next();
				 all_ids[i] = stream.next();
				 stream.nextLine();
				 i++;
			 }
			 stream.close();
			 for(int j = 0; j < i; j++)
			 {
				 if(sid.equals(all_ids[j]))
					 return true;
			 }
			 return false;
		}
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
		}
	}
	private boolean canStudentBorrow(String sid)
	{
		try {
			File f1 = new File("Issued Books.txt");
			 if(!f1.exists()) {
			    return true;
			 }
			 Scanner stream;
			 stream = new Scanner(f1);
			 int flag = 0;
			 int i = 0;
			 String[] all_ids = new String[100];
			 stream.useDelimiter(",");
			 if(!stream.hasNext())
			 {
				 stream.close();
				 return true;
			 }
			 while(stream.hasNextLine())
			 {
				 stream.next();
				 all_ids[i] = stream.next();
				 stream.nextLine();
				 i++;
			 }
			 stream.close();
			 for(int j = 0; j < i; j++)
			 {
				 if(sid.equals(all_ids[j]))
					 flag++;
			 }
			 if(flag < 3)
				 return true;
			 else return false;
		}
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
		}
	}
	private boolean incrementIssued(String call_no) // returns false if can't increment (max.books issued), returns true if increment is successful
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
					if(list[i].getIssueNumber() + 1 > list[i].getQuantity())
						return false;
					list[i].setIssueNumber(list[i].getIssueNumber()+1);
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
	private void addtofile()
	{
		try {
	         File f1 = new File("Issued Books.txt");
	         if(!f1.exists()) {
	            f1.createNewFile();
	         }
	         PrintWriter stream = new PrintWriter(new BufferedWriter(new FileWriter("Issued Books.txt", true)));
	         stream.println(book_no.getText() + "," + sid.getText() + "," + sname.getText() + "," + snumber.getText() + "," + issuedate.getText() + ",");
	         stream.close();
	      } catch(IOException e){
	         e.printStackTrace();
	}
	}
}