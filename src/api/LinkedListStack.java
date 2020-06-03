package api;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
	class Node {
		E element;
		Node next;

		public Node(E data) {
			element = data;
			next = null;
		}
	}

	Node stack = null;

	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}

	@Override
	public void push(E element) {
		Node node = new Node(element);
		node.next = stack;
		stack = node;
	}

	@Override
	public E pop() {
		if (stack != null) {
			E element = stack.element;
			stack = stack.next;
			return element;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return stack == null;
	}

	@Override
	public E top() {
		if (stack != null)
			return stack.element;
		return null;
	}
	
	public void printStack() {
		Node node = stack;
		while(node != null) {
			System.out.print(node.element + " ");
			node = node.next;
		}
		System.out.println();
	}

	class StackIterator implements Iterator<E> {
		private Node currentNode = stack;

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public E next() {
			E data = currentNode.element;
			currentNode = currentNode.next;
			return data;

		}
	}
	
	public static void main(String[] args) {
		LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		stack.pop();
		System.out.println(stack.top());
		
//		stack.printStack();
		
		Iterator<Integer> it = stack.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

}
