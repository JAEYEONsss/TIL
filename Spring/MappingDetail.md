# 요청 매핑 자세히
<b>지난 Mapping TIL보다 자세한 내용이 있고, 중복되는 내용은 포함하지 않았음</b>  

## PathVariable 사용
```java
  @GetMapping("/mapping/{userId}")
  public String mappingPath(@PathVariable("userId") String data) {
      log.info("mappingPath userId={}", data);
      return "ok";
  }
```
실행 - http://localhost:8080/mapping/user1  
* url에 식별자를 넣어서 사용 가능하게 한다.
* @PathVariable()에 있는 이름과 경로 상에 있는 식별자가 동일하면  @PathVariable() 내에 이름 생략 가능함  
예시)
```java
  @GetMapping("/mapping/{userId}")
  public String mappingPath(@PathVariable String userId) {
      log.info("mappingPath userId={}", userId);
      return "ok";
  }
```

## PathVariable 다중 사용
```java
@GetMapping("/mapping/users/{userId}/orders/{orderId}")
  public String mappingPath(@PathVariable String userId, @PathVariable Long
  orderId) {
      log.info("mappingPath userId={}, orderId={}", userId, orderId);
      return "ok";
  }
```
* url에 식별자를 여러 개 넣어도 사용 가능함

## 특정 파라미터 조건 매핑

```java
@GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }
```

* url에 파라미터로 mode=debug 를 넣어야 사용 가능함  
* 예시) http://localhost:8080/mapping-param?mode=debug

## 특정 헤더 조건 매핑
```java
@GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }
```
* http header에 mode = debug를 넣어야 사용 가능함