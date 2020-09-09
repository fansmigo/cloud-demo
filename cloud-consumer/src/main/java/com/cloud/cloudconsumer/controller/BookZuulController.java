package com.cloud.cloudconsumer.controller;

import com.cloud.cloudconsumer.feignclient.BookService;
import com.cloud.cloudconsumer.pojo.Book;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookZuulController {

  @Autowired
  private BookService bookService;

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello(HttpServletRequest request) {
    System.out.println("这是响应端口：" + request.getServerPort());
    return "hello " + request.getServerPort();
  }

  @RequestMapping(value = "/consumer/findBook/{bookId}", method = RequestMethod.GET)
  public String findBook(@PathVariable(value = "bookId") Integer bookId) {
    // 调用book查找服务
    Book book = bookService.getBook(bookId);
    // 控制台输入，模拟进行书本查找
    System.out.println("cloud-consumer查找到的书籍ID为：" + book.getId() + ", 书名：" + book.getName());
    // 查找成功
    return "success";

  }
}
