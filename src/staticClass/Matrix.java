package staticClass;

public class Matrix {
	
	public static double[][] matSum(double[][] matrixA, double[][] matrixB) {
		if (matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length) {
			double[][] matrixResult = new double[matrixA.length][matrixB[0].length];
			for (int k = 0; k < matrixA.length; k++) {
				for (int i = 0; i < matrixB[0].length; i++) {
					matrixResult[k][i] = matrixA[k][i] + matrixB[k][i];
				}
			}
			return matrixResult;
		} else {
			System.out.println("Invalid dimensions!");
			return null;
		}
	}
	
	public static double[][] matSub(double[][] matrixA, double[][] matrixB) {
		if (matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length) {
			double[][] matrixResult = new double[matrixA.length][matrixB[0].length];
			for (int k = 0; k < matrixA.length; k++) {
				for (int i = 0; i < matrixB[0].length; i++) {
					matrixResult[k][i] = matrixA[k][i] - matrixB[k][i];
				}
			}
			return matrixResult;
		} else {
			System.out.println("Invalid dimensions!");
			return null;
		}
	}
	
	public static double[][] matMul(double[][] matrixA, double[][] matrixB) {
		if (matrixA[0].length == matrixB.length) {
			double[][] matrixResult = new double[matrixA.length][matrixB[0].length];
			for (int k = 0; k < matrixA.length; k++) {
				for (int i = 0; i < matrixB[0].length; i++) {
					for (int j = 0; j < matrixB.length; j++) {
						matrixResult[k][i] += matrixA[k][j] * matrixB[j][i];
					}
				}
			}
			return matrixResult;
		} else {
			System.out.println("Invalid dimensions!");
			return null;
			
		}
	}
	
	public static double[][] matMulSca(double scalar, double[][] matrix) {
		double[][] matrixResult = new double[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrixResult[i][j] = scalar * matrix[i][j];
			}
		}
		return matrixResult;
	}
	
	public static double[][] matTrans(double[][] matrixA) {
		double[][] matrixResult = new double[matrixA[0].length][matrixA.length];
		for (int i = 0; i < matrixResult.length; i++) {
			for (int j = 0; j < matrixResult[0].length; j++) {
				matrixResult[i][j] = matrixA[j][i];
			}
		}
		return matrixResult;
	}

// Method to invert matrix
	public static double[][] matInv(double[][] matrixA) {
		
		final double tolerance = 1.0e-15;
		int dim_1 = matrixA.length - 1;
		int dim = matrixA.length;
		double[][] matrixResult = new double[dim][dim];
		double b[] = new double[dim];
		
		// Checks if the matrix has only one element
		if (dim_1 == 0) {
			matrixResult[dim_1][dim_1] = 1.0 / matrixA[dim_1][dim_1];
			return matrixResult;
		}
		// Starts matrixResult as identity matrix
		for (int i = 0; i < dim; i ++) {
			for (int j = 0; j < dim; j ++) {
				matrixResult[i][j] = 0.0;
			}
			matrixResult[i][i] = 1.0;
		}
		// Find the element with the highest absolute value in the column
		for (int k = 0; k < dim_1; k++) {
			int k1 = k + 1;
			int icmx = k;
			double coefmx = Math.abs(matrixA[k][k]);
			for (int i = k1; i < dim; i++) {
				if (Math.abs(matrixA[i][k]) > coefmx) {
					icmx = i;
					coefmx = Math.abs(matrixA[i][k]);
				}
			}
			if (coefmx <= tolerance) {
				System.out.println("Error: Maximum coefficient lower than tolerance. Rows 96");
				return null;
			}
			if (icmx != k) {
				for (int j = k; j < dim; j++) {
					double temp = matrixA[k][j];
					matrixA[k][j] = matrixA[icmx][j];
					matrixA[icmx][j] = temp;
				}
				for (int m = 0; m < dim; m++) {
					double temp = matrixResult[k][m];
					matrixResult[k][m] = matrixResult[icmx][m];
					matrixResult[icmx][m] = temp;
				}
			}
			
			// Highest coefficient in absolute value of column K
			double c = matrixA[k][k];
			// DIVIDE ROW BY DIAGONAL COEFFICIENT / ELIMINATE UNKNOWN X(K)
			for (int m = 0; m < dim; m++) {
				matrixResult[k][m] = matrixResult[k][m] / c;
			}
			for (int j = k1; j < dim; j++) {
				double akj = matrixA[k][j] / c;
				matrixA[k][j] = akj;
				for (int i = k1; i < dim; i++) {
					matrixA[i][j] = matrixA[i][j] - matrixA[i][k] * akj;
				}
				for (int m = 0; m < dim; m++) {
					matrixResult[j][m] = matrixResult[j][m] - matrixA[j][k] * matrixResult[k][m];
				}
			}
		}	
		//
		if (Math.abs(matrixA[dim_1][dim_1]) <= tolerance) {
			System.out.println("Error: Maximum coefficient lower than tolerance. Rows 130");
			return null;
		}
		//
		for (int m = 0; m < dim; m++) {
			matrixResult[dim-1][m] = matrixResult[dim-1][m] / matrixA[dim-1][dim-1];
		}
		
		// APPLY BACKSUBSTITUTION PROCESS TO COMPUTE REMAINING UNKNOWNS
		for (int m = 0; m < dim; m++) {
			for (int i = 0; i < dim; i++) {
				b[i] = matrixResult[i][m];
			}
			for (int k = 0; k < dim_1; k++) {
				int j = dim_1 + 1 - k;
				for (int i = 0; i < (j - 1); i++) {
					b[i] = b[i] - matrixA[i][j-1] * b[j-1];
				}
			}
			for (int i = 0; i < dim; i++) {
				matrixResult[i][m] = b[i];
			}
		}
		return matrixResult;
	}
	
}
