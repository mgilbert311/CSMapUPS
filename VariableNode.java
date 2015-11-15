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
	private String name;

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
		name = d;
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
	public double evaluate(Map<String,Double> env){

		double value = 0;

		if(env == null){
			return value;
			
		}
		return env.get(this.data);
		
//		if(env.isEmpty() && env.containsKey(data) == false ){
//			throw new NullPointerException("Not found in map!");
//		}else {
//			
//			 return value;
//		}
//			if(env == null || ){
//				//If the 
//				throw new NullPointerException("Not found in map!");
//			}else{
//				
//				value = env.get(this.data); //retrieves value from map
//			}
//			if(env.get(this.data) != null){ //if map has this variable on it
//			
//				//System.out.println(env.get(this.data));
//				value = env.get(this.data); //retrieves value from map
//			}
			
		}

		
	

	/**
	 * 
	 */
	public String toString(){
		return name;
	}
}

