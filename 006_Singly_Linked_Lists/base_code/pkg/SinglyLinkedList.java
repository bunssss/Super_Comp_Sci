package pkg;
import java.util.Scanner;
import java.util.Random;


public class SinglyLinkedList {
	Node head;
	Node test = new Node(1);

	/* 
		Postcondition: The head will be null 
	*/
	public SinglyLinkedList() {
		head = null;
		
	}

	/* 
		Receives an integer position, searches through the SinglyLinkedList for the position and returns the data at that positon
	   	If the position doesn't exist, it returns -1
	*/ 
	public int get(int pos){
		Node node = head;
		
		for(int c = 0; c < pos; c++){
			node = node.getNext();
		}

		
		if(node == null){
			return -1;
		} else {
			return node.getData();
		}
		
	}

	/*
		Insert a new Node at the given position with the data given
	*/
	public void insert(int pos, int data){
	
		// Node node = new Node(data);
		// Node node2 = head;
		Node newNode = new Node(data);
		
		// if(pos == 0){
		// 	if(head == null){
		// 		head = node;
		// 	} else {
		// 		node.setNext(head);
		// 		head = node;
		// 	}
		// } else {
		// 	for(int c = 0; c < pos-2; c++){
		// 		node2 = node2.getNext();
		// 	}
			
		// 	node.setNext(node2.getNext());
		// 	node2.setNext(node);
			
		// }
		
		if(head == null){
			head = newNode;
		}
		
		if(pos == 0){
			newNode.setNext(head);
			head = newNode;
			return;
		}
		
		Node prev = head;
		Node curr = head.getNext();
		int count = 1;
		
		while(curr != null){
			if(count == pos){
				prev.setNext(newNode);
				newNode.setNext(curr);
				return;
			}
			
			prev = prev.getNext();
			curr = curr.getNext();
			count++;
		}
		
		prev.setNext(newNode);
		
	}

	/*
		Remove the node at the given position
		If no position exists, don't change the list
	*/
	public void remove(int pos){
		Node node = head;
		
		for(int c = 0; c < pos-1; c++){
			node = node.getNext();
		}
		
		Node node2 = node.getNext().getNext();
		node.setNext(node2);
		
	}

	/*
		Swap two Nodes with the two positions given
	*/
	public void swap(int pos1, int pos2){
		int a = get(pos1);
		int b = get(pos2);
		
		insert(pos1, b);
		remove(pos1);
		
		insert(pos2, a);
		remove(pos2);
		
	}

	/*
		Print all data values in the LinkedList 
	*/
	public void printList(){
		Node node = head;
		int c = 0;
		
		while(true){
			System.out.println(node.getData() + " " + c);
			node = node.getNext();
			c++;
			if(node == null){
				break;
			}
		}
	}
}
