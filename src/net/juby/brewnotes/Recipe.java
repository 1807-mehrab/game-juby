package net.juby.brewnotes;

import java.util.*;

public class Recipe {
	private String name, notes;
	private int boilTime, id;
	private Yeast yeastStrain;
	private ArrayList<Hops> hopVarieties;
	private ArrayList<Malt> maltExtracts;

	/**
	 * @param id
	 *            database id of this recipe
	 * @param name
	 *            name of this recipe
	 * @param notes
	 *            notes on this recipe
	 * @param boilTime
	 *            time (in minutes) to boil the wort
	 * @param yeastStrain
	 *            Yeast strain to be used in this recipe
	 * @param hopVarieties
	 *            Hops varieties to be used in this recipe
	 * @param maltExtracts
	 *            Malt extracts to be used in this recipe
	 */
	public Recipe(int id, String name, String notes, int boilTime, Yeast yeastStrain, ArrayList<Hops> hopVarieties,
			ArrayList<Malt> maltExtracts) {
		super();
		this.id = id;
		this.name = name;
		this.notes = notes;
		this.boilTime = boilTime;
		this.yeastStrain = yeastStrain;
		this.hopVarieties = hopVarieties;
		this.maltExtracts = maltExtracts;
	}

	/**
	 * @return the database id of this recipe
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name of this recipe
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the notes for this recipe
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the time (in minutes) to boil the wort
	 */
	public int getBoilTime() {
		return boilTime;
	}

	/**
	 * @param boilTime
	 *            the time (in minutes) to set this recipe's wort to boil
	 */
	public void setBoilTime(int boilTime) {
		this.boilTime = boilTime;
	}

	/**
	 * @return the Yeast strain to use for this recipe
	 */
	public Yeast getYeastStrain() {
		return yeastStrain;
	}

	/**
	 * @param yeastStrain
	 *            the Yeast strain to set for this recipe
	 */
	public void setYeastStrain(Yeast yeastStrain) {
		this.yeastStrain = yeastStrain;
	}

	/**
	 * @return the Hops varieties to use in this recipe
	 */
	public ArrayList<Hops> getHopVarieties() {
		return hopVarieties;
	}

	/**
	 * @param hopVarieties
	 *            the Hops varieties to set to be used in this recipe
	 */
	public void setHopVarieties(ArrayList<Hops> hopVarieties) {
		this.hopVarieties = hopVarieties;
	}

	/**
	 * @return the Malt extracts to be used in this recipe
	 */
	public ArrayList<Malt> getMaltExtracts() {
		return maltExtracts;
	}

	/**
	 * @param maltExctracts the Malt extracts to set to be used in this recipe
	 */
	public void setMaltExtracts(ArrayList<Malt> maltExtracts) {
		this.maltExtracts = maltExtracts;
	}

}
