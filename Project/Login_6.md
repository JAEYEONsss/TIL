# 스프링 시큐리티 with JWT _ TokenCheckFilter

## TokenCheckFilter의 역할
* 로그인은 회원의 인증 및 인가를 위한 기초 작업입니다.   
즉, 회원과 비회원의 서비스 사용 범위를 분리해야합니다. 따라서, 프로젝트에는 JWT를 통한 인증 및 인가를 도입했습니다.

* 프로젝트에서 로그인을 한 사용자만 사용할 수 있는 서비스는 요청 URL로 auth/~ 를 사용해야 합니다.

* auth/~로 시작하는 요청 URL은 TokenCheckFilter에서 요청을 가로채서 본인의 역할을 수행합니다.

* TokenCheckFilter의 역할은 Access Token의 유효성을 검사하는 것입니다.

## 필터 체인의 요청 가로채기란?
* 앞서 드린 설명에서 "auth/~로 시작하는 요청 URL은 TokenCheckFilter에서 요청을 가로채서 본인의 역할을 수행합니다" 라고 말씀 드렸습니다.

```java
if (!requestURI.startsWith("/auth/")) {
            filterChain.doFilter(request, response);
            return;
        }
```

* [로그인 구현과정-5](https://github.com/JAEYEONsss/TIL/blob/main/Paran/Login_5.md)을 정독하고 오신 분은 어떤 하나의 의문이 생기셨을 것이라고 생각합니다.

* "일련의 필터 체인이 순서있게 구성되어 있으면, 내가 요청을 보낼 때마다 필터는 요청을 가로채서 검사한다는 것인가?"

* 우선, 아닙니다. "auth/~로 시작하는 요청 URL은 TokenCheckFilter에서 요청을 가로채서 본인의 역할을 수행합니다." 이 말에 힌트가 있습니다.

```java
if (!requestURI.startsWith("/auth/")) {
            filterChain.doFilter(request, response);
            return;
        }
```

* 위의 코드는 TokenCheckFilter 클래스의 코드를 일부분 가져온 것입니다.

* "/auth 로 시작하지 않는 url은 해당 클래스를 건너 뛰어서 다음 필터로 이동하라"는 뜻입니다.

* 즉, 저희 서비스는 /auth/~ 로 되어있는 요청 url은 Access Token을 검사할 것입니다.

## TokenCheckFilter 동작

```java
private Map<String, Object> validAccessToken(HttpServletRequest request) throws AccessTokenException {

        String authorization = request.getHeader("Authorization");

        if (authorization == null || authorization.length() < 8) {
            throw new AccessTokenException(AccessTokenException.TOKEN_ERROR.UNACCEPT);
        }

        String tokenType = authorization.substring(0, 6);
        String tokenContent = authorization.substring(7);

        if (!tokenType.equalsIgnoreCase("Bearer")) {
            throw new AccessTokenException(AccessTokenException.TOKEN_ERROR.BADTYPE);
        }

        if (redisTemplate.opsForValue().get(tokenContent) != null) {
            throw new AccessTokenException(AccessTokenException.TOKEN_ERROR.LOGOUT);
        }

        try {
            Map<String, Object> tokenValue = jwtUtil.validateToken(tokenContent);

            return tokenValue;
        } catch (MalformedJwtException malformedJwtException) {
            throw new AccessTokenException(AccessTokenException.TOKEN_ERROR.MALFORM);
        } catch (SignatureException signatureException) {
            throw new AccessTokenException(AccessTokenException.TOKEN_ERROR.BADSIGN);
        } catch (ExpiredJwtException expiredJwtException) {
            throw new AccessTokenException(AccessTokenException.TOKEN_ERROR.EXPIRED);
        }

    }
```

* 총 6개의 Exception을 만들었고, 각각에 대해서 설명 드리겠습니다.

1. AccessTokenException.TOKEN_ERROR.UNACCEPT
    * request header에 Token이 없거나, Token 자체에 대한 오류가 있을 시에 발생됩니다.

2. AccessTokenException.TOKEN_ERROR.BADTYPE
    * Bearer 타입의 토큰이 아닐 시에 발생됩니다.

3. AccessTokenException.TOKEN_ERROR.LOGOUT
    * Logout 처리된 토큰을 사용한 경우에 발생됩니다.

4. AccessTokenException.TOKEN_ERROR.MALFORM
    * JWT의 형식이 헤더, 페이로드, 서명으로 구성되어있지 않거나, 인코딩이 잘못 되어있는 경우에 발생됩니다.

5. AccessTokenException.TOKEN_ERROR.BADSIGN
    * JWT에 서명이 올바르지 않게 되어있을 때, 발생됩니다.

6. AccessTokenException.TOKEN_ERROR.EXPIRED
    * 토큰의 유효 기간이 지났을 때, 발생됩니다.

<b>따로 Access Token과 관련된 Exception 클래스를 작성해서 사용했습니다.</b>

* 위의 6가지 exception에 걸리지 않으면 올바른 token으로 간주하고, 요청을 수행할 수 있도록 controller가 동작하게 됩니다.