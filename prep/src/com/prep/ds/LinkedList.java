package com.prep.ds;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item>{
	
	private Node head;
	
	private Node tail;
	
	private class Node
	{
		private Item item;
		private Node next;
	}
	
	public void enqueue(Item item)
	{
		Node newTail = new Node();
		newTail.item = item;
		if(tail != null)
		{
			tail.next = newTail;
		}
		else
		{
			head = newTail;
		}
		tail = newTail;
	}
	
	public Item dequeue()
	{
		if(head == null)
		{
			throw new NoSuchElementException("empty list!!");
		}
		Item i = head.item;
		head = head.next;
		if(head == null)
		{
			tail = null;
		}
		return i;
	}
	
	public void push(Item item)
	{
		Node oldHead = head;
		Node newHead = new Node();
		newHead.item = item;
		newHead.next = oldHead;
		head = newHead;
		if(tail == null)
		{
			tail = head;
		}
	}
	
	public Item pop()
	{
		if(head == null)
		{
			throw new NoSuchElementException("Empty stack!!");
		}
		
		Item i = head.item;
		head = head.next;
		if(head == null)
		{
			tail = null;
		}
		return i;
		
	}
	
	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>
	{
		private Node currHead = head; 
		public boolean hasNext()
		{
			return currHead != null;
		}
		
		public Item next()
		{
			Item i = currHead.item;
			currHead = currHead.next;
			return i;
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException("Remove not allowed while iterating!");
		}
		
	}
	

}
