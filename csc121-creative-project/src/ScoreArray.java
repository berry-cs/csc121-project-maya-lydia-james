import java.util.Arrays;

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
   public ScoreArray addScore(HighScore score, int pos ) {
	   int i=pos+1;
	   HighScore save = this.scores[pos];
	   HighScore save2 = this.scores[pos];
	   this.scores[pos]=score;
	   while(i<5) {
		   save2=this.scores[i];
		   this.scores[i]=save;
		   save = save2;
		   i=i+1;
				   
	   }
	   return this;
			   
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
