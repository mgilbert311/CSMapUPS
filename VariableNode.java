package arithmeticExpression;   
import java.util.InputMismatchException;
import java.util.Map;
/**
 * Write a description of class VaribleNode here.
 * 
 * @author Nicole Cahlander, Shannon Leahy, Mark Gilbert 
 */
public class VariableNode implements Evaluable{
	    private final String NODE_TYPE = "VariableNode";
	private String data;
	private Evaluable left;
	private Evaluable right;


	/**
	 * 
	 * @param d
	 */
	public VariableNode(String varName){ 
		
		//What do we mod this by??
		//int index = Math.abs(s.hashCode(varName)) % ;
		
		//Make sure it is not a Operator
		if(d.equals("*")||d.equals("/")||d.equals("+")||d.equals("-")){
			throw new InputMismatchException("Not a variable");
		}
		this.data = varName;
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
		    
    public String getNODE_TYPE()
    {
        return NODE_TYPE;
    }

	//keeps track of the values for the varibles
	/**Evaluates the expression and returns its value as a double.
       @param java.util.Map<java.lang.String,java.lang.Double>
       @return value*/
	public double evaluate(Map<String,Double> env){
		// wait should this return the value of the varible if not how can a varible be made into a double 


		return 1.0;
	}
	/**Evaluates the expression and returns its value as a double.
    @param java.util.Map<java.lang.String,java.lang.Double>
    @return value*/
    public double evaluate(Map<String,Double> env){
        // wait should this return the value of the varible if not how can a varible be made into a double
        //look up in map value
        //throw exception if you can't find value env will be that

        double value = Integer.MAX_VALUE;
        try
        {
            if(env.get(this.data) != null) //if map has this variable on it
            {
                //System.out.println(env.get(this.data));
                value = env.get(this.data); //retrieves value from map
            }
            else
            {
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Not found in map!");
        }
        
        return value;
    }

	/**
	 * 
	 */
	public String toString(){
		return this.data;
	}
}

