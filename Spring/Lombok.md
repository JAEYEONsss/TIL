#  Lombok이란?
* 코드 작성 시 getter, setter 처럼 기본적으로 작성해야 하는 코드를 직접 작성하지 않고 사용할 수 있도록 해주는 라이브러리  

* 어노테이션 기반으로 코드를 자동완성해주는 라이브러리    
## 코드 예시 (Getter, Setter 작성)

```Java
public class HelloLombok {
    private String name;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("hello");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
```

## 코드 예시 (Lombok 사용)
```Java
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("hello");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
```
* 위 코드 블록에서 볼 수 있듯이 훨씬 간결한 코드 작성이 가능해진다.