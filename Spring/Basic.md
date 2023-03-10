# IoC, DI, 컨테이너

## IoC (제어의 역전, Inversion of Control)
* 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전 (IoC)이라고 한다.


## 프레임워크와 라이브러리 차이
* 프레임워크 : 본인이 작성한 어플리케이션 코드가 프레임워크에 의해 실행 되는 것. 즉, 어플리케이션 코드는 프레임워크 틀 안에서 수동적으로 동작하고, 프레임워크가 제어 흐름을 갖고 있음.
* 라이브러리 : 본인이 작성한 어플리케이션 코드를 본인이 직접 제어할 수 있음

## DI (의존관계 주입, Dependency Injection)
* 의존관계 : B 객체가 변경되었을 때, 그 변경이 A 객체에도 영향을 끼치는 관계
* 의존관계 주입 : 어플리케이션 실행 시점(run time)에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결 되는 것
* 정적인 클래스 의존관계 : 클래스가 사용하는 import 코드만 보고 의존관계를 쉽게 판단할 수 있다. 정적인 의존관계는 어플리케이션을 실행하지 않아도 분석할 수 있다.
* 동적인 객체 인스턴스 의존관계 : 어플리케이션 실행 시점에 실제 생성된 객체 인스턴스 참조가 연결된 의존관계이다.
    * DI를 통해서 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.

## 컨테이너
* 객체를 생성하고 관리하면서 의존관계를 연결해주는 것을 IoC 컨테이너 or DI 컨테이너라고 한다.