package com.cloud.cloudprovider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import redis.clients.jedis.Jedis;

public class JedisTest {

  public static void main(String[] args) {
    // 登录本地的Redis
    Jedis jedis = new Jedis("localhost");
    jedis.auth("123456");
    // 将数据保存为hash类型
    Map<String, String> data = new HashMap<String, String>();
    data.put("name", "fanyutao");
    data.put("age", "29");
    data.put("company", "suning");

    jedis.hmset("person_test", data);
    // 查询hash类型的数据
    List<String> dbDatas = jedis.hmget("person_test", "name", "age");
    for (String dbData : dbDatas) {
      System.out.println("hash类型输出：" + dbData);
    }

    /* ================分隔线=================== */

    // 将数据保存为set类型
    jedis.sadd("person_test_ids", "1", "2");
    // 查询数据
    Set<String> dbDatasSet = jedis.smembers("person_test_ids");
    for (String dbData : dbDatasSet) {
      System.out.println("set类型输出：" + dbData);
    }
  }

}
