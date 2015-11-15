package arithmeticExpression; 
import java.util.InputMismatchException;
import java.util.Map;  
/**
 * Write a description of class BinOpNode here.
 * 
 * @authorNicole Cahlander, Shannon Leahy, Mark Gilbert
 */
public class BinOpNode implements Evaluable{
	private String data;
	public static Evaluable leftTree;
	public static Evaluable rightTree;
	Expression expr;
	BinOpNode bon;

	/**
	 * 
	 * @param Op the operand used for evaluation
	 */
	public BinOpNode (String Op, Evaluable left, Evaluable right){    
		if(Op.equals("*")||Op.equals("/")||Op.equals("+")||Op.equals("-")){
			this.data = Op;
			this.leftTree = left;
			this.rightTree = right;
		} else{
			throw new InputMismatchException("Input is not valid");
		}

	}
	/**
	 * 
	 * @return
	 */
	public String getData(){
		return data;
	}

	/**Evaluates the expression and returns its value as a double.
       @param java.util.Map<java.lang.String,java.lang.Double>
       @return value*/
	public double evaluate(Map<String, Double> env){
		double fValue = 0;
//		double left = leftTree.evaluate(env);
//		double right = rightTree.evaluate(env);
		double left;
		double right;
		//If the trees have
		if(leftTree.equals(bon) && rightTree.equals(bon)){
			left = leftTree.evaluate(env);
			right = rightTree.evaluate(env);
		}
		if(data.equals("+")){
			 left = leftTree.evaluate(env);
			 right = rightTree.evaluate(env);
			fValue = left + right;
		}else if(data.equals("-")){
			 left = leftTree.evaluate(env);
			 right = rightTree.evaluate(env);
			fValue = left - right;
		}else if(data.equals("*")){
			 left = leftTree.evaluate(env);
			 right = rightTree.evaluate(env);
			fValue = left * right;
		}else if(data.equals("/")){
			 left = leftTree.evaluate(env);
			 right = rightTree.evaluate(env);
			fValue = left / right;
		}else{
			System.err.println("Unknown operator: "+data.toString());
		}
    return fValue;
	}
	
	/* How if a node only has it's one data value supposed to create an 
    expression or do more then return it's data*/
	/**
	 * 
	 */

	public String toString(){
		String binOp = "";
		if(this == null){
			return null; 
		}else{

			binOp = binOp + " (";
			String left = leftTree.toString();
			binOp = binOp + " " + left;

			binOp = binOp + " " + data + " ";

			String right = rightTree.toString();
			binOp = binOp + right;
			binOp = binOp +" ) ";
		}

		return binOp;
	}

	public static void main(String[] args){
		//BinOpNode bin = new BinOpNode("*", leftTree, rightTree);
		//System.out.println(bin.toString());
	}
}
