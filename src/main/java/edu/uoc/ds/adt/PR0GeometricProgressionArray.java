package edu.uoc.ds.adt;

public class PR0GeometricProgressionArray {

    public int[] array;

    public PR0GeometricProgressionArray(int a1, int r, int size) {
        newArray(a1, r, size);
    }

    private int[] newArray(int a1, int r, int size) {
        array = new int[size];
        for (int i = 1; i <= size; i++) {
            array[i-1] = (int) (a1 * Math.pow(r, (i - 1)));
        }
        return array.clone();
    }

    public int getIndexOf(int searching) {
        int i = 0;
        while (i < this.getArray().length) {
            if (this.getArray()[i] == searching) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // Check
    public int[] getArray() {
        //int[] res = new int[20];
        return this.array;
    }

    /***********************************************************************
     * Los métodos siguientes están basados en el código publicado en:
     * "Binary Search in Java", java T point, consultado en octubre de 2023
     * https://www.javatpoint.com/binary-search-in-java
     ***********************************************************************/

    // Standard implementation
    public int binarySearch(int srch) {
        int[] arr = this.getArray();
        int first = 0;
        int last = arr.length;
        int mid = (first + last) / 2;

        while (first <= last) {
            if (arr[mid] < srch) {
                first = mid + 1;
            } else if (arr[mid] == srch) {
                return mid;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        return -1;
    }

    // Recursive implementation.
    public int binarySearch2(int srch) {
        return binarySearchRecursive(this.getArray(),0, this.getArray().length, srch);
    }

    private int binarySearchRecursive(int[] arr, int first, int last, int srch) {
        if (last >= first) {
            int mid = first + (last - first)/2;
            if (arr[mid] == srch) {
                return mid;
            }
            if (arr[mid] > srch) {
                return binarySearchRecursive(arr, first, mid-1, srch);
            } else {
                return binarySearchRecursive(arr, mid+1, last, srch);
            }
        }
        return -1;
    }
}