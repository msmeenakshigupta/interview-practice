package HackerRank;
import java.util.*;
/**
 * created by megupta on 25/04/20
 */
public class PasswordSwapTest {

    // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public List<String> reorderLines(int logFileSize, List<String> logLines)
        {
            // WRITE YOUR CODE HERE
            HashMap<String, List<String>> logMap = new HashMap<String, List<String>> ();
            for(String line : logLines){
                int firstSpacePlace = line.indexOf(" ");
                String identifier = line.substring(0, firstSpacePlace);
                String log = line.substring(firstSpacePlace+1);
                String[] words = log.split(" ");
                logMap.put(identifier, Arrays.asList(words));
            }
            Map<String, List<String>> sortedMap = sortByValue(logMap);
            Map<String, List<String>> strlogMap = new LinkedHashMap<String, List<String>> ();
            for(String key : sortedMap.keySet()){
                boolean allStr = true;
                List<String> logs = sortedMap.get(key);
                for(String str : logs){
                    if(isNumeric(str)){
                        allStr = false;
                        break;
                    }
                }
                if(allStr){
                    strlogMap.put(key, sortedMap.get(key));
                }
            }
            for(String key : sortedMap.keySet()){
                if(!strlogMap.containsKey(key)){
                    strlogMap.put(key, sortedMap.get(key));
                }
            }


            List<String> resList = new LinkedList<String>();
            for(String key : strlogMap.keySet()){
                List<String> vals = strlogMap.get(key);
                StringBuffer sb = new StringBuffer();
                sb.append(key);
                resList.add(sb.toString()+convertToStr(vals));
            }

            return resList;
        }

        private String convertToStr(List<String> ls){
            StringBuffer sb = new StringBuffer();

            for(String val : ls){
                sb.append(" ").append(val);
            }
            return sb.toString();
        }
        private boolean isNumeric(String str){
            try{
                Integer.valueOf(str);
            }catch(NumberFormatException nfe){
                return false;
            }
            return true;
        }
        private HashMap<String, List<String>> sortByValue(HashMap<String,List<String>> hm){
            List<Map.Entry<String, List<String>>> list = new LinkedList<Map.Entry<String, List<String>>> (hm.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, List<String>>>(){
                public int compare(Map.Entry<String, List<String>> o1, Map.Entry<String, List<String>> o2){
                    String o1Val = convertToStr(o1.getValue());
                    String o2Val = convertToStr(o2.getValue());
                    return o1Val.compareTo(o2Val);
                }
            });

            HashMap<String, List<String>> temp = new LinkedHashMap<String, List<String>>();
            for(Map.Entry<String, List<String>> aa : list){
                temp.put(aa.getKey(), aa.getValue());
            }
            return temp;
        }
        // METHOD SIGNATURE ENDS
}

