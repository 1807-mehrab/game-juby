package net.juby.brewnotes;

public class Malt extends Ingredient {
	private boolean isDry;

	/**
	 * @param id
	 *            database id of this malt extract
	 * @param name
	 *            name of this malt extract
	 * @param notes
	 *            notes on this malt extract
	 * @param weight
	 *            weight of this malt extract (in ounces)
	 * @param isDry
	 *            denotes whether this is dry or wet malt extract
	 */
	public Malt(int id, String name, String notes, double weight, boolean isDry) {
		super(id, name, notes, weight);
		this.isDry = isDry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
			StringBuilder ret = new StringBuilder();
			ret.append("Malt extract: " + getName() + "\n");
			ret.append("Weight used (in lbs): " + getWeight()/16.0 + "\n");
			ret.append("Notes: " + getNotes());
			
			return ret.toString();
	}

	/**
	 * @return whether the malt extract is dry
	 */
	public boolean isDry() {
		return isDry;
	}

	/**
	 * @param isDry
	 *            whether the malt extract is dry
	 */
	public void setDry(boolean isDry) {
		this.isDry = isDry;
	}

}
