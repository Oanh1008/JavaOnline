package com.generic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Predicate;

public class CustomList<E> implements IList<E> {
	private int initialCapacity=4;
	private int size;
	private E[] elements;
	
	public CustomList() {
		elements= createGenericArray(initialCapacity);
	}
	public CustomList(int capacity) {
		if(capacity <0) {
			throw new IllegalArgumentException("Lenght should be greater than 0");
		}
		if(capacity >initialCapacity) {
			initialCapacity=capacity;
		}
		elements= createGenericArray(initialCapacity);
		
	}
	
	
	
	@Override
	public boolean add(E e) {
		if(size <initialCapacity) {
			elements[size++]=e;
			return true;
		}
		
		elements = grow(size + initialCapacity);
		elements[size++] = e;
		return true;
		
	
	}

	@Override
	public boolean remove(E e) {
		return false;
	}

	@Override
	public boolean remove(int index) {
		E[] newElements= createGenericArray(size -1);
		for(int i=0;i<newElements.length;i++) {
			newElements[i]=elements[i];
		}
		for(int i=index;i<newElements.length;i++) {
			newElements[i]= elements[i+1];
		}
		size--;
		elements=newElements;
		return true;
	}

	@Override
	public E get(int i) {
		if(i<0 || i>=size) {
			throw new ArrayIndexOutOfBoundsException("Lenght over "+size);
		}
		return elements[i];
	}

	@Override
	public E set(int i, E e) {
		if(i<0 || i>=size) {
			throw new ArrayIndexOutOfBoundsException("Lenght over "+size);
		}
		return (elements[i]=e);
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int size() {
		return size;
	}
	@Override
	public void show() {
		for(int i=0;i<size;i++) {
			System.out.println(elements[i]);
		}
	}
	
	@SuppressWarnings( "unchecked")
	private E[] createGenericArray(int size) {
		return (E[])Array.newInstance(Object.class, size);
	}
	private E[] grow(int newSize) {
		E[] newElements = createGenericArray(newSize);
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		return newElements;
		
	}
	@Override
	public int count(Predicate<E> predicate) {
		int count=0;
		for(int i=0;i<size;i++) {
			E element=elements[i];
			if(predicate.test(element)) {
				count ++;
			}
		}
		return count;
		
	}
	
	
}
