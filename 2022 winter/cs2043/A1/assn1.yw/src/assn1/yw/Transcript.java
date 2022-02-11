package assn1.yw;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Transcript {
	private int studentId;
	private List<Grade> grades = new ArrayList<>();
	
	Transcript(int studentId){
		Registrar.initMap();
		this.studentId = studentId;
	}

	public void addGrade(String gradeInput){
		try{
			Grade grade = new Grade(gradeInput);
			grades.add(grade);
		}catch (InvalidParameterException e){
			System.out.println(e.getMessage());
		}
	}

	public void removeByName(String name){
		grades.removeIf(grade -> grade.getCourseName().equals(name));
	}

	public void removeByNameLetterGrade(String name, String letterGrade){
		grades.removeIf(grade -> grade.getCourseName().equals(name) && Objects.equals(grade.getLetterGrade(), letterGrade));
	}

	public void printTranscript() {
		String netString = "Student " + studentId + ": GPA " + Registrar.calculateNetGpa(this.grades) + "\n";
		for(Grade temp : grades){
			netString += temp.toString();
		}
		System.out.println(netString);
	}

	@Override
	public String toString() {
		return "Transcript{" +
				"studentId=" + studentId +
				", grades=" + grades +
				'}';
	}
}
