package com.sbms.pack.service;

import java.util.List;

import com.sbms.pack.model.Pack;
import com.sbms.pack.parameter.PackParameter;

/**
 * 
 * @author DPraveen
 *
 */
public interface IPackService {

	/**
	 * Saves pack details
	 * 
	 * @param packParameter
	 * @return
	 * @throws Exception
	 */
	public Pack save(PackParameter packParameter) throws Exception;

	/**
	 * Updates a pack
	 * 
	 * @param pack
	 * @return
	 * @throws Exception
	 */
	public Pack update(Pack pack) throws Exception;

	/**
	 * Deletes a pack
	 * 
	 * @param pack
	 * @throws Exception
	 */
	public void delete(Pack pack) throws Exception;

	/**
	 * Get's all the pack details
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Pack> getAllPacks() throws Exception;

	/**
	 * Get's a single pack detail
	 * 
	 * @param packId
	 * @return
	 * @throws Exception
	 */
	public Pack getPackById(String packId) throws Exception;

}
