import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by megupta on 19/05/20
 */
public class SubDomainsVisits {

    public static void main(String[] args) {
        String[] dd = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> visits = subdomainVisits(dd);
        System.out.println("counted.");

    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> visits = new ArrayList<String>();
        return countVisits(visits, cpdomains);
    }

    public static List<String> countVisits(List<String> visits, String[] cpdomains) {
        Map<String, Integer> sub = new HashMap<String, Integer>();
        String[] domains = new String[sub.size()];
        for (String cp : cpdomains) {
            visits.add(cp);
            String[] ss = cp.split(" ");
            String[] sd = ss[1].split("\\.");
            if (sd.length > 1) {
                String str = "";
                for (int i = 1; i < sd.length - 1; i++) {
                    str += sd[i] + ".";
                }
                str += sd[sd.length - 1];
                int ff = Integer.valueOf(ss[0]);
                if (sub.containsKey(str))
                    ff += sub.get(str);
                sub.put(str, ff);
            }
        }
        if (sub.size() > 0) {

            int i = 0;
            for (String key : sub.keySet()) {
                domains[i] = sub.get(key) + " " + key;
            }
            return countVisits(visits, domains);
        }
        return visits;
    }
}
