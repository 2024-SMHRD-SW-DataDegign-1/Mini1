package Mini1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MiniRank {

	private int ranking;
	private String id;
	private String name;
	private int score;

	Connection conn = null;
	PreparedStatement psmt = null;

	public MiniRank(int ranking, String id, String name, int score) {
		super();
		this.ranking = ranking;
		this.id = id;
		this.name = name;
		this.score = score;
	}

	public MiniRank() {
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}