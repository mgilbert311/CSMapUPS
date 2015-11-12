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

//tree stack 
//1. make a stack of the trees by making new root every time we come across an operand -- fill RIGHT TO LEFT 
//2. pop off top of stack (should be root operand)
//3. loop/recursion to check right -- within each tree, check to see if we have filled right and left, stitch if there's empty - when we hit bottom, go out of right loop
//4. loop/recursion to check lefted -- within each tree, check to see if we have filled the right and left 
//done with if/ else if -- done!!!!! return full tree stitched together?

//some code to ponder below~~~
//get top
//get next
	// put on right
//getnext
	//put on right
	//if full
		//put on left
//getnext
	//put on right
	//if full
		//put on left
		//if full go up?
    public void makeNode(String s)
    {
        //postfix into node, push node onto estack, estack into trees???
        Scanner scannedPostfix = new Scanner(s);
        while(scannedPostfix.hasNext())
        {
            eStack.push(scannedPostfix.next());
        }
        //turn into node
        
        System.out.println(eStack);
    }
    
        public void makeNode(String s)
    {
        //postfix into node, push node onto estack
        Stack<Evaluable> postfixNodes = new Stack<Evaluable>();
        Scanner scannedPostfix = new Scanner(s);

        while(scannedPostfix.hasNext()) {                 // Keep going while there's more
            //get the next portion of the string wether its operator, value or varible
            String thing = scannedPostfix.next();  
            
            
            try
            {
                int value = Integer.parseInt(thing); //this will attempt to pars the value to a int
                
                // my making it to this line the thing is forsure 
                //an int and is made into a ValueNode
                postfixNodes.push( new ValueNode(value)); 
            }
            catch(Exception NumberFormatException)//by trowing the exception we know the string is not a integer with values
            {
                // check to see if the string is an operator  
                if(thing.equals("*")||thing.equals("/")||thing.equals("+")||thing.equals("-"))
                {
                    postfixNodes.push(new BinOpNode(thing)); //makes the OperatorNode
                }
                else //if its not a value or an operator then iit must be a varible
                {
                    postfixNodes.push(new VariableNode(thing)); //makes the VariableNode
                }
            }

        }
        
        
                //         while(!postfixNodes.empty())
                //         {
                //             Stack<Evaluable> wait = new Stack<Evaluable>();
                //             Evaluable node = postfixNodes.pop();
                // 
                //             try {
                //             if(node.getNODE_TYPE().equals("BinOpNode"))
                //             {
                //                 try
                //                 {
                //                     while(!wait.empty())
                //                     {
                //                         if(node.leftNode != null)
                //                         {}
                //                     }
                //                 }
                //                 catch(Exception e){}
                //             }
                //             if(node.getNODE_TYPE().equals("ValueNode") || node.getNODE_TYPE().equals("VariableNode"))
                //             {
                //                 wait.push(node);
                //             }
                //             
                //             //go through and take nodes off saving them in numeric order if varible || value
                //             //if operater then take the node and all the previously poped and 
                //             //link themselves togetheras a mini tree
                //         }
                //         catch(Exception e){}
                //         
                //     }
        //turn into node

        System.out.println(postfixNodes);
    }
    
    /**
     * 
     * /
     * 
  
    	public static void test() {
    	
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
