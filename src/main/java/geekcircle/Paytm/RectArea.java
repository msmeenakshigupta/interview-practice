package com.geekcircle.Paytm;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-11
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Stack;

public class RectArea
{
    static int getMaxArea(int hist[], int n)
    {
        Stack<Integer> s = new Stack<>();

        int max_area = 0;
        int tp;
        int area_with_top;

        int i = 0;
        while (i < n)
        {
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);
            else {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (s.empty() == false)
        {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;

    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }
}