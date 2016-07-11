package com.kn.dto;

/**
 * @author krishnanand
 *
 */
public class Employee {
	private String name;
	private String mID;
	private String competency;
	private String subpractice;
	private String vertical;

	public Employee() {
	}

	/**
	 * @param name
	 * @param mID
	 * @param competency
	 * @param subpractice
	 * @param vertical
	 */
	public Employee(String name, String mID, String competency, String subpractice, String vertical) {
		super();
		this.name = name;
		this.mID = mID;
		this.competency = competency;
		this.subpractice = subpractice;
		this.vertical = vertical;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mID
	 */
	public String getmID() {
		return mID;
	}

	/**
	 * @param mID
	 *            the mID to set
	 */
	public void setmID(String mID) {
		this.mID = mID;
	}

	/**
	 * @return the competency
	 */
	public String getCompetency() {
		return competency;
	}

	/**
	 * @param competency
	 *            the competency to set
	 */
	public void setCompetency(String competency) {
		this.competency = competency;
	}

	/**
	 * @return the subpractice
	 */
	public String getSubpractice() {
		return subpractice;
	}

	/**
	 * @param subpractice
	 *            the subpractice to set
	 */
	public void setSubpractice(String subpractice) {
		this.subpractice = subpractice;
	}

	/**
	 * @return the vertical
	 */
	public String getVertical() {
		return vertical;
	}

	/**
	 * @param vertical
	 *            the vertical to set
	 */
	public void setVertical(String vertical) {
		this.vertical = vertical;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mID == null) ? 0 : mID.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (mID == null) {
			if (other.mID != null)
				return false;
		} else if (!mID.equals(other.mID))
			return false;
		return true;
	}

}
