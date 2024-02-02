package com.prep.app;

import com.prep.algos.BST;

public class BSTTestApp {
	
	public static void main(String[] args) {
		BST<Integer> tree = new BST<>();
		tree.add(7);
		tree.add(5);
		tree.add(10);
		tree.add(1);
		tree.inorderTraversal((item)->System.out.println(item));
		System.out.println(tree.isPresent(12));
		System.out.println(tree.isPresent(1));
	}

}
