package net.juby.brewnotes;

/**
 * @author Andrew
 *
 */
public class Yeast extends Ingredient {
	private boolean isDry;

	/**
	 * @param id
	 *            database id of this yeast strain
	 * @param name
	 *            name of this yeast strain
	 * @param notes
	 *            notes on this yeast strain
	 * @param isDry
	 *            denotes whether this is dry or wet yeast
	 */
	public Yeast(int id, String name, String notes, boolean isDry) {
		super(id, name, notes, 0);
		this.isDry = isDry;
	}
	
	/**
	 * @return whether the yeast is dry
	 */
	public boolean isDry() {
		return isDry;
	}

	/**
	 * @param isDry
	 *            whether the yeast is dry
	 */
	public void setDry(boolean isDry) {
		this.isDry = isDry;
	}
}
