package entities;

public class Points {
	
	private Integer id;
	private Double coordinateX, coordinateY;
	
	public Points(Integer id, Double coordinateX, Double coordinateY) {
		this.id = id;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(Double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public Double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(Double coordinateY) {
		this.coordinateY = coordinateY;
	}
	

	@Override
	public String toString() {
		return "Points [id=" + id + ", coordinateX=" + coordinateX + ", coordinateY=" + coordinateY + "]";
	}

	
	
}
