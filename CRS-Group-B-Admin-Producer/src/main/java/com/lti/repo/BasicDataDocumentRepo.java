package com.lti.repo;

import org.springframework.stereotype.Repository;

import com.lti.document.BasicDataDocument;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface BasicDataDocumentRepo extends MongoRepository<BasicDataDocument, String> {
    
}
