package entities;

public class PointsBoundery extends Points {
	
	private Integer boundaryConditionX, boundaryConditionY;
	private Double normalX, normalY, surfaceForceX, surfaceForceY;

	public PointsBoundery(Integer id, Double coordinateX, Double coordinateY,
			Double normalX, Double normalY) {
		super(id, coordinateX, coordinateY);
		this.boundaryConditionX = 0;
		this.boundaryConditionY = 0;
		this.normalX = normalX;
		this.normalY = normalY;
		this.surfaceForceX = 0.0;
		this.surfaceForceY = 0.0;
	}

	public Double getNormalX() {
		return normalX;
	}

	public void setNormalX(Double normalX) {
		this.normalX = normalX;
	}

	public Double getNormalY() {
		return normalY;
	}

	public void setNormalY(Double normalY) {
		this.normalY = normalY;
	}
	
	public Integer getBoundaryConditionX() {
		return boundaryConditionX;
	}

	public void setBoundaryConditionX(Integer boundaryConditionX) {
		this.boundaryConditionX = boundaryConditionX;
	}

	public Integer getBoundaryConditionY() {
		return boundaryConditionY;
	}

	public void setBoundaryConditionY(Integer boundaryConditionY) {
		this.boundaryConditionY = boundaryConditionY;
	}

	public Double getSurfaceForceX() {
		return surfaceForceX;
	}

	public void setSurfaceForceX(Double surfaceForceX) {
		this.surfaceForceX = surfaceForceX;
	}

	public Double getSurfaceForceY() {
		return surfaceForceY;
	}

	public void setSurfaceForceY(Double surfaceForceY) {
		this.surfaceForceY = surfaceForceY;
	}

	@Override
	public String toString() {
		return "PointsBoundery [getId()=" + getId() + ", getCoordinateX()=" + getCoordinateX() + ", getCoordinateY()="
				+ getCoordinateY() + ", normalX=" + normalX + ", normalY=" + normalY + ", boundaryConditionX="
				+ boundaryConditionX + ", boundaryConditionY=" + boundaryConditionY + ", surfaceForceX=" + surfaceForceX
				+ ", surfaceForceY=" + surfaceForceY + "]";
	}

	

	

	
	
	

}
