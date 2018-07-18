package com.forevc.util;

/**
 * Created by Administrator on 2018/7/18.
 */

public class NumUtil {

    public static float max(float[] numbers) {

        float max = numbers[0];

        for (int i=1; i < numbers.length; i++) {
            if (numbers[i] > max) max = numbers[i];
        }
        return max;
    }

    public static float min(float[] numbers) {

        float min = numbers[0];

        for (int i=1; i < numbers.length; i++) {
            if (numbers[i] < min) min = numbers[i];
        }
        return min;
    }
}
