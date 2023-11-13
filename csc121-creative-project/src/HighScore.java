import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

/** represents a high score in the fruit game with the name of the player and the score they achieved*/
public class HighScore {

private String name;
private int score;
    
    public HighScore(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public HighScore(Scanner sc) {
    	this.score = sc.nextInt();
    	this.name = sc.nextLine();
    } 
    
    public void writeToFile(PrintWriter pw) {
    	pw.println(this.score + " " + this.name);
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

	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HighScore other = (HighScore) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
    
}
 