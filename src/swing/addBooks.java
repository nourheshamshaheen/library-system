package swing;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addBooks {
	
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel label_title;
	private static JLabel label_book_no;
	private static JTextField book_no;
	private static JLabel label_name;
	private static JTextField name;
	private static JLabel label_author;
	private static JTextField author;
	private static JLabel label_publisher;
	private static JTextField publisher;
	private static JLabel label_quantity;
	private static JTextField quantity;
	private static JButton button_add;
	private static JButton button_back;
	private static JLabel label_error;
	
	addBooks()
	{
		panel = new JPanel();
		frame = new JFrame();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(300,350);
		frame.add(panel);

		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		
		label_error = new JLabel("");
		label_error.setBounds(10,250, 200, 50);
		panel.add(label_error);
		label_error.setForeground(Color.RED);
		
		
		label_title = new JLabel("Add Books");
		label_title.setBounds(110,03,100,50);
		panel.add(label_title);
		label_title.setForeground(Color.CYAN);
		label_title.setFont(new Font("BankGothic Lt BT", Font.BOLD, 15));
		
		label_book_no = new JLabel("Call no:");
		label_book_no.setBounds(10,40,80,25);
		panel.add(label_book_no);
		label_book_no.setForeground(Color.CYAN);
		label_book_no.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		book_no = new JTextField(20);
		book_no.setBounds(100,40,165,25);
		panel.add(book_no);
		
		label_name = new JLabel("Name:");
		label_name.setBounds(10,70,80,25);
		panel.add(label_name);
		label_name.setForeground(Color.CYAN);
		label_name.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		name = new JTextField(40);
		name.setBounds(100,70,165,25);
		panel.add(name);
		
		label_author = new JLabel("Author:");
		label_author.setBounds(10,100,80,25);
		panel.add(label_author);
		label_author.setForeground(Color.CYAN);
		label_author.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		author = new JTextField(20);
		author.setBounds(100,100,165,25);
		panel.add(author);
		
		label_publisher = new JLabel("Publisher:");
		label_publisher.setBounds(10,130,80,25);
		panel.add(label_publisher);
		label_publisher.setForeground(Color.CYAN);
		label_publisher.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		publisher = new JTextField(20);
		publisher.setBounds(100,130,165,25);
		panel.add(publisher);
		
		label_quantity = new JLabel("Quantity:");
		label_quantity.setBounds(10,160,80,25);
		panel.add(label_quantity);
		label_quantity.setForeground(Color.CYAN);
		label_quantity.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		quantity = new JTextField(20);
		quantity.setBounds(100,160,165,25);
		panel.add(quantity);
				
		button_add = new JButton("Add Book");
		button_add.setBounds(110, 190, 110, 25);
		button_add.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		button_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				addb_actionPerformed(e);
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

	private void addb_actionPerformed(java.awt.event.ActionEvent e) {
		if(isfieldempty())
		{
			label_error.setText("Please fill all fields.");			
		}
		else if(invalid_callno(book_no.getText()) && invalid_quantity(quantity.getText()))
		{
			label_error.setText("<html>*Invalid Call NO. It should be letter @ number. <br/> *Invalid Quantity. Numbers only.</html>");
		}
		
		else if(invalid_callno(book_no.getText()))
		{
			label_error.setText("*Invalid Call NO. It should be letter @ number.");
		}
		else if(invalid_quantity(quantity.getText()))
		{
			label_error.setText("*Invalid Quantity. Numbers only.");
		}
		else
		{
			addtofile();
			label_error.setText("");
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Book Added Successfully!");
			frame.dispose();
			new librarianSection();
		}
	}
	
	private void back_actionPerformed(java.awt.event.ActionEvent e) {
		frame.dispose();
		new librarianSection();

	}
	
	private boolean invalid_callno(String call_no)
	{
		int n = call_no.length();
		if(call_no.isEmpty())
		{
			return false;
		}
		else if(call_no.length()<3)
			return true;
		else if(Character.isLetter(call_no.charAt(0)) && call_no.charAt(1) == '@' && Character.isDigit(call_no.charAt(2)) && n == 3)
			return false;
		else return true;
	}
	
	private boolean invalid_quantity(String quantity)
	{
		int n = quantity.length();
		for(int i = 0; i < n; i++)
		{	// Check if character is digit from 0-9
			if (Character.isDigit(quantity.charAt(i))) 
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
		if(book_no.getText().isEmpty() || name.getText().isEmpty() || author.getText().isEmpty() || publisher.getText().isEmpty() || quantity.getText().isEmpty())
			return true;
		else return false;
	}
	private void addtofile()
	{
		Book obj = new Book(book_no.getText(), name.getText(), author.getText(), publisher.getText(), Integer.parseInt(quantity.getText()));
		obj.setIssueNumber(0);
		String date = LocalDateTime.now().toString();
		obj.setAddedDate(date);
		obj.addbooktofile("Books.txt");
	}
}
