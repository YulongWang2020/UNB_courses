package assn1.yw;

import java.util.*;

public class Registrar {
    public static final HashMap<String, Double> table = new HashMap<String, Double>();

    public static void initMap(){
        table.put("A+",4.3);
        table.put("A",4.0);
        table.put("A-",3.7);
        table.put("B+",3.3);
        table.put("B",3.0);
        table.put("B-",2.7);
        table.put("C+",2.3);
        table.put("C",2.0);
        table.put("D",1.0);
        table.put("F",0.0);
    }



    public static double calculateGpa(String letterGrade){
        return table.get(letterGrade);
    }

    public static String calculateLetterGrade(double grade) throws NoSuchElementException {
        for (Map.Entry<String, Double> entry : table.entrySet()) {
            if (grade == entry.getValue()) {
                return entry.getKey();
            }
        }
        throw new NoSuchElementException("Can not match gpa to a letter grade.");
    }

    public static String calculateNetGpa(List<Grade> grade){
        if(grade.isEmpty()){
            return "NaN";
        }
        int ch = 0;
        double gpa = 0.0;
        double sum = 0.0;
        for(Grade temp: grade){
            sum += temp.getGpa()*temp.getCreditHours();
            ch += temp.getCreditHours();
        }
        return "" + Math.round(sum/ch * 100.0) / 100.0;
    }
}
