package com.gao.base_001.conn013;


import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class UseCopyOnWrite {

	public static void main(String[] args) {
		
		CopyOnWriteArrayList<String> cwal = new CopyOnWriteArrayList<String>();
		CopyOnWriteArraySet<String> cwas = new CopyOnWriteArraySet<String>();
		System.out.println("CopyOnWriteArrayList替代arrayList.."+cwal);
		System.out.println("CopyOnWriteArraySet替代Set..."+cwas);
		
	}
}
