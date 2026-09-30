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

public class Procedure 
{
	private String procedureName;
	private String procedureDate;
	private String practitionerName;
	private double charges;
	
	/**
	 * No-argument constructor.
	 * Initializes the procedure fields to default values.
	 */
	public Procedure() 
	{
		procedureName = "";
		procedureDate = "";
		practitionerName = "";
		charges = 0.0;
	}
	
	/**
	 * Parameterized constructor.
	 * Initializes the procedure name and date.
	 * 
	 * @param procedureName name of the procedure
	 * @param procedureDate date of the procedure
	 */
	public Procedure(String procedureName, String procedureDate)
	{
		this();
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
	}
	
	/**
	 * Parameterized constructor.
	 * Initializes all procedure attributes.
	 * 
	 * @param procedureName name of the procedure
	 * @param procedureDate date of the procedure
	 * @param practitionerName name of the practitioner
	 * @param charges charges for the procedure
	 */
	public Procedure(String procedureName, String procedureDate,
						String practitionerName, double charges)
	{
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
		this.practitionerName = practitionerName;
		this.charges = charges;
	}
	
	/**
	 * Returns the procedure name.
	 * 
	 * @return procedure name
	 */
	public String getProcedureName()
	{
		return procedureName;
	}
	
	/**
	 * Sets the procedure name.
	 * 
	 * @param procedureName procedure name
	 */
	public void setProcedureName(String procedureName)
	{
		this.procedureName = procedureName;
	}
	
	/**
	 * Returns the procedure date.
	 * 
	 * @return procedure date
	 */
	public String getProcedureDate()
	{
		return procedureDate;
	}
	
	/**
	 * Sets the procedure date.
	 * 
	 * @param procedureDate procedure date
	 */
	public void setProcedureDate(String procedureDate)
	{
		this.procedureDate = procedureDate;
	}
	
	/**
	 * Returns the practitioner's name.
	 * 
	 * @return practitioner name
	 */
	public String getPractitionerName()
	{
		return practitionerName;
	}
	
	/**
	 * Sets the practitioner's name.
	 * 
	 * @param practitionerName practitioner name
	 */
	public void setPractitionerName(String practitionerName)
	{
		this.practitionerName = practitionerName;
	}
	
	/**
	 * Returns the procedure charges.
	 * 
	 * @return procedure charges
	 */
	public double getCharges()
	{
		return charges;
	}
	
	/**
	 * Sets the procedure charges.
	 * 
	 * @param charges procedure charges
	 */
	public void setCharges(double charges)
	{
		this.charges = charges;
	}
	
	/**
	 * Returns a String containing all procedure information.
	 * 
	 * @return formatted procedure information
	 */
	@Override
	public String toString()
	{
		return "\tProcedure: " + procedureName + "\n"
				+ "\tProcedure Date: " + procedureDate + "\n"
				+ "\tPractitioner: " + practitionerName + "\n"
				+ String.format("\tCharge: $%,.2f", charges);
	}
}


