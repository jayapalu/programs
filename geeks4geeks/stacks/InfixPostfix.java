package stacks;
import java.util.Scanner;

class Stack{
    int top;
    char [] a;
    int capacity;

    Stack(){
        this.top=-1;
    }

    Stack(int cap){
        this.capacity=cap;
        a = new char[capacity];
        this.top=-1;
    }

    void push(char ch){
        this.a[++this.top]=ch;
    }

    char peek(){
        return this.a[top];
    }

    char pop(){
        if(top == -1){
            return '\0';
        }
        return this.a[top--];
    }

    boolean isEmpty(){
        if (this.top == -1){
            return true;
        }
        return false;
    }
}

public class InfixPostfix {


    static int prec(char ch){
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
        }

        static boolean isOperand(char ch){
        if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'){
            return true;
        }
        return false;
        }

    static boolean isOperator(char ch){
        if(ch == '+' || ch == '-' || ch == '*'){
            return true;
        }
        return false;
    }


    public static void main(String[] args){

        Stack st = new Stack(50);
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("expression "+str);
        int i=0;

        while(i<str.length()) {
            //System.out.printf("%c", str.charAt(i));

            if (isOperand(str.charAt(i))) {
                System.out.printf("%c", str.charAt(i));
            } else if (str.charAt(i) == '(') {
                st.push(str.charAt(i));
            } else if(str.charAt(i) == ')'){
                while (!st.isEmpty()  && st.peek() != '('){
                    char c = st.pop();
                    System.out.printf("%c", c);
                }

                st.pop(); //remove ( from stack
            }else {
                while (!st.isEmpty() && prec(str.charAt(i)) < prec(st.peek())) {
                    char c = st.pop();
                    System.out.printf("%c", c);
                }
                st.push(str.charAt(i));
            }

            i++;
        }

        while(!st.isEmpty()){
            char c = st.pop();
            System.out.printf("%c",c);
        }


    }
}
