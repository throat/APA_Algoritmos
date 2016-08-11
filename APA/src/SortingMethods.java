import java.util.ArrayList;

 
public class SortingMethods {
    
	/** INSERTION SORT **/
	
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> inputList){
    	ArrayList<Integer> ints = new ArrayList<Integer>(inputList);
        int i, j, contadorMov = 0, qtdints = ints.size();
        int num;
        for(i = 1; i < qtdints; i++){
            num = ints.get(i);
            j = i - 1;
            while((j >= 0) && (num < ints.get(j))){
                ints.set(j + 1, ints.get(j));
                j--;
                contadorMov++;
            }
            ints.set(j + 1, num);
            contadorMov++;
        }
        return ints;

    }
    
    /** SELECTION SORT **/
    
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> inputList){
    	ArrayList<Integer> ints = new ArrayList<Integer>(inputList);
        
    	int i, j, qtdints = ints.size(), menor, contadorMov = 0;
        int intEscolhido;
        for(i = 0; i < (qtdints - 1); i++){
            menor = i;
            for(j = (i + 1); j < qtdints; j++){ // Encontra o índice do menor
                if(ints.get(j) < ints.get(menor))
                    menor = j;
            }
            if(i != menor){ // Faz a movimentação do menor encontrado
                intEscolhido = ints.get(i);
                ints.set(i, ints.get(menor));
                ints.set(menor, intEscolhido);
                contadorMov++;
            }
        }
        return ints;
    }
    
    /** MERGE SORT **/
    
    
}
