# REST API
**Representational State Transfer**  
REST(restful) 아키텍처의 조건을 준수하는 API.  
리소스를 이름으로 구분해 리소스의 상태를 주고 받는 것  
일반적으로 JSON이나 XML형태로 주고받는다.  

HTTP URI를 사용해 접근할 자원(Resource)를 명시하고,  
HTTP Method(POST, GET, PUT, DELETE)를 통해 명시된 자원에 CRUD를 적용한다.  

HTTP를 사용해 데이터를 주고받기 때문에,  
별도의 인프라 구성 없이 웹의 장점을 최대한 활용할 수 있다.  

최근의 서버 프로그램은 다양한 브라우저와 모바일 환경에서 통신을 할수 있어야 하기 때문에 REST가 뜨는 중  

## 특징
- Uniform  
Uniform Interface는 URI로 지정한 리소스에 대한 조작을 HTTP Method라는 통일된 인터페이스로 수행  
- Stateless  
클라이언트 서버간 요청정보를 따로 저장하지 않고 관리되어 각 요청이 분리되어 처리 된다.  
- Cacheable  
HTTP표준을 사용하기 때문에 그 기능 중 하나인 클라이언트 - 서버간 상호작용을 간소화해주는 캐싱 가능  
- 자체표현구조  
REST API메세지만 보고도 이해가능  
- Client - Server 구조  
서버와 클라이언트의 역할이 확실히 구분되어 의존성을 낮춤  
- 계층화  
서버의 각 유형(보안, 로드밸런싱, 암호화 등)이 계층화 되어 유연한 구조를 가지고 클라이언트가 볼 수 없음  
- 범용성  
HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용가능하다.  

## 단점
- 표준이 존재하지 않음  
- HTTP 메소드가 4개라 표현이 제한적이다.  
