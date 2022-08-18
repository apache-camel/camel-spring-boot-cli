Spring Boot command line features for [Apache Camel](https://github.com/apache-camel/camel).

To install, make sure you have [Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/cli.html)

    $ sdk install springboot

To verify

    $ spring version
    Spring CLI v2.7.3
    
To install Spring Camel plugin

    $ spring install org.apache.camel.springboot:camel-spring-boot-cli:0.0.1

To run

    $ spring camel run app.groovy