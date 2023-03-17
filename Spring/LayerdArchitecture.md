# 내가 이해한 Spring 계층

<img width="1637" alt="스프링 계층 구조" src="https://user-images.githubusercontent.com/87291052/225894404-bc188a81-c445-4261-a13f-eadf99986711.jpeg">

* Client : Application을 사용하는 사용자가 있는 계층
* Controller : Client에서 보낸 요청을 받고, 응답을 하는 계층
* Service : Controller에서 받은 요청을 처리하는 계층. 즉, 비즈니스 로직을 포함하고    있는 계층이다.
* Repository : DB에 접근해서 값을 처리하는 계층

## 계층 분리의 이유?
* 각 계층에서 하나의 동작에만 집중해서, 결과물의 품질을 높이기 위해서이다. 
  즉, 단일 책임 원칙을 적용했기 때문이다.

## 계층 간 데이터 전달
### ORM
* Object-relational mapping (객체 관계 매핑)의 줄임말이다.
    * 객체는 객체대로 설계하고, 관계형 데이터베이스는 관계형 데이터베이스대로 설계한다.
    * ORM 프레임워크가 중간에서 매핑해준다.

### Hibernate
* ORM 프레임 워크

### JPA
* 자바 진영의 ORM 기술 표준으로, 인터페이스 모음이다.
    ### JPA의 사용 이유
    1. SQL 중심적인 개발에서 객체 중심으로 개발
    2. 생산성 향상
    3. 유지보수성 향상

### DTO
* Data Transfer Object의 줄임말이다.
* Entity는 DB와 1대1 연결된 객체이다. 즉, entity 객체에는 DB에 있는 정보와 관련된 필드가 존재하는 것이다.   
하지만, 그 중에는 외부에 노출시킬 필요가 없는 필드도 존재할 수 있다.   
이 때, 사용되는것이 Dto이다. 외부에 노출시키기 민감한 자료는 숨기고, 필수적인 정보만 client단에 노출 시킬 수 있는 필드만 갖고있는 객체이다.

<img width="1637" alt="스프링 계층 구조" src="https://user-images.githubusercontent.com/87291052/225900462-0042152c-147b-419f-9556-f1a8ebdd9df3.jpeg">
<center><b>그림 1</b></center>

<img width="1637" alt="스프링 계층 구조" src="<img width="1637" alt="스프링 계층 구조" src="https://user-images.githubusercontent.com/87291052/225899906-d7ae0bb7-4d6f-41ef-a037-7240be426aa0.jpeg">
<center><b>그림 2</b></center>

1. 그림 1의 경우에는 Controller 계층까지 Dto가 전달되고 있다.
2. 그림 2의 경우에는 Service 계층까지 Dto가 전달되고 있다.


### 1의 장점
- Service 계층에서 Entity를 바로 받게 함으로써, Service 계층은 Entity에만 의존할 수 있어서, 코드 재사용성이 높아진다는 장점이 있음
   
### 1의 단점
- Controller 계층에서 Dto -> Entity 변환 과정이 일어나면서 비즈니스 로직이 발생하고, 단일 책임 원칙이 깨진다.

### 2의 장점
- JPA에서 Lazy 조회 시 LayInitializationException에 노출 위험을 줄여준다.

### 2의 단점
- Service 계층이 특정 Dto에 의존하게 되기 때문에, 여러 종류의 컨트롤러에서 해당 서비스를 사용할 수 없을 수도 있기 때문에 코드 재사용성이 떨어짐

### 정리
* 각 방식의 장단점을 고려해서 프로젝트의 목적에 맞게 선택해서 사용하면 된다.