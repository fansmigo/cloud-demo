package com.cloud.cloudconsumer.feignclient;

import com.cloud.cloudconsumer.pojo.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "cloud-provider")
public interface BookService {

  @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
  Book getBook(@PathVariable(value = "bookId") Integer bookId);
}
