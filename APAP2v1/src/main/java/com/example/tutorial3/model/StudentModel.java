package com.example.tutorial3.model;

public class StudentModel {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((npm == null) ? 0 : npm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentModel other = (StudentModel) obj;
		if (npm == null) {
			if (other.npm != null)
				return false;
		} else if (!npm.equals(other.npm))
			return false;
		return true;
	}

	private String name;
	private String npm;
	private double gpa;
	
	public StudentModel (String npm, String name, double gpa) {
		this.name =  name;
		this.npm = npm;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNpm() {
		return npm;
	}

	public void setNpm(String npm) {
		this.npm = npm;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	

}
