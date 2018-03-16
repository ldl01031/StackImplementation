import java.util.LinkedList;

public class StackImplementation
{
    private LinkedList<Integer> _linkedList = new LinkedList<>();

    public void Push(int newValue) {
        _linkedList.add(newValue);
    }

    public int Pop() {
        int returnValue = _linkedList.getLast();
        _linkedList.removeLast();
        return returnValue;
    }
}
