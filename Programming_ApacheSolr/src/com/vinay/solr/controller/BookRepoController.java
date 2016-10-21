package com.vinay.solr.controller;

import java.util.Iterator;

import com.vinay.solr.entity.Book;
import com.vinay.solr.repo.BookRepo;

public class BookRepoController extends BaseController {
	static BookRepo bookRepository = context.getBean(BookRepo.class);

	public static void main(String[] args) {
		createRepository();

		// For deleting one documents from repository
		// bookRepository.delete(new Book("1"));

		// For deleting all documents from repository
		// bookRepository.deleteAll();

		System.out.println("*******************************************");

		// For extracting documents from repository
		for (Iterator<Book> iterator = bookRepository.findAll().iterator(); iterator.hasNext();) {
			Book bookObject = iterator.next();
			System.out.println("Document Extracted : " + bookObject);
		}

		System.out.println("*******************************************");

		// For extracting document from repository by Book-Title
		// Book bookByTitle = bookRepository.findByBookTitle("Java-2");
		// System.out.println("Title :: " + bookByTitle.getTitle());
		// System.out.println("Desc :: " + bookByTitle.getDescription());
	}

	private static void createRepository() {
		for (int i = 1; i <= 5; i++) {
			Book bookObject = new Book();
			bookObject.setId(i + "");
			bookObject.setTitle("Java-" + i);
			bookObject.setDescription("Desc-" + i);
			bookRepository.save(bookObject);
			System.out.println("Document Added : " + bookObject);
		}
	}
}
