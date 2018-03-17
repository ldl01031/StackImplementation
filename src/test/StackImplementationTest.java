import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class StackImplementationTest {

    private StackImplementation myStack;

    @Before
    public void setUp() {
        myStack = new StackImplementation();
    }

    @Test
    public void HappyPathTest() throws OperationNotSupportedException {
        int stackValue1 = 42;
        myStack.Push(stackValue1);
        int result = myStack.Pop();
        Assert.assertEquals(stackValue1, result);
    }

    @Test
    public void PushMultiplePopMultipleSucceeds() throws OperationNotSupportedException {
        int stackValue1 = 42;
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
