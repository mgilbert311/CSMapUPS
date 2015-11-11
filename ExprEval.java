ckage arithmeticExpression;

import java.util.Scanner;
import java.util.Stack;
/**
 * 
 * @author Nicole Cahlander, Shannon Leahy, Mark Gilbert
 */
public class ExprEval
{
    /**
     * Takes an expression in postfix form (as a string),
     * evaluates it, and returns the result.  It works by
     * pushing operands (numbers) onto a stack until it 
     * encounters an operator, then it applies the operator
     * to the top two items on the stack and replaces them
     * with the result.
     */
    public static int eval(String expr) {
        Scanner tokens = new Scanner(expr);
        Stack<Integer> operands = new Stack<Integer>();
        
        while(tokens.hasNext()) {
            System.out.println(operands);
            if (tokens.hasNextInt()) {
                // If we get here, the next item is a number
                operands.push(tokens.nextInt());
            }
            else {
                // If we're here, the next thing is NOT a number
                String operator = tokens.next();
                int operand2 = 0;
                int operand1 = 0;
                try {
                    operand2 = operands.pop();
                    operand1 = operands.pop();
                }
                catch(Exception e) {
                    System.err.println("Not enough operands!");
                }
                switch(operator.charAt(0)) {
                    case '+':
                        int temp = operand1 + operand2;
                        operands.push(temp);
                        break;
                    case '-':
                        operands.push(operand1-operand2);
                        break;
                    case '*':
                        operands.push(operand1*operand2);
                        break;
                    case '/':
                        operands.push(operand1/operand2);
                        break;
                    default:
                        System.err.println("Unknown operator: "+operator);
                }
            }
        }
        // If all went well, there should be exactly one thing
        // left on the stack -- the overall result of the expression
        return operands.peek();
    }
    
}
