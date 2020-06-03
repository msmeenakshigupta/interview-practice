import java.util.ArrayList;
import java.util.List;

/**
 * created by megupta on 07/05/20
 */
public class RemoveBoxes {

    public static void main(String[] args) {
        int[] boxes = {1,3,2,2,2,3,4,3,1};
        System.out.println(removeBoxes(boxes));
    }

    static class ColorBox {
        private int color;
        private int count;

        public ColorBox(int c, int n){
            this.color = c;
            this.count = n;
        }

        public int getCount(){
            return this.count;
        }

        public int getColor(){
            return this.color;
        }
    }
    public static int removeBoxes(int[] boxes) {
        if(boxes.length==0)
            return 0;
        List<ColorBox> cboxes = new ArrayList<ColorBox>();
        for(int i=0; i<boxes.length; i++){
            int c = boxes[i];
            int size = cboxes.size();
            if(i==0 || c!=boxes[i-1]){
                cboxes.add(new ColorBox(c, 1));
            }else{
                cboxes.get(size-1).count++;
            }
        }

        return removeBoxes(cboxes);
    }

    public static int removeBoxes(List<ColorBox> cboxes ){
        int size = cboxes.size();
        if(size==0)
            return 0;
        ColorBox last = cboxes.get(size-1);
        cboxes = cboxes.subList(0, size-1);
        int ans = last.getCount()*last.getCount() + removeBoxes(cboxes);

        for(int i=0; i<size-1; i++){
            if(cboxes.get(i).getColor() == last.getColor()){
                cboxes.get(i).count+=last.getCount();
                int ansN = removeBoxes(cboxes.subList(0, i+1)) + removeBoxes(cboxes.subList(i+1, size));
                if(ansN > ans){
                    ans = ansN;
                }
                cboxes.get(i).count-=last.getCount();
            }
        }

        return ans;



    }
}
