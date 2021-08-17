# Builder패턴
java에서 주로 사용하는 builder패턴을 공부해보자.  

## 클래스의 인자
자바에서 클래스를 설계할 때 여러개의 인자들을 선택적으로 받아와야 하는 경우가 생긴다.  
이 때, 기본 문법대로라면 아래와 같이 점진적 생성자 방식을 사용할 수 있다.  
```java
public class PersonInfo{
    private String name;         
    private int age;                
    private String phoneNum;   
    public PersonInfo(String name){
       this.name = name;
    }
    public PersonInfo(String name, int age){
      this.name = name;
      this.age = age;
    }
    public PersonInfo(String name, int age, String phoneNum){
      this.name = name;
      this.age = age;
      this.phoneNum = phoneNum;
    }
}
```  

```java
PersonInfo('홍길동', 13, '010-1234-5678`)
```
이와 같은 패턴은 코드가 너무 많아질 수 있고,  
초기화할 때 헷갈릴 수 있다.  

## Builder패턴
빌더 패턴을 적용하면 각 인자가 어떤 의미인지 쉽게 알 수 있고, 객체 일관성도 유지된다.  
올바른 값이 입력되었는지 검증도 가능하다.  
```java
public class PersonInfo{
    // 기본값을 지정
    private String name = '홍길동';         
    private int age = 100;                
    private String phoneNum = '010-1234-5678';   
    public PersonInfo(){
    }
    public static class Builder{
        private String name;         
        private int age;                
        private String phoneNum; 
    
        public Builder(){
        }
        public Builder setName(String name){
            this.name=name;
            return this;
        }
        public Builder setAge(int age){
            this.age=age;
            return this;
        }
        public Builder setPhoneNum(String phoneNum){
            this.phoneNum=phoneNum;
            return this;
        }

        public PersonInfo build(){
            return new PersonInfo(this)
        }
    }
    
    private PersonInfo(Builder builder){
        name = builder.name;
        age = builder.age;
        phoneNum = builder.phoneNum;
    }
}
```  

```java
PersonInfo personA = new PersonInfo
    .Builder()
    .setName("가나다")
    .setAge(123)
    .build();
```
와 같이 사용할 수 있다.  

물론 빌더패턴의 코드도 상당하기 때문에 적절하게 사용하여야 한다.  