package arithmeticExpression;   
import java.util.Map;
/**
 * Write a description of class ValueNode here.
 * 
 * @author (Nicole Cahlander, Shannon Leahy, Mark Gilbert
 * @version (a version number or a date)
 */
public class ValueNode implements Evaluable{
    private double data;
    /**
     * 
     * @param d
     */
    public ValueNode(double d){
         this.data = d;
    }
    
    /**
     * 
     * @return
     */
    public double getData(){
        return data;
    }
    
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
       // String valueString = "" + this.data;
        return " " + data;
    }
}

