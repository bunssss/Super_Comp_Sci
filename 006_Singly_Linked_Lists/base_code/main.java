import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		// for(int c = 0; c < 10; c++){
		// 	list.insert(c, c);
		// }
		
		// for(int c = 0; c < 20; c++){
		// 	int a = (int)(Math.random()*100);
		// 	list.insert(0, a);
		// }
		
		// for(int c = 0; c < 20; c++){
		// 	int a = (int)(Math.random()*19);
		// 	list.insert(a, -1);
		// }
		
		// System.out.println("List #1");
		// System.out.println("--------------------");
		// list.printList();
		
		// for(int c = 0; c < 20; c++){
		// 	System.out.println(list.get(c));
		// }
		
		// System.out.println(list.get(25));
		// System.out.println(list.get(26));
		// list.swap(25, 26);
		// System.out.println(list.get(25));
		// System.out.println(list.get(26));
		
		
		// System.out.println(list.get(39));
		// list.remove(39);
		// System.out.println();
		// System.out.println(list.get(39));
		
		
		// int r = 39;
		// for(int c = 0; c < 20; c++){
		// 	list.swap(c, r);
		// 	r--;
		// }
		
		// System.out.println();
		// System.out.println("List #2");
		// System.out.println("--------------------");
		// list.printList();
		
		
		for(int c = 0; c < 10; c++){
			System.out.println(c);
			
			if(c == 3){
				while(c < 8){
					c++;
					System.out.println(c + "d");
				}
			}
		}
		
	}
}
