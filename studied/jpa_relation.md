# JPA에서의 연관관계
SQL DB상에서의 연관관계 정의는 한번 연결해놓으면 서로를 참조하도록 되어있다.  
JPA에서는 각 Entity에 단방향 매핑을 서로 해주어 양방향으로 매핑한다.  
공부해보니 사실 양방향을 지양하는 개발자들이 많았다.  

## 1:1관계
1대1 관계에서는 외래키를 가지고있는 엔티티 객체에서  
`@OneToOne`어노테이션을 추가해 단방향 관계를 설정해준다.  
양방향을 위해서는 참조되는 엔티티에서도 속성을 만들어 주인 엔티티를 참조하면 된다.  

`@JoinColumn`어노테이션을 통해 `join`할 테이블의 속성을 지정해준다.  
아래와 같이 구성해주었을 경우 `mainEntity`와 `sampleEntity`에서 `sampleId`컬럼값을 비교해  
`sampleId`값이 같은 `sampleEntity`를 `mainEntity`에서 참조할 수 있다.  
```java
public class mainEntity {
    @Id
    @Column(nullable = false)
    private String mainId;

    @OneToOne
    @JoinColumn(name="sampleId")
    private sampleEntity sampleId;
}
```  

## 1:N 관계
`@OneToMany`어노테이션 사용. 보통 외래키가 N쪽에 있는 경우가 많아서 잘 사용하지 않는다고 한다.  
`@ManyToOne`으로 바꾸어 사용할 수도 있으나 상황에 따라 `@OneToMany`로도 충분히 사용가능.  
`1:N` 양방향 관계에서 `mappedBy`옵션과 합께 사용하여 `@ManyToOne`을 사용했을 대상 엔티티의 속성과 연결할 수 있다.    

## N:1 관계
`@ManyToOne`어노테이션 사용. 다대일 관계에서 쉽게 사용할 수 있다.  
일반적인 관계테이블에서 다수쪽이 외래키를 갖고 있기 때문에 편하게 사용할 수 있다.  

## N:1 양방향 예시
`mainEntity`와 `sampleEntity`간의 `1:N`양방향 관계를 알아보자.  
```java
public class mainEntity {
    @Id
    @Column(nullable = false)
    private String mainId;

    @OneToMany(mappedBy="mainId")
    private List<sampleEntity> sampleId;
}
```
```java
public class sampleEntity {
    @Id
    @Column(nullable = false)
    private String sampleId;

    @ManyToOne
    @JoinColumn(name="mainId");
    private mainEntity mainId;
}
```  
`mainEntity`에서 다수의 `sampleEntity`를 리스트 형태로 받아오고,  
`sampleEntity`에서는 하나의 `mainEntity`를 참조하는 구조이다.    

이렇게 양방향 관계를 구성할 경우 조회할 때 무한참조 문제가 발생할 수 있다.  

## N:N 관계
`@ManyTOMany`어노테이션 사용. 그러나 다대다 관계는 보통 중간에 연계해주는 연계테이블을 사용하므로 사용할 일이 거의 없다.  
JPA에서는 두 테이블에서 서로 `@ManyToOne`을 사용하여 참조할 경우 두 테이블의 PK를 속성으로 하는 연계테이블이 자동으로 만들어지며,  
연계테이블에 속성을 넣고 싶은 경우 직접 만들어 두 테이블에서 연계 테이블을 향해 `@ManyToOne`을 사용하면 된다.  
