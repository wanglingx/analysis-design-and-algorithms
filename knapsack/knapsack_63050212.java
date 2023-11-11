package knapsack;
import java.util.Scanner;

class knapsack_63050212 {
    static Scanner input = new Scanner(System.in);
    static int n = 0;

    public static void main(String[] args) {
        System.out.print("Enter your data size > ");
        n = input.nextInt();
        double value[] = new double[n];// { 26, 31, 51, 21, 20 };
        double weight[] = new double[n];// { 8, 13, 12, 15, 20 };
        System.out.print("Enter your capacity of bag > ");
        double capacity = input.nextInt(); // capacity in knapsack
        for (int i = 0; i < n; i++) {
            System.out.print("add value  > ");
            value[i] = input.nextDouble();
            System.out.print("add weight > ");
            weight[i] = input.nextDouble();
            System.out.println("********************************************");
        }
        Knapsack nap = new Knapsack();
        System.out.print("value/weight >> ");
        double ans = nap.knapsack(capacity, weight, value, n);
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("total value in capacity %d is > %.2f", (int) capacity, ans);
    }
}

class Knapsack {
    public double knapsack(double w, double weight[], double value[], int size) {
        double vw[] = new double[size];
        double temp1[] = new double[size];
        double pick[] = new double[size];
        double answer = 0;
        for (int i = 0; i < size; i++) {
            vw[i] = value[i] / weight[i];
            System.out.printf("%.1f/%.1f = %.2f  ", value[i], weight[i], vw[i]);
        }
        System.out.println();
        sort(vw,value,weight);
        // condition
        try {
            for (int j = 0; j < size; j++) {
                temp1[0] = w;
                if (weight[j] <= temp1[j]) {
                    temp1[j + 1] = temp1[j] - weight[j];
                    pick[j] = 1;
                    answer += value[j] * pick[j];
                }

                if (weight[j] > temp1[j]) {
                    temp1[j + 1] = temp1[j] - weight[j];
                    pick[j] = temp1[j] / weight[j];
                    answer += value[j] * pick[j];
                }
                if (w <= 0)
                    return 0;
            }
        } catch (ArrayIndexOutOfBoundsException err) {
    }
        display(w, weight, value, vw, size);
        return answer;
    }
    static void quickSort(double keys[],double v[],double w[], int begin, int end) {
        int p = partition(keys,v,w, begin, end);
        if(p-1 > begin) {
            quickSort(keys,v,w, begin,p-1);
        }
        if(p+1 < end) {
            quickSort(keys,v,w,p+1,end);
        }
    }
    static int partition(double keys[],double v[],double w[], int begin, int end) {
        double pivot = keys[end],temp;
        double pV = v[end],tempV;
        double pW = w[end],tempW;

        for(int i = begin ; i < end ; i++)
            if(keys[i] > pivot){
                temp = keys[begin];
                keys[begin] = keys[i];
                begin+=1;
                keys[i] = temp; 
            }

        //sort vw
        temp = keys[begin];
        keys[begin] = pivot;
        keys[end] = temp;

        //sort value
        tempV = v[begin];
        v[begin] = pV;
        v[end] = tempV;

        //sort weight
        tempW = w[begin];
        w[begin] = pW;
        w[end] = tempW;

        return begin;
    }

    static void sort(double keys[],double v[],double w[]) {
        quickSort(keys,v,w ,0, keys.length-1);
    }

    public void display(double w, double[] weight, double[] value, double vw[], int size) { // 6

        System.out.print("value  : ");
        for (int i = 0; i < size; i++) {
            System.out.print((int) value[i] + "  ");
        }
        System.out.println();

        System.out.print("weight : ");
        for (int i = 0; i < size; i++) {
            System.out.print((int) weight[i] + "  ");
        }
        System.out.println();

        System.out.print("va/wei : ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%.2f  ",vw[i]);
        }
        System.out.println();

    }
}