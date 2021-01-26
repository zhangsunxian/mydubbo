## 技术栈：

springboot+dubbo+zookeeper+mybatis+mysql



## 搭建笔记：

### 1.整合dubbo+zookeeper配置注意事项：

- 启动顺序：双击zookeeper的bin文件夹下的zkServer.cmd，启动provider服务，在启动comsumer服务
- application.yml中没有dubbo相关的代码提示：

- pom文件：

```java
<!--注意groupId为com.alibaba.boot-->
<dependency>
    <groupId>com.alibaba.boot</groupId>
    <artifactId>dubbo-spring-boot-starter</artifactId>
    <version>0.2.0</version>
</dependency>

<!--注意zookeeper需要两个 -->
<dependency>
    <groupId>org.apache.zookeeper</groupId>
    <artifactId>zookeeper</artifactId>
    <version>3.4.10</version>
</dependency>
<dependency>
    <groupId>com.101tec</groupId>
    <artifactId>zkclient</artifactId>
    <version>0.10</version>
    <exclusions>
        <exclusion>
            <artifactId>zookeeper</artifactId>
            <groupId>org.apache.zookeeper</groupId>
        </exclusion>
    </exclusions>
</dependency>    
```

- application.yml或者application.properties


```yml
#服务端
dubbo:
  application:
    name: dubbo-order-provider
  registry:
    address: zookeeper://127.0.0.1:2181
  protocol:
    name: dubbo
    port: 20881
```

```yml
#客户端
dubbo:
  application:
    name: dubbo-consumer
  registry:
    address: zookeeper://127.0.0.1:2181
```



### 2.整合mybatis+mysql配置注意事项：

- pom文件：

  ```java
  <!--mysql-->
  <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.11</version>
  </dependency>
  <!--druid连接池-->
  <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.1.10</version>
  </dependency>
  <!--mybatis-->
  <dependency>
      <groupId>org.mybatis.spring.boot</groupId>
      <artifactId>mybatis-spring-boot-starter</artifactId>
      <version>1.3.2</version>
  </dependency>
  ```

- application.yml或者application.properties

  ```java
  #mysql
  spring.datasource.username=root
  spring.datasource.password=123456
  spring.datasource.url=jdbc:mysql://106.15.63.194:3306/shop?useUnicode=true&characterEncoding=utf-8
  spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
  
  #mybatis
  mybatis.mapper-locations=classpath*:mapper/*xml
  ```

  



### 3.整合swagger注意事项：

- pom.xml配置

```
<!--springfox swagger官方Starter-->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
<!-- 不加会报错误:Failed to start bean 'documentationPluginsBootstrapper'... -->
<dependency>
    <groupId>org.springframework.plugin</groupId>
    <artifactId>spring-plugin-core</artifactId>
    <version>2.0.0.RELEASE</version>
</dependency>
```

- Swagger2Config设置：

  ```java
  @Configuration
  public class Swagger2Config {
  
      public Docket createRestApi() {
          return new Docket(DocumentationType.SWAGGER_2)
                  .apiInfo(apiInfo())
                  .select()
                  .apis(RequestHandlerSelectors.basePackage("com.xxxx.controller"))
                  .paths(PathSelectors.any())
                  .build();
      }
  
      private ApiInfo apiInfo() {
          return new ApiInfoBuilder()
                  .title("SwaggerUI演示")
                  .description("restful 风格接口")
                  .contact(new Contact("macro", null, null))
                  .version("1.0")
                  .build();
      }
  }
  ```

- 访问地址： http://localhost:8082/swagger-ui/ 

