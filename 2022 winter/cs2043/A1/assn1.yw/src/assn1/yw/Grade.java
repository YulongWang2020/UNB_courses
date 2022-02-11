package assn1.yw;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Grade {
    private String letterGrade;
    private double gpa;
    private String courseName;
    private int creditHours;

    public Grade(String grade) throws InvalidParameterException {
        String[] info = grade.split(" ");
        if(info.length != 3){
            throw new InvalidParameterException("Invalid grade input length!");
        }else{
            if(!Pattern.matches("[a-zA-Z]+[0-9]+", info[0])){
                throw new InvalidParameterException("Invalid course name!");
            }else {
                this.courseName = info[0];
            }
            if(!Pattern.matches("\\dCH", info[1])){
                throw new InvalidParameterException("Invalid credit hours!");
            }else{
                this.creditHours = Integer.parseInt(info[1].substring(0,1));
            }
            if(Registrar.table.containsKey(info[2])){
                this.letterGrade = info[2];
                this.gpa = Registrar.calculateGpa(this.letterGrade);
            }else if(Pattern.matches("[0-9]*\\.[0-9]+", info[2]) && Registrar.table.containsValue(Double.parseDouble(info[2]))){
                this.gpa = Double.parseDouble(info[2]);
                this.letterGrade = Registrar.calculateLetterGrade(this.gpa);
            }else{
                throw new InvalidParameterException("Invalid grade format");
            }
        }
    }

    public double getGpa() {
        return gpa;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public int getCreditHours() {
        return creditHours;
    }

    @Override
    public String toString() {
        return courseName + " " + creditHours + "CH " + gpa + " ("+letterGrade+") \n";
    }
}
