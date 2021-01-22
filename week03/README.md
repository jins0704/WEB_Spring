# WEB_Spring

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
