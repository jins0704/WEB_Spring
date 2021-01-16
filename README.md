# WEB_Spring


<img width="400" alt="sdfsf" src="https://user-images.githubusercontent.com/70695311/103991607-42c52680-51d6-11eb-9cf4-082865c9d0b2.png">


## Week02

   **[수업 목표]**

   1. RDBMS의 기초 지식을 습득한다.
   2. Spring Data JPA의 사용법을 습득한다.
   3. REST API를 만드는 방법을 익힌다.

- 3 Layers 
   * Controller : 제일 바깥 쪽에서 요청을 받고, 응답을 되돌려주는 역할  
   * Service : 중간에서 구체적인 작업 순서 결정
   * Repository : DB와 직접 소통하며 자료를 생성, 조회, 변경, 삭제
   * Layer 간에는 절대 Entity를 직접 사용하지 않고, DTO 사용
    
- Using H2 RDBMS (http://localhost:8080/h2-console)

    src > main > resources > application.properties
    - spring.h2.console.enabled=true
    - spring.datasource.url=jdbc:h2:mem:testdb
- Timestamped
        
        Timestamed.java
        
        @MappedSuperclass // 상속했을 때, 컬럼으로 인식
        @EntityListeners(AuditingEntityListener.class) // 생성/수정 시간을 자동으로 반영하도록 설정
        
        public class Timestamped {
             @CreatedDate // 생성일자
             private LocalDateTime createdAt;

             @LastModifiedDate // 마지막 수정일자
             private LocalDateTime modifiedAt;
        }
        
        이후 테이블이 상속하고 Application에 추가
        @EnableJpaAuditing
        @SpringBootApplication
        
- Using Lombok, DTO

- #### Task02
    
      Person 정보를 CRUD 기능을 이용하여 관리하자. 
        https://localhost:8080/api/persons : POST
        https://localhost:8080/api/persons : GET
        https://localhost:8080/api/person/{id} PUT
        https://localhost:8080/api/persons/{id} DELETE
  
  
## Week03
  
   **[수업 목표]**
   
   1. 페이지를 만들기 위한 HTML,CSS, Javascript를 익힌다.
   2. 스프링을 이용해 API를 만들고 기능 확인하는 법을 손에 익힌다.
   3. 타임라인 서비스를 완성한다.

        
   <img width="300" alt="ffffff" src="https://user-images.githubusercontent.com/70695311/103992123-0219dd00-51d7-11eb-8b51-2e97c67d4cd8.png">
 
 - Javascript 기초문법
        
- jQuery : 미리 작성된 자바스크립트 함수 모음


- #### Task03
    
    타임라인 서비스가 불러오는 메모 목록의 시간을, 조회 시간으로부터 24시간 이내로 바꾸기
    
      MemoRepository 
          public interface MemoRepository extends JpaRepository<Memo, Long> {                    
                List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
          }
          
      MemoController - @Getmapping("/api/memos")      
           public List<Memo> getMemos() {  
               LocalDateTime startDatetime = LocalDateTime.now().minusDays(1);
               LocalDateTime endDatetime = LocalDateTime.now();
               return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(startDatetime, endDatetime);
          }
          
    ![timeline](https://user-images.githubusercontent.com/70695311/103992908-27f3b180-51d8-11eb-87c7-346bb66d49a3.gif)
