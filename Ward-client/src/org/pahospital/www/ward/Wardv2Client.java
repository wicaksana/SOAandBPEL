package org.pahospital.www.ward;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.pahospital.www.ward.Wardv2Stub;
import org.pahospital.www.ward.Wardv2Stub.ExamType_type1;
import org.pahospital.www.ward.Wardv2Stub.NeedTransport_type1;
import org.pahospital.www.ward.Wardv2Stub.SampMaterial_type1;
import org.pahospital.www.ward.Wardv2Stub.ValidateReport;
import org.pahospital.www.ward.Wardv2Stub.ValidateReportResponse;
import org.pahospital.www.ward.Wardv2Stub.Wardv2Request;
import org.pahospital.www.ward.Wardv2Stub.Wardv2Response;

public class Wardv2Client {

	private final static String URL = "http://localhost:8080/ode/processes/Wardv2";
	
	public static void main(String[] args) {
		Wardv2Request orderRequest = new Wardv2Request();
		Wardv2Response examReport = new Wardv2Response();
		ValidateReport validateReport = new ValidateReport();
		ValidateReportResponse dischargeLetter = new ValidateReportResponse();
		
		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		
		Integer temp;
		List<String> labParams = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		
		//enter Patient ID
		System.out.print("Patient ID: ");
		orderRequest.setPatID(scanner.nextLine());
		
		//enter patient name
		System.out.print("Patient name: ");
		orderRequest.setPatName(scanner.nextLine());
		
		//enter patient's address
		System.out.print("Patient street address: ");
		orderRequest.setPatStreet(scanner.nextLine());
		
		//enter patient's ZIP code
		System.out.print("Patient ZIP code: ");
		orderRequest.setPatZipCode(Integer.parseInt(scanner.nextLine()));
		
		//enter patient's city
		System.out.print("Patient city: ");
		orderRequest.setPatCity(scanner.nextLine());
		
		//enter patient's birth date
		System.out.print("Patient birth date (dd-MMM-yyyy): ");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			orderRequest.setPatBirthday(formatter.parse(scanner.nextLine()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		//enter patient's case ID
		System.out.print("Case ID: ");
		orderRequest.setCasID(scanner.nextLine());
		
		//enter patient's sample ID
		System.out.print("Sample ID: ");
		orderRequest.setSampID(scanner.nextLine());
		
		//enter sample material provided
		System.out.print("Sample material (BLOOD/URINE): ");
		orderRequest.setSampMaterial(new SampMaterial_type1(scanner.next().toUpperCase(), true));
		
		//enter lab parameters needed to be analyzed
		System.out.print("Number of lab parameters: ");
		temp = Integer.parseInt(scanner.next());
		for(int i = 0; i < temp; i++) {
			System.out.print("- Lab parameter(" + i + "): ");
			labParams.add(scanner.next());
		}
		String[] temp2 = new String[labParams.size()];
		temp2 = labParams.toArray(temp2);
		orderRequest.setLabPar(temp2);
		
		//enter examination type needed
		System.out.print("Examination type (XRAY/CT): ");
		orderRequest.setExamType(new ExamType_type1(scanner.next(), true));

		//need transportation for radiology exam?
		System.out.print("Need transportation? (Yes/No): ");
		orderRequest.setNeedTransport(new NeedTransport_type1(scanner.next(), true));

		//enter radiology exam date
		System.out.print("Examination date (dd-MMM-yyyy): ");
		SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			orderRequest.setExamDate(formatter3.parse(scanner.next()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		//enter date and hour for radiology exam
		System.out.print("Transportation date and time (yyyy/MM/dd/HH:mm:ss): ");
		SimpleDateFormat formatter2  = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
		try {
			cal.setTime(formatter2.parse((scanner.next())));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		orderRequest.setTransportDateTime(cal);

		System.out.print("Requesting unit: ");
		orderRequest.setRequestUnit(scanner.next());
		
		System.out.print("Destination unit: ");
		orderRequest.setDestUnit(scanner.next());
		
		/**
		 * Send the order to the BPEL Server, and display the retrieved reports, if succeed
		 */
		
		try {
			Wardv2Stub stub = new Wardv2Stub(URL);
			examReport = stub.order(orderRequest);
			displayReport(examReport);
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		
		/**
		 * having read the report, now the physician will give his/her analysis about the patient
		 * condition
		 */
		System.out.println("-------------------------------------------------");
		System.out.println("Enter the summary of the patient examination: ");
		System.out.println("-------------------------------------------------");
		System.out.print("Patient ID: ");
		validateReport.setPatiID(scanner.next());
		System.out.println("Physician analysis: ");
		String temp4 = scanner2.nextLine();
		validateReport.setValidation(temp4);
		
		/**
		 * Send the analysis, to generate the discharge letter
		 */
		try {
			Wardv2Stub stub = new Wardv2Stub(URL);
			dischargeLetter = stub.validateReport(validateReport);
			displayDischargeletter(dischargeLetter);
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		scanner.close();
		scanner2.close();
	}

	private static void displayDischargeletter(
			ValidateReportResponse dischargeLetter) {
		System.out.println("\n\n-----------------Discharge Letter----------------");
		System.out.println(dischargeLetter.getOut());
		System.out.println("-------------------------------------------------");
	}

	private static void displayReport(Wardv2Response examReport) {
		//display retrieved report
		System.out.println("\n\n------------------Report received----------------");
		System.out.println("*) Radiology report");
		System.out.println("-- Patient ID = " + examReport.getRadiologyReport().getPatientID());
		System.out.println("-- Radiology order ID = " + examReport.getRadiologyReport().getRadiologyOrderID());
		System.out.println("-- Date of examination = " + examReport.getRadiologyReport().getDateOfExamination());
		System.out.println("-- Report = " + examReport.getRadiologyReport().getReportText());
		System.out.println("\n*) Laboratory report");
		System.out.println("-- Patient ID = " + examReport.getLabReport().getPatientID());
		System.out.println("-- Laboratory order ID = " + examReport.getLabReport().getLabOrderID());
		System.out.println("-- Sample ID = " + examReport.getLabReport().getSampleID());
		System.out.println("-- Lab results = ");
		for(int i = 0; i < examReport.getLabReport().getLabValues().length; i++)
			System.out.println("\t" + examReport.getLabReport().getLabValues()[i].getLabParameter() +
					"\t" + examReport.getLabReport().getLabValues()[i].getLabValue());
		System.out.println("-------------------------------------------------");
		System.out.println("\n\n");
	}

}
