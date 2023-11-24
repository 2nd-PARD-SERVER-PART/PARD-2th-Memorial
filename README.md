# 버르장례식 - 백엔드

---

>### 프로젝트 설명
> 내가 버리고 싶은 버릇과 모습에 대한 장례식을 치룰 수 있는 서비스이다. 이를 통해서 나의 새로운 출발을 위해 나를 격려해줄 지인들을 ‘Connect’해준다.
> 
> <a href = "https://github.com/2nd-PARD-WEB-PART/PARD-2th-Memorial/blob/main/README.md">프론트엔드 보러가기</a>
> 
> 백엔드 개발 : 서하민

---

## 개발 환경
+ Java : OpenJDK 17.0.8.1
+ IDE : IntelliJ 2023.2
+ Framework : SpringBoot 3.2.0
+ ORM : JPA
+ Database version : Mysql 8.1.0

---

## 주요기능
>### <a href = "https://github.com/2nd-PARD-SERVER-PART/PARD-2th-Memorial/blob/main/src/main/java/com/pard/memorial/controller/posting/PostingController.java">장례식 기본 정보 등록 기능</a>
> 장례식의 제목, 유언장, 시간을 등록하고 조회 할 수 있다.
> 


>### <a href = "https://github.com/2nd-PARD-SERVER-PART/PARD-2th-Memorial/blob/main/src/main/java/com/pard/memorial/controller/posting/CommentController.java">장례식 댓글 등록 기능</a>
> 장례식 정보와 장례식의 댓글을 1:N 관계로 설정해서 한 장례식에 많은 댓글들을 작성 할 수 있다. 
> 댓글은 로그인 하지 않아도 익명으로 작성이 가능하다.


>### <a href = "https://github.com/2nd-PARD-SERVER-PART/PARD-2th-Memorial/blob/main/src/main/java/com/pard/memorial/controller/image/ImageController.java">장례식 사진 등록 기능</a>
> 장례식에 사용될 사진을 사용자가 선택해서 원하는 이미지를 서버에 업로드 할 수 있다.
> 또한 업로드 된 사진을 사용자에게 보여 줄 수 있다.


>### <a href = "https://github.com/2nd-PARD-SERVER-PART/PARD-2th-Memorial/blob/main/src/main/java/com/pard/memorial/controller/user/UserController.java">사용자별 장례식 조회 기능</a>
> 프론트에서 구글 로그인을 통해 얻은 아이디를 통해 사용자가 등록했던 장례식이 어떤 것이 있는지 조회 할 수 있다.


---

## 주요 API

+ POST - [ /api/v1/posting ]  장례식의 정보를 등록한다.
+ GET - [ /api/v1/posting/{id} ]  특정 장례식의 정보를 가져온다.
+ GET - [ /api/v1/posting/all ]  모든 장례식의 정보를 가져온다.
+ PATCH - [ /api/v1/posting/{id} ]  특정 장례식의 정보를 수정한다.
+ DELETE - [ /api/v1/posting/{id}?authorId={authorId} ]  특정 장례식의 정보를 삭제한다.


+ POST - [ /api/v1/posting/{id}/comment ]  특정 장례식에 댓글을 추가한다.


+ POST - [ /api/v1/image?postingId={postingId} ]  특정 장례식에 사진을 추가한다.
+ GET - [ /api/v1/image/{postingId} ]  특정 장례식의 사진을 가져온다.


+ GET - [ /api/v1/user/{authorId} ]  특정 사용자가 작성한 장례식의 정보를 모두 갸져온다.

