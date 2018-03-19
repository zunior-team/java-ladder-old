package ladder.domain;

public class User {

	private int col;
	private String name;

	public User(int col, String name) {
		this.name = name;
		this.col = col;
	}

	public int getCol() {
		return col;
	}

	public String getName() {
		return name;
	}

	public void increaseCol() {
		col++;
	}

	public void decreaseCol() {
		col--;
	}

	public Boolean isSameName(String userName) {
		return name.equals(userName);
	}

}
