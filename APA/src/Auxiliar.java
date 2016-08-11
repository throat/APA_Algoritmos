/*
 * Só usarei esta classe para encontrar a moda e a mediana
 */


import java.util.Arrays;

/**
 * @author Emerson
 */
public class Auxiliar {
    
    public static int median(int a[], int left, int right){
        int fiveNumbers[] = new int[5];
        int candidatesForMedian[] = new int[5];
        int median, indexOfMedian = left;
        //Generates 5 random numbers between left and right
        for(int i = 0; i < 5; i++)
            fiveNumbers[i] = left + (int)(Math.random()*(right - left));
        //Checks their content
        for(int i = 0; i < 5; i++)
            candidatesForMedian[i] = a[fiveNumbers[i]];
        Arrays.sort(candidatesForMedian);
        median = candidatesForMedian[2];
        for(int i = left; i < right; i++){
            if(median == a[i])
                indexOfMedian = i;
                }
        
        return indexOfMedian;
    }
    
    public static int average(int a[], int left, int right){
        int totalSum = 0, average;
        for(int i = left; i < right; i++)
            totalSum = totalSum + a[i];
        average = (totalSum)/(right - left);
        return average;
    
    }
    
    public static int mode(int a[], int left, int right) {
    int maxValue = 0, maxCount = 0;

    for (int i = left; i < right; ++i) {
        int count = 0;
        for (int j = left; j < right; ++j) {
            if (a[j] == a[i]) ++count;
        }
        if (count > maxCount) {
            maxCount = count;
            maxValue = a[i];
        }
    }

    return maxValue;
}
    
}
