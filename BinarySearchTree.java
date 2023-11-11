
import java.util.Scanner;
class Lab9 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int num[] = { 1, 1, 2, 3, 5, 8, 13, 21, 34 };
       
        BinarySearchTree bst = new BinarySearchTree();
            System.out.println("-----------------------------");
            for (int i = 0; i < num.length; i++) {
                bst.insert(num[i]);
            }
             
        System.out.println("value >> ");
        int n = scan.nextInt();
            System.out.println("My position number is >> ");
            bst.search(n);
    }
}
class BinarySearchTree{
    public class TreeNode{
        int data;
        TreeNode left=null, right=null,parent=null;
        public TreeNode(int d){
            data = d;
        }
    }

    TreeNode root = null;
    
    TreeNode search(int data) {
        TreeNode current = root;
        while (current != null) {
            if (current.data == data) {
                break;
            }
            current = current.data < data ? current.right : current.left;

        }
        return current;
    }
    void insert(int d){
        if (root == null) {
            root = new TreeNode(d);
        }else{
            TreeNode p = root;
                while (p != null) {
                    if (d < p.data) {
                        if (p.left != null){
                             p = p.left;
                        }
                        else{
                            p.left = new TreeNode(d);
                            p.left.parent = p;
                            return;
                        }
                    }
                    else {
                        if (p.right != null){
                            p = p.right;
                        }
                        else {
                            p.right = new TreeNode(d);
                            p.right.parent = p;
                            //printInOrder(p.parent);
                        return;
                        }
                    }
                }
        }
    }
    void printInOrder(TreeNode node){
        if(node==null) return;
        //System.out.print("Node Data InOrder = ");
        printInOrder(node.left);
        System.out.println(node.data+" ");
        printInOrder(node.right);
    }
}
