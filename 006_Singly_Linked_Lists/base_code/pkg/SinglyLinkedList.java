package pkg;
import java.util.Scanner;
import java.util.Random;


public class SinglyLinkedList {
	Node head;

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
		Node node = new Node(head.getNext());
		for(int c = 0; c < pos; c++;){
			node = node.getNext();
		}
		
		return node.getData();
	}

	/*
		Insert a new Node at the given position with the data given
	*/
	public void insert(int pos int data){
		Node node = new Node(head.getNext());
		for(int c = 0; c < pos-1; c++){
			node = node.getNext();
		}
		
		node.setNext(data);
	}

	/*
		Remove the node at the given position
		If no position exists, don't change the list
	*/
	public void remove(int pos){
		Node node = new Node(head.getNext());
		
		for(int c = 0; c < pos-1; c++){
			node = node.getNext();
		}
		
		if(node != null){
			node.setNext(null);
		} else {
			return;
		}
	}

	/*
		Swap two Nodes with the two positions given
	*/
	public void swap(int pos1, int pos2){

	}

	/*
		Print all data values in the LinkedList 
	*/
	public void printList(){

	}
}
