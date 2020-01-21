package com.sbms.pack.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbms.pack.exceptions.ApplicationException;
import com.sbms.pack.exceptions.BadRequestException;
import com.sbms.pack.exceptions.NotFoundException;
import com.sbms.pack.model.Pack;
import com.sbms.pack.parameter.PackParameter;
import com.sbms.pack.service.IPackService;

/**
 * Pack rest controller
 * 
 * @author DPraveen
 *
 */
@RestController
@RequestMapping("/api/v1/pack")
public class PackController {

	@Autowired
	private IPackService packService;

	/**
	 * Creates a new pack
	 * 
	 * @param packParameter pack parameter
	 * @return Pack
	 */
	@PostMapping("/save")
	public Pack createPack(@RequestBody(required = true) PackParameter packParameter) {

		if (StringUtils.isBlank(packParameter.getPackId())) {
			throw new BadRequestException("Pack Id is mandatory.", HttpStatus.BAD_REQUEST);
		}
		validateParameters(packParameter);
		try {
			return packService.save(packParameter);
		} catch (Exception e) {
			throw new ApplicationException("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Updates a pack based
	 * 
	 * @param packID        the pack id
	 * @param packParameter pack parameter
	 * @return updated pack
	 */
	@PutMapping("/update/{packId}")
	public ResponseEntity<Pack> update(@NotNull @PathVariable(value = "packId", required = true) String packId,
			@RequestBody(required = true) PackParameter packParameter) {

		validateParameters(packParameter);
		try {
			Pack pack = packService.getPackById(packId);
			pack.setPackId(packId);
			pack.setPackName(packParameter.getPackName());
			pack.setPackType(packParameter.getPackType());
			Pack updatedpack = packService.update(pack);
			return new ResponseEntity<Pack>(updatedpack, HttpStatus.OK);
		} catch (Exception e) {
			throw new ApplicationException("Pack with pack id (" + packId + ") not found.", HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Retrive's a single pack
	 * 
	 * @param packId the pack id
	 * @return a single pack
	 */
	@GetMapping("/get/{packId}")
	public Pack getPackById(@NotNull @PathVariable(value = "packId", required = true) String packId) {
		try {
			return packService.getPackById(packId);
		} catch (Exception e) {
			throw new NotFoundException("Given pack id (" + packId + ") not exist in the system",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Get all the packs
	 * 
	 * @return list of packs
	 */
	@GetMapping("/getall")
	public List<Pack> getAllPacks() {
		try {
			return packService.getAllPacks();
		} catch (Exception e) {
			throw new ApplicationException("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Deletes a pack
	 * 
	 * @param packId the pack id
	 * @throws Exception
	 */
	@DeleteMapping("/delete/{packId}")
	public ResponseEntity<String> delete(@NotNull @PathVariable(value = "packId", required = true) String packId)
			throws Exception {
		try {
			Pack pack = packService.getPackById(packId);
			if (pack != null) {
				packService.delete(pack);
				return new ResponseEntity<String>(HttpStatus.OK);
			} else {
				throw new NotFoundException("Given pack id (" + packId + ") not exist in the system",
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			throw new ApplicationException("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private void validateParameters(PackParameter packParameter) {

		if (StringUtils.isBlank(packParameter.getPackName())) {
			throw new BadRequestException("Pack name is mandatory.", HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isBlank(packParameter.getPackType())) {
			throw new BadRequestException("Pack type is mandatory.", HttpStatus.BAD_REQUEST);
		}

	}
}
