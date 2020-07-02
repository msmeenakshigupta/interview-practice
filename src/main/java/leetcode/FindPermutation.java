class Solution {
    public int[] findPermutation(String s) {
        int len = s.length();
        int[] arr = new int[len+1];
        int index=0;
        Stack<Integer> st = new Stack();
        for(int i=0; i<len; i++){
            if(s.charAt(i)=='I'){
                st.push(i+1);
                while(!st.isEmpty()){
                    arr[index++] =st.pop();
                }
            }else if(s.charAt(i)=='D'){
                st.push(i+1);
            }
        }
        st.push(len+1);
        while(!st.isEmpty()){
            arr[index++] =st.pop();
        }
        return arr;
        
    }
}
