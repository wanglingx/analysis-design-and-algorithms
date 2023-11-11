import java.util.Scanner;
class BST_63050212 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[]) {
        int data[] = { 1, 1, 2, 3, 5, 8, 13, 21, 34 };
        System.out.print("value >> ");
        int key = scan.nextInt();

        int first = 0;
        int last = data.length - 1;

        int mid = (first + last) / 2;
        while (first <= last) {

            if (data[mid] < key) {
                mid++;
                first = mid;
            } 
            else if (data[mid] == key) {
                System.out.println("Find value in index >> " + mid);
                return;
            } 
            else {
                mid--;
                last = mid;
            }
            mid = (first + last) / 2;
        }
       
        System.out.print("DATA >> ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------");
        if (first > last) {
            System.out.println("Not found "+key+" in this data");
        }
    }
}
