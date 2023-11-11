import java.util.Arrays;

class ADAKnapsack_63050212{
    public static void main(String[] args) {
        int value[]  = {26,31,51,21,20};
        int weight[] = {8, 13, 12, 15, 20};
        int W = 45; //capacity in knapsack
        int n = value.length;
        System.out.println(Arrays.toString(value));
        System.out.println(Arrays.toString(weight));
        System.out.print("Total Value >> ");
        System.out.println(Knapsack.knapSack(W, weight, value, n));
        //Knapsack.display(weight,value, n);

    }
}
class Knapsack{
    static int knapSack(int w,int weight[],int value[],int n){
        int total_weight = 0;
        if(n==0||w==0) return 0;
        if (weight[n-1] > w ){
            return knapSack(w, weight, value, n - 1);
        }
        total_weight = Math.max(value[n - 1] + knapSack(w-weight[n - 1], weight,value, n - 1),knapSack(w, weight, value, n - 1));
        
       return total_weight;
    }
    static void display(int weight[],int value[],int size){ //6
        int v[] = new int[size-2];
        int w[] = new int[size-2];
        weight[3] = weight[5];
        value[3]  = value[5];

        for(int i =0 ; i<size-2;i++){
            v[i] = value[i];
            w[i] = weight[i];
        }
        System.out.println(Arrays.toString(v));
        System.out.println(Arrays.toString(w));
    }
}
