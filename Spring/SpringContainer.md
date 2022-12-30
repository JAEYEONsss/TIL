# Spring Container

## ApplicationContext : 스프링 컨테이너
* 스프링컨테이너를 이용해서 DI 가능
* 스프링 컨테이너는 @Configuration이 붙은 class를 설정(구성) 정보로 사용한다. 여기서 @Bean이라 적힌 메소드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다. 이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라한다.
* 스프링 빈은 @Bean이 붙은 메소드의 명을 스프링 빈의 이름으로 사용한다.
* 스프링 빈은 applicationContext.getBean() 매소드를 이용해서 찾을 수 있다.
