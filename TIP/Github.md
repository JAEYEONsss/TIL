# github 수정 전으로 되돌리기
<img width="617" alt="스크린샷 2023-01-11 오후 6 50 25" src="https://user-images.githubusercontent.com/87291052/211773681-c8eabfee-11d3-4476-8e6c-b4b27c5c4546.png">

## 문제상황
- 웹에서 Spring 디렉토리 하위의 CheckLog.md 와 로컬에서 Spring/CheckLog.md의 내용이 다른 경우이다.

## 문제해결
```
git checkout $문제되는파일
```
- 로그 상에서 문제되는 파일을 checkout 해주면 파일 내용이 같아진다.