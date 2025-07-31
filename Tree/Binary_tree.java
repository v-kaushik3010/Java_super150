package Tree;
import java.util.*;

public class Binary_tree {
	
	class 	Node{
		int val;
		Node left;
		Node right;
	}
	private Node root;
	Scanner sc = new Scanner(System.in);

	public Binary_tree() {
		root = CreateTree();
	}
	private Node CreateTree() {
		int item = sc.nextInt();
		
		Node nn = new Node();
		nn.val = item;
		
		boolean hlc = sc.nextBoolean();                          //has left Child
		if(hlc) {
			nn.left = CreateTree();
		}
		
		boolean hrc = sc.nextBoolean();                          //has right Child
		if(hrc) {
			nn.right = CreateTree();
		}
		return nn;
		
	}
	
	private void Display(Node nn) {
		if(nn == null) {
			return;
		}
		String str = "<--"+nn.val+"-->";
		if (nn.left != null) {
			str = nn.left.val + str;
		}else {
			str = "."+ str;
		}
		if (nn.right != null) {
			str = nn.right.val + str;
		}else {
			str = "."+ str;
		}
		
		
		
		
		
	}

}
