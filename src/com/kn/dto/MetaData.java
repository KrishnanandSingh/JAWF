package com.kn.dto;

import java.util.List;

public class MetaData {

	private List<String> competence;
	private List<String> subpractice;
	private List<String> verticals;
	public List<String> getCompetence() {
		return competence;
	}
	public void setCompetence(List<String> competence) {
		this.competence = competence;
	}
	public List<String> getSubpractice() {
		return subpractice;
	}
	public void setSubpractice(List<String> subpractice) {
		this.subpractice = subpractice;
	}
	public List<String> getVerticals() {
		return verticals;
	}
	public void setVerticals(List<String> verticals) {
		this.verticals = verticals;
	}
	public MetaData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MetaData(List<String> competence, List<String> subpractice, List<String> verticals) {
		super();
		this.competence = competence;
		this.subpractice = subpractice;
		this.verticals = verticals;
	}
	

}
