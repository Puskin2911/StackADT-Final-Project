package api;

import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
	private E[] arr;
	private int defaultSize = 100;
	private int index = 0;

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		arr = (E[]) new Object[capacity];
	}

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		arr = (E[]) new Object[defaultSize];
	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> it = new Iterator<E>() {
			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < index;
			}

			@Override
			public E next() {
				return arr[currentIndex++];
			}
		};
		return it;
	}

	@Override
	public void push(E element) {
		if (index == arr.length) {
			throw new StackOverflowError("Stack is full");
		}
		arr[index] = element;
		index++;
	}

	@Override
	public E pop() {
		if (index == 0) {
			throw new EmptyStackException();
		}
		E data = arr[index - 1];
		index--;
		return data;
	}

	@Override
	public boolean isEmpty() {
		return index == 0;
	}

	@Override
	public E top() {
		if (index == 0) {
			throw new EmptyStackException();
		}
		return arr[index - 1];
	}

	public void printStack() {
		for (int i = 0; i < index; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<Integer>(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		stack.pop();

//		System.out.println(stack.top());
		System.out.println(stack.index);

		Iterator<Integer> it = stack.iterator();
//		stack.printStack();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

}
