package swing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Student {
	
	private String name;
	private int ID;
	private String number;
	private String password;
	private String email;
	private String city;
	private String address;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Student()
	{
		
	}
	
	public Student(String name, String password)
	{
		this.name = name;
		this.password = password;
	}
	public Student(String name, String password, String email, String address, String city, String number) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.city = city;
		this.number = number;
	}
	public void addstudenttofile(String path)
	{
		try {
	         File f1 = new File(path);
	         if(!f1.exists()) {
	            f1.createNewFile();
	         }
	         
	         PrintWriter stream = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
	         stream.println(name + "," + password + "," + email + "," + address + "," + city + "," + number + "," + ID + ",");
	         stream.close();
	      } catch(IOException e){
	         e.printStackTrace();
	      }
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
