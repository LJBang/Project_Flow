# JPA Query
JPA에서 함수형 쿼리사용과,  
직접 쿼리를 만들어 사용하는 법.  

`JpaRepository`를 상속받으면 기본적으로 제공되는 쿼리들이 있고,  
메서드 명명규칙에 따라 메서드를 만들면 자동 생성되는 쿼리도 존재한다.  

## 기본 제공 쿼리
- save(S): 엔티티를 저장한다. 새로운엔티티는 생성하고, 기존 엔티티는 변경사항을 저장한다.  
- delete(T): 엔티티 하나를 삭제한다.  
- findById(ID): `@id`지정된 id값으로 엔티티 하나를 조회한다.
- getOne(ID): 엔티티를 프록시로 조회한다.
- findAll(): 모든 엔티티를 조회한다.

## Query Method
jpa에서 정한 메서드 명명규칙에 따라 메서드를 만들면 쿼리가 자동생성된다.  
- findByMainId : `mainId`값을 이용해 엔티티를 조회한다.  
- countByMainId : `mainId`값이 같은 엔티티의 개수를 집계한다.  
위와 같이 `findBy~`, `countBy~`뒤에 엔티티의 속성을 대문자로 시작하도록 넣어주면 된다.  

추가적인 규칙이 존재한다. 위의 규칙에 키워드를 더해 더 많은 쿼리를 작성할 수 있다.  
|키워드|샘플|설명|
|:---:|:---:|:---:|
|And|findByMainIdAndName|여러 컬럼을 and로 결합하여 검색|
|Or|countByMainIdOrName|여러 컬럼을 or로 결합하여 검색|
|Like|findByNameLike|sql의 like검색|
|Less(Greater)Than(Equal)|countByPriceGreaterThanEqual|컬럼값에 대합 비교구문|

등이 있고 더 많은 규칙은 [여기](https://docs.spring.io/spring-data/jpa/docs/2.3.9.RELEASE/reference/html/#reference)에 정리되어 있다.  


## Query 직접 정의
`@Query`어노테이션을 통해 사용하고 싶은 쿼리를 직접 작성할 수 있다.  
```java
    @Query("select count(acc_type) from accident where acc_type like ?1 and acc_time = ?2")
    public Integer countByAccTypeByDate(String acctype, String acctime);
```  
직접 정의한 쿼리는 위의 쿼리메소드 방식보다 우선순위가 높다.  

`?1`, `?2`를 이용해 파라미터 순서대로 바인딩 할 수 있다.  
위의 예시에서는 `?1`자리에 `acctype`, `?2`자리에 `acctime`이 바인딩 된다.  
네이티브 SQL쿼리문을 사용할 때에는 `?0`부터 바인딩 된다고 한다.  

이름을 기반으로도 파라미터 바인딩을 할 수 있다.  
```java
    @Query("select count(acc_type) from accident where acc_type like :type and acc_time = :time")
    public Integer countByAccTypeByDate(@Param("type") String acctype, @Param("time") String acctime);
```  

