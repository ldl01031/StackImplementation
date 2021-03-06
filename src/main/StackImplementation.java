import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Array;

//import java.util.LinkedList;

public class StackImplementation<T> {

    private static final int INITIAL_SIZE = 2;
    //private LinkedList _linkedList = new LinkedList();
    //private T[] _array = new T[INITIAL_SIZE];
    private T[] _array;// = (T[])Array.newInstance(StackImplementation.class, INITIAL_SIZE);
    //T[] array = (T[])Array.newInstance(cls, d1);
    private int _currentSize = INITIAL_SIZE;
    private int _currentPointer = -1;
    private Class<T> _instantiatedClass;

    @SuppressWarnings("unchecked")
    StackImplementation(Class<T> instantiatedClass) {
        _instantiatedClass = instantiatedClass;
        _array = (T[]) Array.newInstance(_instantiatedClass, INITIAL_SIZE);
    }

    public void Push(T value) {
        ///_linkedList.add(value);
        if (_currentPointer == _currentSize - 1) {
            _array = ResizeArray(_array);
            _currentSize = _array.length;
            Push(value);
        } else {
            _array[++_currentPointer] = value;
        }
    }

    public T Peek() {
        return _array[_currentPointer];
    }

    public T Pop() throws OperationNotSupportedException {
//        if (Count() < 1) {
//            throw new OperationNotSupportedException("Cannot Pop from an empty stack.");
//        int returnValue = (int) _linkedList.getLast();
//        _linkedList.removeLast();
//        return returnValue;
        if (_currentPointer < 0)
            throw new OperationNotSupportedException("Cannot Pop from an empty stack.");
        T result = Peek();
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

    private T[] ResizeArray(T[] array) {
        int newSize;
        int currentSize = array.length;
        newSize = currentSize * 2;
        //T[] newArray = new T[newSize];
        //T[] newArray = (T[]) Array.newInstance(StackImplementation.class, newSize);
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) Array.newInstance(_instantiatedClass, newSize);
//    private T[] _array = (T[])Array.newInstance(StackImplementation.class, INITIAL_SIZE);
//        for (int i = 0; i < array.length; i++) {
//            newArray[i] = array[i];
//        }
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }
}
