package swing;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class libraryManagement {
	
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel label_title;
	private static JButton button_admin;
	private static JButton button_librarian;
	private static JButton button_student;
	
	libraryManagement()
	{
		panel = new JPanel();
		frame = new JFrame();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(300,300);
		frame.add(panel);
		
		panel.setBackground(Color.DARK_GRAY);
		
		panel.setLayout(null);
	
		label_title = new JLabel("Library Management");
		label_title.setBounds(60,40,200,50);
		panel.add(label_title);
		label_title.setForeground(Color.CYAN);
		label_title.setFont(new Font("BankGothic Lt BT", Font.BOLD, 15));
		
		
		button_admin = new JButton("Admin Login");
		button_admin.setBounds(70, 90, 150, 25);
		panel.add(button_admin);
		button_admin.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		button_admin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				admin_actionPerformed(e);
			}
		});
		
		button_librarian = new JButton("Librarian Login");
		button_librarian.setBounds(70, 130, 150, 25);
		panel.add(button_librarian);
		button_librarian.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		button_librarian.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				librarian_actionPerformed(e);
			}
		});
		
		button_student = new JButton("Student Login");
		button_student.setBounds(70, 170, 150, 25);
		panel.add(button_student);
		button_student.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		button_student.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				student_actionPerformed(e);
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void librarian_actionPerformed(java.awt.event.ActionEvent e) {
		frame.dispose();
		librarianLogin login = new librarianLogin();
		login.login();
	}
	private void admin_actionPerformed(java.awt.event.ActionEvent e) {	
		frame.dispose();
		adminLogin login = new adminLogin();
		login.login();
	}
	private void student_actionPerformed(java.awt.event.ActionEvent e) {	
		frame.dispose();
		studentLogin login = new studentLogin();
		login.login();
	}

}
