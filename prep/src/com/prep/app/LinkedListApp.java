package com.prep.app;

import com.prep.ds.LinkedList;

public class LinkedListApp {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> mylist = new LinkedList<>();
		mylist.enqueue(1);
		mylist.enqueue(2);
		mylist.enqueue(3);
		mylist.dequeue();
		mylist.enqueue(4);
		mylist.dequeue();
		
		for(Integer i : mylist)
		{
			System.out.print(i + "-->");
		}
		System.out.println();
		System.out.println("-------------------");
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		stack.push(4);
		stack.pop();
		
		for(Integer i : stack)
		{
			System.out.print(i + "-->");
		}
		System.out.println();
		System.out.println("-------------------");
		
		stack.pop();
		stack.pop();
		
		for(Integer i : stack)
		{
			System.out.print(i + "-->");
		}
		System.out.println();
		System.out.println("-------------------");
		
		
		mylist.push(5);
		mylist.push(6);
		mylist.enqueue(7);
		mylist.enqueue(8);
		mylist.pop();
		
		for(Integer i : mylist)
		{
			System.out.print(i + "-->");
		}
		System.out.println();
		System.out.println("-------------------");
		
		
		
		mylist.pop();
		mylist.dequeue();
		mylist.pop();
		mylist.pop();
		mylist.dequeue();
		
		for(Integer i : mylist)
		{
			System.out.print(i + "-->");
		}
		System.out.println();
		System.out.println("-------------------");
		
		mylist.enqueue(10);
		mylist.enqueue(20);
		mylist.push(30);
		
		for(Integer i : mylist)
		{
			System.out.print(i + "-->");
		}
		System.out.println();
		System.out.println("-------------------");
		
	}

}
