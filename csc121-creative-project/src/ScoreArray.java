import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class ScoreArray {
private HighScore[] scores;
    
    public ScoreArray() {
        this.scores= new HighScore[5];
        
        this.scores[0]=new HighScore("xxx",0);
        this.scores[1]= new HighScore("xxx",0);
        this.scores[2]= new HighScore("xxx",0);
        this.scores[3]=new HighScore("xxx",0);
        this.scores[4]=new HighScore("xxx",0);
    }

    //returns the highest score in the array 
    public HighScore getHighest() {
    	int i =1;
    	HighScore highest = this.scores[0];
    	while (i < 5) {
    		if (highest.getScore()>this.scores[i].getScore()) {
    			
    		} else
    		{
    		highest=this.scores[i];	
    		}
    	
    	}
    	return highest;
    	
    	}
    
    //removes the highest score from the array
    public ScoreArray removeHighest() {
    	int i=0;
    	while(i < 5) {
    	if (this.getHighest()==this.scores[i]) {
    		this.scores[i]= new HighScore("xxx",0);
    	}
    	}
    	return this;
    }
    
    //sorts the ScoreArray from lowest to highest 
    public ScoreArray sort() {
    ScoreArray save = this;
    ScoreArray use = this;
    int i = 0;
    while (i <5) {
    	this.scores[i]= use.getHighest();
    	save= save.removeHighest();
    	use =save;
    	i=i+1;
    
    }
    	return this;
    }
    
    //returns the position that the score should be added to. If the score is lower than the high scores in the array, returns 6
    public int maybeScore(int score) {
    	int i= 0;
    	while (i<5) {
    		if (score>this.scores[i].getScore()) {
    			return i;
    		}
    		i=i+1;
    	}
    	return 6;
    }
    //adds the given score to this ScoreArray at the given position
    public ScoreArray addScore(int score, int pos, String name ) {
	   int i=pos+1;
	   HighScore save = this.scores[pos];
	   HighScore save2 = this.scores[pos];
	   
	   this.scores[pos]= new HighScore(name, score);
	   while(i<5) {
		   save2=this.scores[i];
		   this.scores[i]=save;
		   save = save2;
		   i=i+1;
				   
	   }
	   return this;
			   
   }
   
   /**
	 * saves the current HighScore list to a text file
	 */
	public void saveScore() { 
	    try {
	        
   	    PrintWriter pw = new PrintWriter(new File("output.txt"));
   	    
   	    for (HighScore hs : this.scores) {    // for-each
   	        hs.writeToFile(pw); 
   	    }
   	    int i=0;
   	    while (i<5) {  /*  hour = hour + 1    ====    hour += 1    =====    hour++   */
				pw.println(this.scores[i].getName() + ": " + this.scores[i].getScore());
		}
   	    
   	    pw.close();
	    } catch (IOException exp) {
	        System.out.println("Problem saving scores:" + exp.getMessage());
	    }
	}
	
	/**
	 * restores the state of the scores in the window from a text file
	 */
	public void loadScore() {
	    try {
	        Scanner sc = new Scanner(new File("output.txt"));
	       
	        
	        while (sc.hasNextInt()) {	            
	            HighScore hs = new HighScore(sc); 
	            if (this.maybeScore(hs.getScore())<6) {
					this.addScore(hs.getScore(), this.maybeScore(hs.getScore()), hs.getName());
				}
	            
	        }
	        
	        sc.close();
	    } catch (IOException exp) {
	        System.out.println("Problem loading scores: " + exp.getMessage());
	    } 
	    
	    
	}
    
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(scores);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreArray other = (ScoreArray) obj;
		return Arrays.equals(scores, other.scores);
	}
    
    

}