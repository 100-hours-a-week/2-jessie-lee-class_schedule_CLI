# 1주차 CLI 과제 - 시간표

## 주제

학원의 시간표에 자녀를 직접 등록하는 프로그램입니다.

> 어머니가 피아노 학원을 하시는데 시간표 때문에 매 학기 힘들어하시는 모습을 보고 생각해보게 되었습니다.
> 
> 시간표를 학부모가 쉽게 등록할 수 있으면, 어머니와 학부모님들 모두 편해지실 것 같아 간단하게라도 제작해보게 되었습니다.

## 기능 구현 목록

1. 학부모 이름 입력받기 (`학부모 성함을 적어주세요.`)
    - 학부모 이름이 없는 경우 회원가입 (`현재 00학원의 회원이 아니십니다. 회원가입 하시겠습니까? (y/n)`)
        - y -> 자녀 이름 입력받기 (`학부모의 자녀로 등록할 아이(들)의 이름을 적어주세요. (ex. jiye, nix)`, 쉼표 기준으로 5명까지 받을 수 있음)
        - n -> 프로그램 종료
2. 현재 시간표를 보여준다.
      ```
            MON      TUE     WED     THU     FRI
      -------------------------------------------
      1시 |          jiye
      2시 |                          helen
      3시 | 
      4시 | rosy
      5시 | 
    
      ```
3. 자녀 이름 입력 받기 (`시간표를 등록할 아이의 이름을 적어주세요.`)
   - 아이 이름이 학부모 멤버에 등록되어 있지 않은 경우 (`아이가 현재 등록되어 있지 않습니다. 등록하시겠습니까? (y/n)`)
     - y -> 자녀 이름 입력받기 (`등록할 자녀의 이름을 입력해주세요. (ex. jiye, nix)`)
     - n -> 자녀 이름 다시 받기 (`자녀의 이름을 다시 입력해주세요.`)
4. 원하는 시간대 입력 받기 (`원하시는 요일과 시간을 올바른 형식으로 입력해주세요 (ex. 월-3시)`)
   - 원하는 시간대에 이미 이름이 있는 경우, Error 발생 후 재입력
5. 시간대에 학생 이름을 적은 후 프로그램 종료할건지 물어보기 (y/n)
---
- 모든 이름은 영어로 5글자 이하만 가능
  - 형식 어긋난 경우, `Error` 발생 후 재입력 (`영어로 5자 이하만 가능합니다. ex. lee`)

### 확장 가능성

- 관리자인지 물어보고, 관리자의 경우 시간표 수정도 가능하도록...

## 클래스 다이어그램
### 기획단계의 다이어그램
![classDiagram.jpg](image/classDiagram_draft.jpg)

### 구현 후 다시 작성한 다이어그램
![classDiagram.jpg](image/classDiagram.jpg)

## 예시 출력
```
학부모 성함을 적어주세요: jiye
현재 00학원의 회원이 아니십니다. 회원가입 하시겠습니까? (y/n): y
학부모의 자녀로 등록할 아이(들)의 이름을 적어주세요. (ex. jiye, nix): jiye, nix

안녕하세요. 00학원입니다 :)

    MON    TUE    WED    THU    FRI
----------------------------------
 1시 |                                        
 2시 |                                        
 3시 |                                        
 4시 |                                        
 5시 |                                        
시간표를 등록할 자녀의 이름을 입력해주세요: nix
원하시는 요일과 시간을 올바른 형식으로 입력해주세요 (ex. 월-3시): 월-2시

    MON    TUE    WED    THU    FRI
----------------------------------
 1시 |                                        
 2시 |    nix                                 
 3시 |                                        
 4시 |                                        
 5시 |                                        
프로그램을 종료하시겠습니까? (y/n): n
학부모 성함을 적어주세요: jiye

안녕하세요. 00학원입니다 :)

    MON    TUE    WED    THU    FRI
----------------------------------
 1시 |                                        
 2시 |    nix                                 
 3시 |                                        
 4시 |                                        
 5시 |                                        
시간표를 등록할 자녀의 이름을 입력해주세요: jiye
원하시는 요일과 시간을 올바른 형식으로 입력해주세요 (ex. 월-3시): 목-4시

    MON    TUE    WED    THU    FRI
----------------------------------
 1시 |                                        
 2시 |    nix                                 
 3시 |                                        
 4시 |                           jiye         
 5시 |                                        
프로그램을 종료하시겠습니까? (y/n): y
```

## 신경 쓴 부분
### `Interface` 분리, `controller` 분리 등
- 기본적인 `model.Member`, `model.Parent`, `model.Child`, `model.Timetable`이라는 MVC 패턴의 Model과 유사한 클래스 외에 
인터페이스를 담당하는 `view.InputView`, `view.OutputView`를 만들어 SOLID 원칙 중 인터페이스 분리 원칙을 적용해보고자 함
- 추가적으로 `controller`를 분리하여, `Main`에 너무 많은 책임이 주어지지 않도록 함
    - 다만 이 과정에서 아쉬운 점은 `controller`가 또 너무 많은 책임을 갖게 된 것 같음..

### 재입력 받기
- 입력이 잘못 들어왔을 때, 재입력을 받도록 하기 위해 재귀 함수 사용

## 아쉬운 부분
- 2차 상속을 못했다ㅠㅠ 아무리 머리를 쥐어 짜도 이 프로그램에서는 2차 상속을 만들 수가 없었다...
- 폴더구조..가 없다 ㅎㅎ

## 간단 후기
Java 진짜 오랜만에 해서 다 까먹은 바람에, 내장 클래스나 메서드들 검색해서 사용하느라고 시간을 많이 뺏겼다ㅠㅠ
그래도 확실히 코딩은 이런 간단한 프로그램을 만들어 봐야 깨닫는 부분이 많은 것 같다. 
그동안 프론트엔드 한다고 JS나 TS만 하다가 Java를 하니, 언어마다의 매력을 느낄 수 있었던 시간이었다.

그리고 이 프로젝트는 진짜로 내가 개인프로젝트로 수행하고 싶었던 주제라서 (엄마 학원에 쓰기 위해) 간단하게 연습해볼 수 있어서 좋았다.
이번 풀스택 과정을 수강한 후에 정말로 내가 풀스택으로 이 프로젝트를 확장시켜보고 싶다!