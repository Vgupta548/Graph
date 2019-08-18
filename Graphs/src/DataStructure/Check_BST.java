package DataStructure;

import java.util.HashMap;
import java.util.Scanner;

public class Check_BST {

	/*
	 * 
	 * 2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R
	 *
	 * void printInorder(Node node) { if (node == null) return; /* first recur on
	 * left child
	 * 
	 */
	// printInorder(node.left);
	/* then print the data of node */
	// System.out.print(node.data + " ");
	/* now recur on right child */
	// printInorder(node.right);
	// }*/
	// driver function to test the above functions
	public static void main(String args[]) {
		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Check_BST ob = new Check_BST();
		while (t > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = sc.nextInt();

			Node root = null;
			while (n > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				// cout << n1 << " " << n2 << " " << (char)lr << endl;
				Node parent = m.get(n1);
				if (parent == null) {
					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}
				Node child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
				n--;
			}

			GfG g = new GfG();
			System.out.println(g.isBST(root));
			// ob.printInorder(root);
			t--;

		}
	}
}

class GfG {
	int isBST(Node root) {
		// Your code here
		if (root == null)
			return 1;
		System.out.print(" start : " + Integer.MIN_VALUE + " : " + Integer.MAX_VALUE);
		if (checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			return 1;
		else
			return 0;

	}

	boolean checkBST(Node node, int min, int max) {
		System.out.println(" Node : " + node.data + " left : "+ node.left.data+ " right : "+node.right.data);
		if (node.left != null) {
			System.out.println("check left");
			if (!leftBST(node, min) || !checkBST(node.left, min, node.data))
				return false;
		}

		if (node.right != null) {
			System.out.println("check right");
			if (!leftBST(node, max) || !checkBST(node.right, node.data, max))
				return false;
		}
		return true;
	}

	boolean leftBST(Node node, int min) {
		int max = node.data;
		return node.left.data <= node.data && node.left.data >= min;
	}

	boolean rightBST(Node node, int max) {
		int min = node.data;
		return node.right.data <= max && node.right.data >= min;
	}
}

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}