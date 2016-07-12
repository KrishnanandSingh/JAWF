package com.kn.entity;

public class Verticals {
	private int idverticals;
	private String vertical_name;
	
	
	public Verticals(int idverticals, String vertical_name) {
		super();
		this.idverticals = idverticals;
		this.vertical_name = vertical_name;
	}
	public Verticals() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdverticals() {
		return idverticals;
	}
	public void setIdverticals(int idverticals) {
		this.idverticals = idverticals;
	}
	public String getVertical_name() {
		return vertical_name;
	}
	public void setVertical_name(String vertical_name) {
		this.vertical_name = vertical_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idverticals;
		result = prime * result + ((vertical_name == null) ? 0 : vertical_name.hashCode());
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
		Verticals other = (Verticals) obj;
		if (idverticals != other.idverticals)
			return false;
		if (vertical_name == null) {
			if (other.vertical_name != null)
				return false;
		} else if (!vertical_name.equals(other.vertical_name))
			return false;
		return true;
	}
	
	
}
