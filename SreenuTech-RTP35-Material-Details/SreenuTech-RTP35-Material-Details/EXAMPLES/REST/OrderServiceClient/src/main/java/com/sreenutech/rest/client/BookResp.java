package com.sreenutech.rest.client;

import java.util.List;

public class BookResp {
	
	private List<Books> book;

	public List<Books> getBook() {
		return book;
	}

	public void setBook(List<Books> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookResp [book=");
		builder.append(book);
		builder.append("]");
		return builder.toString();
	}
	
	

}
