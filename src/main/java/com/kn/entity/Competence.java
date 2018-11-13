package com.kn.entity;

public class Competence {
	private int idcompetence;
	private String competence_name;
	public Competence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Competence(int idcompetence, String competence_name) {
		super();
		this.idcompetence = idcompetence;
		this.competence_name = competence_name;
	}
	public int getIdcompetence() {
		return idcompetence;
	}
	public void setIdcompetence(int idcompetence) {
		this.idcompetence = idcompetence;
	}
	public String getCompetence_name() {
		return competence_name;
	}
	public void setCompetence_name(String competence_name) {
		this.competence_name = competence_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competence_name == null) ? 0 : competence_name.hashCode());
		result = prime * result + idcompetence;
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
		Competence other = (Competence) obj;
		if (competence_name == null) {
			if (other.competence_name != null)
				return false;
		} else if (!competence_name.equals(other.competence_name))
			return false;
		if (idcompetence != other.idcompetence)
			return false;
		return true;
	}
	
	
}
