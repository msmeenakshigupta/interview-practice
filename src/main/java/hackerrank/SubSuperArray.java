package HackerRank;

import java.io.*;
import java.util.*;

/**
 * created by megupta on 23/04/20
 */
public class SubSuperArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_Arr = br.readLine().split(" ");
            int[] Arr = new int[N];
            for (int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++) {
                Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
            }

            int out_ = calcSubAndSuperArray(Arr, N);
            wr.println(out_);
        }

        wr.close();
        br.close();
    }

    static int calcSubAndSuperArray(int[] Arr, int N) {
        // Write your code here

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int num = Arr[0];
        l1.add(num);
        int j=0;
        for(int i=1; i<N; i++){
            if(Arr[i]>num){
                l1.add(Arr[i]);
                num = Arr[i];
                continue;
            }else{
                if(l1.size()==1){
                    l1.add(1, Arr[i]);
                    num = Arr[i];
                    continue;
                }
                else{
                    j=i;
                    break;
                }
            }
        }
        l2.add(num);
        for( ; j<N; j++){
            if(Arr[j]>num){
                l2.add(Arr[j]);
                num = Arr[j];
                continue;
            }else{
                if(l2.size()==1){
                    l2.add(1, Arr[j]);
                    num = Arr[j];
                    continue;
                }

            }
        }

        return l1.size()+l2.size();
    }
}
