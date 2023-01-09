# Http 요청 메시지 로그로 확인

1. application.properties로 이동   

2. 밑에 코드 작성
```Java
logging.level.org.apache.coyote.http11=debug
```
3. 위와 같이 작성 후 코드 재 실행   
---
* 참고
- 운영 서버에 모든 요청 정보를 남기면 성능 저하가 발생할 수 있으므로 개발 단계에서만 적용하는게 낫다.