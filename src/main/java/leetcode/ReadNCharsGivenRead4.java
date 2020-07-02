/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 
 Method read4:

The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf.

The return value is the number of actual characters read.

Note that read4() has its own file pointer, much like FILE *fp in C.

Definition of read4:

    Parameter:  char[] buf4
    Returns:    int

Note: buf4[] is destination not source, the results from read4 will be copied to buf4[]

 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int i=0;
        boolean stopflag=true;
        while(i<n && stopflag){
            char[] read4=new char[4];
            int readchar=read4(read4);
            for(int j=0;j<readchar && i<n;j++,i++){
                buf[i]=read4[j];
            }
            if(readchar<4) stopflag=false;
        }
        return i;
    }
}
