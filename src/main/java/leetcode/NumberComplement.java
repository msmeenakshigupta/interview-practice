/**
 * created by megupta on 04/05/20
 */
public class NumberComplement {

    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(5));
    }

    public static int findComplement(int num) {
        String binString = converToBinary(num);
        String complement =  complement(binString);
        return convertToBase10(complement);
    }

    public static String converToBinary(int num){
        return  Integer.toString( Integer.parseInt(String.valueOf(num), 10), 2);
    }

    public static String complement(String binString){
        StringBuffer sb = new StringBuffer();
        for(char c : binString.toCharArray()){
            if(c=='1')
                sb.append("0");
            if(c=='0')
                sb.append("1");
        }
        return sb.toString();
    }

    public static int convertToBase10(String complement){
       return Integer.parseInt( Integer.toString(Integer.parseInt(complement, 2), 10));



    }
}
