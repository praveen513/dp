package com.sbms.pack.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbms.pack.model.Pack;
import com.sbms.pack.parameter.PackParameter;
import com.sbms.pack.repository.IPackRepository;
import com.sbms.pack.service.IPackService;

/**
 * Service class for pack
 * 
 * @author DPraveen
 *
 */
@Service
public class PackService implements IPackService {

	@Autowired
	private IPackRepository packRepository;

	@Override
	public Pack save(PackParameter packParameter) {
		Pack pack = new Pack(packParameter);
		return packRepository.save(pack);
	}

	@Override
	public Pack update(Pack pack) {
		return packRepository.save(pack);
	}

	@Override
	public void delete(Pack pack) {
		packRepository.delete(pack);

	}

	@Override
	public List<Pack> getAllPacks() {
		return packRepository.findAll();
	}

	@Override
	public Pack getPackById(String packId) {

		Optional<Pack> pack = packRepository.findById(packId);
		if (pack.isPresent()) {
			pack.get();
		}
		return null;
	}

}
