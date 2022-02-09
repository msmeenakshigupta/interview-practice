package com.geekcircle.ImportantProblems;

public class D11 {
    public static int maxProduct(int[] A)
    {
        int max_ending = 0, min_ending = 0;
        int max_so_far = 0;
        for (int i: A)
        {
            int temp = max_ending;
            max_ending = Integer.max(i, Integer.max(i * max_ending, i * min_ending));
            min_ending = Integer.min(i, Integer.min(i * temp, i * min_ending));
            max_so_far = Integer.max(max_so_far, max_ending);
        }
        return max_so_far;
    }

    public static void main(String[] args)
    {
        int[] A = { -2 };
        System.out.println("The maximum product of a sub-array is " + maxProduct(A));
    }
}
