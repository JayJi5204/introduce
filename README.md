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

## 세부내용

![image](https://github.com/JayJi5204/introduce/assets/126458483/2f4238a5-552e-4d7c-88fd-dfc1d39988ef)

![image](https://github.com/JayJi5204/introduce/assets/126458483/e1b0b62f-820e-455f-b582-23500064979b)

![image](https://github.com/JayJi5204/introduce/assets/126458483/1a18fd8a-c035-4261-9b65-f208c1c4f0a0)

![image](https://github.com/JayJi5204/introduce/assets/126458483/ddd998e8-86f8-4a4e-8445-5523c5c06e9f)

![image](https://github.com/JayJi5204/introduce/assets/126458483/75b2a9d2-000f-4dd9-a50e-78a161f9c195)

![image](https://github.com/JayJi5204/introduce/assets/126458483/bba74927-53bd-42aa-9e85-42e7277e449d)

![image](https://github.com/JayJi5204/introduce/assets/126458483/5c42396d-1f0f-4b4b-936b-7a57d6ba161a)

![image](https://github.com/JayJi5204/introduce/assets/126458483/fdbb7285-4f87-4f9c-803a-6d0951f52cc8)

![image](https://github.com/JayJi5204/introduce/assets/126458483/da740182-7aa4-4fa5-a741-08573f8835a8)

![image](https://github.com/JayJi5204/introduce/assets/126458483/c575cea9-2fe9-4ea5-80df-e3d5f0e301e4)

![image](https://github.com/JayJi5204/introduce/assets/126458483/9496b96b-5602-41ca-ae09-7fa0cbc3c1ac)

## 향후 계획

1. 모바일 사용자를 위한 반응형 페이지 구현
2. 홈페이지 UI/UX 대폭 변경 예정
3. 로그인 기능 추가
4. 게시글에 사진 업로드 기능 추가



