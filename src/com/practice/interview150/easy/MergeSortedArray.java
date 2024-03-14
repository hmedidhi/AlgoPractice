package com.practice.interview150.easy;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int k = 0; k < m; k++) {
            temp[k] = nums1[k];
        }
        int i = 0, j = 0, r = 0;
        while (i < m && j < n) {
            if (temp[i] > nums2[j]) {
                nums1[r] = nums2[j];
                j++;
            } else {
                nums1[r] = temp[i];
                i++;
            }
            r++;
        }
        while (i < m) {
            nums1[r] = temp[i];
            i++;
            r++;
        }
        while (j < m) {
            nums1[r] = nums2[j];
            j++;
            m++;
        }
    }
}
