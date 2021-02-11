package staticClass;

import entities.BasicParameters;

public class Constants {
	
	private Double E;
	private Double PO;
	
	public Constants(BasicParameters param) {
		this.E = param.getModulusElasticity();
		this.PO = param.getPoisson();
	}

	public double EPT() {
		return E / (1.0 - Math.pow(PO, 2));
	}
	
	public double EPD() {
		return E / ((1.0 + PO) * (1.0 - 2.0 * PO));
	}
	
	public double lambda() {
		return (PO * E) / ((1.0 + PO) * (1.0 - 2.0 * PO));
	}
	
	public double G() {
		return E / (2 * (1 + PO));
	}
	
}
