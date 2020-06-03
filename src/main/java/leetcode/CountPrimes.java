/**
 * created by megupta on 01/05/20
 */
public class CountPrimes {

    public static void main(String[] args) {
        int num = 1500000;
        int primes = countPrimes(num);
        System.out.println(primes);
    }

    public static int countPrimes(int n) {
        int count=0;
        for(int i=0; i<n; i++){
            if(isPrime(i))
                count++;
        }
        return count;
    }

    private static boolean isPrime(int num){
        if(num>3){
            int i=2;
            for(; i<=Math.sqrt(num); i++){
                if(num%i==0)
                    return false;
            }
            if(i>num/2)
                return true;
        }else if(num==0 || num==1){
            return false;
        }else {
            return true;
        }
        return true;

    }
}
