import java.util.HashMap;

/**
 * Convert Hex number to decimal integer
 * @author Yulong Wang
 * @date 2021/11/05
 */
public class HexToDecimal {
    public static HashMap<Character,Integer> hexMap = new HashMap<Character,Integer>(){{
        put('A',10);
        put('B',11);
        put('C',12);
        put('D',13);
        put('E',14);
        put('F',15);
    }};

    /**
     * @param str The hex number to be converted
     * @return int The decimal value
     * @throws IllegalArgumentException Throw if invalid input.
     */
    public static int hexToDecimal(String str) throws IllegalArgumentException{
        if(str == null){
            throw new IllegalArgumentException("No argument provided");
        }
        str = str.toUpperCase();
        if(str.length()<1){
            return 0;
        }
        char digit = str.charAt(0);
        if(digit>47 && digit<58){
            return Character.getNumericValue(digit)*(int)Math.pow(16, str.length()-1) + hexToDecimal(str.substring(1));
        }else if(digit>64 && digit<71){
            return hexMap.get(digit)*(int)Math.pow(16, str.length()-1) + hexToDecimal(str.substring(1));
        }else{
            throw new IllegalArgumentException("The given string is not a hex number");
        }
    }

    /**
     * @param args argument
     */
    public static void main(String[] args) {
        try{
            String i = args[0];
            System.out.println(hexToDecimal(i));
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No argument entered.");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}