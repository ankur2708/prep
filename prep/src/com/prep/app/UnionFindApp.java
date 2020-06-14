package com.prep.app;

import com.prep.algos.UnionFind;

public class UnionFindApp {

	public static void main(String[] args) {
		
		UnionFind uf = new UnionFind(10);
		
		uf.union(0, 1);
		uf.union(1, 2);
		uf.union(2, 3);
		uf.union(1, 4);
		uf.union(7, 9);
		
		System.out.println(uf.connected(4, 1));
		System.out.println(uf.connected(7, 2));
		
		
	}
}
