import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		STack test = new STack();
		Scanner sc = new Scanner(System.in);
		ArrayList<Character> signs = new ArrayList<Character>();
		ArrayList<Character> numbers = new ArrayList<Character>();
		ArrayList<Character> FinalEQ = new ArrayList<Character>();
		boolean isParen = false;
		
		System.out.print("Type in a equation:  ");
		String equation = sc.nextLine();
		
		// for(int c = 0; c < equation.length(); c++){
		// 	char Sign = equation.charAt(c);
		// 	if(Sign == '('){
		// 		isParen = true;
		// 		break;
		// 	}
		// }
		
		// if(isParen = false){
			
			for(int c = 0; c < equation.length(); c++){
				char newSign = equation.charAt(c);
			
				if(newSign == '+' || newSign == '-' || newSign == '*' || newSign == '/' || newSign == '%'){
					signs.add(newSign);
				} else {
					numbers.add(newSign);
				}
			}
			
		// }
		
		for(int c = 0; c < signs.size(); c++){
			if(signs.get(c) == '+' || signs.get(c) == '-'){
				test.push(signs.get(c));
			}
		}
		
		for(int c = 0; c < signs.size(); c++){
			if(signs.get(c) == '/' || signs.get(c) == '%'){
				test.push(signs.get(c));
			}
		}
		
		for(int c = 0; c < signs.size(); c++){
			if(signs.get(c) == '*'){
				test.push(signs.get(c));
			}
		}
		
		
		boolean empty = test.isEmpty();
		
		
		for(int c = 0; c < numbers.size(); c++){
			FinalEQ.add(numbers.get(c));
		}
		
			while(empty == false){
			FinalEQ.add(test.peek());
			test.pop();
			empty = test.isEmpty();
		}
		
		for(int c = 0; c < FinalEQ.size(); c++){
			System.out.print(FinalEQ.get(c));
		}

	}
}
