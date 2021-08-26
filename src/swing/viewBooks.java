package swing;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class viewBooks {
	
	private static JFrame frame;
	private static JTable table;
	private static int number_of_books;
	private static Book[] list = new Book[100];
	
	viewBooks()
	{
		number_of_books = getBooks();
		
		frame = new JFrame();
				
		String names[] = {"Id", "Book Call No", "Name", "Author", "Publisher", "Quantity", "Issued", "Date Added"};
		String[][] body = new String[number_of_books][8];
		
		for(int i = 0; i < number_of_books; i++)
		{
			body[i][0] = Integer.toString(i+1);
			body[i][1] = list[i].getCall_no();
			body[i][2] = list[i].getName();
			body[i][3] = list[i].getAuthor();
			body[i][4] = list[i].getPublisher();
			body[i][5] = Integer.toString(list[i].getQuantity());
			body[i][6] = Integer.toString(list[i].getIssueNumber());
			body[i][7] = list[i].getAddedDate();
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
	
	public int getBooks()
	{
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
		}
		catch(FileNotFoundException f) {
			System.out.println("File not found. No books available!");
		//	f.printStackTrace();
		}
		return count;
	}
}
