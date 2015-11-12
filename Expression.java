package arithmeticExpression;   
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
    Stack<String> eStack = new Stack<String>(); 
	double value = 0;
	String postfix = "";
	/**
	 * 
	 * @param infix
	 * @throws SyntaxErrorException 
	 */
	public Expression (String infix) throws SyntaxErrorException{
		//can that just be a String or does it have to be java.lang.String
		// how will the infix equations be written ie will there be space divisions
		try{
			InfixToPostfixParens converter = new InfixToPostfixParens();
			postfix = converter.convert(infix);
			System.out.println(postfix.toString());
		} catch (SyntaxErrorException e) {
			throw new SyntaxErrorException("Not valid input");		
			
		}
		  makeNode(postfix);
	}

	/**
	 * 
	 */
	public double evaluate(Map<String, Double> env){	
		   //thatItem.evaluate()
        ExprEval expEvaluator = new ExprEval();
        value = expEvaluator.eval(postfix);
        if(env == null)
        {
            return value;
        }
        return value;
        //return 1.0;
	}

    public void makeNode(String s)
    {
        //postfix into node, push node onto estack
        Scanner scannedPostfix = new Scanner(s);
        while(scannedPostfix.hasNext())
        {
            eStack.push(scannedPostfix.next());
        }
        //turn into node
        
        System.out.println(eStack);
    }
	/**
	 * 
	 * @return
	 */
	public Set<String> getVariables(){ //
		Set<String> varibles = new LinkedHashSet<String>();
		return varibles;
	}

	/**
	 * 
	 */
	public String toString(){
		return null;
	}
}
