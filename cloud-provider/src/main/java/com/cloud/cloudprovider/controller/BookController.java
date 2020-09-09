package com.cloud.cloudprovider.controller;

import com.cloud.cloudprovider.pojo.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public Book findBook(@PathVariable Integer bookId) {
    Book book = new Book();
    book.setId(bookId);
    book.setName("Spring Cloud");
    book.setAuctor("杨恩雄");
    System.out.println("我是cloud-provider的查找书籍");
    return book;
  }
}
