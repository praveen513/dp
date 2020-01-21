package com.sbms.pack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sbms.pack.model.Pack;

/**
 * 
 * @author DPraveen
 *
 */
public interface IPackRepository extends MongoRepository<Pack, String> {

}
