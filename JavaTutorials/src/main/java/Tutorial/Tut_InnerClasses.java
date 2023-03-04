package Tutorial;

class OuterClass{
    void printMessage(){
        System.out.println("Inside the Outer Class");
    }

    class InnerClass{
        void print(){
            System.out.println("Inside the Inner Class");
        }
    }
}
public class Tut_InnerClasses {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        outerClass.printMessage();
        innerClass.print();
    }
}
