// ArrayStack must implement the interface defined in the file Stack.java, specifically the functions push, pop, peek and empty

public class ArrayStack implements Stack
{
	// Data Members.
	public int defaultSize = 100;
	private Object array[];
	private int stackTop;	   
	private int size;	   

	// Default Constructor.
	public ArrayStack() 
	{
		array = new Object[defaultSize];
		stackTop = 0;
		size = defaultSize;
	}

	// Adds an item to the stack.
	public void push(Object item) 
	{
		// Conditional to grow stack if too small to add item.
		if (stackTop == size)
		{
			growStack();
		}

		// Pushes item to the stack.
		array[stackTop] = item;
		stackTop++;
	}

	// Removes an item from the stack.
	public Object pop() 
	{	
		if (stackTop > 0)
		{
			return array[--stackTop];
		}

		else
		{
			return null; 
		}
	}

	// Checks the item at the top of the stack.
	public Object peek()
	{
		return array[stackTop];
	}

	// Empties the stack.
	public boolean empty() 
	{
		return stackTop == 0;
	}

	// Increases the size of the stack.
	protected void growStack() 
	{
		Object newArray[];

		newArray = new Object[size * 2];
		for (int i = 0; i < size; i++)
		{
			newArray[i] = array[i];
		}
		array = newArray;
		size = size * 2;
	}
}