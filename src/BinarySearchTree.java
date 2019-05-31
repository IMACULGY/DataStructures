import java.util.*;

public class BinarySearchTree
{
	public TreeNode<Double> root;

	// Custom methods for Binary Search Tree

	public BinarySearchTree()
	{
		root = null;
	}
	
	public BinarySearchTree(TreeNode<Double> root)
	{
		this.root = root;
	}

	public void insert(double value)
	{
		if (root == null)
			root = new TreeNode<Double>(new Double(value));
		else
			insertHelper(value, root);
	}

	private void insertHelper(double value, TreeNode<Double> root)
	{
		if (value <= root.getData().doubleValue())
		{
			if (root.getLeft() == null)
				root.setLeft(new TreeNode<Double>(value));
			else
				insertHelper(value, root.getLeft());
		}
		else
		{
			if (root.getRight() == null)
				root.setRight(new TreeNode<Double>(value));
			else
				insertHelper(value, root.getRight());
		}
	}

	public boolean search(double value)
	{
		TreeNode<Double> temp = root;

		while (temp != null)
		{
			if (value > temp.getData().doubleValue())
				if (temp.getRight() != null)
					temp = temp.getRight();
				else
					return false;
			else if (value < temp.getData().doubleValue())
				if (temp.getLeft() != null)
					temp = temp.getLeft();
				else
					return false;
			else
				temp = null;
		}
		return true;
	}

	private TreeNode<Double> findNode(double value)
	{
		TreeNode<Double> temp = root;

		while (temp != null)
		{
			if (value > temp.getData().doubleValue())
				if (temp.getRight() != null)
					temp = temp.getRight();
				else
					return null;
			else if (value < temp.getData().doubleValue())
				if (temp.getLeft() != null)
					temp = temp.getLeft();
				else
					return null;
			else
			{
				break;
			}
		}
		return temp;
	}

	private TreeNode<Double> findParent(TreeNode<Double> node)
	{
		TreeNode<Double> temp = root;
		TreeNode<Double> parent = null;

		while (temp != null)
		{
			if (node.getData().doubleValue() > temp.getData().doubleValue())
				if (temp.getRight() != null)
				{
					parent = temp;
					temp = temp.getRight();
				}
				else
					return null;
			else if (node.getData().doubleValue() < temp.getData().doubleValue())
				if (temp.getLeft() != null)
				{
					parent = temp;
					temp = temp.getLeft();
				}
				else
					return null;
			else
			{
				break;
			}
		}
		return parent;

	}
	
	public TreeNode<Double> findInorderSuccessor(TreeNode<Double> node)
	{
		if (node.getRight() != null)
		{
			TreeNode<Double> current = node.getRight(); 

	        while (current.getLeft() != null) { 
	            current = current.getLeft(); 
	        } 
	        return current; 
		}
		else
		{
			TreeNode<Double> next = null, current = root;
			while(current != null)
			{
				if (node.getData() < current.getData())
				{
					next = current;
					current = current.getLeft();
				}
				else if (node.getData() > current.getData())
				{
					current = current.getRight();
				}
				else
					break;
			}
			
			return next;
		}
	}
	
	public void delete(double value)
	{
		if (root == null)
			throw new IllegalArgumentException("aaaaTree is empty");
		if (!search(value))
			throw new IllegalArgumentException("Value does not exist in the tree.");
		else
		{
			TreeNode<Double> parent; // parent node of the one to be removed
			TreeNode<Double> node = findNode(value);
			parent = findParent(node);

			// 0 children
			if (node.getLeft() == null && node.getRight() == null)
			{
				if (node == root)
					root = null;
				else
				{
					if(node.getData() > parent.getData())
						parent.setRight(null);
					else
						parent.setLeft(null);
				}
				
				return;
			}
			// right child only
			else if (node.getLeft() == null && node.getRight() != null)
			{
				node.setData(node.getRight().getData());
				node.setRight(null);
				return;
			}
			// left child only
			else if (node.getLeft() != null && node.getRight() == null)
			{
				node.setData(node.getLeft().getData());
				node.setLeft(null);
				return;
			}
			// 2 children
			else
			{
				TreeNode<Double> successor = findInorderSuccessor(node);
				parent = findParent(successor);
				node.setData(successor.getData());
				
				if(successor.getData() > parent.getData())
					parent.setRight(null);
				else
					parent.setLeft(null);
				return;
			}
		}
	}

	public static BinarySearchTree convert(BinaryTree<Double> tree)
	{
		ArrayList<Double> inorder = new ArrayList<Double>();
		traverseArray(tree.getRoot(), inorder);
		Collections.sort(inorder);
		TreeNode<Double> rootNode = new TreeNode<Double>();
		copy(tree.getRoot(), inorder);
		BinarySearchTree bstree = new BinarySearchTree();
		bstree.root = tree.getRoot();
		return bstree;

	}
	
	public static BinarySearchTree convert(LinkedList<Double> list)
	{
		int length = list.size();
		BinarySearchTree result = new BinarySearchTree(LLtoTree(0, length-1 , list));
		return result;
		
	}
	
	
	
	public static BinarySearchTree convert(double[] arr)
	{
		LinkedList<Double> list = new LinkedList<Double>();
		for (int i = 0; i < arr.length; i++)
		{
			list.add(new Double(arr[i]));
		}
		return convert(list);
	}
	
	private static TreeNode<Double> LLtoTree(int beg, int end, LinkedList<Double> list)
	{
		if (beg > end)
			return null;
		
		int mid = (beg + end)/2;
		
		TreeNode<Double> root = new TreeNode<Double>(list.get(mid));
		
		TreeNode<Double> left = LLtoTree(beg, mid - 1, list);
		TreeNode<Double> right = LLtoTree(mid + 1, end, list);
		
		root.setLeft(left);
		root.setRight(right);
		
		return root;
	}

	private static void traverseArray(TreeNode<Double> root, ArrayList<Double> arr)
	{
		if (root == null)
			return;

		traverseArray(root.getLeft(), arr);

		arr.add(root.getData());

		traverseArray(root.getRight(), arr);
	}

	private static void copy(TreeNode<Double> root, ArrayList<Double> arr)
	{
		if (root == null)
			return;

		copy(root.getLeft(), arr);

		root.setData(arr.remove(0));

		copy(root.getRight(), arr);
	}

	// Taken from BinaryTree.java

	public int height()
	{
		return height(root);
	}
	
	public int height(TreeNode<Double> root)
	{
		if (root == null)
			return 0;

		int leftHeight = height(root.getLeft());
		int rightHeight = height(root.getRight());

		return 1 + Integer.max(leftHeight, rightHeight);

	}

	public void printInorder()
	{
		printInorder(root);
	}
	
	public void printPreorder()
	{
		printPreorder(root);
	}
	
	public void printPostorder()
	{
		printPostorder(root);
	}
	
	public void printInorder(TreeNode<Double> root)
	{
		if (root == null)
			return;

		printInorder(root.getLeft());

		System.out.println(root.getData());

		printInorder(root.getRight());
	}

	public void printPreorder(TreeNode<Double> root)
	{
		if (root == null)
			return;

		System.out.println(root.getData());

		printPreorder(root.getLeft());
		printPreorder(root.getRight());
	}

	public void printPostorder(TreeNode<Double> root)
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

	public void printGivenLevel(TreeNode<Double> root, int level)
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

		Queue<TreeNode<Double>> q = new Queue<TreeNode<Double>>();
		q.enqueue(root);
		q.enqueue(null);

		while (!q.isEmpty())
		{
			TreeNode<Double> temp = q.dequeue();

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

	public TreeNode<Double> getRoot()
	{
		return root;
	}

}
