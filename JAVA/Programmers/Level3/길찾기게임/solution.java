import java.util.*;
import java.io.*;

class Solution {
    ArrayList<Integer> post;
    ArrayList<Integer> pre;
    
    public int[][] solution(int[][] nodeinfo) {
        
        pre = new ArrayList<>();
        post = new ArrayList<>();
        
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0 ; i < nodeinfo.length ; i++){
            list.add(new Node(nodeinfo[i][1], nodeinfo[i][0], i+1));
        }
        
        Collections.sort(list, new Comparator<Node>(){
           @Override
            public int compare(Node n1, Node n2){
                if(n1.y  == n2.y){
                    return n1.x - n2.x;
                } else{
                    return n2.y - n1.y;
                }
            }
        });
        
        Node root = list.get(0);
        for(int i = 1 ; i < list.size() ; i++){
            createTree(root, list.get(i));
        }
        // System.out.println(root.left.left.num);
        
        preOrder(root);
        postOrder(root);
        
        
        
        
        
        int[][] answer = new int[2][nodeinfo.length];
        for(int j = 0 ; j < nodeinfo.length ; j++){
            answer[0][j] = pre.get(j);
            answer[1][j] = post.get(j);
        }
        return answer;
    }
    
    public void createTree(Node root, Node node){
        if(root.x > node.x){
            if(root.left == null){
                root.left = node;
            } else{
                createTree(root.left, node);
            }
        } else if(root.x < node.x){
            if(root.right == null){
                root.right = node;
            } else{
                createTree(root.right, node);
            }
        }
    }
    
    public void preOrder(Node root){
        pre.add(root.num);
        if(root.left != null){
            preOrder(root.left);
        }
        if(root.right != null){
            preOrder(root.right);
        }
        
        
    }
    
    public void postOrder(Node root){
        if(root.left != null){
            postOrder(root.left);
        }
        if(root.right != null){
            postOrder(root.right);
        }
        post.add(root.num);
    }
    
    
    static class Node{
        int x;
        int y;
        int num;
        Node left;
        Node right;
        
        public Node(int y, int x, int n){
            this.y = y;
            this.x = x;
            num = n;
        }
        
    }
}
