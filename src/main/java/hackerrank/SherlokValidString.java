package HackerRank;

import java.util.*;

/**
 * created by megupta on 11/7/19
 */
public class SherlokValidString {
    // Complete the isValid function below.
    static String isValid(String s) {
        boolean isvalid = false;
        String result;

        Map<Character, Integer> frequencyMap = createFrequencyMap(s);
        isvalid = checkConsistency(frequencyMap);

        if(isvalid){
            result="YES";
        }else {
            result="NO";
        }
        return result;
    }




    private static Map createFrequencyMap(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int count = 1;
            if(frequencyMap.containsKey(c)){
                count = frequencyMap.get(c);
                count++;
            }
            frequencyMap.put(c, count);
        }
        return frequencyMap;
    }

    private static boolean checkConsistency(Map<Character,Integer> frequencyMap) {
        boolean isConsistent = false;
        Set<Integer> countsSet = new HashSet<>( frequencyMap.values());

        //all chars have same frequency.
        if(countsSet.size()==1){
            isConsistent = true;
        }

        //check if is Consistent By Removing One Char

        //if count set is of size more than 2, it can not be made valid.
        if(countsSet.size()==2){
           Map<Integer, Integer> numberOfStringsWithFrequency = new HashMap<>();
           for(char c : frequencyMap.keySet()){
               int count = frequencyMap.get(c);
               int chars = 0;
               if(numberOfStringsWithFrequency.containsKey(count)){
                   chars = numberOfStringsWithFrequency.get(count);
               }
               chars++;
               numberOfStringsWithFrequency.put(count, chars);
           }
           int numberOfCharsWithFreq1 , numberOfCharsWithFreq2;

           Iterator itr = numberOfStringsWithFrequency.keySet().iterator();
           int freq1 = (int) itr.next();
           int freq2 = (int) itr.next();
           numberOfCharsWithFreq1 = numberOfStringsWithFrequency.get(freq1);
           numberOfCharsWithFreq2 = numberOfStringsWithFrequency.get(freq2);

           if(numberOfCharsWithFreq1==1 && (freq1==1 || Math.abs(freq1-freq2)==1 ) )
               isConsistent = true;
           else if(numberOfCharsWithFreq2==1  && (freq2==1 || Math.abs(freq1-freq2)==1))
               isConsistent = true;
           else if(Math.abs(freq1-freq2)==1){
               if(freq1<freq2){
                   if(numberOfCharsWithFreq1==1)
                       isConsistent = true;
               }else if(numberOfCharsWithFreq2 ==1){
                   isConsistent = true;
               }
           }

        }

        return isConsistent;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        String s = scanner.nextLine();
        String result = isValid(s);
        scanner.close();
        System.out.println(result);
    }

}
