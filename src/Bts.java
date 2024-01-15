// Hussein's Code

public class Bts<T extends Comparable<T>> {
	
	BinaryNode<T> root;
	
	public Bts() {
		root = null;
	}
	
	
	// Insert function for the binary search tree
	public void insert(T d) {
		if(this.root == null) {
			root = new BinaryNode<T> (d);
		} else {
			insert(d, root);
		}
	}
	public void insert ( T d, BinaryNode <T> node ) { 
		if ((d.compareTo(node.data)) <= 0) { 
			if (node.left == null) {
				node.left = new BinaryNode<T> (d); 
			} else {
				insert (d, node.left); 
			} 
		} else { 
			if (node.right == null) {
				node.right = new BinaryNode<T> (d); 
			} else {
				insert (d, node.right); 
			} 	
		}
	}
	
	//Print function for the binary tree in an InOrder Traversal
	public void visit ( BinaryNode<T> node ) { 
		System.out.println (node.data);
	}
	public void inOrder () { 
		inOrder (root); 
	} 
	public void inOrder ( BinaryNode<T> node ) { 
		if (node != null) { 
			inOrder (node.getLeft ()); 
			visit (node); 
			inOrder (node.getRight ()); 
		}
	}
	
	//Find function for the binary search tree
	public BinaryNode<T> find ( T d ) { 
		if (root == null) {
			return null; 
		} else {
			return find (d, root); 
		} 
	}
	public BinaryNode<T> find ( T d, BinaryNode<T> node ) { 
		int cmp = d.compareTo (node.data);  
		if (cmp == 0) {
			return node; 
		} else if (cmp < 0) {
			return (node.left == null) ? null : find (d, node.left); 
		} else {
			return (node.right == null) ? null : find (d, node.right);
		}
	}
	
	//Delete function for the binary search tree
	public void delete (T d) {
		root = delete(d, root);
	}
	public BinaryNode<T> delete (T d, BinaryNode<T> node) {
		if(node == null) {
			return null;
		}
		int cmp = d.compareTo(node.data);
		if(cmp < 0) {
			node.left = delete(d, node.left);
		} else if (cmp > 0) {
			node.right = delete(d, node.right);
		} else if(node.left != null && node.right != null) {
			node.data = findMin(node.right).data;
			node.right = removeMin(node.right);
		} else {
			 if (node.left != null) {
				 node = node.left;
			 } else {
				 node = node.right;
			 }
		}
		return node;
	}
	//To find and return the minimum node in the binary tree
	public BinaryNode<T> findMin( BinaryNode<T> node ) {
		if (node != null) {
			while (node.left != null) {
				node = node.left;
			}
		}
		return node;
	}
	//To remove the node in the binary tree
	public BinaryNode<T> removeMin( BinaryNode<T> node ) {
		if (node == null) {
			return null; 
		} else if (node.left != null) { 
			node.left = removeMin (node.left); 
			return node; 
		} else {
			return node.right;
		}
	}

}


