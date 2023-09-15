# 스프링 시큐리티 with JWT _ CustomUserDetailService, LoginFilter

## CustomUserDetailService - 역할
* 데이터베이스에서 사용자 정보를 가져오는 역할을 합니다.
* 가져온 사용자 정보를 통해서 인증 작업을 수행합니다.

## LoginFilter 역할
* 사용자가 입력한 정보를 기반으로 authentication 객체를 반환합니다.

## CustomSecurityConfig.java
```java
authenticationManagerBuilder
                .userDetailsService(customUserDetailService)
                .passwordEncoder(passwordEncoder());

AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        http.authenticationManager(authenticationManager);

        LoginFilter loginFilter = new LoginFilter("/login");
        loginFilter.setAuthenticationManager(authenticationManager);
```
* /login url로 올 경우 LoginFilter가 동작할 수 있도록 설정했습니다.

## CustomUserDetailService.java
```java
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> find = memberRepository.findByMemberId(username);

        Member member = find.orElseThrow(() -> new UsernameNotFoundException("해당 아이디는 존재하지 않습니다."));


        MemberLoadUserDto memberLoadUserDto = new MemberLoadUserDto(
                member.getMemberId(),
                member.getPassword(),
                true,
                List.of(new SimpleGrantedAuthority(member.getRole().name())
                ));

        return memberLoadUserDto;
    }

}
```

* 회원 관련 db를 관리하는 memberRepository를 주입받아서 db에 회원 정보가 있는지 판단합니다.

## LoginFilter.java
```java
@Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        if (request.getMethod().equalsIgnoreCase("GET")) {
            throw new UnavailableException("get method는 지원하지 않습니다");
        }

        Map<String, String> jsonData = parseRequestJson(request);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                jsonData.get("id"),
                jsonData.get("pwd")
        );

        return getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
    }
```

* UsernamePasswordAuthenticationToken은 인증 요청에 필요한 사용자 이름과 암호를 담는 클래스입니다.

## 인증 과정
* [로그인 구현과정-2](https://github.com/JAEYEONsss/TIL/blob/main/Paran/Login_2.md)에서 확인할 수 있듯이, AuthenticationManager는 userDetailService로 CustomUserDetailService를 받았고, LoginFilter 클래스에 set 되어있습니다.

* LoginFilter에서 사용자 입력 정보를 기반으로 authentication 객체 생성 ->   
 authenticationManger에게 authentication 객체 전달 ->    
 authenticatioManager는 CustomUserDetailService를 통해서 사용자 정보를 가져와서 인증 시작 ->   
 인증 성공 : 인증된 authentication 객체 반환   
 인증 실패 : authenticationException 발생