package exercise_test;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = 8973172462997054265L;
	
	private String name;
	private int age;
	private String nameMother;
	private String nameFather;
	private String birthday;
	private String address;
	
	public Person() {
		
	}
	
	public Person(int age) {
		this.age = age;
	}
	
	public Person(String name, String nameFather, String nameMother, String birthday, String address) {
		super();
		this.name = name;
		this.nameFather = nameFather;
		this.nameMother = nameMother;
		this.birthday = birthday;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNameMother() {
		return nameMother;
	}
	public void setNameMother(String nameMother) {
		this.nameMother = nameMother;
	}
	public String getNameFather() {
		return nameFather;
	}
	public void setNameFather(String nameFather) {
		this.nameFather = nameFather;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
