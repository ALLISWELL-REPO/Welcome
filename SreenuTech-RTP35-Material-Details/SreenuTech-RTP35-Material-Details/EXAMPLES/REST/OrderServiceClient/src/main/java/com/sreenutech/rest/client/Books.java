package com.sreenutech.rest.client;

public class Books {
	private String author;
	private String height;
	private String img_url;
	private String instock;
	private String isbn;
	private String language;
	private String name;
	private String pages;
	private String price;
	private String publication_year;
	private String weight;
	private String width;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getInstock() {
		return instock;
	}
	public void setInstock(String instock) {
		this.instock = instock;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublication_year() {
		return publication_year;
	}
	public void setPublication_year(String publication_year) {
		this.publication_year = publication_year;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	@Override
	public String toString() {
		return "Books [author=" + author + ", height=" + height + ", img_url=" + img_url + ", instock=" + instock
				+ ", isbn=" + isbn + ", language=" + language + ", name=" + name + ", pages=" + pages + ", price="
				+ price + ", publication_year=" + publication_year + ", weight=" + weight + ", width=" + width + "]";
	}
	
	
	
	
	

}
