# @RequestMapping annotation
```java
    @RequestMapping(value = "/new-form", method = "RequetsMethod.GET")
    public String newForm() {
        ```
    }   
```
* URL을 controller 내의 method와 mapping할 때 사용하는 annotation이다.
* value => mapping 되는 URL / method => HTTP method
* Class level, Method level 모두 적용이 가능하다

# @GetMapping, @PostMapping
```java
    @GetMapping("/new-form")
    public String newForm(){
        ```
    }

    @PostMapping("/another-form")
    public String anotherForm(){
        ```
    }
```

* RequestMapping의 경우에는 method를 지정하지 않으면 Get, Post method의 관계없이 모든 요청을 받을 수 있는 위험성이 존재한다.

* 위의 GetMapping, PostMapping annotation을 사용하면 이름에 나타나있는 요청만 받을 수 있기 때문에 코드 작성자의 의도대로 코드가 동작할 수 있다.

* Get, Post 뿐만 아니라 Put, Delete 등 다른 annotation도 존재한다.