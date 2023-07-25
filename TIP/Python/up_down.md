# python 대/소문자 변경
* 어떤 문자(열)이 있을 때, 여러가지 경우에 맞춰서 대/소문자로 변경해야 할 경우가 있다.

##  upper() -> 모든 알파벳을 대문자로 변환
```python
alpha = "abcd"
beta = "a1b2c3"
gamma = "abc-def ghi"

print(alpha.upper())
print(beta.upper())
print(gamma.upper())

# ABCD
# A1B2C3
# ABC-DEF GHI
```

## capitalize() ->  맨 첫 글자만 대문자로 변경
```python
alpha = "abcd"
beta = "a1b2c3"
gamma = "abc-def ghi"

print(alpha.capitalize())
print(beta.capitalize())
print(gamma.capitalize())

# Abcd
# A1b2c3
# Abc-def ghi
```

## title() -> 알파벳 외의 문자(숫자, 특수기호, 공백 등)로 나눠져 있는 영단어의 첫 글자를 모두 대문자로 변경

```python
alpha = "abcd"
beta = "a1b2c3"
gamma = "abc-def ghi"

print(alpha.title())
print(beta.title())
print(gamma.title())

# Abcd
# A1B2C3
# Abc-Def Ghi
```

## lower() -> 모든 알파벳을 소문자로 변경
```python
alpha = "abcd"
beta = "a1b2c3"
gamma = "abc-def ghi"

print(alpha.lower())
print(beta.lower())
print(gamma.lower())

# abcd
# a1b2c3
# abc-def ghi
```