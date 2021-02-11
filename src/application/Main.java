package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.BasicParameters;
import entities.MQM;
import entities.Points;
import entities.PointsBoundery;
import entities.PointsDomain;
import staticClass.MonomialBase;
import staticClass.WeightFunction;

public class Main {

	public static void main(String[] args) {
		//
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		//
		List<PointsBoundery> listPointsBoundery = new ArrayList<>();
		List<PointsDomain> listPointsDomain = new ArrayList<>();
		List<Points> listPoints = new ArrayList<>();
		BasicParameters basicParameters = null;
		//
		System.out.print("Enter the file name without extension: ");
		String path = sc.nextLine(); // String way
		String pathIn = path + ".txt";
		File pathInFile = new File(pathIn); // File way
		File absolutePathInFile = pathInFile.getAbsoluteFile(); // Absolute way
		// Read basic parameters
		try (BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			// Reading basic parameters
			String line = br.readLine();
			String[] lineSplit = line.split("	");
			int numberPointsBoundery = Integer.parseInt(lineSplit[0]);
			int numberPointsDomain = Integer.parseInt(lineSplit[1]);
			double modulusElasticity = Double.parseDouble(lineSplit[2]);
			double poisson = Double.parseDouble(lineSplit[3]);
			int typeWeightFunction = Integer.parseInt(lineSplit[4]);
			int statePlain = Integer.parseInt(lineSplit[5]);
			int typeMonomial = Integer.parseInt(lineSplit[6]);
			int totalNumberPoints = numberPointsBoundery + numberPointsDomain;
			basicParameters = new BasicParameters(numberPointsBoundery, numberPointsDomain, totalNumberPoints, typeWeightFunction, statePlain, typeMonomial, modulusElasticity, poisson);
			// Read the data of the points in the Boundery
			for (int i = 0; i < numberPointsBoundery; i++) {
				line = br.readLine();
				lineSplit = line.split("	");
				int id = Integer.parseInt(lineSplit[0]);
				double coordX = Double.parseDouble(lineSplit[1]);
				double coordY = Double.parseDouble(lineSplit[2]);
				double normalX = Double.parseDouble(lineSplit[3]);
				double normalY = Double.parseDouble(lineSplit[4]);
				listPointsBoundery.add(new PointsBoundery(id, coordX, coordY, normalX, normalY));
			}
			//
			line = br.readLine();
			lineSplit = line.split("	");
			int prescribedLoading = Integer.parseInt(lineSplit[0]);
			int prescribedDisplacement = Integer.parseInt(lineSplit[1]);
			for (int i = 0; i < prescribedLoading; i++) {
				line = br.readLine();
				lineSplit = line.split("	");
				listPointsBoundery.get(Integer.parseInt(lineSplit[0])-1).setBoundaryConditionX(Integer.parseInt(lineSplit[1]));
				listPointsBoundery.get(Integer.parseInt(lineSplit[0])-1).setBoundaryConditionY(Integer.parseInt(lineSplit[2]));
				listPointsBoundery.get(Integer.parseInt(lineSplit[0])-1).setSurfaceForceX(Double.parseDouble(lineSplit[3]));
				listPointsBoundery.get(Integer.parseInt(lineSplit[0])-1).setSurfaceForceY(Double.parseDouble(lineSplit[4]));
			}
			//
			for (int i = 0; i < prescribedDisplacement; i++) {
				line = br.readLine();
				lineSplit = line.split("	");
				listPointsBoundery.get(Integer.parseInt(lineSplit[0])-1).setBoundaryConditionX(Integer.parseInt(lineSplit[1]));
				listPointsBoundery.get(Integer.parseInt(lineSplit[0])-1).setBoundaryConditionY(Integer.parseInt(lineSplit[2]));
				listPointsBoundery.get(Integer.parseInt(lineSplit[0])-1).setSurfaceForceX(Double.parseDouble(lineSplit[3]));
				listPointsBoundery.get(Integer.parseInt(lineSplit[0])-1).setSurfaceForceY(Double.parseDouble(lineSplit[4]));
			}
			// Read the data of the points in the domain
			for (int i = 0; i < numberPointsDomain; i++) {
				line = br.readLine();
				lineSplit = line.split("	");
				int id = Integer.parseInt(lineSplit[0]);
				double coordX = Double.parseDouble(lineSplit[1]);
				double coordY = Double.parseDouble(lineSplit[2]);
				listPointsDomain.add(new PointsDomain(id, coordX, coordY));
			}
			// 
			line = br.readLine();
			lineSplit = line.split("	");
			int prescribedVolumeForce = Integer.parseInt(lineSplit[0]);
			System.out.println(prescribedVolumeForce);
			for (int i = 0; i < prescribedVolumeForce; i++) {
				line = br.readLine();
				lineSplit = line.split("	");
				listPointsDomain.get(Integer.parseInt(lineSplit[0])-1).setVolumeForceX(Double.parseDouble(lineSplit[1]));
				listPointsDomain.get(Integer.parseInt(lineSplit[0])-1).setVolumeForceY(Double.parseDouble(lineSplit[2]));
			}
		} catch (IOException e) {
			System.out.println("error: " + e.getMessage());
		} finally {
			sc.close();
		}
		// 
		listPoints.addAll(listPointsBoundery);
		listPoints.addAll(listPointsDomain);
		// Created local support and the local matrix
		List<MQM> mqm = new ArrayList<>();
		for (int i = 0; i < basicParameters.getTotalNumberPoint(); i++) {
			mqm.add(new MQM(basicParameters, i, listPoints));
		}
		//
		for (MQM local : mqm) {
				System.out.println(local);
		}
		// Created the output file
		boolean newFolder = new File(absolutePathInFile.getParent() + "\\out").mkdir();
		String pathOut = absolutePathInFile.getParent() + "\\out";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut + "\\out-" + pathIn))) {
			bw.write("   Problem name: " + path + "\n");
			bw.newLine();
			// Writed basic parameters
			bw.write("   Number of points in the contour: " + basicParameters.getNumberPointsBoundery() + "\n");
			bw.write("   Number of points in the domain: " + basicParameters.getNumberPointsDomain() + "\n");
			bw.write("   Total number of points: " + basicParameters.getTotalNumberPoint() + "\n");
			bw.write("   Modulus of elasticity: " + basicParameters.getModulusElasticity() + "\n");
			bw.write("   Poisson: " + basicParameters.getPoisson() + "\n");
			bw.write("   Weight function: " + WeightFunction.nameWeightFunction(basicParameters.getTypeWeightFunction()) + "\n");
			bw.write("   Type of monomial: " + MonomialBase.monomialName(basicParameters.getTypeMonomial()) + "\n");
			bw.write("   State Plain: " + basicParameters.getStatePlain() + "\n");
			bw.newLine();
			// Writed contour point data
			bw.write("   Contour point data\n");
			bw.write("   Id    Coord. X     Coord. Y     Normal X     Normal Y     " +
					"Bou. Con. X     Bou. Con. Y     Sur. Force X     Sur. Force Y\n");
			for (int i = 0; i < listPointsBoundery.size(); i++) {
				bw.write(String.format("%5d", listPointsBoundery.get(i).getId())  + "  " +
						String.format("%8.2f", listPointsBoundery.get(i).getCoordinateX()) + "     "	+	
						String.format("%8.2f", listPointsBoundery.get(i).getCoordinateY()) + "        " + 
						String.format("%5.2f", listPointsBoundery.get(i).getNormalX())  + "        " + 
						String.format("%5.2f", listPointsBoundery.get(i).getNormalY()) + "           " + 
						listPointsBoundery.get(i).getBoundaryConditionX() + "               " +
						listPointsBoundery.get(i).getBoundaryConditionY() + "           " + 
						String.format("%8.2f", listPointsBoundery.get(i).getSurfaceForceX())  + "         " +
						String.format("%8.2f", listPointsBoundery.get(i).getSurfaceForceY()) + "\n");
			}
			bw.newLine();
			// Writed domain point data
			bw.write("   Domain point data\n");
			bw.write("   Id    Coord. X     Coord. Y      Vol. Force X     Vol. Force Y\n");
			for (int i = 0; i < listPointsDomain.size(); i++) {
				bw.write(String.format("%5d", listPointsDomain.get(i).getId())  + "  " +
						String.format("%8.2f", listPointsDomain.get(i).getCoordinateX()) + "     "	+	
						String.format("%8.2f", listPointsDomain.get(i).getCoordinateY()) + "        " + 
						String.format("%8.2f", listPointsDomain.get(i).getVolumeForceX())  + "         " +
						String.format("%8.2f", listPointsDomain.get(i).getVolumeForceY()) + "\n");
			}
			bw.newLine();
			// Writed base point data
			bw.write("   Base point data\n");
			bw.write("   Id         Type             m        n         Radius\n");
			for (int i = 0; i < listPoints.size(); i++) {
				bw.write(String.format("%5d", listPoints.get(i).getId())  + "    " +
						String.format("%14s", MonomialBase.monomialName(basicParameters.getTypeMonomial())) + "     "	+	
						String.format("%4d", MonomialBase.monomialAmount(basicParameters.getTypeMonomial())) + "     " + 
						String.format("%4d", mqm.get(i).getLocalSupportSize())  + "         " +
						String.format("%6.4f", mqm.get(i).getMinimusRaius()) + "\n");
			}
			//
			bw.newLine();
			bw.write("   Id        Selected points within the support\n");
			for (int i = 0; i < listPoints.size(); i++) {
				bw.write(String.format("%5d", listPoints.get(i).getId())  + "      ");
				for (int j = 0; j < mqm.get(i).getLocalSupportSize(); j++) {
					bw.write(String.format("%5d", mqm.get(i).getLocalSupport().get(j)));
				}
				bw.newLine();		
			}
			
		} catch (IOException e) {
			System.out.println("error: " + e.getMessage());
		}
	}
}
