import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Emerson
 */
public class MergeSort {
    public static int compI = 0, compR = 0;
    
    
    
    public static int[] Iterative(int array[]){
    for (int i = 1; i <= (array.length) + 1; i *= 2)
    {
        for (int j = i; j < array.length; j += 2 * i)
        {
            MergeI(array, j - i, j, Math.min(j + i, array.length));
        }
    }
 
    long now2 = System.currentTimeMillis();
    return array;
    }
    
    private static void MergeR(int array[], int start, int middle, int end){
        int[] merge = new int[end - start];
        int l = 0, r = 0, i = 0;
        while ((l < middle - start) && (r < (end - middle))){
            merge[i] = Integer.compare(array[start + l], array[middle + r]) < 0
                ? array[start + l++]
                : array[middle + r++];
            i++;
        }
 
        while (r < end - middle) {
            merge[i++] = array[middle + r++];
            compR++;}
 
        while(l < (middle - start)) {
            merge[i++] = array[start + l++];
            compR++;}
        System.arraycopy(merge, 0, array, start, merge.length);
    }
    
    private static void MergeI(int array[], int start, int middle, int end){
        int[] merge = new int[end - start];
        int l = 0, r = 0, i = 0;
        while ((l < middle - start) && (r < (end - middle))){
            merge[i] = Integer.compare(array[start + l], array[middle + r]) < 0
                ? array[start + l++]
                : array[middle + r++];
            i++;
        }
 
        while (r < end - middle) {
            merge[i++] = array[middle + r++];
            compI++;}
 
        while(l < (middle - start)) {
            merge[i++] = array[start + l++];
            compI++;}
        System.arraycopy(merge, 0, array, start, merge.length);
    }
    
 
 public static void Recursive(int array[], int start, int end)
 {
     if (end - start <= 1) return;
     int middle = start + ((end - start) / 2);
 
     Recursive(array, start, middle);
     Recursive(array, middle, end);
     MergeR(array, start, middle, end);
 }
    
}
