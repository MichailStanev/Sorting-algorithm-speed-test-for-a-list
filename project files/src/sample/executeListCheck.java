package sample;

import java.util.ArrayList;
import java.util.List;

public class executeListCheck {


    //====================================================================================
    // Sorts for Numbers
    //====================================================================================

    //Bubble Sort
    public static void doBubbleSort(int[] intArray) {
        int n = intArray.length;
        int temp = 0;

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){

                if(intArray[j-1] > intArray[j]){
                    temp = intArray[j-1];
                    intArray[j-1] = intArray[j];
                    intArray[j] = temp;
                }

            }
        }

    }


    //Bucket Sort
    public static void doBucketSort(int array[]) {
        int bucketSize = 2;
        if (array.length == 0) {
            return;
        }

        Integer minValue = array[0];
        Integer maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < array.length; i++) {
            buckets.get((array[i] - minValue) / bucketSize).add(array[i]);
        }

        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Integer[] bucketArray = new Integer[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            sort(bucketArray);
            for (int j = 0; j < bucketArray.length; j++) {
                array[currentIndex++] = bucketArray[j];
            }
        }

    }
    public static void sort(Integer array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }


    //Heap Sort
    public static void doHeapSort(int array[], int low, int high){
        int mid;
        if(low < high)
        {
            mid = (low + high) / 2;
            doHeapSort(array, low, mid);
            doHeapSort(array, mid + 1, high);
            Sort(array, low, mid, high);
        }
    }
    public static void Sort(int list[],int low,int mid,int high)
    {
        int i, mi, k, lo ;
        int[] tempArr = new int[list.length];

        lo = low;
        i = low;
        mi = mid + 1;
        while ((lo <= mid) && (mi <= high))
        {
            if (list[lo] <= list[mi])
            {
                tempArr[i] = list[lo];
                lo++;
            }
            else
            {
                tempArr[i] = list[mi];
                mi++;
            }
            i++;
        }
        if (lo > mid)
        {
            for (k = mi; k <= high; k++)
            {
                tempArr[i] = list[k];
                i++;
            }
        }
        else
        {
            for (k = lo; k <= mid; k++)
            {
                tempArr[i] = list[k];
                i++;
            }
        }

        for (k = low; k <= high; k++)
        {
            list[k] = tempArr[k];
        }
    }

    //Insertion Sort
    public static void doInsertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }


    //Merge Sort
    private int[] array;
    private int[] tempMergArray;
    private int length;

    public static void doMergeSort(int[] array){
        executeListCheck mms = new executeListCheck();
        mms.doMerge(array);
    }
    public void doMerge(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArray = new int[length];
        sortMerge(0, length - 1);

        return;
    }
    private void sortMerge(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            sortMerge(lowerIndex, middle);
            sortMerge(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArray[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArray[i] <= tempMergArray[j]) {
                array[k] = tempMergArray[i];
                i++;
            } else {
                array[k] = tempMergArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArray[i];
            k++;
            i++;
        }

    }


    //Selection Sort
    public static int[] doSelectionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }


    //Shell Sort
    public static int[] doShellSort(int arr[])
    {
        int i, j, k, tmp;
        int num = arr.length;
        for (i = num / 2; i > 0; i = i / 2)
        {
            for (j = i; j < num; j++)
            {
                for(k = j - i; k >= 0; k = k - i)
                {
                    if (arr[k+i] >= arr[k])
                        break;
                    else
                    {
                        tmp = arr[k];
                        arr[k] = arr[k+i];
                        arr[k+i] = tmp;
                    }
                }
            }
        }

        return  arr;
    }

    //Quick Sort
    /*
    public static void doQuickSort(int[] array){
        executeListCheck  mms = new executeListCheck();
        mms.sortQuick(array);
    }

    public void sortQuick(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    */

    static int partition(int arr[], int left, int right){
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }



    public static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }


    //====================================================================================
    // Sorts for Text
    //====================================================================================

    //Bubble Sort (Text)
    public static void doBubbleSortText(String[] stringArray) {
        String temp;

        for(int i=0; i < stringArray.length; i++){
            for(int j=1; j < (stringArray.length-i); j++){

                if(stringArray[j-1].compareTo(stringArray[j]) > 0){
                    temp = stringArray[j-1];
                    stringArray[j-1] = stringArray[j];
                    stringArray[j] = temp;
                }

            }
        }
    }


    //Insertion Sort (Text)
    public static void doInsertionSortText(String array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            String key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i].compareTo(key) > 0 ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }

    //MSD String Sort
    static int R = 2<<8;
    public static void doMSDStringSort(String[] s){
        String[] aux = new String[s.length];
        int lo = 0, hi = s.length-1, at = 0;
        sort(s, aux, lo, hi, at);
    }
    private static int charAt(String s, int i){
        if(i<s.length())return s.charAt(i);
        else return -1;
    }
    private static void sort(String[] s, String[] aux, int lo, int hi, int at){

        if(hi<=lo)return;

        int[] count = new int[R+2];

        for(int i = lo; i <= hi; ++i)    count[charAt(s[i], at)+2]++;

        for(int i = 0; i < R+1; ++i)     count[i+1] += count[i];

        for(int i = lo; i <= hi; ++i)    aux[count[charAt(s[i], at)+1]++] = s[i];

        for(int i = lo; i <= hi; ++i)    s[i] = aux[i-lo];

        for(int r=0;r<R;++r) sort(s, aux, lo+count[r], lo+count[r+1]-1, at+1);
    }


    //Three Way String QuickSort
    public static void doThreeWSQS(String[] s){
        sort(s, 0, s.length-1, 0);
    }
    public static int charAtWSQS(String s, int i){
        if(i<s.length()-1)return s.charAt(i); else return -1;
    }
    private static void exch(String[] s, int a, int b){
        String ss = s[a];
        s[a] = s[b];
        s[b] = ss;
    }
    private static void sort(String[] s, int lo, int hi, int d){
        if(hi<=lo)return;

        int lt = lo, gt = hi;
        int i = lo+1;
        int c = charAtWSQS(s[lo], d);

        while(i<=gt){
            int cc = charAtWSQS(s[i], d);
            if(cc<c)exch(s, lt++, i++);
            else if(cc>c)exch(s, i, gt--);
            else i++;
        }

        sort(s, lo, lt-1, d);
        if(c>=0)sort(s, lt, gt, d+1);
        sort(s, gt+1, hi, d);
    }



}
