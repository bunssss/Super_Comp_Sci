package pkg;
import java.util.Scanner;
import java.util.Random;


public class STack {
	/*  LAST IN FIRST OUT  */
	Node top;

	/* 
		Postcondition: The top will be null.
	*/
	public STack() {
		top = null;
	}

	/*
		Insert a new Node on top of the stack
	*/
	public void push(char data){
		Node newNode = new Node(data);
		Node previous = top;
		
		top = newNode;
		top.setNext(previous);
		
	}

	/*
		Removes the top node of the stack
	*/
	public void pop(){
		
		if(top == null){
			return;
		}
		
		char topvalue = top.getData();
	
		if(top.getNext() == null){
			top = null;
			return;
		}
		
		top = top.getNext();
	}

	/*
		Returns the top value of the stack. Doesn't pop. 
	*/
	public char peek(){
		if(top == null)
		{
			return '-';
		}
		return top.getData();
	}

	/*
		Checks if the stack is empty. 
	*/
	public boolean isEmpty(){
		if(top == null){
			return true;
		}
			return false;
	}
}
