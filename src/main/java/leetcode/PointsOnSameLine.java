import java.util.*;

/**
 * created by megupta on 06/05/20
 */
public class PointsOnSameLine {

    public static void main(String[] args) {
        int[][] points =  {{1,1},{2,2},{3,3}};
        System.out.println(maxPoints(points));

        int[][] pointsn = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(maxPoints(pointsn));

    }


        public static int maxPoints(int[][] points) {
            if(points == null) return 0;
            if (points.length <= 2) return points.length;
            int ans = 0;
            int overlap;
            HashMap<my_no,Integer> slopeCount = new HashMap<>();
            for (int i = 0;i<points.length;i++){
                slopeCount.clear();
                overlap = 0;
                int lc_ans = 0;
                for (int j = i+1;j<points.length;j++){
                    int x1 = points[i][0];
                    int y1 = points[i][1];

                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    if(y2-y1 == 0 && x2 - x1 == 0){
                        overlap++;
                        continue;
                    }
                    my_no slope = new my_no(y2-y1,x2-x1);
                    int slopeVal = slopeCount.getOrDefault(slope,1);
                    lc_ans = Math.max(lc_ans,slopeVal+1);
                    slopeCount.put(slope,slopeVal+1);
                }
                if (overlap > 0 && lc_ans == 0)overlap++;
                lc_ans+=overlap;
                ans = Math.max(lc_ans,ans);
            }
            return ans;
        }
        public static long gcd(long a, long b)
        {
            if (a == 0)
                return b;
            return gcd(b%a, a);
        }
        static class my_no{
            long num;
            long denom;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                my_no my_no = (my_no) o;
                return num == my_no.num &&
                        denom == my_no.denom;
            }

            @Override
            public int hashCode() {
                return Objects.hash(num, denom);
            }

            @Override
            public String toString() {
                if (denom<0){
                    this.num=-this.num;
                    this.denom=-this.denom;
                }
                if (num==0)return "0";
                return (num+"/"+denom);
            }

            my_no(int no){
                this.num=no;
                this.denom=1;
            }
            my_no(long num,long denom){
                this.num=num;
                this.denom=denom;
                long gcd = gcd(this.num,this.denom);
                if(gcd == 0) gcd = 1;
                this.num = this.num/gcd;
                this.denom = this.denom/gcd;
            }


            my_no multiply(my_no obj){
                long num1=obj.num;
                long denom1=obj.denom;
                long n=num1*num;
                long d=denom1*denom;
                long gcd=gcd(n,d);
                n/=gcd;
                d/=gcd;
                return new my_no(n,d);

            }

            my_no multiply(int no){
                long n=num*no;
                long d=denom;
                long gcd=gcd(n,d);
                n/=gcd;
                d/=gcd;
                return new my_no(n,d);

            }

        }

}
