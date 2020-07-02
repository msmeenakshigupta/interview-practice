/**

Note:

Consider that you cannot manipulate the file directly, the file is only accesible for read4 but not for read.
The read function may be called multiple times.
Please remember to RESET your class variables declared in Solution, as static/class variables are persisted across multiple test cases. Please see here for more details.
You may assume the destination buffer array, buf, is guaranteed to have enough space for storing n characters.
It is guaranteed that in a given test case the same buffer buf is called by read.


 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    
    List<Character> list = new ArrayList();
    public int read(char[] buf, int n) {
            if(list.size()==0){
                populate();
            }
        if(list.size()==0)
            return 0;
        int i=0;
        while(i<n){
            buf[i] = list.remove(0);
             i++;
            if(list.size()==0){
                populate();
                if(list.size()==0)
                      return i;
            }
           
               
           
        }
            
       return i; 
        
    }
    
    public void populate(){
        char[] read4=new char[4];
        int readchar=read4(read4);
       
        for(int i=0; i<readchar; i++){
            list.add(read4[i]);
        }
    }
}
