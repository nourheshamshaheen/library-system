package swing;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class adminSection{
	
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel label_title;
	private static JButton button_add;
	private static JButton button_view;
	private static JButton button_delete;
	private static JButton button_students;
	private static JButton button_logout;
	
	adminSection()
	{
		panel = new JPanel();
		frame = new JFrame();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(300,300);
		
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		frame.add(panel);
		
		label_title = new JLabel("Admin Section");
		label_title.setBounds(80,10,180,50);
		panel.add(label_title);
		label_title.setForeground(Color.CYAN);
		label_title.setFont(new Font("BankGothic Lt BT", Font.BOLD, 15));
		
		button_add = new JButton("Add Librarian");
		button_add.setBounds(70, 60, 150, 25);
		button_add.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		panel.add(button_add);
		button_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				add_actionPerformed(e);
			}
		});

		
		button_view = new JButton("View Librarian");
		button_view.setBounds(70, 90, 150, 25);
		button_view.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		panel.add(button_view);
		button_view.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				view_actionPerformed(e);
			}
		});
		
		button_delete = new JButton("Delete Librarian");
		button_delete.setBounds(70, 120, 150, 25);
		button_delete.setFont(new Font("BankGothic Lt BT", Font.BOLD, 12));
		panel.add(button_delete);
		button_delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				delete_actionPerformed(e);
			}
		});
		
		button_students = new JButton("Add Student");
		button_students.setBounds(70, 150, 150, 25);
		button_students.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
		panel.add(button_students);
		button_students.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				students_actionPerformed(e);
			}
		});

		
		button_logout = new JButton("Logout");
		button_logout.setBounds(70, 180, 150, 25);
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
		new addLibrarian();
	}
	
	private void view_actionPerformed(java.awt.event.ActionEvent e) {
		new viewLibrarian();
	}
	
	private void delete_actionPerformed(java.awt.event.ActionEvent e) {
		frame.dispose();
		new deleteLibrarian();
	}
	
	private void students_actionPerformed(java.awt.event.ActionEvent e) {
		frame.dispose();
		new addStudent();
	}
	
	private void logout_actionPerformed(java.awt.event.ActionEvent e) {
		System.out.println("Logging out...");
		frame.dispose();
		new libraryManagement();
	}


}
