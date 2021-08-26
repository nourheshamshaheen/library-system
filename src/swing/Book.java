package swing;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Book {
	
	private String call_no;
	private String name;
	private String author;
	private String publisher;
	private int quantity;
	private String issueDate;
	private int issueNumber;
	private String addedDate;
	
	
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public Book()
	{
		
	}
	public Book(String call_no, String name, String author, String publisher, int quantity) {
		super();
		this.call_no = call_no;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}
	
	public String getCall_no() {
		return call_no;
	}
	public void setCall_no(String call_no) {
		this.call_no = call_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void addbooktofile(String path)
	{
		 try {
	         File f1 = new File(path);
	         if(!f1.exists()) {
	            f1.createNewFile();
	         }
	         
	         PrintWriter stream = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
	         stream.println(call_no + "," + name + "," + author + "," + publisher+ "," + quantity +"," + issueNumber + "," + addedDate + ",");
	         stream.close();
	      } catch(IOException e){
	         e.printStackTrace();
	      }
	
	}
	public int getIssueNumber() {
		return issueNumber;
	}
	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}
	public String getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}	

}
