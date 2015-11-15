package arithmeticExpression;   
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Stack;

import arithmeticExpression.InfixToPostfixParens.SyntaxErrorException;
/**
 * Write a description of class Expression here.
 * 
 * @author  Nicole Cahlander, Shannon Leahy, Mark Gilbert
 */
public class Expression implements Evaluable{
	String postfix = "";
	public BinOpNode bon;
	public VariableNode varNode;
	public ValueNode valNode;
	public static HashMap env;

	static Stack<Evaluable> finalTree;

	/**
	 * 
	 * @param infix
	 * @throws SyntaxErrorException 
	 */
	public Expression (String infix) throws SyntaxErrorException{
		try{
			InfixToPostfixParens converter = new InfixToPostfixParens();
			postfix = converter.convert(infix);
			System.out.println("Postfix representation in constructor" + postfix.toString());
			finalTree = eval(postfix);
		} catch (SyntaxErrorException e) {
			throw new SyntaxErrorException("Not valid input");		
		}
	}

	/**
	 * 
	 */
	public double evaluate(Map<String, Double> env){	
		Evaluable nodeToEval = finalTree.pop();
		System.out.println("The node to evaluate " + nodeToEval);
		System.out.println("Tree in evaluate method" + finalTree);
		double value = nodeToEval.evaluate(env);
		//If the tree is not there, throw an exceptions
		if(finalTree == null){
			throw new EmptyStackException();
		}
		System.out.println("value from evaluate " + value);
		return value;

	}

	/**
	 * 
	 * @return
	 */
	public Set<String> getVariables(){ //
		Set<String> variables = env.keySet();
		return variables;
	}

	/**
	 * Takes an expression in postfix form (as a string),
	 * evaluates it, and returns the result.  It works by
	 * pushing operands (numbers) onto a stack until it 
	 * encounters an operator, then it applies the operator
	 * to the top two items on the stack and replaces them
	 * with the result.
	 * Have the stack hold references to tree nodes: 
	 * When you encounter a value or a variable, make a new 
	 * tree node and push it onto the stack. When an operator 
	 * is encountered, build a larger tree out of the operator and
	 *  the two subtrees at the top of the stack, then push
	 *   this new tree onto the stack.
	 */
	public static Stack<Evaluable> eval(String expr) {
		Scanner tokens = new Scanner(expr);
		finalTree = new Stack<Evaluable>();
		while(tokens.hasNext()) {

			if (tokens.hasNextDouble()) {
				// If we get here, the next item is a number
				double value = tokens.nextDouble();
				finalTree.push(new ValueNode(value)); 

			}
			else {
				// If we're here, the next thing is NOT a number
				String next = tokens.next();
				VariableNode node = null;
				if(next.equals("*")||next.equals("/")||next.equals("+")||next.equals("-")){

					//String operator = tokens.next();
					Evaluable operand2 = null;
					Evaluable operand1 = null;
					try {
						operand2 = finalTree.pop();
						operand1 = finalTree.pop();
					}
					catch(Exception e) {
						System.err.println("Not enough operands!");
					}
					if(next.equals("+")){
						finalTree.push(new BinOpNode(next, operand1, operand2));
					}else if(next.equals("-")){
						finalTree.push(new BinOpNode(next, operand1, operand2));
					}else if(next.equals("*")){
						finalTree.push(new BinOpNode(next, operand1, operand2));
					}else if(next.equals("/")){
						finalTree.push(new BinOpNode(next, operand1, operand2));
					}else{
						System.err.println("Unknown operator: " + next);
					}
					break;
				}else{ //It's a variable node, push it on the stack

					finalTree.push(new VariableNode(next));

				}

			}
		}
		// If all went well, there should be exactly one thing
		// left on the stack -- the overall result of the expression
		System.out.println("final tree in eval method" + finalTree);
		return finalTree;
	}
	/**
	 * 
	 * @throws InfixToPostfixParens.SyntaxErrorException
	 */
	public static void test() throws InfixToPostfixParens.SyntaxErrorException{

		/* Testing the ValueNode */

		ValueNode vlData = new ValueNode(7.888);
		double vLd = 7.888;



		// Check the constructor - Line 16
		assert vlData == null : "Check the constructor - Line 16";

		// Check the getData Method - Line 24
		assert  vlData.getData() == 7.888 : "Checks the get Method in ValueNode Line 24";

		// Check the getNodeType Method - Line 28 - NO
		// check to make sure it returns the correct # as a double
		assert  vlData.getData() == vLd;


		// Check to ensure that evaluate method works - Line 37
		// call on a value node and a map of null and check that it returns the correct data
		// call on a value node and a map with other varibles and check that it returns the correct data

		// Check the toString
		// check to make sure it returns the correct value as a string 




		/* Testing the VaribleNode */

		// Check the constructor - Line 18
		// make sure that you can create a varible node with 
		// a String other than a BianaryNode

		// QUESTION: if a varible node is passed a String 
		// should we have the constructor throw an error

		// make sure when you pass in a BinaryNode it does not make the Node

		// Check the setLeft - Line 28
		// make sure that when passes a evaluable node it 
		// then saves to other node to the correct connection

		// make sure that it will not work if a something is passes that is no Evaluable

		// Check the setRight - Line 36
		// make sure that when passes a evaluable node it then saves to other node to the correct connection

		// make sure that it will not work if a something is passes that is no

		// Check the getData - Line 44
		// when called on a varible node it will return the correct string

		// Check evaluate - Line 52
		// run w/ map as null and have it throw IllegalArgumentException and make sure the full err is printed
		// run w/ real map ask for a varible that is there and make sure it works
		// run w/ real map asking for a varible that is not there and that it tthrows the error 

		// Check toString - Line 81
		// run method and verify it returns the correct string

		/* Testing the BinOpNode */
		// Check the BinOpNode Constructor - Line 22
		// Try & Fail to make a node w/o a Binary Operator and see the exception thrown
		// Make a Binary Operator

		// Check the setLeft method - Line 36
		// set a node and make sure that it is saved on the correct side

		// Check the setRight method - Line 44
		// set a node and make sure that it is saved on the correct side

		// Check the setgetNODE_TYPE() method - Line 56
		// call this and make sure that it redurns the correct string

		// Check the evaluate method - Line 65
		// check that the method will run on a all value equation w/ a map of null
		// check that the method will run on a all value equation w/ a varible map w/ varibles

		// Check the toString method - Line 96
		// check to ensure that if there is just an operator that it still works
		// check to make sure that the method also print all the lower portions of the trees

		// Check the main method
	}
	/**
	 * 
	 */
	public String toString(){
		return "This is a string representation " + finalTree;
	}

	/**
	 * 
	 * @param args
	 * @throws SyntaxErrorException
	 */
	public static void main(String[] args) throws SyntaxErrorException{
		Expression e = new Expression(" 1 + 2 * ( 3 - 4 ) ");
		System.out.println( e.toString());

		//e.evaluate(null);
		System.out.println("This is what was evaluated " + e.evaluate(null));
		System.out.println(e.toString());

		
		//		env = new HashMap();
		//		env.put("foo", 17.8);
		//		Expression e = new Expression(" ( foo + ( 1.0 * ( foo + 2.5 ) ) ) " );
		//		System.out.println(e.evaluate(env));
		//		System.out.println( e.toString());
		//		//This should prin the variable
		//		System.out.println("Variable" +  e.getVariables().toString());


	}
}
