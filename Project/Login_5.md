# 스프링 시큐리티 with JWT _ AutoLoginCheckFilter


### CustomSecurityConfig.java 코드 
```java
http.addFilterBefore(new AutoLoginCheckFilter("/autoLogin", jwtUtil, redisTemplate, memberRepository), TokenCheckFilter.class);
```
* http.addFilterBefore(a.class, b.class) : 스프링 시큐리티 필터 체인에서 b 필터 클래스 이전에 a 클래스가 실행될 수 있도록 등록하는 메소드입니다.

* 즉. 위의 코드에서는 TokenCheckFilter<b>(이후에 설명할 예정입니다)</b> 클래스 이전에 AutoLoginCheckFilter 클래스를 먼저 거칠 수 있도록 등록한 것입니다.

### addFilterBefore() 메소드를 사용한 이유?
1. 스프링 시큐리티에서 필요한 필터만 추가할 수 있습니다.   
    * Security 필터 체인에는 여러 개의 필터가 존재하는데, 이번 프로젝트에서 모든 필터를 사용해서 로그인 로직을 구현하지 않아도 되었습니다. 따라서, addFilterBefore() 메소드를 통해서 제가 사용할 필터를 추가했고, 직접 커스터마이징해서 코드 구현을 했습니다.   
    
2. 필터 처리의 순서를 지정할 수 있습니다.   
    * addFilterBefore() 메소드를 사용하여 필터 체인에 필터를 추가하면, 해당 필터의 위치를 원하는 위치에 추가할 수 있습니다. 이를 통해 필터 처리 순서를 조절할 수 있습니다. 제가 구성한 필터의 순서는 곧 설명드리도록 하겠습니다.

## CustomSecurityConfig 에서 필터 처리를 관리한 부분
```java
http.addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class);//...1

        http.addFilterBefore(
                tokenCheckFilter(jwtUtil, customUserDetailService),
                UsernamePasswordAuthenticationFilter.class
        );//...2

        http.addFilterBefore(new AutoLoginCheckFilter("/autoLogin", jwtUtil, redisTemplate, memberRepository), TokenCheckFilter.class);//...3
```

### 전체 필터 흐름도   
```
AutoLoginCheckFilter -> TokenCheckFilter -> LoginFilter -> UsernamePasswordAuthenticationFilter    
```

### 궁금할 수 있는 질문
1.
 ``` 
http.addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class)
``` 
이후에
```
 http.addFilterBefore(
                tokenCheckFilter(jwtUtil, customUserDetailService),
                UsernamePasswordAuthenticationFilter.class
        )
```
가 나왔음에도 불구하고 TokenCheckFilter -> LoginFilter -> UsernamePasswordAuthenticationFilter 의 순서로 필터 체인이 구성된 이유?    
* addFilterBefore는 동일 클래스 앞에 두 개의 다른 클래스를 설정했을 때, 필터 체인의 순서를 구성하는 우선 순위가 코드 진행 흐름에 따라 더 뒤에 있는 클래스를 필터의 앞 부분에 놓습니다. 따라서, 위의 순서가 되는 것입니다.

## AutoLoginFilter의 역할
* 우선, AutoLoginFilter의 역할을 알기 위해서는 프로젝트에서 사용자 인증의 과정을 알고 계셔야 합니다.

* 사용자는 로그인을 했을 때, 2개의 토큰을 받습니다. <b>1. Access Token</b> <b>2. Refresh Token</b>

* Access Token과 Refresh Token을 쉽게 이해하기 위해서는 놀이공원을 생각하시면 됩니다.
Access Token은 일일 입장권, Refresh Token은 1년 회원권의 개념으로 생각하시면 됩니다.   
놀이공원을 들어갈 때, 손님은 일일 입장권을 구매해서 입장권을 직원에게 확인을 받아야지만 놀이기구에 탑승할 수 있습니다.   
일일 입장권의 단점이라면, 1일 이라는 짧은 유효 기간안에 사용할 수 밖에 없다는 것입니다.   
하지만, 1년 회원권을 갖고 있는 손님은 일일 입장권의 유효기간이 지나도, 1년 회원권을 이용해서 일일 입장권을 다시 발급 받을 수 있고, 놀이 공원을 재밌게 즐길 수 있습니다.

* Access Token과 Refresh Token도 동일합니다.    
사용자는 Access Token을 이용해서 웹/앱 서비스를 사용할 권한을 확인받을 수 있고, Access Token의 유효기간이 지나면 Refresh Token을 통해서 Access Token을 다시 발급 받아서 서비스를 이용할 수 있습니다.

* 놀이공원으로 돌아가서 1년 회원권에 대해서 다시 생각해보겠습니다.   
만약, 어떤 한 손님이 1년 회원권이 만료되었음에도 불구하고, 만료된 1년 회원권을 직원에게 건네며 일일 입장권을 달라고 고집을 부립니다.   
이러한 경우에는 일일 입장권을 발급 받을 수 없고, 다시 1년 회원권을 구매해서 일일 입장권을 받아야 합니다.   

* Refresh Token 역시 마찬가지 입니다.    
클라이언트에서 유효 기간이 지난 Refresh Token을 서버로 보내면서 다시 Access Token을 받는 것은 불가능합니다.   
이 경우에는 로그인을 다시 해서 새로운 Refresh Token을 발급 받아야 합니다.

* 따라서, 기본적으로 Access Token과 Refresh Token의 유효 기간을 비교했을 때, Access Token의 유효 기간은 Refresh Token보다 상대적으로 짧습니다.

* AutoLoginFilter의 역할은 놀이공원의 직원과 동일하다고 생각하시면 됩니다.    
Access Token을 확인하고, Access Token의 유효기간이 만료 되었을 때, Refresh Token의 유효기간을 확인하고, Refresh Token의 유효기간이 지나지 않았을 경우에 Access Token을 다시 발급해주는 역할을 수행합니다.

