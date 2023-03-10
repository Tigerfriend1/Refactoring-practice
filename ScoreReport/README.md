## 📌ScoreReport
---
### 1. 개요
- 학생들의 이름과 성적을 받아 저장하는 기본적인 프로그램이다.
- JAVA언어로 작성된 st파일과 ScoreReportMain파일로 이루어져 있다.

### 2. Major Refactoring
- 클래스명, 변수명
- add함수를 addScores과 addStudent로 분리하여 각각의 기능이 명확하게 구별 되게 하였다.
- 기존 add함수는 학생입력이 아니면 모두 score로 인식하였는데, 분리하여 string입력과 int입력으로 이를 구별하였다.
- 보다 정확하게 score의 범위를 설정하면 확실하게 이상값을 걸러낼 수 있지만, 기존 before에서 해당 조건을 찾을 수 없어 원본 훼손을 최소화 하기 위해 작성하지 않았다. 