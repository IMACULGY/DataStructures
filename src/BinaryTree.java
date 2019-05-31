//Drew Isaacson
public class BinaryTree<Type>
{
	private TreeNode<Type> root;

	public BinaryTree() // default constructor should set root to NULL
	{
		root = null;
	}

	public BinaryTree(Type obj)
	{
		root = new TreeNode<Type>(obj);
	}
	
	public int height()
	{
		return height(root);
	}

	public int height(TreeNode<Type> root)
	{
		if (root == null)
			return 0;

		int leftHeight = height(root.getLeft());
		int rightHeight = height(root.getRight());

		return 1 + Integer.max(leftHeight, rightHeight);

	}

	public void insert(Type obj)
	{
		if (root == null)
		{
			root = new TreeNode<Type>(obj);
			return;
		}

		Queue<TreeNode<Type>> q = new Queue<TreeNode<Type>>();
		q.enqueue(root);

		while (!q.isEmpty())
		{
			TreeNode<Type> temp = q.dequeue();

			if (temp.getLeft() == null)
			{
				temp.setLeft(new TreeNode<Type>(obj));
				break;
			}
			else
				q.enqueue(temp.getLeft());

			if (temp.getRight() == null)
			{
				temp.setRight(new TreeNode<Type>(obj));
				break;
			}
			else
				q.enqueue(temp.getRight());
		}

	}

	public void printInorder(TreeNode<Type> root)
	{
		if (root == null)
			return;

		printInorder(root.getLeft());

		System.out.println(root.getData());

		printInorder(root.getRight());
	}

	public void printPreorder(TreeNode<Type> root)
	{
		if (root == null)
			return;

		System.out.println(root.getData());

		printPreorder(root.getLeft());
		printPreorder(root.getRight());
	}

	public void printPostorder(TreeNode<Type> root)
	{
		if (root == null)
			return;

		printPostorder(root.getLeft());
		printPostorder(root.getRight());

		System.out.println(root.getData());

	}

	public void printBreadthFirst()
	{
		for (int i = 1; i <= height(root); i++)
			printGivenLevel(root, i);
	}

	public void printGivenLevel(TreeNode<Type> root, int level)
	{
		if (root == null)
			return;

		if (level == 1)
			System.out.print(root.getData() + " ");
		else if (level > 1)
		{
			printGivenLevel(root.getLeft(), level - 1);
			printGivenLevel(root.getRight(), level - 1);
		}
	}

	public void printBreadthFirstQ()
	{
		if (root == null)
			return;

		Queue<TreeNode<Type>> q = new Queue<TreeNode<Type>>();
		q.enqueue(root);
		q.enqueue(null);

		while (!q.isEmpty())
		{
			TreeNode<Type> temp = q.dequeue();

			if (temp == null)
			{
				if (!q.isEmpty())
				{
					q.enqueue(null);
				}
			}
			else
			{
				if (temp.getLeft() != null)
					q.enqueue(temp.getLeft());
				if (temp.getRight() != null)
					q.enqueue(temp.getRight());

				System.out.println(temp.getData() + " ");
			}
		}
	}

	public TreeNode<Type> getRoot()
	{
		return root;
	}

}
