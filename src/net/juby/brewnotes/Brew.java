package net.juby.brewnotes;

import java.util.Date;

public class Brew {
	private User brewer;
	private int id;
	private Recipe recipe;
	private Date brewDate, secondaryDate, rackDate;
	private boolean isBottled, isKegged;
	private String notes;

	/**
	 * @param brewer
	 *            the User that brewed this brew
	 * @param id
	 *            database id for this brew
	 * @param recipe
	 *            the Recipe used for this brew
	 * @param brewDate
	 *            the Date that the brew occurred
	 * @param secondaryDate
	 *            the Date that the brew was racked to secondary (null if no
	 *            secondary was used)
	 * @param rackDate
	 *            the Date that the brew was bottled and/or kegged
	 * @param isBottled
	 *            denotes if the brew was bottled
	 * @param isKegged
	 *            denotes if the brew was kegged
	 * @param notes
	 *            notes about this brew
	 */
	public Brew(User brewer, int id, Recipe recipe, Date brewDate, Date secondaryDate, Date rackDate, boolean isBottled,
			boolean isKegged, String notes) {
		super();
		this.brewer = brewer;
		this.id = id;
		this.recipe = recipe;
		this.brewDate = brewDate;
		this.secondaryDate = secondaryDate;
		this.rackDate = rackDate;
		this.isBottled = isBottled;
		this.isKegged = isKegged;
		this.notes = notes;
	}

	/**
	 * @return the User that brewed this brew
	 */
	public User getBrewer() {
		return brewer;
	}

	/**
	 * @param brewer the User to set that brewed this brew
	 */
	public void setBrewer(User brewer) {
		this.brewer = brewer;
	}

	/**
	 * @return the Recipe used for this brew
	 */
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * @param recipe the Recipe to set for this brew
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	/**
	 * @return the Date that this brew occurred
	 */
	public Date getBrewDate() {
		return brewDate;
	}

	/**
	 * @param brewDate the Date to set for this brew
	 */
	public void setBrewDate(Date brewDate) {
		this.brewDate = brewDate;
	}

	/**
	 * @return the Date the brew was racked to secondary (null if no secondary was used)
	 */
	public Date getSecondaryDate() {
		return secondaryDate;
	}

	/**
	 * @param secondaryDate the Date to set for racking to secondary (null if no secondary was used)
	 */
	public void setSecondaryDate(Date secondaryDate) {
		this.secondaryDate = secondaryDate;
	}

	/**
	 * @return the Date the brew was bottled and/or kegged
	 */
	public Date getRackDate() {
		return rackDate;
	}

	/**
	 * @param rackDate the Date to set for bottling and/or kegging
	 */
	public void setRackDate(Date rackDate) {
		this.rackDate = rackDate;
	}

	/**
	 * @return if the brew was bottled
	 */
	public boolean isBottled() {
		return isBottled;
	}

	/**
	 * @param isBottled if the brew was bottled
	 */
	public void setBottled(boolean isBottled) {
		this.isBottled = isBottled;
	}

	/**
	 * @return if the brew was kegged
	 */
	public boolean isKegged() {
		return isKegged;
	}

	/**
	 * @param isKegged if the brew was kegged
	 */
	public void setKegged(boolean isKegged) {
		this.isKegged = isKegged;
	}

	/**
	 * @return the notes on this brew
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set for this brew
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the database id of this brew
	 */
	public int getId() {
		return id;
	}

}
