package staticClass;

import entities.Points;

public class WeightFunction {
	
	public static String nameWeightFunction(int typeWeightFunction) {
		switch (typeWeightFunction) {
		case 1: {
			return "Gaussiana";
		}
		case 2: {
			return "Gaussiana com Raio";
		}
		case 3: {
			return "Spline de 4ª ordem";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeWeightFunction);
		}
	}
//=====================================================================================================================================	
	public static double weightFunction(int typeWeightFunction, double supportRadius, Points basePoint, Points supportPoint) {
		double r2 = Math.pow((basePoint.getCoordinateX() - supportPoint.getCoordinateX()), 2) + Math.pow((basePoint.getCoordinateY() - supportPoint.getCoordinateY()), 2);
		double r = Math.sqrt(r2);
		double r2d2 = r2 / 2.0;
		double c = supportRadius / 3.0;
		double c1 = 1.0 / (1.0 - Math.exp(-Math.pow(supportRadius / c, 2)));
		double c2 = c1 * Math.exp(-Math.pow(supportRadius / c, 2));
		//
		switch (typeWeightFunction) {
		case 1: {
			return Math.exp(-r2d2);
		}
		case 2: {
			return c1 * Math.exp(-Math.pow(r / c, 2)) - c2;
		}
		case 3: {
			return 1.0 - 6.0 * Math.pow((r / supportRadius), 2) + 8.0 * Math.pow((r / supportRadius), 3) - 3.0 * Math.pow((r / supportRadius), 4);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeWeightFunction);
		}
	}
//=====================================================================================================================================		
	public static double d1XweightFunction(int typeWeightFunction, double supportRadius, Points basePoint, Points supportPoint) {
		double r2 = Math.pow((basePoint.getCoordinateX() - supportPoint.getCoordinateX()), 2) + Math.pow((basePoint.getCoordinateY() - supportPoint.getCoordinateY()), 2);
		double r = Math.sqrt(r2);
		double r2d2 = r2 / 2.0;
		double c = supportRadius / 3.0;
		double c1 = 1.0 / (1.0 - Math.exp(-Math.pow(supportRadius / c, 2)));
		//
		switch (typeWeightFunction) {
		case 1: {
			return (supportPoint.getCoordinateX() - basePoint.getCoordinateX()) * Math.exp(-r2d2);
		}
		case 2: {
			return (-2.0 * c1 * (basePoint.getCoordinateX() - supportPoint.getCoordinateX()) * Math.exp(-Math.pow(r / c, 2))) / Math.pow(c, 2);
		}
		case 3: {
			return (24 * (basePoint.getCoordinateX() - supportPoint.getCoordinateX()) * r) / Math.pow(supportRadius, 3) - (12 * (basePoint.getCoordinateX() - supportPoint.getCoordinateX())) / Math.pow(supportRadius, 2) - (12 * (basePoint.getCoordinateX() - supportPoint.getCoordinateX()) * r2) / Math.pow(supportRadius, 4);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeWeightFunction);
		}
	}
//=====================================================================================================================================		
	public static double d2XweightFunction(int typeWeightFunction, double supportRadius, Points basePoint, Points supportPoint) {
		double r2 = Math.pow((basePoint.getCoordinateX() - supportPoint.getCoordinateX()), 2) + Math.pow((basePoint.getCoordinateY() - supportPoint.getCoordinateY()), 2);
		double r = Math.sqrt(r2);
		double r2d2 = r2 / 2.0;
		double c = supportRadius / 3.0;
		double c1 = 1.0 / (1.0 - Math.exp(-Math.pow(supportRadius / c, 2)));
		//
		switch (typeWeightFunction) {
		case 1: {
			return (-1.0 + Math.pow(basePoint.getCoordinateX() - supportPoint.getCoordinateX(), 2)) * Math.exp(-r2d2);
		}
		case 2: {
			return (-2.0 * c1 * (Math.pow(c, 2) - 2.0 * Math.pow(basePoint.getCoordinateX() - supportPoint.getCoordinateX(), 2)) * Math.exp(-Math.pow(r / c, 2))) / Math.pow(c, 4);
		}
		case 3: {
			return -(36 * Math.pow(basePoint.getCoordinateX() - supportPoint.getCoordinateX(), 2)) / Math.pow(supportRadius, 4) - (12 * Math.pow(basePoint.getCoordinateY() - supportPoint.getCoordinateY(), 2)) / Math.pow(supportRadius, 4) + (24 * Math.pow(basePoint.getCoordinateX() - supportPoint.getCoordinateX(), 2)) + (24 * r) / Math.pow(supportRadius, 3) - 12 / Math.pow(supportRadius, 2);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeWeightFunction);
		}
	}
//=====================================================================================================================================		
	public static double d1YweightFunction(int typeWeightFunction, double supportRadius, Points basePoint, Points supportPoint) {
		double r2 = Math.pow((basePoint.getCoordinateX() - supportPoint.getCoordinateX()), 2) + Math.pow((basePoint.getCoordinateY() - supportPoint.getCoordinateY()), 2);
		double r = Math.sqrt(r2);
		double r2d2 = r2 / 2.0;
		double c = supportRadius / 3.0;
		double c1 = 1.0 / (1.0 - Math.exp(-Math.pow(supportRadius / c, 2)));
		//
		switch (typeWeightFunction) {
		case 1: {
			return (supportPoint.getCoordinateY() - basePoint.getCoordinateY()) * Math.exp(-r2d2);
		}
		case 2: {
			return (-2.0 * c1 * (basePoint.getCoordinateY() - supportPoint.getCoordinateY()) * Math.exp(-Math.pow(r / c, 2))) / Math.pow(c, 2);
		}
		case 3: {
			return (24 * (basePoint.getCoordinateY() - supportPoint.getCoordinateY()) * r) / Math.pow(supportRadius, 3) - (12 * (basePoint.getCoordinateY() - supportPoint.getCoordinateY())) / Math.pow(supportRadius, 2) - (12 * (basePoint.getCoordinateY() - supportPoint.getCoordinateY()) * r2) / Math.pow(supportRadius, 4);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeWeightFunction);
		}
	}
//=====================================================================================================================================		
	public static double d2YweightFunction(int typeWeightFunction, double supportRadius, Points basePoint, Points supportPoint) {
		double r2 = Math.pow((basePoint.getCoordinateX() - supportPoint.getCoordinateX()), 2) + Math.pow((basePoint.getCoordinateY() - supportPoint.getCoordinateY()), 2);
		double r = Math.sqrt(r2);
		double r2d2 = r2 / 2.0;
		double c = supportRadius / 3.0;
		double c1 = 1.0 / (1.0 - Math.exp(-Math.pow(supportRadius / c, 2)));
		//
		switch (typeWeightFunction) {
		case 1: {
			return (-1.0 + Math.pow(basePoint.getCoordinateY() - supportPoint.getCoordinateY(), 2)) * Math.exp(-r2d2);
		}
		case 2: {
			return (-2.0 * c1 * (Math.pow(c, 2) - 2.0 * Math.pow(basePoint.getCoordinateY() - supportPoint.getCoordinateY(), 2)) * Math.exp(-Math.pow(r / c, 2))) / Math.pow(c, 4);
		}
		case 3: {
			return -(36 * Math.pow(basePoint.getCoordinateY() - supportPoint.getCoordinateY(), 2)) / Math.pow(supportRadius, 4) - (12 * Math.pow(basePoint.getCoordinateX() - supportPoint.getCoordinateX(), 2)) / Math.pow(supportRadius, 4) + (24 * Math.pow(basePoint.getCoordinateY() - supportPoint.getCoordinateY(), 2)) + (24 * r) / Math.pow(supportRadius, 3) - 12 / Math.pow(supportRadius, 2);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeWeightFunction);
		}
	}
//=====================================================================================================================================		
	public static double dXYweightFunction(int typeWeightFunction, double supportRadius, Points basePoint, Points supportPoint) {
		double r2 = Math.pow((basePoint.getCoordinateX() - supportPoint.getCoordinateX()), 2) + Math.pow((basePoint.getCoordinateY() - supportPoint.getCoordinateY()), 2);
		double r = Math.sqrt(r2);
		double r2d2 = r2 / 2.0;
		double c = supportRadius / 3.0;
		double c1 = 1.0 / (1.0 - Math.exp(-Math.pow(supportRadius / c, 2)));
		//
		switch (typeWeightFunction) {
		case 1: {
			return (basePoint.getCoordinateX() - supportPoint.getCoordinateX()) * (basePoint.getCoordinateY() - supportPoint.getCoordinateY()) * Math.exp(-r2d2);
		}
		case 2: {
			return (4.0 * c1 * (basePoint.getCoordinateX() - supportPoint.getCoordinateX()) * (basePoint.getCoordinateY() - supportPoint.getCoordinateY()) * Math.exp(-Math.pow(r / c, 2))) / Math.pow(c, 4);
		}
		case 3: {
			return (24 * (basePoint.getCoordinateX() - supportPoint.getCoordinateX()) * (basePoint.getCoordinateY() - supportPoint.getCoordinateY())) / Math.pow(supportRadius, 3) - (12 / Math.pow(supportRadius, 4));
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeWeightFunction);
		}
	}

}
