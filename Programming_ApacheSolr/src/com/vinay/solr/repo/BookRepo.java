package com.vinay.solr.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.solr.repository.Query;

import com.vinay.solr.entity.Book;

public interface BookRepo extends CrudRepository<Book, Long> {

	// The Spring Data provides a number of inbuilt method for manipulating the
	// Data. We need not write the queries for basic data manipulation and
	// reading. It is achieved by extending the CrudRepository and declaring the
	// proper Generics as per the Entity, which in our case is the <Book, Long>

	@Query("title:?0")
	public Book findByBookTitle(String name);

}
