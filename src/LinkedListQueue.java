//Drew Isaacson
public class LinkedListQueue<Type>
{
	private Node<Type> first, current;
	private int size = 0;

	public LinkedListQueue()
	{
		first = null;
	}

	public boolean enqueue(Type obj)
	{

		Node<Type> node = new Node<Type>(obj, null);

		if (first == null)
		{
			first = node;
		}
		else
		{
			current = first;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(node);
		}
		size++;
		return true;

	}

	public Type dequeue()
	{
		if (size == 0)
			throw new EmptyQueueException("The LinkedListQueue is empty.");
		else
		{
			Node<Type> result = first;
			first = first.getNext();
			size--;
			return result.getData();
		}
	}

	public Node<Type> getFirst()
	{
		return first;
	}

	public int size()
	{
		return size;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}
}

