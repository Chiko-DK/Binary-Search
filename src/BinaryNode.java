
public class BinaryNode<T> {
	T data;
	BinaryNode <T> left;
	BinaryNode <T> right;


	public BinaryNode (T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public BinaryNode<T> getLeft () { 
		return this.left; 
	}
	
	public BinaryNode<T> getRight () { 
		return this.right; 
	}
	
	public T getData() {
		return this.data;
	}
	
}
