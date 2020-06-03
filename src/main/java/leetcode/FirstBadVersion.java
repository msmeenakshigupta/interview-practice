import java.util.HashMap;
import java.util.Map;

/**
 * created by megupta on 01/05/20
 */
public class FirstBadVersion extends VersionControl {

    public static void main(String[] args) {
        Map<Integer, Boolean> versionMap = new HashMap<Integer, Boolean>();
        versionMap.put(1, false);
        versionMap.put(2, false);
        versionMap.put(3, false);
        versionMap.put(4, true);
        versionMap.put(5, true);

        VersionControl versionControl = new VersionControl();
        versionControl.setVersionMap(versionMap);

        System.out.println(firstBadVersion(versionMap.size()));
    }

    public static int firstBadVersion(int n) {
        return firstBadVersion(1,n);
    }
    private static int firstBadVersion(int first, int last){
        if(first==last && isBadVersion(first))
            return first;
        int mid = (last+first)/2;
        if(isBadVersion(mid)){
            if(!isBadVersion(mid-1))
                return mid;
            else return firstBadVersion(first, mid-1);
        }else{
            return firstBadVersion(mid+1, last);
        }



    }
}
