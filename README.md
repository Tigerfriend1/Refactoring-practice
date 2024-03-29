# Refactoring-practice

## 📌 목적
- GoF 디자인 패턴을 자바 코드에 대입하며 익혀본다.
- 대규모 프로젝트와 같은 여러 개발자와 함께 일할 때를 대비하여 수정, 보완, 유지에 용이하게 작성하는 방법을 연습한다.
- 리팩토링에 익숙해지는 시간을 가진다.

## 📌 사용언어 및 환경
- Java
- Eclipse
- MacOS ARM64 

## 📌 설명
### 1. ScoreReport
- 학생들의 성적을 입력하여 출력하는 프로그램
- 설명으로 이동 : [ScoreReport](https://github.com/Tigerfriend1/Refactoring-practice/tree/main/ScoreReport)

### 2. VideoRentalShop
- 고객에게 비디오를 출시일, 연령별로 금액을 달리하여 대여해주는 프로그램
- 설명으로 이동 : [VideoRentalShop](https://github.com/Tigerfriend1/Refactoring-practice/tree/main/VideoRentalShop)


### 3. PuzzleBuilder
- 낱말 퍼즐을 만드는 프로그램
- 현재 Refactoring 진행중

### 4. ScoreRecordObserver
- 점수를 받아 저장하고, 점수를 목록형식으로 저장하는 프로그램
- 이때, 최대와 최소값만을 출력받고자 하는 클라이언트의 요구에 따라 추가적인 기능을 추가하는 상황이다.
- Observer 패턴을 사용하여 클라이언트에 다양한 요구를 수용할 수 있는 방식으로 리팩토링한다.
- 설명으로 이동 : [ScoreRecordObserver](https://github.com/Tigerfriend1/Refactoring-practice/tree/main/ScoreRecordObserver)
