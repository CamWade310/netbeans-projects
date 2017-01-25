/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodsandbasicgraphicslibrary;

import java.util.Random;
//import javax.swing.JOptionPane;
import basicGraphicsLibv2.*;
import java.awt.Color;

/**
 *
 * @author Camden Wade
 */
public class MethodsAndBasicGraphicsLibrary {

    /**
     * @param args the command line arguments
     */
    private static String createExpression(char operator, int bound) {
        Random rand = new Random();
        int var1, var2; //variables to respresent random numbers

        //randomzing the two variables up to the bound exclusively
        var1 = rand.nextInt(bound);
        var2 = rand.nextInt(bound);

        if (operator == '/') {
            while (var2 > var1) {
                var1 = rand.nextInt(bound);
                var2 = rand.nextInt(bound);
            }

        }
        return var1 + " " + operator + " " + var2 + " = ";
    }

    private static char randomOp() {
        Random operationMixer = new Random();
        char mathSymbol = ' ';
        int i = operationMixer.nextInt(4);
        switch (i) {
            case 1:
                mathSymbol = '/'; //returns division
                break;
            case 2:
                mathSymbol = '+'; // returns addition
                break;
            case 3:
                mathSymbol = '-'; // returns subtraction
                break;
            case 0:
                mathSymbol = '*'; // returns multipication
                break;

        }

        return mathSymbol;
    }

    private static void displayExpresssion(BasicFrame myFrame, String expression) {
        String_gl statement = new String_gl(expression);
        statement.setFontSize(20);
        statement.setColor(Color.DARK_GRAY);
        statement.setLocXY(10, 200);
        myFrame.add(statement);
        Rectangle_gl rec = new Rectangle_gl(100, 50);
        rec.setFilled(false);
        rec.setColor(Color.blue);
        rec.setLocXY(300, 200);
        myFrame.add(rec);
        myFrame.displayIt();
    }

    private static void delay() {
        for (long i = 0; i < 2000; i++) {
            for (long j = 0; j < 10000000; j++) {
                double value = i * j;
            }
        }
    }

    private static void displayExpression2(BasicFrame myFrame, String expression) {
        String_gl statement = new String_gl(expression);
        statement.setFontSize(20);
        statement.setColor(Color.DARK_GRAY);
        statement.setLocXY(10, 200);
        myFrame.add(statement);
        Rectangle_gl rec = new Rectangle_gl(100, 50);
        rec.setFilled(false);
        rec.setColor(Color.blue);
        rec.setLocXY(300, 200);
        myFrame.add(rec);
        myFrame.displayIt();
        delay();
        myFrame.clear();
        int a = computeResult(expression);
        String_gl answer = new String_gl(Integer.toString(a));
        answer.setFontSize(20);
        answer.setColor(Color.DARK_GRAY);
        answer.setLocXY(330, 225);
        myFrame.add(statement);
        myFrame.add(answer);
        myFrame.add(rec);
        myFrame.displayIt();
        delay();
    }

    private static int computeResult(String expr) {
//parse the expression using the String split function
        String[] tokens = expr.split(" ");
//extract the operator
        char operator = tokens[1].charAt(0);
//extract and convert the operands
        int op1 = Integer.parseInt(tokens[0]);
        int op2 = Integer.parseInt(tokens[2]);
//Perform integer arithmetic
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            default:
                return (-10000); //error condition
        }
    }

    public static void main(String[] args) {

        // TODO code application logic here
        BasicFrame myFrame = new BasicFrame(500, 400, Color.GREEN);
        for (int i = 0; i < 11; i++) {
            String myExpression = createExpression(randomOp(), 12);
            //JOptionPane.showMessageDialog(null, myExpression);
            displayExpression2(myFrame, myExpression);
          
            myFrame.clear();

        }
    }

}
