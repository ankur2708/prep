package com.prep.app;

import com.prep.algos.TernaryTrieTree;

public class TernaryTrieTreeTestApp {
	
	
	public static void main(String[] args) {
		
		TernaryTrieTree<Integer> trie = new TernaryTrieTree<Integer>();
		
		trie.put("sea", 10);
		trie.put("sell", 5);
		trie.put("so", 25);
		trie.put("seems", 15);
		trie.put("saw", 20);
		
		System.out.println(trie.get("so"));
		
		System.out.println(trie.inorderTraverse());
		
		System.out.println(trie.wordWithPrefix("se"));
		
		
	}

}
