
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User implements Comparable<User> {
	
	private String account;
	private String description;
	private List<Post> posts;
	

	public User(String account, String description) {
		this.account = account;
		this.description = description;
		this.posts = new ArrayList<>();
	}
	
	public String getAccount() {
		return this.account;
	}
	
	public String getDesc() {
		return this.description;
	}
	
	public void addPost(Post post) {
        this.posts.add(post);
    }

	public void printPosts() {
		Collections.reverse(posts);
		for (Post p: posts) {
			p.printPost();
		}
	}

	@Override
	public int compareTo(User o) {
		int result = this.account.compareTo(o.getAccount());
		return result;
	}
	
	public String toString() {
		String user = getAccount();
		return user;
	}
	
}
