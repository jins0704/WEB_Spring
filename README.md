# WEB_Spring

## Week01
- Run Spring
     
        1.lombok 
        2. Spring Web 
        3. Spring Data JPA 
        4. H2 Database
        5. MySQL Driver
        이용한다고 가정하고 진행
- Using RestController

- #### Task01
   
      Make Person class
      Using Getter, Setter
      View in http://localhost:8080/myinfo

## Week02
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
    
      CRUD 
        Person(name,gender,age) 
        https://localhost:8080/api/persons : POST
        https://localhost:8080/api/persons : GET
        https://localhost:8080/api/person/{id} PUT
        https://localhost:8080/api/persons/{id} DELETE
  
