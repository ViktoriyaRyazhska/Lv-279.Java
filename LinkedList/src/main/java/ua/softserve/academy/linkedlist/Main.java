package ua.softserve.academy.linkedlist;

import ua.softserve.academy.linkedlist.dynamic.array.DynamicArray;
import ua.softserve.academy.linkedlist.dynamic.array.interfaces.IDynamicArray;

import java.util.ArrayList;
import java.util.List;

class Main{
	public static void main(String[] args) {
		IDynamicArray iDynamicArray=new DynamicArray();
		for (int i=0;i<10;i++) {
			iDynamicArray.add("aaa"+i);
		}
		System.out.println(iDynamicArray);
		iDynamicArray.insert(2,"INSERT");
		System.out.println(iDynamicArray);

	}
}
