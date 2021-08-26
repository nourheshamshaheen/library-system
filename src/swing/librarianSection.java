package swing;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class librarianSection {

	private static JPanel panel;
	private static JFrame frame;
	private static JLabel label_title;
	private static JButton button_add;
	private static JButton button_view;
	private static JButton button_issue;
	private static JButton button_view_issued;
	private static JButton button_return;
	private static JButton button_logout;
	
	librarianSection()
	{
		panel = new JPanel();
		frame = new JFrame();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(300,300);
		frame.add(panel);
		
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		
		label_title = new JLabel("Librarian Section");
		label_title.setBounds(70,10,200,30);
		panel.add(label_title);
		label_title.setForeground(Color.CYAN);
		label_title.setFont(new Font("BankGothic Lt BT", Font.BOLD, 15));
		
		button_add = new JButton("Add Books");
		button_add.setBounds(70, 40, 150, 25);
		button_add.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		panel.add(button_add);
		button_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				add_actionPerformed(e);
			}
		});

		
		button_view = new JButton("View Books");
		button_view.setBounds(70, 70, 150, 25);
		button_view.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		panel.add(button_view);
		button_view.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				view_actionPerformed(e);
			}
		});
		
		button_issue = new JButton("Issue Book");
		button_issue.setBounds(70, 100, 150, 25);
		button_issue.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		panel.add(button_issue);
		button_issue.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				issue_actionPerformed(e);
			}
		});
		
		button_view_issued = new JButton("View Issued Books");
		button_view_issued.setBounds(70, 130, 150, 25);
		button_view_issued.setFont(new Font("BankGothic Lt BT", Font.BOLD, 11));
		panel.add(button_view_issued);
		button_view_issued.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				view_issued_actionPerformed(e);
			}
		});
		
		button_return = new JButton("Return Book");
		button_return.setBounds(70, 160, 150, 25);
		button_return.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		panel.add(button_return);
		button_return.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				return_actionPerformed(e);
			}
		});
		button_logout = new JButton("Logout");
		button_logout.setBounds(70, 190, 150, 25);
		button_logout.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		panel.add(button_logout);
		button_logout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				logout_actionPerformed(e);
			}
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void add_actionPerformed(java.awt.event.ActionEvent e) {
		frame.dispose();
		new addBooks();
	}
	
	private void view_actionPerformed(java.awt.event.ActionEvent e) {
		new viewBooks();
	}
	
	private void issue_actionPerformed(java.awt.event.ActionEvent e) {
		frame.dispose();
		new issueBook();
	}
	
	private void view_issued_actionPerformed(java.awt.event.ActionEvent e) {	
		new viewIssuedBooks();
	}
	
	private void return_actionPerformed(java.awt.event.ActionEvent e) {
		frame.dispose();
		new returnBook();
	}
	
	private void logout_actionPerformed(java.awt.event.ActionEvent e) {
		System.out.println("Logging out...");
		frame.dispose();
		new libraryManagement();
	}
}
