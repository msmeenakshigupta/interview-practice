package HackerRank;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by megupta on 11/19/19
 */
public class RegexDay28 {
    private static final Scanner scanner = new Scanner(System.in);

    static class Data{
        String firstname;
        String email;

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Data(String firstname, String email) {
            this.firstname = firstname;
            this.email = email;
        }
    }


    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        List<Data> dataList = new LinkedList<>();

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];

            Data data  = new Data(firstName, emailID);
            dataList.add(data);
        }

        printSortedNameWithGmail(dataList);

        scanner.close();
    }

    private static void printSortedNameWithGmail(List<Data> dataList) {
        Iterator itr = dataList.iterator();
        Pattern pattern = Pattern.compile("@gmail.com");
        List<String> names = new ArrayList<>();
        while(itr.hasNext()){
            Data data = (Data) itr.next();
            Matcher m = pattern.matcher(data.getEmail());
            if(m.find()){
                names.add(data.getFirstname());
            }
        }
        Collections.sort(names);
        for(int i=0; i<names.size(); i++){
            System.out.println(names.get(i));
        }


    }
}
