package stacks;

public class StackEx {

    int a[];
    int top=-1;

    StackEx(int size) {
        this.a = new int[size];
    }

    int push(int ele){
        top++;
        a[top]=ele;
        return 0;
    }

    int pop() {

        if(top != -1) {
            return a[top--];
        }else{
            System.out.println("StackEx is empty");
            return -1;
        }
    }

    int peek(){
        if(top == -1) {
            System.out.println("StackEx is empty");
            return -1;
        }
        return a[top];
    }

    public static  void main(String args[]){
        StackEx s = new StackEx(5);
        int ele;
        s.push(10);
        s.push(20);
        ele = s.pop();
        System.out.println("poped ele="+ele);
        ele = s.pop();
        System.out.println("poped ele="+ele);
        ele = s.pop();
        System.out.println("poped ele="+ele);
        ele = s.peek();
        System.out.println("peek ele="+ele);
        s.push(10);
        ele=s.peek();
        System.out.println("peek ele="+ele);
    }
}
