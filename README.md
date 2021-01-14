# week04
    
- 3계층
      
    1.	Controller
	   
       - ProductRestController: 관심 상품 관련 컨트롤러
       - SearchRequestController: 검색 관련 컨트롤러
    	
    2.	Service
	     
       - ProductService: 관심 상품 가격 변경
	    
    3.	Repository
	  
       - Product: 관심 상품 테이블 (실질적 DB에 저장되는 부분)
       - ProductRepository: 관심 상품 조회, 저장
       - ProductRequestDto: 관심 상품 등록하기
   	   - ProductMypriceRequestDto: 관심 가격 변경하기
   	   - ItemDto: 검색 결과 주고받기

- 네이버 API와 서비스 연결
    1. NaverShopSearch 컴포넌트 등록 
    2. ARC를 이용하여 확인 

- API 업데이트 
    1. utils 패키지의 스케줄러 클래스를 이용하여 주기적으로 업데이트
    2. @Scheduled(cron = "0 0 1 * * *") - (초,분,시,일,월,주)
      
    <img width="400" alt="스크린샷 2021-01-14 오후 12 21 33" src="https://user-images.githubusercontent.com/70695311/104540762-7505d680-5663-11eb-8c03-d15183f739b5.png">

- Implementation
  -	상품명에 따른 검색
  - 관심 상품 등록 & 조회
  - 관심 상품에 대한 최저가 등록, 그 가격보다 낮은 경우 표시하기 
    
    <img width="300" alt="스크린샷 2021-01-14 오후 12 29 04" src="https://user-images.githubusercontent.com/70695311/104541279-a6cb6d00-5664-11eb-8fac-da73c18d01da.png">
  <img width="300" alt="스크린샷 2021-01-14 오후 12 31 25" src="https://user-images.githubusercontent.com/70695311/104541281-a9c65d80-5664-11eb-9d2c-6e583a60dc8d.png">
  <img width="300" alt="스크린샷 2021-01-14 오후 12 31 55" src="https://user-images.githubusercontent.com/70695311/104541282-aaf78a80-5664-11eb-9dc8-96d98db747ae.png">
