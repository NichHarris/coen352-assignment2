//Nicholas Harris
//harris.nicholas1998@gmail.com

import java.io;
import java.util;
import java.util.Stack;

public class A1Q1 {
    public static void main(String[] args){
        Stack operations = new Stack();
        Stack numbers = new Stack();
        String word = "1+1)*3-4)*5-6)))";
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == "+" || word.charAt(i) == "*" || word.charAt(i) == "-" || word.charAt(i) == "/"){
                operations.push(word.charAt(index));
            }
            else if(word.charAt(i) == ")"){
                String output = operations.pop();
                String num1 = numbers.pop();
                String num2 = numbers.pop();
                String newOut = "(" + numbers.pop() + "" + operations.pop() + "" + numbers.pop() + ")";
                numbers.push(newOut);
            }
            else{
                numbers.push(word.charAt(i));
            }
        }
        while(!numbers.empty()){
            System.out.println(numbers.pop());
        }
    }
}
