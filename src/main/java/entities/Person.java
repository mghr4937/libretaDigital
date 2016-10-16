package entities;

import java.awt.Image;
import java.util.Date;

import utils.Gender;

public abstract class Person {
	
	private long oid;
	private String name;
	private String lastName;
	private Date birthDate;
	private Image photo;
	private Gender gender;
	private String email;
	
	public Person(){}
	
	public Person(String name, String lastName, Date birthDate, Image photo, Gender gender, String email){
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.photo = photo;
		this.gender = gender;
		this.email = email;
	}
	
	public Person(String name, String lastName, Date birthDate, Gender gender, String email){
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.email = email;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Person))
			return false;
		Person that = (Person) other;
		return this.getEmail().equals(that.getEmail());
	}
	
	@Override
	public String toString() {
		return this.getName() + " " + this.getLastName() + ". E-mail: " + this.getEmail();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Image getPhoto() {
		return photo;
	}
	public void setPhoto(Image photo) {
		this.photo = photo;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

}