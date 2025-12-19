import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    
   

    public static class Node {
        int val;
        Node left, right;
        public Node(int val) {
            this.val = val;
        }

        void insert(int v) {
            if (v > this.val) {
                if (this.right == null) {
                    this.right = new Node(v);    
                } else {
                    this.right.insert(v);
                }
             } else {
                if (this.left == null) {
                    this.left = new Node(v);    
                } else {
                    this.left.insert(v);
                }
             }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while(true) {
            String str = br.readLine();
            if (str == null || str.equals("")) break;
            int n = Integer.parseInt(str);
            root.insert(n);
        }
        postOrder(root);
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

   
}