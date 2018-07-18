package net.juby.brewnotes;

/**
 * @author Andrew
 *
 */
abstract class Ingredient {
	private String name, notes;
	private int id;
	private double weight;

	/**
	 * @param id
	 *            database id of this ingredient
	 * @param name
	 *            name of this ingredient
	 * @param notes
	 *            notes on this ingredient
	 * @param weight
	 *            weight of this ingredient in ounces
	 */
	public Ingredient(int id, String name, String notes, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.notes = notes;
		this.weight = weight;
	}

	/**
	 * @return the database id of this ingredient
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @return the name of the ingredient
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            new name for this ingredient
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return notes on this ingredient
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes
	 *            new notes on this ingredient
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the weight in ounces
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set (in ounces)
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
