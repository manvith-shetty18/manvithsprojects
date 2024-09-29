package com.fsd2425.mongoapi.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Document(collection = "bookdb")

public class books {
	
    @Id  
    private String iSBN; 
    private String bookname;
    private String author;
    private String publisher;
    private float price;
    
    public books() {}

    public books(String iSBN, String bookname, String author, String publisher, float price) {
        this.iSBN = iSBN;
        this.bookname = bookname;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public String getIsbn() {
        return iSBN;
    }

    public void setIsbn(String isbn) {
        this.iSBN = isbn;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ("{\n\"ISBN\":\"" + this.iSBN +
                "\",\n\"BookName\":\"" + this.bookname +
                "\",\n\"Author\":\"" + this.author +
                "\",\n\"Publisher\":\"" + this.publisher +
                "\",\n\"Price\":\"" + price +
                "\"}");
    }
}
