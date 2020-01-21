package com.sbms.pack.parameter;

import java.io.Serializable;

/**
 * 
 * @author DPraveen
 *
 */
public class PackParameter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String packId;
	private String packName;
	private String packType;

	/**
	 * @return the packId
	 */
	public String getPackId() {
		return packId;
	}

	/**
	 * @param packId the packId to set
	 */
	public void setPackId(String packId) {
		this.packId = packId;
	}

	/**
	 * @return the packName
	 */
	public String getPackName() {
		return packName;
	}

	/**
	 * @param packName the packName to set
	 */
	public void setPackName(String packName) {
		this.packName = packName;
	}

	/**
	 * @return the packType
	 */
	public String getPackType() {
		return packType;
	}

	/**
	 * @param packType the packType to set
	 */
	public void setPackType(String packType) {
		this.packType = packType;
	}

}
