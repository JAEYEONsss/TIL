# Could not find method compile() 오류

## 문제 상황
* build.gradle에 dependencies를 설정할 때,
<img width="563" alt="스크린샷 2023-01-25 오후 6 26 10" src="https://user-images.githubusercontent.com/87291052/214526500-2c7bfade-63cc-48c4-af71-e3aebd24918c.png">
위와 같이 설정한 뒤 적용을 했는데
<img width="852" alt="스크린샷 2023-01-25 오후 6 26 36" src="https://user-images.githubusercontent.com/87291052/214526739-b5a39d59-f2e6-4c7c-9f25-ded54c29343d.png">
와 같은 오류가 발생했다.

## 문제 원인

<b>compile</b>, <b>runtime</b>, <b>testCompile</b>, <b>testRuntime</b>은 Gradle 4.10 (2018.08.27) 이후로 deprecated (더 이상 사용 x) 되었고, Gradle 7.0 (2021.04.09) 부터 삭제되었기 때문에 발생한 오류라고 한다.

## 문제 해결
* compile => implementation
* runtime => runtimeOnly
* testCompile => testImplementation
* testRuntime => testRuntimeOnly 로 변경해서 사용하면 된다.

<img width="635" alt="스크린샷 2023-01-25 오후 6 32 59" src="https://user-images.githubusercontent.com/87291052/214527809-e91a6658-b985-4a21-b2c5-7e66a12a9139.png">
위와 같이 변경 후 오류를 해결했다.