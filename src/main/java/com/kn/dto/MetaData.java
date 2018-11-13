package com.kn.dto;

import java.util.List;

import com.kn.entity.Competence;
import com.kn.entity.Subpractice;
import com.kn.entity.Vertical;

public class MetaData {

	private List<Competence> competence;
	private List<Subpractice> subpractice;
	private List<Vertical> vertical;
	/**
	 * @param competence
	 * @param subpractice
	 * @param vertical
	 */
	public MetaData(List<Competence> competence, List<Subpractice> subpractice, List<Vertical> vertical) {
		super();
		this.competence = competence;
		this.subpractice = subpractice;
		this.vertical = vertical;
	}
	/**
	 * 
	 */
	public MetaData() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the competence
	 */
	public List<Competence> getCompetence() {
		return competence;
	}
	/**
	 * @param competence the competence to set
	 */
	public void setCompetence(List<Competence> competence) {
		this.competence = competence;
	}
	/**
	 * @return the subpractice
	 */
	public List<Subpractice> getSubpractice() {
		return subpractice;
	}
	/**
	 * @param subpractice the subpractice to set
	 */
	public void setSubpractice(List<Subpractice> subpractice) {
		this.subpractice = subpractice;
	}
	/**
	 * @return the vertical
	 */
	public List<Vertical> getVertical() {
		return vertical;
	}
	/**
	 * @param vertical the vertical to set
	 */
	public void setVertical(List<Vertical> vertical) {
		this.vertical = vertical;
	}

}
