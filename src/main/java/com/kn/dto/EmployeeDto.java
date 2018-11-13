package com.kn.dto;

/**
 * @author krishnanand
 *
 */
public class EmployeeDto {
	private String name;
	private int mID;
	private String competency;
	private String subpractice;
	private String vertical;

	public EmployeeDto() {
	}

	/**
	 * @param name
	 * @param mID
	 * @param competency
	 * @param subpractice
	 * @param vertical
	 */
	public EmployeeDto(String name, int mID, String competency, String subpractice, String vertical) {
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
	public int getmID() {
		return mID;
	}

	/**
	 * @param mID
	 *            the mID to set
	 */
	public void setmID(int mID) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competency == null) ? 0 : competency.hashCode());
		result = prime * result + mID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((subpractice == null) ? 0 : subpractice.hashCode());
		result = prime * result + ((vertical == null) ? 0 : vertical.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EmployeeDto other = (EmployeeDto) obj;
		if (competency == null) {
			if (other.competency != null) {
				return false;
			}
		} else if (!competency.equals(other.competency)) {
			return false;
		}
		if (mID != other.mID) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (subpractice == null) {
			if (other.subpractice != null) {
				return false;
			}
		} else if (!subpractice.equals(other.subpractice)) {
			return false;
		}
		if (vertical == null) {
			if (other.vertical != null) {
				return false;
			}
		} else if (!vertical.equals(other.vertical)) {
			return false;
		}
		return true;
	}


}
