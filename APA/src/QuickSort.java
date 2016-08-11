/**
 *
 * @author Emerson
 */
public class QuickSort {
    
    protected static long randomDelay = 0, modeDelay = 0, medianDelay = 0, averageDelay = 0;
    
    
    
    public static void swap(int v[], int i, int j) 
    {
        int t = v[i];
        v[i] = v[j];
        v[j] = t;
    }
    
    public static int partition(int v[], int left, int right,int pivot)
    {
        int i = left + 1, j = right;
        swap(v, left, pivot);
        while(i <= j){
            while(v[i] <= v[left] && i < right)
                i++;
            while(j > left && v[j] > v[left] && j > left)
                j--;
            if(i >= j)
                break;
            else{
                swap(v, i, j);
                i++; 
                j--;
            }
        }
        swap(v, j, left);
        return j;
    }

    public static void quickSort(int v[], int left, int right, String chosenPivot){
        int j, pivot = left, spCasePivot;
                      
        if(left < right){
            
            if("first".equals(chosenPivot)){
                pivot = left;
            }
            if("last".equals(chosenPivot)){
                pivot = right;
            }
            
            if("random".equals(chosenPivot)){
                long generatePivotStarts = System.currentTimeMillis();
                
                spCasePivot = (int)(left + Math.random()*(right - left));
                
                long generatePivotEnds = System.currentTimeMillis();
                long timeToGeneratePivot = generatePivotEnds - generatePivotStarts;
                randomDelay = randomDelay + timeToGeneratePivot;
                pivot = spCasePivot;
                
            }
            
            if("mode".equals(chosenPivot)){
                spCasePivot = 0;
                long searchForModeStarts = System.currentTimeMillis();
                
                int mode = Auxiliar.mode(v, left, right);
                for(int k = left; k < right; k++){
                    if(v[k] == mode)
                        spCasePivot = k;
                        }
                
                long searchForModeEnds = System.currentTimeMillis();
                long timeToFindMode = searchForModeEnds - searchForModeStarts;
                modeDelay = modeDelay + timeToFindMode;
                
                pivot = spCasePivot;            
                
            }
            
            if("average".equals(chosenPivot)){
                spCasePivot = left;
                long searchForAverageStarts = System.currentTimeMillis();
                
                int average = Auxiliar.average(v, left, right);
                for(int k = left; k < right; k++){
                    if(v[k] == average)
                        spCasePivot = k;
                        }
                
                long searchForAverageEnds = System.currentTimeMillis();
                long timeToFindAverage = searchForAverageEnds - searchForAverageStarts;
                averageDelay = averageDelay + timeToFindAverage;
                
                pivot = spCasePivot;            
                //for(int k = 0; k < Main.arraySize; k++)
                    //System.out.print(v[k] + ", ");
                //System.out.println(" | Pivot is: " + pivot + " | Average is: " + average);
                
            }
            
            if("median".equals(chosenPivot)){
                //spCasePivot = left;
                long searchForMedianStarts = System.currentTimeMillis();
                
                spCasePivot = Auxiliar.median(v, left, right);
                
                long searchForMedianEnds = System.currentTimeMillis();
                long timeToFindMedian = searchForMedianEnds - searchForMedianStarts;
                medianDelay = medianDelay + timeToFindMedian;
                
                pivot = spCasePivot;            
                
            }
        
            j = partition(v, left, right, pivot);
            
            if(left < j - 1){
                quickSort(v, left, j - 1, chosenPivot);
            }
            if(j + 1 < right){
                quickSort(v, j + 1, right, chosenPivot);
            }
           
        }
        
    }
    
}
