package entities;

public class PointsDomain extends Points {
	
	private Double volumeForceX, volumeForceY;

	public PointsDomain(Integer id, Double coordinateX, Double coordinateY) {
		super(id, coordinateX, coordinateY);
		this.volumeForceX = 0.0;
		this.volumeForceY = 0.0;
	}

	public Double getVolumeForceX() {
		return volumeForceX;
	}

	public void setVolumeForceX(Double loadingX) {
		this.volumeForceX = loadingX;
	}

	public Double getVolumeForceY() {
		return volumeForceY;
	}

	public void setVolumeForceY(Double surfaceForceY) {
		this.volumeForceY = surfaceForceY;
	}

	@Override
	public String toString() {
		return "PointsDomain [getId()=" + getId() + ", getCoordinateX()=" + getCoordinateX() + ", getCoordinateY()="
				+ getCoordinateY() + ", volumeForceX=" + volumeForceX + ", volumeForceY=" + volumeForceY + "]";
	}

	

	
	
	

}
