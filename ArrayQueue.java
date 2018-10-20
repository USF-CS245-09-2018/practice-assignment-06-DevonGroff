// ArrayQueue must implement the interface defined in the file Queue.java, specifically the functions: enqueue, dequeue and empty

public class ArrayQueue implements Queue
{
	// Data Members
	private Object array[];
	private int defaultSize = 100;
	private int head;
	private int tail;
	private int size;

	// Default Constructor.
	ArrayQueue() 
	{
		array = new Object[defaultSize];
		head = 0;
		tail = 0;
		size = defaultSize;
	}

	// Adds an element to the queue.
	public void enqueue(Object elem) 
	{
		// Conditional to check if the queue is full.
		if ((tail + 1) % size == head) 
		{
			growQueue();
		}
		
		// Adds an element to the queue.
		array[tail] = elem;
		tail = (tail + 1) % size;
	}

	// Removes an element from the queue.
	public Object dequeue() 
	{
		Object arrayValue;

		// Conditional to check if queue is empty.
		if (head == tail)
		{
			return null;
		}

		// Removes an element from the queue.
		arrayValue = array[head];
		head = (head + 1) % size;
		return arrayValue;
	}

	// Checks if the queue is empty.
	public boolean empty() 
	{
		return head == tail;
	}

	// Expands the size of the queue (if needed).
	protected void growQueue() 
	{
		Object newArray[];

		newArray = new Object[size * 2];

		// For loop to add items to the new array.
		for (int i = 0; i < size; i++)
		{
			newArray[i] = array[i];
		}

		array = newArray;
		size = size * 2;
	}
}