//Drew Isaacson
public class TreeNode<Type>
{
	private Type data;
	private TreeNode<Type> left, right;
	
	public TreeNode() //default constructor should set global variables to NULL
	{
		data = null;
		left = null;
		right = null;
	}
	
	public TreeNode(Type obj) //constructor that initializes data to t
	{
		data = obj;
		left = null;
		right = null;
	}

	public TreeNode<Type> getLeft()
	{
		return left;
	}

	public void setLeft(TreeNode<Type> left)
	{
		this.left = left;
	}

	public TreeNode<Type> getRight()
	{
		return right;
	}

	public void setRight(TreeNode<Type> right)
	{
		this.right = right;
	}

	public Type getData()
	{
		return data;
	}

	public void setData(Type data)
	{
		this.data = data;
	}

}
