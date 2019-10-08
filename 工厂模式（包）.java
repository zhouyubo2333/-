package cn.text1;
import org.zero01.operation.Operation;
public interface Factory {
    public Operation createOperation() ;
}
package cn.text2;
public class AddFactory implements Factory{

 
    public Operation createOperation() {

        System.out.println("?┏，：????");

        return new Add();
    }

}
package cn.text3;
     public class SubFactory implements Factory{

 
    public Operation createOperation() {

        System.out.println("??，：????");

        return new Sub();
    }

}

package cn.text4;
public class Client {

 
    public static void main(String[] args) throws Exception {


        Factory addFactory = (Factory) Class.forName("org.zero01.factory.AddFactory").newInstance();

        Factory subFactory=(Factory) Class.forName("org.zero01.factory.SubFactory").newInstance();


        Operation add = addFactory.createOperation();

        Operation sub = subFactory.createOperation();

 
        System.out.println(add.getResult(1, 1));

        System.out.println(sub.getResult(1, 1));
    }

}