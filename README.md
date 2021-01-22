# Last week05

-**자세한 사항은 각 주차의 Readme**

 **최종목표**

 1. 내가 만든 로컬서비스를 AWS RDS의 MySQL 데이터베이스 연결
 2. AWS EC2를 세팅하여 배포
 3. 실제 도메인을 붙이기
    
### RDS 구매 후 내 서비스에 MySQL 세팅
      
    1. AWS 서비스 찾기에서 RDS 검색
    2. 데이터베이스 생성
       - 표준생성 선택 
       - MySQL 선택 
       - 프리티어 선택
       - DB 인스턴스 식별자, 마스터 사용자 이름, 암호 설정
       - 로컬컴퓨터에서 AWS RDS의 MySQL 연결이 가능하도록 퍼블릭 엑세스 기능 '예'
       - VPC 보안그룹 새로 임의로 생성
       - 추가 구성에서 초기 데이터베이스 이름 입력 후 생성 완료
    3.  RDS 포트 열기 
       - 생성한 데이터베이스 선택 후 연결&보안 > 보안 > VPC 보안그룹  > 보안그룹 ID클릭
       - 인바운드 규칙 편집 클릭 후 소스 > 위치무관 선택 후 저장
    4.  내 로컬 프로젝트에 DB 연결
       - 로컬컴퓨터의 프로젝트 파일을 IntelliJ에서 열고 Database > Data Source > MySQL 선택
       - Name : 임의지정
       - Host : 나의 엔트포인트
       - User : 나의 Username
       - Password : 나의 비밀번호
       - Database : 내 데이터베이스 이름 
       - Test Connection으로 확인 후 OK
    5. 스프링부트와 MySQL 연결
        - application.properties에서 코드입력
                > spring.datasource.url=jdbc:mysql://나의엔드포인트:3306/myselectshop
                > spring.datasource.username=나의USERNAME
                > spring.datasource.password=나의패스워드
                > spring.jpa.hibernate.ddl-auto=update
    6. OG 태크 붙이기
                > <meta property="og:title" content="title">
                > <meta property="og:description" content="content">
                > <meta property="og:image" content="image">
                
### AWS EC2 서버 구매 후 실제 배포
    1. Launch Instance
        - key pair 받기
        - 무료 기간(1년) 후 종료원하면 인스턴스 상태 > 종료  
    
    2. EC2 접속
        - 터미널 입력 : sudo chmod 400 (키체인붙여넣기)
        - 터미널 입력 : ssh -i (키체인붙여넣기) ubuntu@(ip주소)
       
       <img width="200" alt="사진1" src="https://user-images.githubusercontent.com/70695311/105439783-cc7df500-5ca8-11eb-9ca3-82c330b7482d.png">
       
        - SSH란? - 다른 컴퓨터에 접속 시 쓰는 프로그램으로 보안이 상대적으로 좋음
            - 22번 포트가 열려있어야 접속 가능
    
    3. EC2 배포
        - Intellij 프로젝트 파일 > Gradle > Tasks > build > build 
        - libs 생성
        - OpenJDK 설치
            - 터미널 입력 : sudo apt-get update 로 업데이트 해주기
            - 터미널 입력 : sudo apt-get install openjdk-8-jdk 로 openjdk 설치
            - 터미널 입력 : java -version 으로 마지막 확인
        - Filezilla 이용해서 배포 파일 업로드
            - 사이트 관리자 > New Site에서 설정
            - Protocol : SFTP
            - Logon Type : Key file
            - User : ubuntu
            - 키파일 찾아서 업로드하고 OK
            - libs에서 생성된 .jar 파일 업로드/다운로드
        - 스프링 부트 작동
            - java -jar JAR파일명.jar
            
            <img width="200" alt="사진3" src="https://user-images.githubusercontent.com/70695311/105439787-cee04f00-5ca8-11eb-8aeb-a1340337952f.png">

        - AWS에서 80,8080 포트 열기
            - aws사이트의 인스턴스 > 보안그룹 > ID클릭 > 인바운드규칙 편집 > 8080, 80 포트 추가
            - 80 port : HTTP 접속을 위한 기본포트
            - 8080 port : 스프링 부트를 위한 로컬 기본포트
### Port forwarding & nohup
    1. Port forwarding
        - 80포트로 들어오는 요청을 8080포트로 전달하는 방법
        - 포트 번호 입력없이 자동으로 접속
        - 터미널 입력 : sudo iptables -t nat -A PREROUTING -i eth0 -p tcp --dport 80 -j REDIRECT --to-port 8080  포트포워딩
        - 터미널 입력 : java -jar JAR파일명.jar 서비스 재시작
    2. nohup
        원격접속, SSH 접속을 끊어도 서버가 계속 돌기 위한 방법
        - 터미널 입력 : nohup java -jar JAR파일명.jar &
        - 서버종료를 원할 시, 
                - ps -ef | grep java 로 pid 값 확인
                - kill -9 [pid값] 로 특정 프로세스 kill
        
        <img width="200" alt="사진2" src="https://user-images.githubusercontent.com/70695311/105439785-cdaf2200-5ca8-11eb-9a54-66cf60ef3912.png">        
        
###  도메인 붙이기 
    - 도메인 구매 - '가비아'라는 회사
    - 구매한 도메인의 관리툴 선택 > 도메인 연결 설정 > DNS 설정
    - 호스트 이름 : & , IP 주소 입력
    

### 프로젝트 1 (week03)
![timeline](https://user-images.githubusercontent.com/70695311/103992908-27f3b180-51d8-11eb-87c7-346bb66d49a3.gif)

### 프로젝트 2 (week04)

<img width="300" alt="스크린샷 2021-01-22 오전 11 54 33" src="https://user-images.githubusercontent.com/70695311/105439737-b5d79e00-5ca8-11eb-8b06-3705e82561ac.png">
