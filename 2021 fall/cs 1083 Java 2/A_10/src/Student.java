/**
Represents a student.
*/
public class Student implements Comparable<Student>{

	/**
	The last name of the student.
	*/
	private String lastName;
	
	/**
	The first name of the student.
	*/
	private String firstName;
	
	/**
	The student's ID number.
	*/
	private int id;
	
	
	/**
	Constructs a student given their first and last name, and student ID.
	@param firstNameIn The first name of the student.
	@param lastNameIn The last name of the student.
	@param idIn The student's ID number.
	*/
	public Student(String firstNameIn, String lastNameIn, int idIn){
		firstName = firstNameIn;
		lastName = lastNameIn;
		id = idIn;
	}
		
	/**
	Prints all the information about the student.
	@return The student's information.
	*/
	public String toString(){
		return lastName + ", " + firstName + " (" + id + ")";
	}

	@Override
	public int compareTo(Student o) {
		if(this.lastName.compareTo(o.lastName) != 0){
			return this.lastName.compareTo(o.lastName);
		}else if(this.firstName.compareTo(o.firstName) != 0){
			return this.firstName.compareTo(o.firstName);
		}else{
			return Integer.compare(this.id, o.id);
		}
	}
}