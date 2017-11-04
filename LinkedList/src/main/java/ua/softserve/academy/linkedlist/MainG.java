package ua.softserve.academy.linkedlist;

import ua.softserve.academy.linkedlist.dynamic.array.DynamicArrayG;
import ua.softserve.academy.linkedlist.dynamic.array.interfaces.IDynamicArray;
import ua.softserve.academy.linkedlist.dynamic.array.interfaces.IDynamicArrayG;

class MainG {
	public static void main(String[] args) {
//		IDynamicArrayG<String> iDynamicArray=new DynamicArrayG<>();
//
//		for (int i=0;i<10;i++) {
//			iDynamicArray.add("aaa"+i);
//		}
//
//		System.out.println("New array");
//		System.out.println(iDynamicArray);
//		System.out.println("Size: " + iDynamicArray.size() + "\n");
//
//		iDynamicArray.insert(2,"INSERT");
//		System.out.println("Array after insertion to index = 2");
//		System.out.println(iDynamicArray);
//		System.out.println("Size: " + iDynamicArray.size() + "\n");
//
//		iDynamicArray.remove(2);
//		System.out.println("Array after removing from index = 2");
//		System.out.println(iDynamicArray);
//		System.out.println("Size: " + iDynamicArray.size() + "\n");
//
//		System.out.println("Method get(index)");
//		for (int i=0; i<iDynamicArray.size();i++){
//			System.out.println(iDynamicArray.get(i));
//		}
//
//		System.out.println(iDynamicArray.indexOf("aaa4"));
//		System.out.println(iDynamicArray.indexOf("aaa44"));
//		System.out.println(iDynamicArray.contains("aaa7"));
//		System.out.println(iDynamicArray.contains("aaa71"));


		IDynamicArrayG<Object> array=new DynamicArrayG<>();
        System.out.println(array);
        array.add("ds");
		array.add(123);
		array.insert(1,"Insert");
		System.out.println(array);
		array.clear();
		System.out.println(array);
	}
}
