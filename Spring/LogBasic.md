# log 사용
- System.out.println()을 사용하지 않고 로그를 남길 수 있다.

```java
@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.trace("trace log={}", name);//log level = trace
        log.debug("debug log={}", name);// log level = debug
        log.info("info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);
        return "ok";
    }
}
```
## @RestController
- @Controller는 반환 값이 String이면 view 이름으로 인식해서 view를 찾는다.   
하지만, @RestController를 사용하면 return 값으로 바로 String 입력을 진행한다.

## slf4j 라이브러리
* 해당 라이브러리를 사용해서 로그를 기록한다.
* @Slf4j 어노테이션을 사용하면 log 변수를 선언하지 않고 바로 로그를 사용할 수 있다.

## 로그 레벨
로그 레벨을 설정해서 출력 범위를 다르게 할 수 있다.  
* 범위  
trace > debug > info > warn > error => trace가 출력 범위가 가장 넓고, error가 가장 좁다.  
* 설정
- application.properities애서  설정할 수 있다.
1. 패키지 레벨   
logging.level.a.b = trace 와 같이 설정할 수 있다.  
a.b 패키지와 하위 레벨의 로그 설정법임

2. 전체 레벨  
logging.level.root = info 와 같이 설정할 수 있다.  

## 로그 출력법
1. log.debug("data=" + data)  
2. log.debug("data={}", data)  
결론적으로 2번처럼 사용해야 한다.  
로그 출력 레벨을 info로 설정한 상황에서는  trace, debug가 출력되면 안된다.  
1번과 2번 둘 다 출력을 안하지만, 1번은 문자 연산을 진행한다. 즉, 1번은 연산을 진행하기 때문에 연산에 cpu, memory 할당을 해서 비효율적이다.
