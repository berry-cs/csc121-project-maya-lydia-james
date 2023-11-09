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
    public ScoreArray removeHighest() {
    	int i=0;
    	while(i < 5) {
    	if (this.getHighest()==this.scores[i]) {
    		this.scores[i]= new HighScore("xxx",0);
    	}
    	}
    	return this;
    }
    
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
