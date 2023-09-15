# 스프링 시큐리티 with JWT _ CustomSecurityConfig.Java

## 역할
* 보안 필터를 거치는 순서를 결정하기 위해서 사용합니다.
* 위의 역할을 수행하기 위해서 SecurityFilterChain을 이용합니다.
* 특정 url로 요청이 들어올 때, 필터가 동작하는 로직으로 구성했습니다.
* 각각의 보안 필터는 담당하는 Url이 아닐 경우에는 해당 필터를 거치지 않고, 다른 필터로 넘어갈 수 있도록 구성했습니다.

```java
@Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception{

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .userDetailsService(customUserDetailService)
                .passwordEncoder(passwordEncoder());

        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        http.authenticationManager(authenticationManager);
```
    
## AuthenticationManager
```java
authenticationManagerBuilder
                .userDetailsService(customUserDetailService)
                .passwordEncoder(passwordEncoder());
```

* <b>AuthenticationManager</b> : 스프링 시큐리티에서 인증을 담당하는 인터페이스입니다.   
AuthenticationManager는 <b>Authentication</b> 객체를 받아서 인증을 수행합니다.   
 Authentication은 인증을 요청한 사용자의 정보를 담고 있으며, 인증 결과를 담기 위한 <b>AuthenticationResult</b>를 반환합니다. AuthenticationResult는 인증이 성공한 경우, 인증된 Authentication을 반환하고, 실패하면 AuthenticationException을 발생시킵니다.

 * <b>userDetailService</b> : 간단하게 생각해서, 데이터베이스에 있는 사용자 정보를 가져와서 인증 작업을 수행하는 역할을 합니다.

 * <b>passwordEncoder</b> : 비밀번호가 외부에 노출되어도 바로 식별할 수 없도록 복호화하는 작업을 수행합니다.