//Drew Isaacson
public class Node<Type> 
{
	private Type data;
	private Node<Type> next;
	
	public Node()
	{
		data = null;
		next = null;
	}
	
	public Node(Type obj)
	{
		data = obj;
		next = null;
	}
	
	public Node (Type obj, Node<Type> next)
	{
		data = obj;
		this.next = next;
	}
	
	public Type getData()
	{
		return data;
	}
	
	public Node<Type> getNext()
	{
		return next;
	}
	
	
	public void setData(Type newVal)
	{
		data = newVal;
	}
	
	public void setNext (Node<Type> newNext)
	{
		next = newNext;
	}
}