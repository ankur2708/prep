package com.prep.ds;

import java.util.LinkedList;
import java.util.List;

public class TernaryTrieTree<Value> {
	
	public static class Node<Value>
	{
		private char Key;
		private Value val;
		
		private Node<Value> left;
		private Node<Value> right;
		private Node<Value> middle;
		
		public String toString()
		{
			return "Key:" + String.valueOf(Key) + " val:" + String.valueOf(val) + " left:" + String.valueOf(left != null ? left.Key : null) + 
					" right:" + String.valueOf(right != null ? right.Key : null) + " middle:" + String.valueOf(middle != null ? middle.Key : null);
		}
		
	}
	
	private Node<Value> root;
	
	public void put(String key, Value val)
	{
		root = put(root, key, val, 0);
	}
	
	private Node<Value> put(Node<Value> node, String key, Value val, int charAt)
	{
		char c = key.charAt(charAt);
		if(node == null)
		{
			node = new Node<>();
			node.Key = c;
		}
		if(c > node.Key)
		{
			node.right = put(node.right, key, val, charAt);
		}
		else if(c < node.Key)
		{
			node.left = put(node.left, key, val, charAt);
		}
		else if(charAt == key.length()-1)
		{
			node.val = val;
		}
		else
		{
			node.middle = put(node.middle, key, val, charAt + 1);
		}
		return node;
		
	}
	
	public Value get(String key)
	{
		Node node = get(root, key, 0);
		return node == null ? null : (Value)node.val;
	}
	
	private Node get(Node<Value> node, String key, int charAt)
	{
		if(node == null)
		{
			return null;
		}
		if(key.charAt(charAt) > node.Key)
		{
			return get(node.right, key, charAt);
			
		}
		else if(key.charAt(charAt) < node.Key)
		{
			return get(node.left, key, charAt);
		}
		else if(charAt == key.length() - 1)
		{
			return node;
		}
		else
		{
			return get(node.middle, key, charAt + 1);
		}
	}
	
	public List<String> inorderTraverse()
	{
		List<String> inorderKey = new LinkedList<String>();
		inorderTraverse(root, "", inorderKey);
		return inorderKey;
	}
	
	public List<String> wordWithPrefix(String prefix)
	{
		List<String> inorderKey = new LinkedList<String>();
		inorderTraverse(get(root, prefix, 0).middle, prefix, inorderKey);
		return inorderKey;
	}
	
	private void inorderTraverse(Node node, String prefix, List<String> inorder)
	{
		if(node == null)
		{
			return;
		}
		inorderTraverse(node.left, prefix, inorder);
		
		if(node.val != null)
		{
			inorder.add(prefix + node.Key);
		}
		inorderTraverse(node.middle, prefix + node.Key, inorder);
		inorderTraverse(node.right, prefix, inorder);
	}
	
	

}
