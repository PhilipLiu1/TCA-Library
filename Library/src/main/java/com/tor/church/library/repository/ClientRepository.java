package com.tor.church.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tor.church.library.entity.Client;

public interface ClientRepository extends MongoRepository<Client, String> {
	
}
