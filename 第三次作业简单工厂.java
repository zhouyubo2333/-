public interface Operation {
    public double getResult(double numberA,double numberB) throws Exception;
}

public class Add implements Operation{
 
   

    public double getResult(double numberA, double numberB) {

 
        return numberA + numberB;
    }

}
 
 

public class Sub implements Operation{
 
    

    public double getResult(double numberA, double numberB) {

        return numberA-numberB;
    }

}
 
 

public class Mul implements Operation{
 
    

    public double getResult(double numberA, double numberB) {
        
        return numberA * numberB;
    }

}
 
 

public class Div implements Operation {
 
    
    public double getResult(double numberA, double numberB) throws Exception {
        if (numberB == 0) {

            throw new Exception("除数不能为0！");
        }

        return numberA / numberB;
    }

}

public class EasyFactory {
 
   

    public static Operation createOperation(String name) {

        Operation operationObj = null;
        switch (name) {
 
            case "+":
               operationObj = new Add();
                break;

            case "-":
                operationObj = new Sub();
                break;

            case "*":
                operationObj = new Mul();
                break;

            case "/":
                operationObj = new Div();
                break;
        }

        return operationObj;
    }

}

public class Client {

 
    public static void main(String[] args) throws Exception {

 
       Operation add = EasyFactory.createOperation("+");

        Operation sub = EasyFactory.createOperation("-");

        Operation mul = EasyFactory.createOperation("*");

        Operation div = EasyFactory.createOperation("/");

 
        System.out.println(add.getResult(1, 1));

        System.out.println(sub.getResult(1, 1));

        System.out.println(mul.getResult(1, 1));

        System.out.println(div.getResult(1, 1));
    }

}
