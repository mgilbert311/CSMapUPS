package arithmeticExpression;   
import java.util.Map;
/**
 * Write a description of interface Evaluable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Evaluable{
   public double evaluate(Map<String, Double> env);
   public String toString();
}
