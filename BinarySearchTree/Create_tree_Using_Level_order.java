package BinarySearchTree;
import java.util.*;

public class Create_tree_Using_Level_order {

class Node{
	int val;
	Node right;
	Node left;
}
	private Node root;
	public void Create_Tree_Using_Level_Order() {
		createTree();
		
	}
	private void createTree() {
		Scanner sc = new Scanner(System.in);
		Queue<Node> q = new LinkedList<>();
		Node nn = new Node();
		nn.val = sc.nextInt();
		root = nn;
		q.add(nn);
		while(!q.isEmpty()) {
			Node r = q.poll();
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			if(c1 != -1) {
				Node node = new Node();
				node.val = c1;
				r.left = node;
				q.add(node);
			}
			if(c2 != -1) {
				Node node = new Node();
				node.val = c2;
				r.right = node;
				q.add(node);
			}
			
		}sc.close();
		
	}

}
