/**
 * created by megupta on 02/05/20
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"aca","cba"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int index =0;
        boolean canTraverse = true;
        StringBuilder sb = new StringBuilder();
        while(canTraverse){
            if(index>=strs[0].length()){
                canTraverse = false;
            }else{
                char c = strs[0].charAt(index);
                int i=1;
                for(; i<strs.length; i++){
                    String str = strs[i];
                    if(index>=str.length()){
                        canTraverse = false;
                        break;
                    }else{
                        if(str.charAt(index)!=c){
                            canTraverse = false;
                            break;

                        }
                    }
                }
                if(i==strs.length){
                    sb.append(c);
                }
            }
            index++;
        }
        return sb.toString();
    }
}
