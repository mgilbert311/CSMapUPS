package arithmeticExpression;   
import java.util.Map;
/**
 * Write a description of class ValueNode here.
 * 
 * @author (Nicole Cahlander, Shannon Leahy, Mark Gilbert
 * @version (a version number or a date)
 */
public class ValueNode implements Evaluable{
    private int data;
    
    /**
     * 
     * @param d
     */
    public ValueNode(int d){
         this.data = d;
    }
    
    /**
     * 
     * @return
     */
    public int getData(){
        return data;
    }
      
    /* what is a java.util.Map<java.lang.String,java.lang.Double> */ 
    //keeps track of the values for the varibles
    /**Evaluates the expression and returns its value as a double.
       @param java.util.Map<java.lang.String,java.lang.Double>
       @return value*/
    public double evaluate(Map<String,Double> env){ 
        return data;
    }
    
    /**
     * 
     */
    public String toString(){
        String valueString = "" + this.data;
        return valueString;
    }
}

