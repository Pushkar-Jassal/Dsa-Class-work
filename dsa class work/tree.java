import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    
    Node(int val){
        data=val;
        left=right=null;
    }
}
class trees
{
    /*----------------Height--------------------------*/
    public static int height(Node root){
        if(root==null) return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    
    /*----------------Count of Nodes(recursive)-------------------*/
    public static int numberOfNodes(Node root){
        if(root==null) return 0;
        return 1+numberOfNodes(root.left)+numberOfNodes(root.right);
    }
    
    /*---------------Check value-------------------------------*/
    public static boolean checkValue(Node root,int target){
        if(root==null) return false;
        if(root.data==target) return true;
        return checkValue(root.left,target) || checkValue(root.right,target);
    }
    
    /*----------Count leaf nodes-------------------------*/
    public static int countLeafNode(Node root){
        if(root==null) return 0;
        if(root!=null && root.left==null && root.right==null) return 1;
        return countLeafNode(root.left)+countLeafNode(root.right);
    }
    
    
    public static void NodesAtLevel(Node root, int level){
        if(root==null) return;
        if(level==1){
            System.out.println(root.data+" ");
        }else{
         NodesAtLevel(root.left, level-1);
         NodesAtLevel(root.right, level-1);
        }
    
    }
    
    public static int sumOfNodes(Node root){
        if(root==null) return 0;
        return root.data+sumOfNodes(root.left)+sumOfNodes(root.right);
        
    }
    
	public static void main(String[] args) {
		Node root=new Node(10);
		root.left=new Node(20);
		root.right=new Node(30);
		root.left.left=new Node(40);
		root.left.right=new Node(50);
	    System.out.println("Height of the tree is:"+height(root));
	    System.out.println("Number of nodes are: "+numberOfNodes(root));
	    System.out.println("Is the number present in tree or not?? "+checkValue(root,11));
	    System.out.println("The leaf nodes: "+countLeafNode(root));
	    System.out.println("Node at level 2 are :");
	    NodesAtLevel(root, 2);
	    System.out.println("Sum of Nodes is: "+sumOfNodes(root));
	}
}