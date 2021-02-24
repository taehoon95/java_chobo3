package java_chobo3.ch12;

import java.util.ArrayList;

public class Box<T> {
//	private ArrayList<t> list = new ArrayList<t>();
	private ArrayList<T> list;
	
	
	public Box() {
		list = new ArrayList<T>();
	}

	public void add(T item) {
		list.add(item);
	}
	
	public T get(int idx) {
		return list.get(idx);
	}

	public ArrayList<T> getList() {
		return list;
	}
	
	public int size() {
		return list.size();
	}

	@Override
	public String toString() {
		return String.format("Box [%s]", list);
	}
	
	
	
}
