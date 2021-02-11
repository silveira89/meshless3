package staticClass;

import entities.Points;

public class MonomialBase {
	
	public static String monomialName(int typeMonomial) {
		switch (typeMonomial) {
		case 1: {
			return "Linear base";
		}
		case 2: {
			return "Quadratic base";
		}
		case 3: {
			return "Cubic base";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeMonomial);
		}
	}
//=====================================================================================================================================		
	public static int monomialAmount(int typeMonomial) {
		switch (typeMonomial) {
		case 1: {
			return 3;
		}
		case 2: {
			return 6;
		}
		case 3: {
			return 10;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeMonomial);
		}
	}
//=====================================================================================================================================		
	public static double[] monomialBase(int typeMonomial, Points point) {
		switch (typeMonomial) {
		case 1: {
			double[] pb = new double[3];
			pb[0] = 1.0;
			pb[1] = point.getCoordinateX();
			pb[2] = point.getCoordinateY();
			return pb;
		}
		case 2: {
			double[] pb = new double[6];
			pb[0] = 1.0;
			pb[1] = point.getCoordinateX();
			pb[2] = point.getCoordinateY();
			pb[3] = point.getCoordinateX() * point.getCoordinateX();
			pb[4] = point.getCoordinateX() * point.getCoordinateY();
			pb[5] = point.getCoordinateY() * point.getCoordinateY();
			return pb;
		}
		case 3: {
			double[] pb = new double[10];
			pb[0] = 1.0;
			pb[1] = point.getCoordinateX();
			pb[2] = point.getCoordinateY();
			pb[3] = point.getCoordinateX() * point.getCoordinateX();
			pb[4] = point.getCoordinateX() * point.getCoordinateY();
			pb[5] = point.getCoordinateY() * point.getCoordinateY();
			pb[6] = Math.pow(point.getCoordinateX(), 3);
			pb[7] = point.getCoordinateX() * point.getCoordinateX() * point.getCoordinateY();
			pb[8] = point.getCoordinateX() * point.getCoordinateY() * point.getCoordinateY();
			pb[9] = Math.pow(point.getCoordinateY(), 3);
			return pb;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeMonomial);
		}
	}
//=====================================================================================================================================		
	public static double[] d1XmonomialBase(int typeMonomial, Points point) {
		switch (typeMonomial) {
		case 1: {
			double[] pb = new double[3];
			pb[0] = 0.0;
			pb[1] = 1.0;
			pb[2] = 0.0;
			return pb;
		}
		case 2: {
			double[] pb = new double[6];
			pb[0] = 0.0;
			pb[1] = 1.0;
			pb[2] = 0.0;
			pb[3] = 2.0 * point.getCoordinateX();
			pb[4] = point.getCoordinateY();
			pb[5] = 0.0;
			return pb;
		}
		case 3: {
			double[] pb = new double[10];
			pb[0] = 0.0;
			pb[1] = 1.0;
			pb[2] = 0.0;
			pb[3] = 2.0 * point.getCoordinateX();
			pb[4] = point.getCoordinateY();
			pb[5] = 0.0;
			pb[6] = 3.0 * Math.pow(point.getCoordinateX(), 2);
			pb[7] = 2.0 * point.getCoordinateX() * point.getCoordinateY();
			pb[8] = Math.pow(point.getCoordinateY(), 2);
			pb[9] = 0.0;
			return pb;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeMonomial);
		}
	}
//=====================================================================================================================================		
	public static double[] d2XmonomialBase(int typeMonomial, Points point) {
		switch (typeMonomial) {
		case 1: {
			double[] pb = new double[3];
			pb[0] = 0.0;
			pb[1] = 0.0;
			pb[2] = 0.0;
			return pb;
		}
		case 2: {
			double[] pb = new double[6];
			pb[0] = 0.0;
			pb[1] = 0.0;
			pb[2] = 0.0;
			pb[3] = 2.0;
			pb[4] = 0.0;
			pb[5] = 0.0;
			return pb;
		}
		case 3: {
			double[] pb = new double[10];
			pb[0] = 0.0;
			pb[1] = 0.0;
			pb[2] = 0.0;
			pb[3] = 2.0;
			pb[4] = 0.0;
			pb[5] = 0.0;
			pb[6] = 6.0 * point.getCoordinateX();
			pb[7] = 2.0 * point.getCoordinateY();
			pb[8] = 0.0;
			pb[9] = 0.0;
			return pb;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeMonomial);
		}
	}
//=====================================================================================================================================		
	public static double[] d1YmonomialBase(int typeMonomial, Points point) {
		switch (typeMonomial) {
		case 1: {
			double[] pb = new double[3];
			pb[0] = 0.0;
			pb[1] = 0.0;
			pb[2] = 1.0;
			return pb;
		}
		case 2: {
			double[] pb = new double[6];
			pb[0] = 0.0;
			pb[1] = 0.0;
			pb[2] = 1.0;
			pb[3] = 0.0;
			pb[4] = point.getCoordinateX();
			pb[5] = 2.0 * point.getCoordinateY();
			return pb;
		}
		case 3: {
			double[] pb = new double[10];
			pb[0] = 0.0;
			pb[1] = 0.0;
			pb[2] = 1.0;
			pb[3] = 0.0;
			pb[4] = point.getCoordinateX();
			pb[5] = 2.0 * point.getCoordinateY();
			pb[6] = 0.0;
			pb[7] = point.getCoordinateX() * point.getCoordinateX();
			pb[8] = 2.0 * point.getCoordinateX() * point.getCoordinateY();
			pb[9] = 3.0 * Math.pow(point.getCoordinateY(), 2);
			return pb;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeMonomial);
		}
	}
//=====================================================================================================================================		
	public static double[] d2YmonomialBase(int typeMonomial, Points point) {
		switch (typeMonomial) {
		case 1: {
			double[] pb = new double[3];
			pb[0] = 0.0;
			pb[1] = 0.0;
			pb[2] = 0.0;
			return pb;
		}
		case 2: {
			double[] pb = new double[6];
			pb[0] = 0.0;
			pb[1] = 0.0;
			pb[2] = 0.0;
			pb[3] = 0.0;
			pb[4] = 0.0;
			pb[5] = 2.0;
			return pb;
		}
		case 3: {
			double[] pb = new double[10];
			pb[0] = 0.0;
			pb[1] = 0.0;
			pb[2] = 0.0;
			pb[3] = 0.0;
			pb[4] = 0.0;
			pb[5] = 2.0;
			pb[6] = 0.0;
			pb[7] = 0.0;
			pb[8] = 2.0 * point.getCoordinateX();
			pb[9] = 6.0 * point.getCoordinateY();
			return pb;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeMonomial);
		}
	}
//=====================================================================================================================================		
	public static double[] dXYmonomialBase(int typeMonomial, Points point) {
		switch (typeMonomial) {
		case 1: {
			double[] pb = new double[3];
			pb[0] = 0.0;
			pb[1] = 0.0;
			pb[2] = 0.0;
			return pb;
		}
		case 2: {
			double[] pb = new double[6];
			pb[0] = 0.0;
			pb[1] = 0.0;
			pb[2] = 0.0;
			pb[3] = 0.0;
			pb[4] = 1.0;
			pb[5] = 0.0;
			return pb;
		}
		case 3: {
			double[] pb = new double[10];
			pb[0] = 0.0;
			pb[1] = 0.0;
			pb[2] = 0.0;
			pb[3] = 0.0;
			pb[4] = 1.0;
			pb[5] = 0.0;
			pb[6] = 0.0;
			pb[7] = 2.0 * point.getCoordinateX();
			pb[8] = 2.0 * point.getCoordinateY();
			pb[9] = 0.0;
			return pb;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + typeMonomial);
		}
	}

}
