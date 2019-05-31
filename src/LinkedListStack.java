
//Drew Isaacson
public class LinkedListStack<Type>
{
	private Node<Type> first, current, last;
	private int size = 0;

	public LinkedListStack()
	{
		first = null;
		last = null;
	}

	public boolean push(Type obj)
	{
		if (obj == null)
		{
			throw new NullPointerException();
		}
		else
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
			last = node;
			size++;
			return true;
		}
	}

	public Type pop()
	{
		if (size == 0)
			throw new EmptyStackException("The LinkedListStack is empty.");
		else
		{
			if (first.getNext() == null)
			{
				Type data = first.getData();
				size--;
				first = null;
				last = null;
				return data;
			}
			else
			{
				current = first;
				while (current.getNext().getNext() != null)
					current = current.getNext();
				current.setNext(null);
				size--;
				Type data = last.getData();
				last = current;
				return data;
			}
		}
	}

	public int size()
	{
		return size;
	}
}
