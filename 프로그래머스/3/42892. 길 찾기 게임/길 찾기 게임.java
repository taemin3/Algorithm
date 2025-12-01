import java.util.*;
class Solution {
    
        
    static class Node {
        int x,y, idx;
        Node left, right;
        Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    
    List<Node> list;
        
    public int[][] solution(int[][] nodeinfo) {
        
        list = new ArrayList<>();
        
        for (int i = 0; i < nodeinfo.length;i++) {
            list.add(new Node(nodeinfo[i][0],nodeinfo[i][1], i + 1));
        }
        
        Collections.sort(list,(a,b) -> {
            if (a.y == b.y) {
                return a.x - b.x;
            }
            return b.y - a.y;
        });
        
        Node root = list.get(0);
        
        for (int i = 1; i < list.size() ; i++) {
            insert(root, list.get(i));
        }
        
        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        
        pre(root, preList);
        post(root,postList);
        
        int[][] answer = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }

        
        return answer;
    }
    
    public void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
    
    public void pre(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.idx);
        pre(node.left, result);
        pre(node.right, result);
    }
    
    public void post(Node node, List<Integer> result) {
        if (node == null) return;
        
        post(node.left, result);
        post(node.right, result);
        result.add(node.idx);
    }
    
    
}