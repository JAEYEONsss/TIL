# JPA 사용 시, 쿼리 확인하기

* src/main/resources 디렉토리 아래에 application.properties 파일을 생성해서 아래 코드와 같이 입력해준다.

``` java
spring.jpa.show_sql=true //콘솔에서 쿼리 로그를 확인할 수 있게 만든다

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect // 출력되는 쿼리 로그를 MySQL 버전으로 변경해서 확인할 수 있게 만든다.
```