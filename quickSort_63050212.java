import java.util.Scanner;
public class quickSort_63050212 
{
    static Scanner input = new Scanner(System.in);
    static void quickSort(int keys[], int begin, int end) {
        int p = partition(keys, begin, end);
        if(p-1 > begin) {
            quickSort(keys, begin,p-1);
        }
        if(p+1 < end) {
            quickSort(keys,p+1,end);
        }
    }

    static int partition(int keys[], int begin, int end) {
        int pivot = keys[end],i,temp;
        for(i = begin ; i < end ; i++)
            if(keys[i] < pivot){
                temp = keys[begin];
                keys[begin] = keys[i];
                begin+=1;
                keys[i] = temp; 
            }
        temp = keys[begin];
        keys[begin] = pivot;
        keys[end] = temp;
        return begin;
    }

    static void sort(int keys[]) {
        quickSort(keys, 0, keys.length-1);
    }
    static void printToString(int key[]){
        for(int i=0 ; i < key.length ;i++){
            System.out.printf("%d ", key[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //int array [] = {5,7,9,10,23,23,45,56,1};
        System.out.print("DATA SIZE >> "); int n = input.nextInt();
        int array [] = new int[n];
        for(int i=0 ; i < n ;i++){
            array[i] = input.nextInt();
        }
        System.out.print("BEFORE SORTING > ");
        printToString(array);
        sort(array);
        System.out.print("AFTER  SORTING > ");
        printToString(array);
    }
}
