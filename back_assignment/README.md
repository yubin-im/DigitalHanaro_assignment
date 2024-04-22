# 🌟 백엔드 실습 과제 🌟

## 📍 프로젝트 개요

공지사항과 고객지원을 제공하는 회사 홈페이지입니다.

관리자 페이지가 별도로 존재합니다.

백엔드 개발 후 제공되는 프론트엔드 파일과 연결합니다.

### 프로젝트 기간/참여자

- 프로젝트 기간
  - 2024.04.17 ~ 2024.04.20 (4일)
- 참여자
  - [BE 임유빈](https://github.com/yubin-im)

### 개발 환경

#### [Back-end]

<p>
    <img src="https://img.shields.io/badge/java%2017-007396?style=for-the-badge&logo=java&logoColor=white"> 
    <img src="https://img.shields.io/badge/MySQL%208.0.33-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
    <img src="https://img.shields.io/badge/spring%20boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
    <img src="https://img.shields.io/badge/JPA-005F0F?style=for-the-badge&logo=jpa&logoColor=white">
</p>

#### [Front-end]

<p>
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
  <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white" /> 
  <img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white">
</p>

#### [Toos & Environment]

<p>
  <img src="https://img.shields.io/badge/IntelliJ%20IDEA-CB5B8D?style=for-the-badge&logo=intellijidea&logoColor=white"/>
  <img src="https://img.shields.io/badge/MySQL%20Workbench-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
  <img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white"/>
  <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white"/>
  <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white"/>
</p>

### ERD

![testdb_erd](https://github.com/yubin-im/DigitalHanaro_assignment/assets/140530127/b6203f72-bf32-4845-bd22-6b785795730a)

## 📋 구현 과제

### 홈페이지 기능

- 로그인/회원가입
- 아이디/비밀번호 찾기
- 커뮤니티
  - 공지사항
- 고객 지원
  - 1:1 문의
  - 묻고 답하기
- 관리자 페이지
  - 회원 관리
  - 공지사항 관리
  - 공지사항 작성/수정

### 제공되는 파일

- DB Table 생성 SQL문
  - 제공되는 SQL문을 사용하여 MySQL 데이터베이스와 테이블을 설정한 후 과제 수행
- 프론트엔드 뷰 파일
  - 제공되는 html, css, image 파일을 사용하여 백엔드와 연결

## 🚩 개인적인 목표

- **Repository - Service - Controller 구분하여 구현하기**
  - 이전까지 했던 실습은 테이블이 1개이거나, 부피가 작아서 Service를 사용하지 않았다. 이번에는 3가지 모두 구분하여 작성해보기!
- **DTO 사용하기**
  - 엔티티에 바로 사용하지 말고 DTO로 변환하여 사용하기!
  - 값을 전달할 때 DTO로 전달하기!
- **View와 API Controller 나눠서 작성하기**
  - ViewController는 받는 매개변수 값 없이 순수하게 html 파일만 return 하도록 구현하기!
- **RESTFUL하게 구현하기**
  - 전체 기능을 REST API로 구현해보기
  - Thymeleaf 사용하지 않고 순수 JavaScript로 구현하기
  - 사실 Model과 Thymeleaf 콤보로 구현한다면 빠르고 쉽게 구현할 수 있다. REST API 작성도 금방하지만 역시 문제는 프론트…자바스크립트 코드 작성..

## 🖥️ 프로젝트 실행 방법

1. git clone 하기
2. main-> resources 폴더 안의 db.sql 코드를 복사하여 MySQL Workbench 쿼리에 붙여넣기 및 실행 후 데이터베이스와 테이블을 생성한다.
3. [http://localhost:8080/](http://localhost:8080/) 으로 접속한다.

## 🚀 구현 과정

### [[백엔드 실습 과제] 구현 과정 (클릭!)](https://unleashed-fire-109.notion.site/Back-end-a5cb53824ba0499a9f7cce874b9b55d4)

## 🎯 트러블 슈팅

<details>
<summary>아이디/비밀번호 찾기 실행 시 NullException 발생</summary>
<div markdown="1">

- 문제 발생 현상
  - 아이디/비밀번호 찾기 기능 실행 중 가입하지 않은 아이디나 비밀번호를 입력했을 때 NullException이 발생하면서 서버가 중단되었다.
- 문제 발생 이유
  - company_member 테이블에 없는 아이디나 비밀번호를 입력한다면 엔티티를 찾을 때 결국 엔티티가 null이기 때문에 NullException이 발생한 것이다!
- 해결 방법

  - 엔티티를 찾을 때 null이면 “null”과 같이 **String 데이터 타입으로 return**하여 사용하도록 했다.

    ```java
    // 비밀번호 찾기 기능
    @Transactional
    public String findPw(String memberName, String memberId, String memberEmail) {
        CompanyMember companyMember = companyMemberRepository.findCompanyMemberByMemberNameAndMemberIdAndMemberEmail(memberName, memberId, memberEmail);
        if(companyMember == null) {
            return "null";
        }
        String findMemberPw = companyMember.getMemberPw();

        return findMemberPw;
    }
    ```

  - 비슷한 예로 엔티티 리스트를 검색한다면, 해당하는 검색 값이 없을 때 `Collections.emptyList();` 를 return하는 것과 같이 **null을 만들지 말고, 문자열이나 빈 리스트로 치환하여 사용하도록 해야겠다!**
  </div>
  </details>

<details>
<summary>로그인 기능 실행 시 아이디/비밀번호 틀렸을 때 알림</summary>
<div markdown="2">

- 문제 발생 현상
  - 아이디가 틀렸을 때는 “아이디가 존재하지 않습니다.”가 출력 되었지만, 아이디가 맞고 비밀번호가 틀렸을 때도 “아이디가 존재하지 않습니다.”가 출력되었다.
- 문제 발생 이유
  - 아이디/비밀번호가 모두 일치한 회원만 찾아서 비교했기 때문에 아이디가 맞고 비밀번호가 틀렸을 때도 “아이디가 존재하지 않습니다.”가 출력되었던 것이었다!
- 해결 방법

  - **먼저 아이디만 일치한 회원을 찾고, 비밀번호를 비교**하여 틀렸다면 “비밀번호가 맞지 않습니다.”를 출력하도록 하였다. **그 후 아이디와 비밀번호가 모두 일치한 회원을 비교**하였다.

    ```java
    // 로그인 기능
    @Transactional
    public String login(String memberId, String memberPw) {
        CompanyMember memberMatchId = companyMemberRepository.findCompanyMemberByMemberId(memberId);
        CompanyMember companyMember = companyMemberRepository.findCompanyMemberByMemberIdAndMemberPw(memberId, memberPw);

        if(memberMatchId == null) {
            return "아이디가 존재하지 않습니다.";
        } else if (!memberPw.equals(memberMatchId.getMemberPw())) {
            return "비밀번호가 맞지 않습니다.";
        } else if (memberId.equals(companyMember.getMemberId()) && memberPw.equals(companyMember.getMemberPw())) {
            return "로그인이 완료되었습니다!";
        } else {
            return "아이디가 존재하지 않습니다.";
        }
    }
    ```

  - 사실 로그인할 때 이렇게 비밀번호가 틀렸다고 하는 건 보안 상에 좋은 것 같지 않지만, 이번 과제의 요구사항이기 때문에 이렇게 구현하였다!
  </div>
  </details>
