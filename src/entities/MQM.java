package entities;

import java.util.ArrayList;
import java.util.List;

import staticClass.Matrix;
import staticClass.MonomialBase;
import staticClass.WeightFunction;

public class MQM {
	
	private List<Points> listPoints = new ArrayList<>();
	private double[][] distance;
	private double[][] W, P, B, A, V;
	private double[][] D1XW, D1YW, D1XB, D1YB, D1XA, D1YA, D1XV, D1YV;
	private List<Integer> localSupport = new ArrayList<>();
	private double minimusRadius;
	private BasicParameters basicParameters;
	private int basePoint;

	public MQM(BasicParameters basicParameters, int basePoint, List<Points> listPoints) {
		this.basicParameters = basicParameters;
		this.basePoint = basePoint;
		this.listPoints = listPoints;
		calculationDistance();
		sortDistance();
		this.minimusRadius = distance[MonomialBase.monomialAmount(basicParameters.getTypeMonomial())][1];
		assemblyLocalSopport();
		localMatrix();

	}
	
	public void calculationDistance() {
		distance = new double[listPoints.size()][2];
		for (int j = 0; j < listPoints.size(); j++) {
				distance[j][0] = j + 1;
				distance[j][1] = Math.sqrt(Math.pow(listPoints.get(basePoint).getCoordinateX() - listPoints.get(j).getCoordinateX(), 2) + (Math.pow(listPoints.get(basePoint).getCoordinateY() - listPoints.get(j).getCoordinateY(), 2)));
		}
	}
	
	public void sortDistance() {
		for (int j = 0; j < distance.length-1; j++) {
			for (int i = 0; i < distance.length-1; i++) {
				if (distance[i][1] > distance[i+1][1]) {
					double aux1 = distance[i+1][0];
					double aux2 = distance[i+1][1];
					distance[i+1][0] = distance[i][0];
					distance[i+1][1] = distance[i][1];
					distance[i][0] = aux1;
					distance[i][1] = aux2;
				}
			}
		}
	}
	
	public void assemblyLocalSopport() {
		for (int i = 0; i < distance.length; i++) {
			if (distance[i][1] < minimusRadius) {
				localSupport.add((int) distance[i][0]);
			}
		}
		if (localSupport.size() < MonomialBase.monomialAmount(basicParameters.getTypeMonomial())) {
			minimusRadius *= 1.1;
			localSupport.clear();
			assemblyLocalSopport();
		}
	}
	
	public int getLocalSupportSize() {
		return localSupport.size();
	}
	
	public List<Integer> getLocalSupport() {
		return localSupport;
	}
	
	public double getMinimusRaius() {
		return minimusRadius;
	}
	
	public void localMatrix() {
		W = new double[localSupport.size()][localSupport.size()];
		for (int j = 0; j < W.length; j++) {
			W[j][j] = WeightFunction.weightFunction(basicParameters.getTypeWeightFunction(), minimusRadius, listPoints.get(basePoint), listPoints.get(localSupport.get(j)-1));
		}
		
		P = new double[localSupport.size()][MonomialBase.monomialAmount(basicParameters.getTypeMonomial())];
		for (int i = 0; i < P.length; i++) {
			double[] pb = MonomialBase.monomialBase(basicParameters.getTypeMonomial(), listPoints.get(localSupport.get(i)-1));
			for (int j = 0; j < P[0].length; j++ ) {
				P[i][j] = pb[j];
			}
		}
		
		B = new double[MonomialBase.monomialAmount(basicParameters.getTypeMonomial())][localSupport.size()];
		B = Matrix.matMul(Matrix.matTrans(P), W);
		
		A = new double[MonomialBase.monomialAmount(basicParameters.getTypeMonomial())][MonomialBase.monomialAmount(basicParameters.getTypeMonomial())]; 
		A = Matrix.matMul(B, P);
		
		V = new double[MonomialBase.monomialAmount(basicParameters.getTypeMonomial())][MonomialBase.monomialAmount(basicParameters.getTypeMonomial())];
		V = Matrix.matInv(A);
		if (V == null) {
			minimusRadius *= 1.1;
			localSupport.clear();
			assemblyLocalSopport();
			localMatrix();
		}
	}

	public void d1localMatrix() {
		D1XW = new double[localSupport.size()][localSupport.size()];
		D1YW = new double[localSupport.size()][localSupport.size()];
		for (int j = 0; j < W.length; j++) {
			D1XW[j][j] = WeightFunction.d1XweightFunction(basicParameters.getTypeWeightFunction(), minimusRadius, listPoints.get(basePoint), listPoints.get(localSupport.get(j)-1));
			D1YW[j][j] = WeightFunction.d1YweightFunction(basicParameters.getTypeWeightFunction(), minimusRadius, listPoints.get(basePoint), listPoints.get(localSupport.get(j)-1));
		}
		
		D1XB = new double[MonomialBase.monomialAmount(basicParameters.getTypeMonomial())][localSupport.size()];
		D1YB = new double[MonomialBase.monomialAmount(basicParameters.getTypeMonomial())][localSupport.size()];
		D1XB = Matrix.matMul(Matrix.matTrans(P), D1XW);
		D1YB = Matrix.matMul(Matrix.matTrans(P), D1YW);
		
		D1XA = new double[MonomialBase.monomialAmount(basicParameters.getTypeMonomial())][MonomialBase.monomialAmount(basicParameters.getTypeMonomial())]; 
		D1YA = new double[MonomialBase.monomialAmount(basicParameters.getTypeMonomial())][MonomialBase.monomialAmount(basicParameters.getTypeMonomial())]; 
		D1XA = Matrix.matMul(D1XB, P);
		D1YA = Matrix.matMul(D1YB, P);
		
		D1XV = new double[MonomialBase.monomialAmount(basicParameters.getTypeMonomial())][MonomialBase.monomialAmount(basicParameters.getTypeMonomial())];
		D1YV = new double[MonomialBase.monomialAmount(basicParameters.getTypeMonomial())][MonomialBase.monomialAmount(basicParameters.getTypeMonomial())];
		D1XV = Matrix.matMulSca(-1.0, Matrix.matMul(Matrix.matMul(V, D1XA), V));
		D1YV = Matrix.matMulSca(-1.0, Matrix.matMul(Matrix.matMul(V, D1YA), V));
		
		
		
		
	}



	@Override
	public String toString() {
		System.out.println("Base point: " + (basePoint+1));
		System.out.println("Distance");
		for (int i = 0; i < distance.length; i++) {
			System.out.println(distance[i][0] + ", " + distance[i][1]);
		}
		
		System.out.println("Selections points");
		for (Integer point : localSupport) {
			System.out.print(point + ", ");
		}
		System.out.println();
		
		System.out.println("Local matrix W");
		for (int i = 0; i < localSupport.size(); i++) {
			for (int j = 0; j < localSupport.size(); j++) {
				System.out.print(W[i][j] + "  ");
			}
			System.out.println();
		}
		
		System.out.println("Local matrix P");
		for (int i = 0; i < P.length; i++) {
			for (int j = 0; j < P[0].length; j++) {
				System.out.print(P[i][j] + "  ");
			}
			System.out.println();
		}
		
		System.out.println("Local matrix B");
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				System.out.print(B[i][j] + "  ");
			}
			System.out.println();
		}
		
		System.out.println("Local matrix A");
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				System.out.print(A[i][j] + "  ");
			}
			System.out.println();
		}
		
		System.out.println("Local matrix V");
		for (int i = 0; i < V.length; i++) {
			for (int j = 0; j < V[0].length; j++) {
				System.out.print(V[i][j] + "  ");
			}
			System.out.println();
		}
		
		return "Minimus Radius: " + minimusRadius + "\n\n";
	}
}
