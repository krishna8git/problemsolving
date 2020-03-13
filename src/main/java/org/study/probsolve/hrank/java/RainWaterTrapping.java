
package org.study.probsolve.hrank.java;

import java.util.Arrays;
/*
 * Problem Link: https://leetcode.com/problems/trapping-rain-water/
 * Problem Description: Given n non-negative integers representing an elevation map
 * where the width of each bar is 1, compute how much water it is able to trap after raining.
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */

public class RainWaterTrapping {

    private final int[] input;

    public RainWaterTrapping(final int[] input) {
        this.input = input;
    }

    public int findAmountOfTrappedWaterWithExtraSpace() {
        int n = input.length;

        // Contains the so far tallest building from the left.
        // So the value at the i-th position is the so far max to the left of i.
        int maxFromLeft[] = new int[n];

        // Contains the so far tallest building from the right.
        // So the value at the i-th building is the so far max to the right of i.
        int maxFromRight[] = new int[n];

        maxFromLeft[0] = input[0];
        maxFromRight[n - 1] = input[n - 1];
        for (int i = 1; i < n; i++) {
            maxFromLeft[i] = Integer.max(maxFromLeft[i - 1], input[i]);
            maxFromRight[n - i - 1] = Integer.max(maxFromRight[n - i], input[n - i - 1]);
        }

        int waterAmount = 0;
        for (int i = 0; i < n; i++) {
            waterAmount += Integer.min(maxFromLeft[i], maxFromRight[i]) - input[i];
        }
        return waterAmount;
    }

    public int findAmountOfTrappedWaterWithConstSpace() {
        int n = input.length;
        int size = n - 1;

        // Let the first element be stored as
        // previous, we shall loop from index 1
        int prev = input[0];

        // To store previous wall's index
        int prevIndex = 0;
        int water = 0;

        // To store the water until a larger wall
        // is found, if there are no larger walls
        // then delete temp value from water
        int temp = 0;
        for (int i = 1; i <= size; i++) {

            // If the current wall is taller than
            // the previous wall then make current
            // wall as the previous wall and its
            // index as previous wall's index
            // for the subsequent loops
            if (input[i] >= prev) {
                prev = input[i];
                prevIndex = i;

                // Because larger or same height wall is found
                temp = 0;
            } else {

                // Since current wall is shorter than
                // the previous, we subtract previous
                // wall's height from the current wall's
                // height and add it to the water
                water += prev - input[i];

                // Store the same value in temp as well
                // If we dont find any larger wall then
                // we will subtract temp from water
                temp += prev - input[i];
            }
        }

        // If the last wall was larger than or equal
        // to the previous wall then prevIndex would
        // be equal to size of the inputay (last element)
        // If we didn't find a wall greater than or equal
        // to the previous wall from the left then
        // prevIndex must be less than the index
        // of the last element
        if (prevIndex < size) {

            // Temp would've stored the water collected
            // from previous largest wall till the end
            // of inputay if no larger wall was found then
            // it has excess water and remove that
            // from 'water' var
            water -= temp;

            // We start from the end of the inputay, so previous
            // should be assigned to the last element
            prev = input[size];

            // Loop from the end of inputay up to the 'previous index'
            // which would contain the "largest wall from the left"
            for (int i = size; i >= prevIndex; i--) {

                // Right end wall will be definitely smaller
                // than the 'previous index' wall
                if (input[i] >= prev) {
                    prev = input[i];
                } else {
                    water += prev - input[i];
                }
            }
        }

        // Return the maximum water
        return water;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        RainWaterTrapping rwt = new RainWaterTrapping(input);
        System.out.println(Arrays.toString(input) + ": " + rwt.findAmountOfTrappedWaterWithExtraSpace());
        System.out.println(Arrays.toString(input) + ": " + rwt.findAmountOfTrappedWaterWithConstSpace());
        System.out.println();

        input = new int[]{3, 0, 0, 2, 0, 4};
        rwt = new RainWaterTrapping(input);
        System.out.println(Arrays.toString(input) + ": " + rwt.findAmountOfTrappedWaterWithExtraSpace());
        System.out.println(Arrays.toString(input) + ": " + rwt.findAmountOfTrappedWaterWithConstSpace());
        System.out.println();

        input = new int[]{2, 0, 2};
        rwt = new RainWaterTrapping(input);
        System.out.println(Arrays.toString(input) + ": " + rwt.findAmountOfTrappedWaterWithExtraSpace());
        System.out.println(Arrays.toString(input) + ": " + rwt.findAmountOfTrappedWaterWithConstSpace());

        input = new int[]{4, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        rwt = new RainWaterTrapping(input);
        System.out.println(Arrays.toString(input) + ": " + rwt.findAmountOfTrappedWaterWithExtraSpace());
        System.out.println(Arrays.toString(input) + ": " + rwt.findAmountOfTrappedWaterWithConstSpace());
    }
}
