package com.kn.entity;

public class Vertical {
	private int idvertical;
	private String vertical_name;
	
	
	public Vertical(int idvertical, String vertical_name) {
		super();
		this.idvertical = idvertical;
		this.vertical_name = vertical_name;
	}
	public Vertical() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdvertical() {
		return idvertical;
	}
	public void setIdvertical(int idvertical) {
		this.idvertical = idvertical;
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
		result = prime * result + idvertical;
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
		Vertical other = (Vertical) obj;
		if (idvertical != other.idvertical)
			return false;
		if (vertical_name == null) {
			if (other.vertical_name != null)
				return false;
		} else if (!vertical_name.equals(other.vertical_name))
			return false;
		return true;
	}
	
	
}
