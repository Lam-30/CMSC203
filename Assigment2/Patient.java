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
 
public class Patient {

	//Patient personal information
	private String firstName;
	private String middleName;
	private String lastName;
	
	//Patient address information
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	
	//Patient phone information
	private String phoneNumber;
	
	//Emergency contact information
	private String emergencyContactName;
	private String emergencyContactPhone;
	
	/**
	 * No-argument constructor.
	 * Initializes all Patient fields to their default values.
	 */
	public Patient()
	{
		firstName = "";
		middleName = "";
		lastName = "";
		streetAddress = "";
		city = "";
		state = "";
		zipCode = "";
		phoneNumber = "";
		emergencyContactName = "";
		emergencyContactPhone = "";
	}
	/**
	 * Parameterized constructor.
	 * Initializes the patient's first, middle, and last names.
	 * 
	 * @param firstName patient's first name
	 * @param middleName patient's middle name
	 * @param lastName patient's last name
	 */
	public Patient(String firstName, String middleName, String lastName)
	{
		this();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	/**
	 * Parameterized constructor.
	 * Initializes all attributes of the patient.
	 * 
	 * @param firstName patient's first name
	 * @param middleName patient's middle name
	 * @param lastName patient's last name
	 * @param streetAddress patient's street address
	 * @param city patient's city
	 * @param state patient's city
	 * @param zipCode patient's ZIP code
	 * @param phoneNumber patient's phone number
	 * @param emergencyContactName emergency contact name
	 * @param emergencyContactPhone emergency contact phone
	 */
	public Patient(String firstName, String middleName, String lastName,
					String streetAddress, String city, String state,
					String zipCode, String phoneNumber,
					String emergencyContactName, String emergencyContactPhone)
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactPhone = emergencyContactPhone;
	}
	
	/**
	 * Returns the patient's first name.
	 * 
	 * @return first name
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Sets the patient's first name.
	 * 
	 * @param firstName first name
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	/**
	 * Returns the patient's middle name.
	 * 
	 * @return middle name
	 */
	public String getMiddleName()
	{
		return middleName;
	}
	
	/**
	 * Sets the patient's middle name.
	 * 
	 * @param middleName middle name
	 * 
	 */
	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}
	
	/**
	 * Returns the patient's last name.
	 * 
	 * @return last name
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Sets the patient's last name.
	 * 
	 * @param lastName last name
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	/**
	 * Returns the patient's street address.
	 * 
	 * @return street address
	 */
	public String getStreetAddress()
	{
		return streetAddress;
	}
	
	/**
	 * Sets the patient's street address.
	 * 
	 * @param streetAddress street address
	 */
	public void setStreetAddress(String streetAddress)
	{
		this.streetAddress = streetAddress;
	}
	
	/**
	 * Returns the patient's city.
	 * 
	 * @return city
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * Sets the patient's city.
	 * 
	 * @param city city
	 */
	public void setCity(String city)
	{
		this.city = city;
	}
	
	/**
	 * Returns the patient's state.
	 * 
	 * @return state
	 */
	public String getState()
	{
		return state;
	}
	
	/**
	 * Sets the patient's state.
	 * 
	 * @param state state
	 */
	public void setState(String state)
	{
		this.state = state;
	}
	
	/**
	 * Returns the patient's ZIP code.
	 * 
	 * @return ZIP code
	 */
	public String getZipCode()
	{
		return zipCode;
	}
	
	/**
	 * Sets the patient's ZIP code.
	 * 
	 * @param zipCode ZIP code
	 */
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	
	/**
	 * Returns the patient's phone number.
	 * 
	 * @return phone number
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	/**
	 * Sets the patient's phone number.
	 * 
	 * @param phoneNumber phone number
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Returns the emergency contact name.
	 * 
	 * @return emergency contact name
	 */
	public String getEmergencyContactName()
	{
		return emergencyContactName;
	}
	
	/**
	 * Sets the emergency contact name.
	 * 
	 * @param emergencyContactName emergency contact name
	 */
	public void setEmergencyContactName(String emergencyContactName)
	{
		this.emergencyContactName = emergencyContactName;
	}
	
	/**
	 * Returns the emergency contact phone number.
	 * 
	 * @return emergency contact phone
	 */
	public String getEmergencyContactPhone()
	{
		return emergencyContactPhone;
	}
	
	/**
	 * Sets the emergency contact phone number.
	 * 
	 * @param emergencyContactPhone emergency contact phone
	 */
	public void setEmergencyContactPhone(String emergencyContactPhone)
	{
		this.emergencyContactPhone = emergencyContactPhone;
	}
	
	/**
	 * Builds and returns the patient's complete name.
	 * 
	 * @return patient's first, middle, and last name
	 */
	public String buildFullName()
	{
		return firstName + " " + middleName + " " + lastName;
	}
	
	/**
	 * Builds and returns the patient's complete address.
	 * 
	 * @return patient's address, city, state, and ZIP code
	 */
	public String buildAddress()
	{
		return streetAddress + " " + city + " " + state + " " + zipCode;
	}
	
	/**
	 * Builds and returns the emergency contact information.
	 * 
	 * @return emergency contact name and phone number
	 */
	public String buildEmergencyContact()
	{
		return emergencyContactName + " " + emergencyContactPhone;
	}
	
	/**
	 * Returns a String containing all patient information.
	 * 
	 * @return formatted patient information
	 */
	@Override
	public String toString()
	{
		return "Patient Information\n\n"
				+ "Patient info:\n"
				+ "Name: " + buildFullName() + "\n"
				+ "Address: " + buildAddress() + "\n"
				+ "Emergency Contact: " + buildEmergencyContact();
	}
}
