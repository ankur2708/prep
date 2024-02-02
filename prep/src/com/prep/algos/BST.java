package com.prep.algos;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BST<Item extends Comparable<Item>> {
	
	private class Node {
		private Item item;
		private Node left;
		private Node right;
		
		public Node(Item item, Node left, Node right) {
			this.item = item;
			this.left = left;
			this.right = right;
		}
	}
	
	private Node root;
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void add(Item item) {
		this.root = add(this.root, item);
		
	}
	
	private Node add(Node root, Item item) {
		if (root == null) {
			root = new Node(item, null, null);;
		}
		else if(item.compareTo(root.item) > 0) {
			root.right = add(root.right, item);
		}
		else {
			root.left = add(root.left, item);
		}
		return root;
	}
	
	public boolean isPresent(Item item) {
		Predicate<Item> isPresentPred = (tItem) -> tItem.compareTo(item) == 0;
		AtomicBoolean isItemPresent = new AtomicBoolean(Boolean.FALSE);
		inorderTraversal((treeItem) -> {
			if (isPresentPred.test(treeItem)) {
				isItemPresent.set(Boolean.TRUE);
			}
			});
		return isItemPresent.get();
	}
	
	public void inorderTraversal(Consumer<Item> consumer) {
		inorder(this.root, consumer);
	}
	
	private void inorder(Node root, Consumer<Item> consumer) {
		if(root != null) {
			if(root.left != null) {
				inorder(root.left, consumer);
			}
			consumer.accept(root.item);
			if(root.right != null) {
				inorder(root.right, consumer);
			}
		}
	}

}
