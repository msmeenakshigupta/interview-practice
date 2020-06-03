import java.util.ArrayList;
import java.util.List;

/**
 * created by megupta on 01/05/20
 */
public class Atoi {

    public static void main(String[] args) {


        String str2 = "-sds";



        System.out.println(str2);
//        System.out.println(myAtoi(str2));
    }
    public static int myAtoi(String str) {
        int num=0;
        List<Character> validCharList = new ArrayList<Character>();
        validCharList.add('-');
        validCharList.add('1');
        validCharList.add('2');
        validCharList.add('3');
        validCharList.add('4');
        validCharList.add('5');
        validCharList.add('6');
        validCharList.add('7');
        validCharList.add('8');
        validCharList.add('9');
        validCharList.add('0');



        if(str.length()==0)
            return num;
        StringBuffer sb = new StringBuffer();
        for(char c : str.toCharArray()){
            if(c==' ')
                continue;
            if(validCharList.contains(c)){
                sb.append(c);
            }else{
                break;
            }
        }
        if(sb.length()>0) {
            if(sb.length()==1 && sb.toString().equals("-")){
                return num;
            }
            long intVal = Long.valueOf(sb.toString());
            if (intVal > Integer.MAX_VALUE)
                intVal = Integer.MAX_VALUE;
            if (intVal < Integer.MIN_VALUE)
                intVal = Integer.MIN_VALUE;

            num  = (int) intVal;
        }
        return num;
    }
}
