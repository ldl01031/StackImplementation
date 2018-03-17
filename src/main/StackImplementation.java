import javax.naming.OperationNotSupportedException;
import java.util.LinkedList;

public class StackImplementation {

    private LinkedList<Integer> _linkedList = new LinkedList<>();

    public void Push(int newValue) {
        _linkedList.add(newValue);
    }

    public int Pop() throws OperationNotSupportedException {
        if (Count() < 1) {
            throw new OperationNotSupportedException("Cannot Pop from an empty stack.");
        }

        int returnValue = _linkedList.getLast();
        _linkedList.removeLast();
        return returnValue;
    }

    public void Clear() {
        _linkedList.clear();
    }

    public int Count() {
        return _linkedList.size();
    }
}
