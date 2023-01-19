# 실행 / 테스트의 분리된 환경

* 테스트 케이스를 진행한 이후에 사용한 데이터는 초기화 되는 것이 이상적이다.   
하지만, 외부 db를 사용하는 환경에서는 번거로움을 요구한다.   
이 때, 어플리케이션 실행 환경과 테스트 실행 환경을 다르게 설정하면 두 실행 환경의 분리가 가능하다.  
   

## 원리
* 실행 환경 차이
    * 어플리케이션 실행
        * main 디렉토리의 resource를 적용
    * 테스트 실행
        * test 디렉토리의 resource를 적용 (디렉토리가 없으면 만들자)

## 분리 방법
1. test 디렉토리에 resource 디렉토리를 만듦
2. data source 설정을 in memory로 변경한다.

예시
```java
spring:
  datasource:
    url: jdbc:h2:mem:test
    username: sa
    password:
    driver-class-name: org.h2.Driver

  jpa:
    hibernate:
      ddl-auto: create
    properties:
      hibernate:
        format_sql: true

  logging.level:
    org.hibernate.SQL: debug
    org.hibernate.type: trace

```

## 알아둬야 할 것
* 스프링 부트는 datasource 설정이 없으면 기본적으로 메모리 db를 사용한다.  
 즉, 내가 설정을 굳이 안해도 된다.

 ```java
spring:
#  datasource:
#    url: jdbc:h2:mem:test
#    username: sa
#    password:
#    driver-class-name: org.h2.Driver
#
#  jpa:
#    hibernate:
#      ddl-auto: create
#    properties:
#      hibernate:
#        format_sql: true

  logging.level:
    org.hibernate.SQL: debug
    org.hibernate.type: trace


```