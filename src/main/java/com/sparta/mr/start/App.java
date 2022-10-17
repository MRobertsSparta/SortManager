package com.sparta.mr.start;

import com.sparta.mr.sorters.MergeSort;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MergeSort ms = new MergeSort();
        int[] ints = {34,7,11,65,9,2,45, 100, 34, 34, 5, 23,7, 43};
        System.out.println(Arrays.toString(ms.sort(ints)));
    }
}
