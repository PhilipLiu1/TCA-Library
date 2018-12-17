package com.tor.church.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tor.church.library.entity.BorrowRecord;

public interface BorrowRecordRepository extends MongoRepository<BorrowRecord, String> {

}
