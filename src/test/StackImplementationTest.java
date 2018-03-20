import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class StackImplementationTest
{

    private static final int STACK_VALUE_1 = 42;
    private StackImplementation<Integer> myStack;

    @Before
    public void setUp() {
        myStack = new StackImplementation<>(Integer.class);
        //StackImplementationUsingDynamicArray<String> a =
        //        new StackImplementationUsingDynamicArray<>(String.class);
    }

    @Test
    public void HappyPathTest() throws OperationNotSupportedException {
        Integer stackValue1 = STACK_VALUE_1;
        myStack.Push(stackValue1);
        Integer result = myStack.Pop();
        Assert.assertEquals(stackValue1, result);
    }

    @Test
    public void PeekReturnsTopOfStackButLeavesDataOnStack() {
        myStack.Push(12);
        int result = myStack.Peek();
        Assert.assertEquals(12, result);
        Assert.assertEquals(1, myStack.Count());
    }

    @Test
    public void PushMultiplePopMultipleSucceeds() throws OperationNotSupportedException {
        int stackValue1 = STACK_VALUE_1;
        int stackValue2 = 43;
        int stackValue3 = 44;
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

    @Test
    public void CountMethodSucceeds() {
        Assert.assertEquals(0, myStack.Count());
        myStack.Push(1);
        myStack.Push(1);
        Assert.assertEquals(2, myStack.Count());
    }

    @Test
    public void ClearMethodClearsStackSucceeds() {
        Assert.assertEquals(0, myStack.Count());
        myStack.Push(1);
        Assert.assertEquals(1, myStack.Count());
        myStack.Clear();
        Assert.assertEquals(0, myStack.Count());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void PopMethodOnEmptyStackReturnsException() throws OperationNotSupportedException {
        myStack.Pop();
    }
}
