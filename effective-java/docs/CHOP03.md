## 모든 객체 공통 메서드

### Item10. equals 는 일반 규약을 지켜 재정의 하자.

#### equals 메스드를 재정의 할 필요가 없는 경우
 1. 각 인스턴스가 본질적으로 고유할 때
 
    값 클래스(```Integer```나 ```String```처럼 값을 표현하는 클래스)가 아닌 동작하는 개체를
    표현하는 클래스
    ex) ```Thread```
    
 2. 인스턴스의 '논리적 동치성'을 검사할 일이 없을 때
 
    ex) ```java.util.regax.Pattern```은 ```equals```를 재정의해 
    두 ```Pattern```의 정규표현식을 비교
 
 3. 상위 클래스에서 재정의한 ```equals```가 하위 클래스에서도 딱 들어맞을 때
 
    ex) ```Set```은 ```AbstractSet```이 구현한 ```equals```를 상속,
     ```List```는 ```AbstractList```, ```Map```은 ```AbstractMap```
 
 4. 클래스가 <i>private</i>이나 <i>package-private</i>이고 ```equals```를 호출할 일이 없을 때
 <br/> 아래와 같이 구현해 ```equals```가 실수라도 호출되는 걸 막을 수 있다.
 
 ```java
@Override public boolean equals(Object o) {
	throw new AssertionError(); // 호출 금지!
} 
```

#### equals 메서드를 재정의 해야 하는 경우
객체 식별성(object identity; 두 객체가 물리적으로 같은가)이 아닌 '논리적 동치성'을 확인해야 하는데,
상위 클래스의 equals가 논리적 동치성을 비교하도록 재정의 되지 않았을 때 (주로 값 클래스)

ex) 두 값 객체를 equals로 비교하는 경우, 객체가 같은지가 아니라 값이 같은지를 알고싶을 것입니다.
equals가 논리적 동치성을 확인하도록 재정의하면, 값 비교는 물론 Map의 키와 Set의 원소로 사용 가능.
but, 값 클래스여도, 같은 인스턴스가 둘 이상 만들어지지 않는 인스턴스 통제 클래스라면 재정의하지 않아도 됩니다.

#### equals 메서드 재정의 일반 규약: 동치관계
 - 반사성(reflexivity)
    : ```null```이 아닌 모든 참조 값 x에 대해, ```x.equals(x)```는 ```true```다.
 
 - 대칭성(symmetry)
    : ```null```이 아닌 모든 참조 값 x,y에 대해, ```x.equals(y)```가
     ```true```이면 ```y.equals(x)```도```true```다.
 
 - 추이성(transitivity)
    : ```null```이 아닌 모든 참조 값 x,y,z에 대해, ```x.equals(y)```가 ```true```이고
    ```y.equals(z)```도 ```true```면 ```x.equals(z)```도 ```true```이다.
 
 - 일관성(consistency)
    : ```null```이 아닌 모든 참조 값 x,y에 대해, x.equals(y)를 반복해서 호출하면 항상
    ```true```이거나 ```false```다.
    
 - null-아님
    : ```null```이 아닌 모든 참조 값 x에 대해, x.equals(null)은 false다. 

#### 양질의 equals 메서드 구현 방법
 1. ```==```연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.
 
 2. ```instanceof``` 연산자로 입력이 올바른 타입인지 확인한다.
 
 3. 입력을 올바른 타입으로 형변환 한다.
 
 4. 입력 객체와 자기 자신의 대응는 '핵심'필드들이 모두 일치하는지 하나씩 검사한다.
    
    모두 일치해야 ```true```를 반환한다.
    
#### 결론
꼭 필요한 경우가 아니면 ```equals```를 재정의하지 말자. 많은 경우에 ```Object```의 ```equals```가
 원하는 비교를 정확히 수행해줍니다. 재정의해야 할 때는 그 클래스의 핵심 필드 모두를 빠짐없이,
 다섯 가지 규약을 확실히 지켜가며 비교해야 합니다.   

### Item11. equals 를 재정의하려거든 hashCode도 재정의 하자.

### Item12. toString 을 항상 재정의하자.

### Item13. clone 재정의는 주의해서 진행하자.

### Item14. Comparable 을 구현할지 고려하라.