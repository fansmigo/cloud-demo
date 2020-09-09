package com.cloud.cloudprovider.controller;

import com.cloud.cloudprovider.pojo.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 当使用 @RestController 时，类中所有方法的 @ResponseBody 注解可以省略。
 */
@RestController
public class HelloWorldController {

  @GetMapping("/hello")
  public String hello(){
    return "Hello World !!!";
  }

  /**
   * 说明：@PathVariable("xxx")
   * 通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
   * 举例：@RequestMapping(value=”user/{id}/{name}”)
   * 请求路径：http://localhost:8080/hello/show5/1/james
   * @param personId
   * @return
   */
  @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public Person findPerson(@PathVariable("personId") Integer personId){
    Person p = new Person();
    p.setId(personId);
    p.setName("Crazy");
    p.setAge(30);
    System.out.println("我是端口8021！！！");
    return p;
  }
}
