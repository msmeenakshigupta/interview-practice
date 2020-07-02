/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    int people ;
    public int findCelebrity(int n) {
       people=n;
        int i=0;
        int celeb=0;
        while(i<n){
            if(knows(celeb, i)){
                celeb=i;
                
            }
            i++;
        }
        if(isCeleb(celeb))
            return celeb;
        else 
            return -1;
            
    }
    
    public boolean isCeleb(int celeb){
        for(int i=0; i<people; i++){
            if(i==celeb)
                continue;
            if(knows(celeb, i) || !knows(i, celeb))
                return false;
        }
        return true;
    }
}
