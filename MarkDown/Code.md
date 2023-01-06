# 코드블록 삽입

## Inline code block
* ``으로 감싸면 inline code block 생성 가능

### 예시
` This is Inline Code Block`

--- 

## Code Block

* *```* 백틱 3회로 감싸서 사용하면 된다.
* *```사용 언어 이름* 사용한 언어 이름도 작성해주면 코드에 색상 하이라이팅이 들어간다

### 예시
```c++
#include <iostrean>
using namespace std;

int main()
{
    cout << "Hello World!" << endl;
}
```

* 스페이스바 4회 입력으로도 코드 블록 표현 가능