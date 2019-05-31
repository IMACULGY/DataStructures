import java.util.LinkedList;

//Drew Isaacson
public class Driver
{
	public static void main(String[] args)
	{
		LinkedListStack<String> stack = new LinkedListStack<String>();
		LinkedListQueue<String> queue = new LinkedListQueue<String>();
		BinaryTree<String> tree = new BinaryTree<String>();
		BinaryTree<Double> doubleTree = new BinaryTree<Double>();
		BinarySearchTree st = new BinarySearchTree();
		
		stack.push("foo");
		stack.push("bar");
		stack.push("baz");
		stack.push("qux");
		stack.push("five");
		
		queue.enqueue("foo");
		queue.enqueue("bar");
		queue.enqueue("baz");
		queue.enqueue("qux");
		queue.enqueue("five");
		
		tree.insert("A");
		tree.insert("B");
		tree.insert("C");
		tree.insert("D");
		tree.insert("E");
		
		st.insert(10);
		st.insert(9);
		st.insert(11);
		st.insert(12);
		st.insert(9.5);
		st.insert(10.5);
		
		System.out.println("Stack\n------------------");
		System.out.println("Size: " + stack.size() + "\n");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		try{System.out.println(stack.pop());}
		catch(EmptyStackException e) {System.out.println(e);}
		
		
		System.out.println("\nQueue\n------------------");
		System.out.println("Size: " + queue.size() + "\n");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		try{System.out.println(queue.dequeue());}
		catch(EmptyQueueException e) {System.out.println(e);}
		
		System.out.println("\nTree\n-------------------");
		System.out.println("Height: " + tree.height(tree.getRoot()));
		System.out.print("\nInorder: \n"); tree.printInorder(tree.getRoot());
		System.out.print("\nPreorder: \n"); tree.printPreorder(tree.getRoot());
		System.out.print("\nPostorder: \n"); tree.printPostorder(tree.getRoot());
		System.out.println("\nBreadth First: "); tree.printBreadthFirst();
		System.out.println("\n\nBreadth First Queue: "); tree.printBreadthFirstQ();
		
		System.out.println("\nSearch Tree\n------------------\n");
		System.out.println("Height: " + st.height(st.getRoot()));
		st.printBreadthFirst(); System.out.println("\n");
		st.printInorder(st.getRoot());
		System.out.println("\n" + st.search(10.0));
		System.out.println(st.search(9.0));
		System.out.println(st.search(9.1));
		
		//remove node with 0 children
		st.delete(12.0);
		st.printInorder(st.getRoot());
		
		//1 child
		st.delete(9.0);
		st.printInorder(st.getRoot());
		
		//2 children
		st.delete(10.0);
		st.printInorder(st.getRoot());
		
		System.out.println("\nBinaryTree to Search Tree\n-------------------");
		doubleTree.insert(1.0);
		doubleTree.insert(3.0);
		doubleTree.insert(2.0);
		doubleTree.insert(4.0);
		doubleTree.insert(6.0);
		doubleTree.printInorder(doubleTree.getRoot());
System.out.println("\nConverted Tree");
		BinarySearchTree convertedTree = BinarySearchTree.convert(doubleTree);
		convertedTree.printInorder(convertedTree.getRoot());
		
		LinkedList<Double> list = new LinkedList<Double>();
		list.add(1.0);
		list.add(2.0);
		list.add(3.0);
		list.add(4.0);
		list.add(6.0);
		list.add(7.0);
		
		double[] arr = {1.0, 2.0, 3.0, 4.0, 6.0, 7.0};
		
		System.out.println();
		BinarySearchTree ct2 = BinarySearchTree.convert(list);
		ct2.printInorder(ct2.getRoot());
		System.out.println();
		BinarySearchTree ct3 = BinarySearchTree.convert(arr);
		ct3.printInorder(ct3.getRoot());
		
		
	}
}
