import java.util.Stack;

/**
 * created by megupta on 12/05/20
 */
public class StackOps {
    public static void main(String[] args) {
        Stack<Integer> spots = new Stack<Integer>();

        System.out.println(spots.size());

        spots.setSize(30);
        System.out.println(spots.size());

        spots.add(1);
        spots.add(3);

        System.out.println(spots.size());



    }
}
