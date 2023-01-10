import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;
import java.util.Random;

class main {
	public static void main(String args[]) {
		/*
			Create an ArrayList of 100 Nodes
			Store random integers in each of them
			Print out all of the values
		*/
		
		// Random rand = new Random();
		// Node node = new Node(rand.nextInt(100));
		
		// ArrayList<Node> arrayList = new ArrayList<Node>();
		// arrayList.add(node);
		
		// for(int x = 0; x < 99; x++){
		// 	Node newNode = new Node(rand.nextInt(100));
		// 	node.setNext(newNode);
		// 	arrayList.add(node.getNext());
		// }
		
		// for(int c = 0; c < 100; c++){
		// 	System.out.println(arrayList.get(c).getData());
		// }
		
		Node node = new Node(1);
		Node newNode = node;
		
		System.out.println(newNode.getData());

	}
}
