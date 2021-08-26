	package swing;
	import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

		public class librarianLogin {
			
			private static JPanel panel;
			private static JFrame frame;
			private static JLabel label_title;
			private static JLabel label_fail;
			private static JLabel label_name;
			private static JTextField userText;
			private static JLabel label_password;
			private static JPasswordField passwordText;
			private static JButton button_login;
			private static JButton button_back;
			private Librarian[] all_users = new Librarian[100];
			
			public void login()
			{
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
				
				label_title = new JLabel("Librarian Login");
				label_title.setBounds(90,20,180,50);
				panel.add(label_title);
				label_title.setForeground(Color.CYAN);
				label_title.setFont(new Font("BankGothic Lt BT", Font.BOLD, 15));
				
				panel.setBackground(Color.DARK_GRAY);
				
				label_name = new JLabel("Name:");
				label_name.setBounds(10,70,80,25);
				panel.add(label_name);
				label_name.setForeground(Color.CYAN);
				label_name.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
				
				userText = new JTextField(20);
				userText.setBounds(110,70,165,25);
				panel.add(userText);
				
				label_password = new JLabel("Password:");
				label_password.setBounds(10,110,110,25);
				panel.add(label_password);
				label_password.setForeground(Color.CYAN);
				label_password.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
				
				passwordText = new JPasswordField();
				passwordText.setBounds(110,110,165,25);
				panel.add(passwordText);
				
				button_login = new JButton("Login");
				button_login.setBounds(110, 170, 80, 25);
				button_login.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
				button_login.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e)
					{
						login_actionPerformed(e);
					}
				});
				panel.add(button_login);
				
				button_back = new JButton("Back");
				button_back.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
				button_back.setBounds(115, 200, 70, 25);
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
			
			public int getDatabase()
			{
				int i = 0;
				try{ 
					File login_database = new File("Librarians.txt");
					Scanner stream = new Scanner(login_database);
					stream.useDelimiter(",");
					while(stream.hasNextLine()) {
						
						all_users[i] = new Librarian(stream.next(), stream.next());
						stream.nextLine();
						i++;
					}
					stream.close();
				}
				catch(FileNotFoundException f) {
					System.out.println("Error occured.");
					f.printStackTrace();
				}
				
				int number_of_records = i;
				return number_of_records;
			}
			
			public void login_actionPerformed(ActionEvent e) {
				String user = userText.getText();
				char[] password = passwordText.getPassword();
		
				String passwordstr = String. valueOf(password);
				
				int number = getDatabase();
				boolean success = false;
				
				if(user.isEmpty() || passwordstr.isEmpty())
				{
					label_fail.setText("Fill all fields.");
				}
				else
				{
					for(int i = 0; i < number; i++)
					{
						if(user.equals(all_users[i].getName()) && passwordstr.equals(all_users[i].getPassword()))
						{
							success = true;
						}
					}
					if(success)
					{
						label_fail.setText("");
						System.out.println("Login Successful");
						frame.dispose();
						new librarianSection();
					}
					else if(!success)
					{
						System.out.println("Login Unsuccesful");
						label_fail.setText("Wrong name or password.");
					}
					
				}	
				
			}
			
			private void back_actionPerformed(java.awt.event.ActionEvent e) {
				frame.dispose();
				new libraryManagement();

			}
			
		}

