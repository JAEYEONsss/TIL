# REST API와 RESTful API

* REST API란 REST를 기반으로 만들어진 API를 의미한다.

## REST 란?
* <b>Representational State Transfer</b> 의 약자로 자원을 정의하고, 자원에 대한 주소를 지정하는 방법 전반을 일컫는다.

1. Http URI를 통해 Resource를 명시한다.
2. Http method (get, post, put, delete, patch 등) 를 통해서 해당 자원 (URI)에 대한 CRUD operation을 적용하는 것을 의미

* Create: 데이터 생성 (post)
* Read: 데이터 조회(get)
* Update: 데이터 수정(put, patch)
* Delete: 데이터 삭제(delete)

## REST 구성 요소

1. <b>Resource</b>
    * http URI
2. <b>Verb (Resource에 대한 행위)</b> 
    * http method
3. <b>Representations (자원에 대한 행위의 내용)</b>
    * http message pay load

## REST의 특징
1. Server - Client
    * 서버는 API를 제공하고, 클라이언트는 사용자 인증 혹은 context (세션, 로그인 정보 ...)를 직접 관리하는 구조로 각각의 역할이 확실하게 구분되기 때문에 각 파트에서 개발할 내용, 관리 부분이 명확해지고 의존성이 줄어든다.

2. Stateless
    * 작업을 위한 상태정보를 따로 저장하고, 관리하지 않는다. 세션 정보나 쿠키정보를 별도로 저장하고 관리하지 않기 때문에 API 서버는 들어오는 요청만을 처리하기만 하면 된다. 덕분에 서비스의 자유도가 높아지고, 서버에서 불필요한 정보를 관리하지 않음으로써 구현이 단순해진다.

3. Uniform
    * URI로 지정한 Resoruce에 대한 조작을 통일되고 한정적인 인터페이스로 수행하는 아키텍쳐 스타일을 말한다.

4. Cacheable
    * REST는 http라는 기존 웹 표준을 그대로 사용하기 때문에, 웹에서 사용하는 기존 인프라를 그대로 활용 가능하다. 따라서, http가 가진 캐싱 기능을 적용 가능하다. http에서 사용하는 Last-Modified 태그, 혹은 E-Tag를 이용하면 된다.

5. Self-descriptiveness
    * REST API 메시지만 보고도 이를 쉽게 이해할 수 잇는 자체 표현 구조로 되어있다.

6. Layered Architecture
    * REST 서버는 다중 계층으로 구성될 수 잇으며 보안, 로드 밸런싱, 암호화 계층을 추가해 구조상의 유연성을 둘 수 있고, Proxy, gateway와 같은 네트워크 기반의 중간매체를 사용할 수 있도록 한다.

## REST의 장단점
### 장점
1. http 프로토콜의 인프라를 그대로 사용하므로 REST API 사용을 위한 별도의 인프라를 구축할 필요가 없다.
2. http 프로토콜을 따르는 모든 플랫폼에서 사용 가능하다.
3. Hypermedia api의 기본을 충실히 지키면서 범용성을 보장한다.
4. REST API 메시지가 의도하는 바를 명확하게 나타내므로 의도하는 바를 쉽게 파악할 수 있다.

### 단점
1. 표준이 존재하지 않기 때문에 정의가 필요하다.
2. http method 형태가 제한적이다.

## REST API란?
* REST의 원리를 따르는 API를 의미한다.

## REST API 설계 가이드
1. URI는 동사보다는 명사를 사용한다.
```
(O) : http://www.abc.com/test
(X) : http://www.abc.com/testing
```

2. 대문자보다는 소문자를 사용한다.
```
(O) : http://www.abc.com/test
(X) : http://www.abc.com/Test
```

3. 마지막에 '/'를 포함하지 않는다.
```
(O) : http://www.abc.com/test
(X) : http://www.abc.com/test/
```

4. 언더바 (_)대신 하이픈(-)을 사용한다.
```
(O) : http://www.abc.com/test-case
(X) : http://www.abc.com/test_case
```

5. 파일 확장자는 URI에 포함하지 않는다.
```
(O) : http://www.abc.com/test
(X) : http://www.abc.com/test.jpg
```

6. 행위를 포함하지 않는다.
```
(O) : http://www.abc.com/test
(X) : http://www.abc.com/delete/test
```

## RESTful 이란?
* REST의 원리를 따르는 시스템을 의미한다. 하지만, REST를 사용한 모든 것이 RESTful한 것은 아니다. 즉, 위에서 언급한 REST API 설계 가이드에 맞춘 시스템을 RESTful 하다고 말할 수 있다.   
예를들어, 모든 CRUD 기능을 POST로 처리하는 API 혹은 URI 규칙을 올바르게 지키지 않은 API는 RESTful 하다고 할 수 없다.