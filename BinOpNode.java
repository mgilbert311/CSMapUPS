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
    static Evaluable leftNode;
    static Evaluable rightNode;
    Expression expr;
    
    //Hello friends
    //Im Here
    /**
     * 
     * @param Op the operand used for evaluation
     */
    public BinOpNode (String Op, Evaluable left, Evaluable right){    
    	   if(Op.equals("*")||Op.equals("/")||Op.equals("+")||Op.equals("-")){
               this.data = Op;
           } else{
        	   throw new InputMismatchException("Input is not valid");
           }
    	    this.leftNode = left;
            this.rightNode = right;
    }
    
    /**
     * 
     * @param l
     */
    public void setLeft(Evaluable l) {
        leftNode = l;
    }
    
    /**
     * 
     * @param r
     */
    public void setRight(Evaluable r){
        rightNode = r;
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
    	 //         double leftValue = this.left.evaluate();
        //         double rightValue = this.right.evaluate();
        double leftValue = 1; //testing
        double rightValue = 0; //testing

        double value = 0;
        switch(data.substring(0)) {
            case "+":
            value = leftValue + rightValue;
            break;
            case "-":
            value = leftValue - rightValue;
            break;
            case "*":
            value = leftValue * rightValue;
            break;
            case "/":
            value = leftValue / rightValue;
            break;
            default:
            System.err.println("Unknown operator: "+data.toString());
        }
        return value;

    }
    
    /* How if a node only has it's one data value supposed to create an 
       expression or do more then return it's data*/
    /**
     * 
     */
    public String toString(){
    	if(expr == null){
    		return "( ";
    	}
    	else{
    		expr.
    	}
//       if(leftNode == null && rightNode == null){
//    	   return " ( " + data + " ) ";
//       }else{
//    	   System.out.println(" (");
//    	   leftNode.toString();
//    	   System.out.print(data);
//    	   rightNode.toString();
//    	   System.out.print(data);
//    	   System.out.print(") ");
//       }
       return data;
    }
    
    public static void main(String[] args){
    	BinOpNode bin = new BinOpNode("*", leftNode, rightNode);
    	System.out.println(bin.toString());
    }
}
