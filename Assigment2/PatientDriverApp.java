package cmsc203;
/*
 * Class: CMSC203-22537
 * Instructor: Ahmed Tarek
 * Description: (Represents a patient and stores the patient's 
 * 				personal information, address, phone number,
 * 				and emergency contact information.)
 * Due: 10/01/2026
 * Platform/compiler: Windows 11 / Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _____Luis Aguero_____
*/
import java.util.Scanner;

public class PatientDriverApp {

	/**
	 * Main method. Collects patient information and procedure
	 * information from the user and displays the results.
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("The program was developed by a Student: " + "Luis Aguero 10/01/2026");
		System.out.println();
		
		//Collect patient information.
		System.out.println("Enter Patient Information");
		
		System.out.print("First Name: ");
		String firstName  = keyboard.nextLine();
		
		System.out.print("Middle Name: ");
		String middleName = keyboard.nextLine();
		
		System.out.print("Last Name: ");
		String lastName = keyboard.nextLine();
		
		System.out.print("Street Address: ");
		String streetAddress = keyboard.nextLine();
		
		System.out.print("City: ");
		String city = keyboard.nextLine();
		
		System.out.print("State: ");
		String state = keyboard.nextLine();
		
		System.out.print("ZIP Code: ");
		String zipCode = keyboard.nextLine();
		
		System.out.print("Phone Number: ");
		String phoneNumber = keyboard.nextLine();
		
		System.out.print("Emergency Contact Name: ");
		String emergencyContactName = keyboard.nextLine();
		
		System.out.print("Emergency Contact Phone: ");
		String emergencyContactPhone = keyboard.nextLine();
		
		//Create the Patient object using the all-attributes constructor.
		Patient patient = new Patient(firstName,
										middleName,
										lastName,
										streetAddress,
										city,
										state,
										zipCode,
										phoneNumber,
										emergencyContactName,
										emergencyContactPhone);
		
		System.out.println();
		
		//Collect Procedure 1 information.
		System.out.println("Enter Procedure 1 Information");
		
		System.out.print("Procedure Name: ");
		String procedure1Name = keyboard.nextLine();
		
		System.out.print("Procedure Date: ");
		String procedure1Date = keyboard.nextLine();
		
		System.out.print("Practitioner Name: ");
		String procedure1Practitioner = keyboard.nextLine();
		
		System.out.print("Charges: ");
		double procedure1Charges = keyboard.nextDouble();
		keyboard.nextLine();
		
		//Procedure 1 uses the no-argument constructor.
		Procedure procedure1 = new Procedure();
		procedure1.setProcedureName(procedure1Name);
		procedure1.setProcedureDate(procedure1Date);
		procedure1.setPractitionerName(procedure1Practitioner);
		procedure1.setCharges(procedure1Charges);
		
		System.out.println();
		
		//Collect Procedure 2 information.
		System.out.println("Enter Procedure 2 Information");
		
		System.out.print("Procedure Name: ");
		String procedure2Name = keyboard.nextLine();
		
		System.out.print("Procedure Date: ");
		String procedure2Date = keyboard.nextLine();
		
		System.out.print("Practitioner Name: ");
		String procedure2Practitioner = keyboard.nextLine();
		
		System.out.print("Charges: ");
		double procedure2Charges = keyboard.nextDouble();
		keyboard.nextLine();
		
		//Procedure 2 uses the name/date constructor.
		Procedure procedure2 = new Procedure(procedure2Name, procedure2Date);
		
		procedure2.setPractitionerName(procedure2Practitioner);
		procedure2.setCharges(procedure2Charges);
		
		System.out.println();
		
		//Collect Procedure 3 information.
		System.out.println("Enter Procedure 3 Information");
		
		System.out.print("Procedure Name: ");
		String procedure3Name = keyboard.nextLine();
		
		System.out.print("Procedure Date: ");
		String procedure3Date = keyboard.nextLine();
		
		System.out.print("Practitioner Name: ");
		String procedure3Practitioner = keyboard.nextLine();
		
		System.out.print("Charges: ");
		double procedure3Charges = keyboard.nextDouble();
		
		//Procedure 3 uses the all-attributes constructor.
		Procedure procedure3 = new Procedure(procedure3Name, 
											procedure3Date, 
											procedure3Practitioner, 
											procedure3Charges);
		
		//Display the information.
		System.out.println();
		displayPatient(patient);
		
		System.out.println();
		displayProcedure(procedure1);
		
		System.out.println();
		displayProcedure(procedure2);
		
		System.out.println();
		displayProcedure(procedure3);
		
		//Calculate and display total charges.
		double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
		
		System.out.printf("%nTotal Charges: $%,.2f%n",  totalCharges);
		
		System.out.println("Program by: Luis Aguero");
		
		keyboard.close();
	}
		
		/**
		 * Displays all information for the specified patient.
		 * 
		 * @param patient patient object to display
		 */
		public static void displayPatient(Patient patient)
		{
			System.out.println(patient);
		}
		
		/**
		 * Displays all information for the specified procedure.
		 * 
		 * @param procedure procedure object to display
		 */
		public static void displayProcedure(Procedure procedure)
		{
			System.out.println(procedure);
		}
		
		/**
		 * Calculate the total charges for three procedures.
		 * 
		 * @param procedure1 first procedure
		 * @param procedure2 second procedure
		 * @param procedure3 third procedure
		 * @return total charges of all three procedures
		 */
		public static double calculateTotalCharges(Procedure procedure1,
													Procedure procedure2,
													Procedure procedure3)
		{
			return procedure1.getCharges()
					+ procedure2.getCharges()
					+ procedure3.getCharges();
		}
		
	}

