package com.epam.rd.autotasks.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{-3, 2, 4, 3, 5, 12, 8};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            if (i == 0 && (array[i + 1] < array[i])) list.add(array[i]);
            if (i == array.length - 1 && array[i - 1] < array[i]) list.add(array[i]);
            else if (i > 0 && array[i + 1] < array[i] && array[i - 1] < array[i]) list.add(array[i]);
        }

        if (list.size() == array.length || list.size() == 0)
            return Arrays.copyOf(array, array.length);

        int[] res = new int[list.size()];
        int index = 0;

        for (Integer integer : list)
            res[index++] = integer;

        return res;
    }
}
