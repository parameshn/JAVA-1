package Generics;

interface Stack {
    public void push(int elt);

    public int pop();

    public boolean isEmpty();
}

class ArrayStack implements Stack {
    private final int MAX_ELEMENTS = 10;
    private int[] stack;
    private int index;

  public ArrayStack() {
    stack = new int[MAX_ELEMENTS];
    index = -1;
  }

  public void push(int elt) {
    if (index != stack.length - 1) {
      index++; 
      stack[index] = elt; // 2
  } else {
      throw new IllegalStateException("stack overflow");
  }
}

public int pop() {
  if (index != -1) {
    int res = stack[index];
    index--;
    return res;
  } else {
      throw new IllegalStateException("stack underflow");
  }
}

public boolean isEmpty() {
  return index == -1;
}
}
public class SynchronizedArrayStack implements Stack {
    private final Stack stack;

    public SynchronizedArrayStack(Stack stack) {
        this.stack = stack;
    }

    public synchronized void push(int elt) {
        stack.push(elt);
    }

    public synchronized int pop() {
        return stack.pop();
    }

    public synchronized boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String [] mai)
    {
        Stack threadSafe = new SynchronizedArrayStack(new ArrayStack());
    }
}
// https://chatgpt.com/c/672510b9-1224-800b-9ac9-0d2128d17af4