package go.multithread.base.oo2_middle.demo003;


import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class UseCopyOnWrite {

	public static void main(String[] args) {
		
		CopyOnWriteArrayList<String> cwal = new CopyOnWriteArrayList<>();
		CopyOnWriteArraySet<String> cwas = new CopyOnWriteArraySet<>();
		System.out.println("CopyOnWriteArrayList替代arrayList.."+cwal);
		System.out.println("CopyOnWriteArraySet替代Set..."+cwas);
		
	}
}
