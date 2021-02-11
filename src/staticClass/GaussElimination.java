package staticClass;

public class GaussElimination {
	
	public static double[] gaussElimination(double[][] matrixA, double[] vectorB) {
		
		double tolerance = 1.0e-15;
		int dim = matrixA.length;
		
		int dim_1 = dim - 1;
		if (dim_1 == 0) {
			vectorB[dim_1] = vectorB[dim_1] / matrixA[dim_1][dim_1];
			return vectorB;
		}
		//
		for (int k = 0; k < dim_1; k++) {
			int k1 = k + 1;
			//
			int icmx = k;
			double coefmx = Math.abs(matrixA[k][k]);
			for (int i = k1; i < dim; i++) {
				if (Math.abs(matrixA[i][k]) > coefmx) {
					icmx = i;
					coefmx = Math.abs(matrixA[i][k]);
				}
			}
			if (coefmx <= tolerance) {
				System.out.println("Error: Maximum coefficient lower than tolerance. Rows 28");
				return null;
			}
			if (icmx != k) {
				for (int j = k; j < dim; j++) {
					double temp = matrixA[k][j];
					matrixA[k][j] = matrixA[icmx][j];
					matrixA[icmx][j] = temp;
				}
				double temp = vectorB[k];
				vectorB[k] = vectorB[icmx];
				vectorB[icmx] = temp;
			}
			double c = matrixA[k][k];
			//
			vectorB[k] = vectorB[k] / c;
			for (int j = k1; j < dim; j++) {
				double akj = matrixA[k][j] / c;
				matrixA[k][j] = akj;
				for (int i = k1; i < dim; i++) {
					matrixA[i][j] = matrixA[i][j] - matrixA[i][k] * akj;
				}
				vectorB[j] = vectorB[j] - matrixA[j][k] * vectorB[k];
			}
		}
		if (Math.abs(matrixA[dim_1][dim_1]) <= tolerance) {
			System.out.println("Error: Maximum coefficient lower than tolerance. Rows 54");
			return null;
		}
		//
		vectorB[dim_1] = vectorB[dim_1] / matrixA[dim_1][dim_1];
		//
		for (int k = 0; k < dim_1; k++) {
			int j = dim_1 + 1 - k;
			for (int i = 0; i < (j - 1); i++) {
				vectorB[i] = vectorB[i] - matrixA[i][j-1] * vectorB[j-1];
			}
		}
		return vectorB;
	}

}
