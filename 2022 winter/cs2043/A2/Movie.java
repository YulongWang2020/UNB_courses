package assn2.yw;

import java.security.InvalidParameterException;

public class Movie implements Comparable<Movie>{
	private final String title;
	private int totalPoints;
	private int numOfRates;
	private Double avgRate;

	Movie(String title){
		this.title = title;
		this.numOfRates = 0;
		this.totalPoints = 0;
	}

	public void addRate(int rate) throws InvalidParameterException {
		if(rate<=5 && rate >= 0) {
			totalPoints += rate;
			numOfRates += 1;
			calAvgRate();
		}else {
			throw new InvalidParameterException("Rate must be a integer from 0 to 5");
		}
	}

	public Double getAvgRate() {
		return avgRate==null ? null : Math.round(avgRate * 10.0) / 10.0;
	}

	public String getTitle() {
		return title;
	}

	private void calAvgRate(){
		if(numOfRates>0){
			this.avgRate = totalPoints/(numOfRates+0.0);
		}else{
			this.avgRate = null;
		}
	}

	public void clearRates(){
		this.numOfRates = 0;
		this.totalPoints = 0;
		this.calAvgRate();
	}

	@Override
	public int compareTo(Movie other) {
		return other.getAvgRate().compareTo(this.getAvgRate());
	}

	@Override
	public String toString() {
		return getTitle() + (avgRate==null ? "" : ", Avg Rating: " + getAvgRate());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Movie)) {
			return false;
		}

		Movie c = (Movie) obj;
		return c.getTitle().equals(this.title);
	}

	public Movie clone() {
		Movie copy = new Movie(this.title);
		copy.totalPoints = this.totalPoints;
		copy.numOfRates = this.numOfRates;
		copy.avgRate = this.avgRate;
    	return copy;
    }
}
