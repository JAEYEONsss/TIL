# 스프링 시큐리티 with JWT _ LoginSuccessHandler, JWTUtil

## LoginSuccessHandler - 역할
* AuthenticationHandler 인터페이스를 구현한 클래스입니다.
* 로그인 성공 시 이뤄져야 할 작업들을 처리한 클래스입니다.

```java
@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        Optional<Member> find = memberRepository.findByMemberId(authentication.getName());
        Member member = find.orElseThrow(() -> new IllegalArgumentException("해당 아이디는 존재하지 않습니다."));

        MemberReturnDto memberReturnDto = MemberReturnDto.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .nickName(member.getNickName())
                .address(member.getAddress())
                .sex(member.getSex())
                .discountPrice(member.getDiscountPrice())
                .build();

        Map<String, Object> claim = Map.of("id", authentication.getName());

        String accessToken = jwtUtil.generateToken(claim, 1000);
        String refreshToken = jwtUtil.generateToken(claim, 3000);

        redisTemplate.opsForValue().set("RT_" + authentication.getName(), refreshToken, 180, TimeUnit.SECONDS);

        Gson gson = new Gson();

        String sendData = gson.toJson(Map.of("info", memberReturnDto, "accessToken", accessToken, "refreshToken", refreshToken));

        try {
            response.getWriter().println(sendData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
```

* memberRepository에서 회원 정보를 가져와서 로그인 성공 시 반환 할 정보를 Dto를 이용해서 반환합니다.

* 사용자 정보를 담아서 JWT 를 생성합니다.
* 로그인이 정상적으로 처리되면, access token, refresh token, 회원 정보를 클라이언트 사이드에게 응답합니다.

## JWTUtil - 역할
* JWT를 생성하고, 유효성 검증을 하는 역할입니다.
* JWT에 대한 설명은 [내가 이해한 SpringSecurity](https://github.com/JAEYEONsss/TIL/blob/main/Spring/SpringSeucurity.md)에 작성해두었습니다.

```java
public String generateToken(Map<String, Object> valueMap, int days) {

        //header 부분
        Map<String, Object> headers = new HashMap<>();
        headers.put("type", "JWT");
        headers.put("algo", "HS256");

        //payload 부분 설정
        Map<String, Object> payloads = new HashMap<>();
        payloads.putAll(valueMap);

        int time = (1) * days;

        String jwtStr = Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(time).toInstant()))
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                .compact();

        return jwtStr;
    }//token 생성
```

* jwt의 타입의 토큰 타입은 JWT 입니다.
* JWT를 생성할 때, 사용하는 해싱 알고리즘입니다. 이것은 토큰을 검증할 때, 사용하는 서명 부분에서 이용됩니다. 해당 코드에서는 HS256 암호화 알고리즘을 사용해서 토큰을 제작했습니다.
* 헤더, 클레임, 발급시각, 만료시각, 서명을 이용해서 JWT를 생성하고 있습니다.