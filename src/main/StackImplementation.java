import javax.naming.OperationNotSupportedException;
//import java.util.LinkedList;

public class StackImplementation
{
    private static final int INITIAL_SIZE = 2;
    //private LinkedList _linkedList = new LinkedList();
    private int[] _array = new int[INITIAL_SIZE];
    private int _currentSize = INITIAL_SIZE;
    private int _currentPointer = -1;

    public void Push(int value) {
        ///_linkedList.add(value);
        if (_currentPointer == _currentSize - 1) {
            _array = ResizeArray(_array);
            _currentSize = _array.length;
            Push(value);
        } else {
            _array[++_currentPointer] = value;
        }
    }

    public int Peek()
    {
        return _array[_currentPointer];
    }

    public int Pop() throws OperationNotSupportedException {
//        if (Count() < 1) {
//            throw new OperationNotSupportedException("Cannot Pop from an empty stack.");
//        int returnValue = (int) _linkedList.getLast();
//        _linkedList.removeLast();
//        return returnValue;
        if (_currentPointer < 0)
            throw new OperationNotSupportedException("Cannot Pop from an empty stack.");
        int result = Peek();
        --_currentPointer;
        //_currentPointer = _currentPointer - 1;
        return result;
        //return _array[_currentPointer--];
    }

    public void Clear() {
        //_linkedList.clear();
        _currentPointer = -1;
    }

    public int Count() {
        //return _linkedList.size();
        return _currentPointer + 1;
    }

    private int[] ResizeArray(int[] array) {
        int newSize;
        int currentSize = array.length;
        newSize = currentSize * 2;
        int[] newArray = new int[newSize];
//        for (int i = 0; i < array.length; i++) {
//            newArray[i] = array[i];
//        }
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }
}
