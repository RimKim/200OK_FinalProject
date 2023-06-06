# :ring:&nbsp;200OK Jewelry  Shop 



<br>

## :speech_balloon:서비스 소개

Spring Boot + MySql + JPA 기반으로 개발된 웹 프로젝트입니다.<br>
200OK라는 이름의 악세사리 쇼핑몰입니다.<br>
고객들이 쉽게 상품을 검색하고, 주문하며, 결제할 수 있도록 다양한 서비스를 제공합니다.<br>
고객들의 만족도를 높이고, 악세사리 쇼핑 경험을 한층 더 편리하고 즐겁게 만들어줍니다.<br> 
200OK는 악세사리를 사랑하는 고객들에게 편리하고 품질 높은 쇼핑 경험을 제공하고자 합니다.<br>


<br>


## 💻기술 스택
<div>
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/>
<img src="https://img.shields.io/badge/mysql-4479A1?style=flat-square&logo=mysql&logoColor=white"/><br>


<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=white"/>
<img src="https://img.shields.io/badge/axios-5A29E4?style=flat-square&logo=axios&logoColor=white"/>
<img src="https://img.shields.io/badge/HTML-E34F26?style=flat-square&logo=HTML5&logoColor=white"/>
<img src="https://img.shields.io/badge/CSS-1572B6?style=flat-square&logo=CSS3&logoColor=white"/><br>
  
<img src="https://img.shields.io/badge/Postman-FF6C37?style=flat-square&logo=Postman&logoColor=white">
  <img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=Git&logoColor=white">
<img src="https://img.shields.io/badge/Miro-050038?style=flat-square&logo=Miro&logoColor=white">
<img src="https://img.shields.io/badge/Slack-4A154B?style=flat-square&logo=Slack&logoColor=white">
<img src="https://img.shields.io/badge/Notion-000000?style=flat-square&logo=Notion&logoColor=white"><br>

  
  




</div>


<br>


## :date:개발 기간
2023.03.13 ~ 2023.04.09

<br>


## :running:팀원 소개
| Name | Git Address |
| -------- | -------- |
|:hamster: 김영림| https://github.com/RimKim|
|🍀 이윤영|https://github.com/younyeong1115| 

<br>


## 🔎설계


### 1️⃣ 데이터베이스 설계
<br><br><br>

<div align="center">

</div>

### 2️⃣ 목업 설계

https://ovenapp.io/project/qd88VIWjsaejDrMlMGqosTVo0LvrruLM#4IE1u

## 📚주요 기능
###  ✔️ 회원가입
▪️  유효성으로 인하여 조건 미충족시 회원가입이 불가합니다.<br>
▪️  유효성: 아이디양식체크, ID중복체크, 비밀번호일치확인, 필수입력사항 알람창, 필수동의사항 알람창, ID중복체크 알람창, 인증번호 알람창<br>
▪️  도로명API를 사용하여 주소지를 입력받게 됩니다.<br> 
▪️  우편번호와 도로명주소는 도로명API를 통해서만 입력됩니다.<br>
▪️  이메일 입력 후 인증버튼 클릭시 인증번호가 메일로 전송됩니다.<br> 
▪️  메일에 전송된 인증번호를 인증번호확인란에 입력 하게 됩니다.<br><br>


###  ✔️ 로그인
▪️  보안을 강화하기 위해 인터셉터(interceptor) 기능을 활용하여 로그인 프로세스를 처리하고 있습니다.<br>
▪️  일반로그인, sns 로그인 두가지 방식으로 로그인이 가능합니다.<br>
▪️  sns로 최초 로그인하는 경우 kakao가 제공하는 사용자 정보 외에 필요한 정보를 회원가입폼을 이용하여 입력 받게 됩니다.<br>
▪️  이후 sns로 로그인 시 별도의 절차 없이 로그인 되어 메인으로 이동 합니다.<br><br>


###  ✔️ 이메일 인증
▪️  비밀번호찾기: 아이디, 이름, 이메일 입력 후 버튼 클릭시 이메일로 임시 비밀번호가 전송됩니다.<br> 
▪️  메일 전송시 회원의 기존 비밀번호는 해당 임시 비밀번호로 갱신됩니다.<br>
▪️  아이디와 임시 비밀번호로 로그인이 가능합니다.<br><br>


###  ✔️ 장바구니
▪️  상품 상세보기에서 장바구니 담기 가능합니다.<br>
▪️  체크박스에 체크 된 상품만 가격 합계 계산 및 주문서로 넘어 가게됩니다.<br>
▪️  상품 결제 시 장바구니에서 해당 상품은 사라지게 됩니다.<br><br>


###  ✔️ 배송지관리
▪️  하나의 배송지만 기본 배송지로 설정 가능합니다.<br>
▪️  기본 배송지가 존재하는 경우 주문서에서 기본배송지로 자동으로 입력되고 체크박스 클릭시 빈칸으로 초기화됩니다.<br><br>


###  ✔️ 결제
▪️  통합결제시 결제API를 통해 실결제가 가능합니다.<br>
▪️  결제창에 주문자의 이름과 이메일이 출력됩니다.<br>
▪️  결제가 완료되면 결제금액 알람창이 나온 후 주문완료 페이지가 나타납니다.<br><br>



###  ✔️ 관리자
▪️  관리자로 로그인 한 경우 마이페이지에서 관리자 홈으로 이동 가능합니다.( 일반 유저의 경우 버튼이 보이지 않습니다. )<br>
▪️  판매량 BEST5,WORST5 상품을 구글 chart api를 통해 출력합니다. <br>
▪️  회원,상품,주문에 대한 관리가 가능합니다.  <br><br>


## 💥트러블 슈팅
###  ✔️ 쿼리 참조 타입 오류 발생
user entity 에서는 userId가 String 타입이었고, cart entity에서 userId의 타입은 User와 조인을 하기 때문에 User타입으로 선언해주었기 때문에 
@Query("SELECT COUNT(c) FROM Cart c WHERE c.userId = :userId") 이렇게 쿼리를 생성해줬을때 타입이 다르다는 오류가 발생했다
@Query("SELECT COUNT(c) FROM Cart c WHERE c.userId.userId = :userId") 따라서 userId(유저타입).userId로 쿼리를 생성하여 오류를 해결하였다

###  ✔️ userEntity 오류 발생
회원가입 기능을 구현하는 도중 userRegdate가 null값으로 출력되면서 오류가 발생되었다.<br>
이때 @CreationTimestamp을 사용하여 오류를 해결하였다.<br>
@CreationTimeStamp는 INSERT 쿼리가 실행될 때 값을 현재시간으로 채워서 쿼리를 생성한다.<br>
따라서 데이터 생성 시점 관리에 대한 수고스러움을 덜 수 있다.<br>

###  ✔️ 타임리프 두가지 list 반복문 오류 발생
컨트롤러에서 product list와 quantity list 두가지 list가 넘어왔을때<br>
&lt;li th:each=&quot;product : ${products}&quot;&gt; list의 size가 같음에도 불구하고 오류가 발생하였으나<br>
&lt;li th:each=&quot;product,productStat : ${products}&quot;&gt; productStat을 추가하여 현재 반복의 상태를 나타내는 변수를 추가하여 오류를 해결하였다<br>
 
###  ✔️ StackOverflow 오류 발생
 StackOverflowError는 우리가 접할 수 있는 가장 일반적인 런타임 오류 중 하나이다<br> 
 여러 원인과 해결 방법이 있으나 우선 엔티티 문제로 파악하고 @tosting을 지우고 직접 tostring지정을 하여 오류를 해결하였다.<br> 


  
