package com.sbms.pack.model;

import java.io.Serializable;

/**
 * 
 * @author DPraveen
 *
 */
public class Module implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sourceOfCharge;
	private String SourceOfHealth;

	/**
	 * @return the sourceOfCharge
	 */
	public String getSourceOfCharge() {
		return sourceOfCharge;
	}

	/**
	 * @param sourceOfCharge the sourceOfCharge to set
	 */
	public void setSourceOfCharge(String sourceOfCharge) {
		this.sourceOfCharge = sourceOfCharge;
	}

	/**
	 * @return the sourceOfHealth
	 */
	public String getSourceOfHealth() {
		return SourceOfHealth;
	}

	/**
	 * @param sourceOfHealth the sourceOfHealth to set
	 */
	public void setSourceOfHealth(String sourceOfHealth) {
		SourceOfHealth = sourceOfHealth;
	}

}
