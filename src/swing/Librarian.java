package swing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Librarian {
	private String name;
	private String password;
	private String email;
	private String address;
	private String city;
	private String number;
	
	Librarian()
	{
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public Librarian(String name, String password, String email, String address, String city, String number) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.city = city;
		this.number = number;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Librarian(String name, String password)
	{
		this.name = name;
		this.password = password;
	}

	public String getName()
	{
		return name;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void addlibrariantofile(String path)
	{
		try {
	         File f1 = new File(path);
	         if(!f1.exists()) {
	            f1.createNewFile();
	         }
	         
	         PrintWriter stream = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
	         stream.println(name + "," + password + "," + email + "," + address + "," + city + "," + number + ",");
	         stream.close();
	      } catch(IOException e){
	         e.printStackTrace();
	      }
		
	}
	
}
