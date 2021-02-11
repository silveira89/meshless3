package entities;

public class BasicParameters {
	
	private Integer numberPointsBoundery, numberPointsDomain, totalNumberPoint, typeWeightFunction, statePlain, typeMonomial;
	private Double modulusElasticity, poisson;
	
	public BasicParameters(Integer numberPointsBoundery, Integer numberPointsDomain, Integer totalNumberPoint, Integer typeWeightFunction,
			Integer statePlain, Integer typeMonomial, Double modulusElasticity, Double poisson) {
		this.numberPointsBoundery = numberPointsBoundery;
		this.numberPointsDomain = numberPointsDomain;
		this.totalNumberPoint = totalNumberPoint;
		this.typeWeightFunction = typeWeightFunction;
		this.statePlain = statePlain;
		this.typeMonomial = typeMonomial;
		this.modulusElasticity = modulusElasticity;
		this.poisson = poisson;
	}

	public Integer getNumberPointsBoundery() {
		return numberPointsBoundery;
	}

	public Integer getNumberPointsDomain() {
		return numberPointsDomain;
	}

	public Integer getTotalNumberPoint() {
		return totalNumberPoint;
	}

	public Integer getTypeWeightFunction() {
		return typeWeightFunction;
	}

	public Integer getStatePlain() {
		return statePlain;
	}

	public Integer getTypeMonomial() {
		return typeMonomial;
	}

	public Double getModulusElasticity() {
		return modulusElasticity;
	}

	public Double getPoisson() {
		return poisson;
	}

	@Override
	public String toString() {
		return "BasicParameters [numberPointsBoundery=" + numberPointsBoundery + ", numberPointsDomain="
				+ numberPointsDomain + ", totalNumberPoint=" + totalNumberPoint + ", typeWeightFunction=" + typeWeightFunction
				+ ", statePlain=" + statePlain + ", typeMonomial=" + typeMonomial + ", modulusElasticity="
				+ modulusElasticity + ", poisson=" + poisson + "]";
	}
	

}
