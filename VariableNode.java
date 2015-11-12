package arithmeticExpression;   
import java.util.InputMismatchException;
import java.util.Map;
/**
 * Write a description of class VaribleNode here.
 * 
 * @author Nicole Cahlander, Shannon Leahy, Mark Gilbert 
 */
public class VariableNode implements Evaluable{

	private String data;
	private Evaluable left;
	private Evaluable right;

	/**
	 * 
	 * @param d
	 */
	public VariableNode(String d){ 
		//Make sure it is not a Operator
		if(d.equals("*")||d.equals("/")||d.equals("+")||d.equals("-")){
			throw new InputMismatchException("Not a variable");
		}
		this.data = d;
		this.left = null;
		this.right = null;
	}

	/**
	 * 
	 * @param l
	 */
	public void setLeft(Evaluable l){   
		left = l;
	}

	/**
	 * 
	 * @param r
	 */
	public void setRight(Evaluable r){
		right = r;
	}

	/**
	 * 
	 * @return
	 */
	public String getData(){ 
		return data;
	}


	//keeps track of the values for the varibles
	/**Evaluates the expression and returns its value as a double.
       @param java.util.Map<java.lang.String,java.lang.Double>
       @return value*/
	public double evaluate(Map<String,Double> env){
		// wait should this return the value of the varible if not how can a varible be made into a double 


		return 1.0;
	}

	/**
	 * 
	 */
	public String toString(){
		return this.data;
	}
}

