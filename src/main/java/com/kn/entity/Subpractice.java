package com.kn.entity;

public class Subpractice {

	private int idsubpractice;
	private String subpractice_name;
	public Subpractice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subpractice(int idsubpractice, String subpractice_name) {
		super();
		this.idsubpractice = idsubpractice;
		this.subpractice_name = subpractice_name;
	}
	public int getIdsubpractice() {
		return idsubpractice;
	}
	public void setIdsubpractice(int idsubpractice) {
		this.idsubpractice = idsubpractice;
	}
	public String getSubpractice_name() {
		return subpractice_name;
	}
	public void setSubpractice_name(String subpractice_name) {
		this.subpractice_name = subpractice_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idsubpractice;
		result = prime * result + ((subpractice_name == null) ? 0 : subpractice_name.hashCode());
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
		Subpractice other = (Subpractice) obj;
		if (idsubpractice != other.idsubpractice)
			return false;
		if (subpractice_name == null) {
			if (other.subpractice_name != null)
				return false;
		} else if (!subpractice_name.equals(other.subpractice_name))
			return false;
		return true;
	}
	
	
}
