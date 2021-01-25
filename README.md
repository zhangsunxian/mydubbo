## 技术栈：

springboot+dubbo+zookeeper+mybatis+mysql



## 搭建笔记：

### 1.整合dubbo+zookeeper配置注意事项：

- 启动顺序：双击zookeeper的bin文件夹下的zkServer.cmd，启动provider服务，在启动comsumer服务

- application.yml中没有dubbo相关的代码提示：

  ​	注意groupId为com.alibaba.boot

  ```java
  <dependency>
      <groupId>com.alibaba.boot</groupId>
      <artifactId>dubbo-spring-boot-starter</artifactId>
      <version>0.2.0</version>
  </dependency>
  ```

  

  

  



### 2.整合mybatis+mysql配置注意事项：



​	需要显式地配置mapper文件映射的xml文件路径：

```java
mybatis.mapper-locations=classpath*:mapper/*xml
```