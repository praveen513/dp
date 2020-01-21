package com.sbms.pack.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sbms.pack.parameter.PackParameter;

/**
 * Model class for pack.
 * 
 * @author DPraveen
 *
 */
@Document
public class Pack implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String packId;
	private String packName;
	private String packType;

	private List<Module> module;

	public Pack() {
		super();
	}

	public Pack(PackParameter packParameter) {
		super();
		this.packId = packParameter.getPackId();
		this.packName = packParameter.getPackName();
		this.packType = packParameter.getPackType();
	}

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

	/**
	 * @return the module
	 */
	public List<Module> getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(List<Module> module) {
		this.module = module;
	}

}
