import java.util.HashMap;
import java.util.Map;

/**
 * created by megupta on 01/05/20
 */
public class VersionControl {
     private static   Map<Integer, Boolean> versionMap ;

    public Map getVersionMap() {
        return versionMap;
    }

    public void setVersionMap(Map versionMap) {
        this.versionMap = versionMap;
    }

    public static boolean isBadVersion(int ver){
        return versionMap.get(ver);
    }
}
