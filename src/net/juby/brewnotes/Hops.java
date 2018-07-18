/**
 * 
 */
package net.juby.brewnotes;

/**
 * @author Andrew
 *
 */
public class Hops extends Ingredient {
	private double alphaAcids;
	private int addTime;

	/**
	 * @param id
	 *            database id of this hop strain
	 * @param name
	 *            name of this hop strain
	 * @param notes
	 *            notes on this hop strain
	 * @param weight
	 *            weight of this batch hops in ounces
	 * @param alphaAcids
	 *            percentage of alphaAcids in this hop strain
	 * @param addTime
	 *            time (in minutes) to add this batch of hops after the boil has
	 *            begun
	 */
	public Hops(int id, String name, String notes, double weight, double alphaAcids, int addTime) {
		super(id, name, notes, weight);
		this.alphaAcids = alphaAcids;
		this.addTime = addTime;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("Hop name: " + getName() + "\n");
		ret.append("Weight used (in oz): " + getWeight() + "\n");
		ret.append("Percentage of alpha acids: " + alphaAcids + "\n");
		ret.append("Notes:" + getNotes());
		
		return ret.toString();
	}

	/**
	 * @return percentage of alpha acids in these hops
	 */
	public double getAlphaAcids() {
		return alphaAcids;
	}

	/**
	 * @param alphaAcids
	 *            new percentage of alpha acids
	 */
	public void setAlphaAcids(double alphaAcids) {
		this.alphaAcids = alphaAcids;
	}

	/**
	 * @return time (in minutes) to add this batch of hops after the boil has begun
	 */
	public int getAddTime() {
		return addTime;
	}

	/**
	 * @param addTime
	 *            time (in minutes) to add this batch of hops after the boil has
	 *            begun
	 */
	public void setAddTime(int addTime) {
		this.addTime = addTime;
	}

}
