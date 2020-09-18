package heat.tracker.models;

public class LocationStats {
	private String city;
	private String state;
	private String country;
	private int latestTotalCases;
	private int diffFromPrevDay;
	
	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public int getLatestTotalCases() {
		return latestTotalCases;
	}

	public int getDiffFromPrevDay() {
		return diffFromPrevDay;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLatestTotalCases(int cases) {
		this.latestTotalCases = cases;
	}

	public void setDiffFromPrevDay(int diffFromPrevDay) {
		this.diffFromPrevDay = diffFromPrevDay;
	}

	@Override
	public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                '}';
    }
}