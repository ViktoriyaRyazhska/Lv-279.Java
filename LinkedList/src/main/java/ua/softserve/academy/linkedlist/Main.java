package ua.softserve.academy.linkedlist;

import ua.softserve.academy.linkedlist.dynamic.array.DynamicArray;
import ua.softserve.academy.linkedlist.dynamic.array.interfaces.IDynamicArray;

class Main {

	public static void main(String[] args) {
		IDynamicArray iDynamicArray=new DynamicArray();
		System.out.println(iDynamicArray);

		for (int i=0;i<10;i++){
			iDynamicArray.add("aaa"+i);
		}

		System.out.println("New array");
		System.out.println(iDynamicArray);
		System.out.println("Size: " + iDynamicArray.size() + "\n");

		iDynamicArray.insert(2,"INSERT");
		System.out.println("Array after insertion to index = 2");
		System.out.println(iDynamicArray);
		System.out.println("Size: " + iDynamicArray.size() + "\n");

		iDynamicArray.remove(2);
		System.out.println("Array after removing from index = 2");
		System.out.println(iDynamicArray);
		System.out.println("Size: " + iDynamicArray.size() + "\n");

		System.out.println("Method get(index)");
		for (int i=0; i<iDynamicArray.size();i++){
			System.out.println(iDynamicArray.get(i));
		}

		System.out.println(iDynamicArray.indexOf("aaa4"));
		System.out.println(iDynamicArray.indexOf("aaa44"));
		System.out.println(iDynamicArray.contains("aaa7"));
		System.out.println(iDynamicArray.contains("aaa71"));

	}

}
