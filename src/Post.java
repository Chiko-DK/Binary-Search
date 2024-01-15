
public class Post {
	
	private String title;
	private String clipFile;
	private String likes;

	public Post(String clipFile, String likes, String title) {
		this.title =title;
		this.clipFile =clipFile;
		this.likes = likes;
	}
	
		
	public String getTitle() {
		return this.title;
	}
	
	public String getClipFile() {
		return this.clipFile;
	}
	
	public String getLikes() {
		return this.likes;
	}
	
	public void printPost() {
		System.out.println("Title:" + getTitle() + "\nVideo: " + getClipFile() + "\nLikes: " + getLikes());
	}

}
