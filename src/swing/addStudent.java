package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class addStudent {
	
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel label_title;
	private static JLabel label_name;
	private static JTextField name;
	private static JLabel label_password;
	private static JPasswordField password;
	private static JLabel label_email;
	private static JTextField email;
	private static JLabel label_address;
	private static JTextField address;
	private static JLabel label_city;
	private static JTextField city;
	private static JLabel label_number;
	private static JTextField number;
	private static JButton button_add;
	private static JButton button_back;
	private static JLabel label_id;
	private static JTextField id;
	private static JLabel label_error;
	private static JLabel label_error1;
	private static JLabel label_error2;
	
	addStudent()
	{
		panel = new JPanel();
		frame = new JFrame();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(360,430);
		frame.add(panel);

		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		
		label_error = new JLabel("");
		label_error.setBounds(10,310, 350, 25);
		panel.add(label_error);
		label_error.setForeground(Color.RED);
		
		label_error1 = new JLabel("");
		label_error1.setBounds(10,335, 350, 25);
		panel.add(label_error1);
		label_error1.setForeground(Color.RED);

		label_error2 = new JLabel("");
		label_error2.setBounds(10,360, 350, 25);
		panel.add(label_error2);
		label_error2.setForeground(Color.RED);
		
		
		label_title = new JLabel("Add Student");
		label_title.setBounds(100,03,130,50);
		panel.add(label_title);
		label_title.setForeground(Color.CYAN);
		label_title.setFont(new Font("BankGothic Lt BT", Font.BOLD, 15));
		
		label_name = new JLabel("Name:");
		label_name.setBounds(10,40,80,25);
		panel.add(label_name);
		label_name.setForeground(Color.CYAN);
		label_name.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		name = new JTextField(40);
		name.setBounds(130,40,165,25);
		panel.add(name);
		
		label_password = new JLabel("Password:");
		label_password.setBounds(10,70,80,25);
		panel.add(label_password);
		label_password.setForeground(Color.CYAN);
		label_password.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		password = new JPasswordField(20);
		password.setBounds(130,70,165,25);
		panel.add(password);
		
		label_email = new JLabel("Email:");
		label_email.setBounds(10,100,80,25);
		panel.add(label_email);
		label_email.setForeground(Color.CYAN);
		label_email.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		email = new JTextField(20);
		email.setBounds(130,100,165,25);
		panel.add(email);
		
		label_address = new JLabel("Address:");
		label_address.setBounds(10,130,80,25);
		panel.add(label_address);
		label_address.setForeground(Color.CYAN);
		label_address.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		address = new JTextField(20);
		address.setBounds(130,130,165,25);
		panel.add(address);
		
		label_city = new JLabel("City:");
		label_city.setBounds(10,160,80,25);
		panel.add(label_city);
		label_city.setForeground(Color.CYAN);
		label_city.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		
		city = new JTextField(20);
		city.setBounds(130,160,165,25);
		panel.add(city);
		
		label_number = new JLabel("Phone Number:");
		label_number.setBounds(10,190,120,25);
		panel.add(label_number);
		label_number.setForeground(Color.CYAN);
		label_number.setFont(new Font("BankGothic Lt BT", Font.BOLD, 12));
		
		number = new JTextField(20);
		number.setBounds(130,190,165,25);
		panel.add(number);
		
		label_id = new JLabel("ID:");
		label_id.setBounds(10,220,80,25);
		panel.add(label_id);
		label_id.setForeground(Color.CYAN);
		label_id.setFont(new Font("BankGothic Lt BT", Font.BOLD, 12));
		
		id = new JTextField(20);
		id.setBounds(130,220,165,25);
		panel.add(id);

		
		
		button_add = new JButton("Add Student");
		button_add.setBounds(90, 250, 150, 25);
		button_add.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		button_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				adds_actionPerformed(e);
			}
		});
		panel.add(button_add);
		
		button_back = new JButton("Back");
		button_back.setBounds(120, 280, 80, 25);
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
	
	private void adds_actionPerformed(java.awt.event.ActionEvent e) {
		if(isfieldempty())
		{
			label_error.setText("Please fill all fields.");			
		}
		else if(invalid_email(email.getText()) || invalid_number(number.getText()) || invalid_sid(id.getText()))
		{
			if(invalid_email(email.getText()))
			{
				label_error.setText("*Invalid Email. It should be email@domain.com (net, org, gov)");
			}
			else
			{
				label_error.setText("");
				label_error1.setText("");
				label_error2.setText("");
			}
			if(invalid_number(number.getText()))
			{
				if(label_error.getText().isEmpty())
					label_error.setText("*Invalid Phone Number. Please Correct it.");
				else label_error1.setText("*Invalid Phone Number. Please Correct it.");
			}
			else
			{
				label_error1.setText("");
				label_error2.setText("");
			}
			if(invalid_sid(id.getText()))
			{
				if(label_error.getText().isEmpty())
					label_error.setText("*Invalid ID. Numbers only.");
				else if(label_error1.getText().isEmpty())
					label_error1.setText("*Invalid ID. Numbers only.");
				else label_error2.setText("*Invalid ID. Numbers only.");
			}
			else
			{
				label_error2.setText("");
			}
		}
		else
		{
			label_error.setText("");
			label_error1.setText("");
			label_error2.setText("");
			addtofile();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Student added successfully!");
			frame.dispose();
			new adminSection();				
		}
		
	}
	private void back_actionPerformed(java.awt.event.ActionEvent e) {
		frame.dispose();
		new adminSection();

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
		if(String.valueOf(password.getPassword()).isEmpty() || name.getText().isEmpty() || email.getText().isEmpty() || address.getText().isEmpty() || city.getText().isEmpty() || number.getText().isEmpty())
			return true;
		else return false;
	}
	private boolean invalid_email(String email)
	{
		if(!(Character.isLetter(email.charAt(0))))
		  return true;
		int at = -1;
		int dot = -1;
		for(int i = 0; i < email.length(); i++) 
		{
			if (email.charAt(i) == '@')
				at = i;
			else if(email.charAt(i) == '.')
				dot = i;
		}
		if (at == -1 || dot == -1)
			return true;
		else if(at-dot>-2)
			return true;
		else if(dot >= (email.length()-1))
			return true;
		else
			return false;

	}
	private boolean invalid_number(String number)
	{
		int n = number.length();
		if((n != 11) || (number.charAt(0) !=  '0' ) || (number.charAt(1) != '1' ) || ((number.charAt(2) != '0') && (number.charAt(2) != '1') && (number.charAt(2) != '2') && (number.charAt(2) != '5')))
			return true;
		
		else return false;
	}
	private void addtofile()
	{
		Student obj = new Student(name.getText(), String.valueOf(password.getPassword()), email.getText(), address.getText(), city.getText(), number.getText());
		obj.setID(Integer.parseInt(id.getText()));
		obj.addstudenttofile("Students.txt");
	}


}