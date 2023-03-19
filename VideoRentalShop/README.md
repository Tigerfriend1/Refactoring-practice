## 📌VideoRentalShop
---
### 1. 개요
- 고객에게 비디오를 출시일, 연령별로 금액을 달리하여 대여해주는 프로그램
- before : Customer, Rental, Movie파일로 구성되어 있다.
- after : Customer, Rental, Movie과 기능별로 분리한 Prcie, ChildernPrice, NewReleasePrice, RegularPrice로 구성되어 있다.

### 2. Major Refactoring
- Customer class안에 나이와 출시일을 기준으로 가격표를 매기는 switch코드가 있어, 스멜을 해결하기 위해 기능별로 함수를 구현하였다.
- 추후, 소스파일을 분리하여 기능별로 class화 하여 기존 Movie와 Rental, Customer에서는 호출을 통해 실행할 수 있도록 구현하였다.
- 추가로 Price클래스를 통해 ChildernPrice, NewReleasePrice, RegularPrice를 접근하게 하고, Movie클래스에서 Price로만 접근하게 하여 수정을 통한 유지보수에 효율성을 더했다.
