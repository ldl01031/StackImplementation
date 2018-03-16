import org.junit.Assert;
import org.testng.annotations.Test;

public class StackImplementationTest {

    @Test
    public void HappyPathTest()
    {
        int stackValue1 = 42;
        StackImplementation myStack = new StackImplementation();
        myStack.Push(stackValue1);
        int result = myStack.Pop();
        Assert.assertEquals(stackValue1, result);
    }

    @Test
    public void PushMultiplePopMultipleSucceeds(){
        int stackValue1 = 42;
        int stackValue2 = 43;
        int stackValue3 = 44;
        StackImplementation myStack = new StackImplementation();
        myStack.Push(stackValue1);
        myStack.Push(stackValue2);
        myStack.Push(stackValue3);
        int result = myStack.Pop();
        Assert.assertEquals(stackValue3, result);
        result = myStack.Pop();
        Assert.assertEquals(stackValue2, result);
        result = myStack.Pop();
        Assert.assertEquals(stackValue1, result);
    }
}
