# JayJi's introduce
> **개발기간: 2023.11.06 ~ 2023.12.05**

## 프로젝트소개

지성현에 대해서 소개하는 사이트

## 설치 가이드
- IntelliJ 
- Spring Boot 3.x
- Java 17
- Oracle 11g

**초기화**  

    $ git clone https://github.com/JayJi5204/introduce.git  
    $ cd introduce

   
**실행방법**  

1. Oracle Db 계정 생성   
   cmd 실행 -> 'sqlplus' 입력 ->   
   Enter username: system   
   Enter password: 1234   
   -> 'conn/as sysdba' 입력   
   -> 'create user jayji identified by 1234;' 입력   
   -> 'grant connect, resource, dba to jayji;' 입력   
2. IntelliJ 실행   
3. 프로젝트 Import   
   [File] -> [Open] -> '/introduce/SpringJPA/board' 폴더 선택 -> 'build.gradle' 선택 -> 'Open as Project' 선택
4. 실행
   src/main/java/introduce.board/BoardApplication 실행행

   ## 주요 기능

- 방명록
- 정보
- 자기소개서
- 게시판

## 기술 스택

- Backend
  - Java 17
  - Spring Boot 3.1.6 (JPA)
  - gradle
    
- Frontend    
  - Thymeleaf
  - HTML5
  - CSS3
  - BootStrap

- DB
  - Oracle 11g

- Tools
  - GitHub

## 기획

- **아키텍처**   
![image](https://github.com/JayJi5204/introduce/assets/126458483/49713935-8371-434e-85be-cdb67c4fc147)
- **ERD**
![image](https://github.com/JayJi5204/introduce/assets/126458483/5ea7ec33-5768-4324-9c98-14563be6c191)



