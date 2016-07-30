package com.kn.entity;

public class Employee {
	private int idemployee;
	private String employee_name;
	private Competence competence;
	private Subpractice subpractice;
	private Vertical vertical;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int idemployee, String employee_name, Competence competence, Subpractice subpractice,
			Vertical vertical) {
		super();
		this.idemployee = idemployee;
		this.employee_name = employee_name;
		this.competence = competence;
		this.subpractice = subpractice;
		this.vertical = vertical;
	}
	public int getIdemployee() {
		return idemployee;
	}
	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	public Subpractice getSubpractice() {
		return subpractice;
	}
	public void setSubpractice(Subpractice subpractice) {
		this.subpractice = subpractice;
	}
	public Vertical getvertical() {
		return vertical;
	}
	public void setvertical(Vertical vertical) {
		this.vertical = vertical;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competence == null) ? 0 : competence.hashCode());
		result = prime * result + ((employee_name == null) ? 0 : employee_name.hashCode());
		result = prime * result + idemployee;
		result = prime * result + ((subpractice == null) ? 0 : subpractice.hashCode());
		result = prime * result + ((vertical == null) ? 0 : vertical.hashCode());
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
		Employee other = (Employee) obj;
		if (competence == null) {
			if (other.competence != null)
				return false;
		} else if (!competence.equals(other.competence))
			return false;
		if (employee_name == null) {
			if (other.employee_name != null)
				return false;
		} else if (!employee_name.equals(other.employee_name))
			return false;
		if (idemployee != other.idemployee)
			return false;
		if (subpractice == null) {
			if (other.subpractice != null)
				return false;
		} else if (!subpractice.equals(other.subpractice))
			return false;
		if (vertical == null) {
			if (other.vertical != null)
				return false;
		} else if (!vertical.equals(other.vertical))
			return false;
		return true;
	}
	
	
}
