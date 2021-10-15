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
일반 규약을 어기게 되어 HashMap이나 HashSet 같은 컬렉션 원소로 사용할 때 문제를 일으킬 수 있다.
1. Object 명세의 3가지 규약
* equals비교에 사용되는 정보가 변경되지 않았다면, 객체의 hashcode 메서드는 몇번을 호출해도 항상 일관된 값을 반환해야 한다.
* equals메서드 통해 두 개의 객체가 같다고 판단했다면, 두 객체는 똑같은 hashcode 값을 반환해야 한다.
* equals메서드가 두 개의 객체를 다르다고 판단했다 하더라도, 두 객체의 hashcode가 서로 다른 값을 가질 필요는 없다. (Hash Collision)
  단, 다른 객체에 대해서는 다른 값을 반환해야 해시테이블의 성능이 좋아진다.

**논리적으로 같은 객체는 같은 해시코드를 반환해야한다.**

#### 최악의 hashCode
```java
// The worst possible legal hashCode implementation - never use!
@Override public int hashCode() { return 42; }
```
이 코드는 동치인 모든 객체에서 똑같은 해시코드를 반환하니 적법한 해시코드 처럼 보이지만,
모든 객체에 대해 똑같은 해시코드를 반환하니 모든 객체가 같은 해시테이블 버킷에 담겨
 연결리스트(Linked List)처럼 동작하게 됩니다.
 
평균 수행시간이 O(1)에서 O(n)으로 느려져서, 성능이 매우 낮아질 뿐더러
 버킷에 대한 overflow가 발생하는 경우 데이터가 누락될 수도 있습니다.

#### 좋은 hashCode를 작성하는 방법

1. 핵심 필드를 2.a 방법으로 계산한다
2. 객체의 나머지 핵심 필드에 대해 계산을 수행한다.
<br/>a. 해당 필드의 해시 코드를 계산한다.
<br/>기본 타입 필드 : Type.hashCode(f) = Integer.hashCode(f);
<br/>참조 타입 필드 + equals가 재귀적으로 호출 : hascode도 재귀적 호출
복잡할 것 같으면 표준형(canoical representation)을 만들어 그 표준형의 hashCode를 호출한다.
<br/>필드가 배열이면, 핵심원소 각각을 별도 필드처럼 다룬다. (Arrays.hashCode)
<br/>b. 2.a에서 계산한 해시코드로 갱신한다 : result = 31 * result + c
3. result를 반환한다.

#### hashCode 작성시 주의점
1. 동치인 인스턴스에 대해 똑같은 해시코드를 반환할지 자문하자
```java
// Typical hashCode method
@Override public int hashCode() {
    int result = Short.hashCode(areaCode);
    result = 31 * result + Short.hashCode(prefix);
    result = 31 * result + Short.hashCode(lineNum);
    return result;
}
```
2. equals 비교에 사용되지 않는 필드는 계산에서 무시하자.
3. 성능을 높이기 위해 해시코드 계산시 핵심 필드를 생략해서는 안된다.
<br/>속도는 빨라지겠지만, hash품질이 나빠져 해시테이블 성능을 떨어뜨릴 수 있다 (Hashing Collision)
4. hashCode가 반환하는 값의 생성규칙을 API 사용자에게 자세히 공표하지 말자
<br/>클라이언트 의존도가 낮아지고, 추후에 계산방식을 바꿀 수 있기 때문이다.

#### Object클래스의 hash()메서드
**장점:** hashCode함수를 단 한줄로 작성할 수 있다.

**단점:** 속도가 더 느리다.

#### 캐싱 전략
클래스가 불변 + 해시코드 계산 비용이 다 -> 새로 계산X

객체가 주로 해시의 키로 사용될 것 같을때 = 인스턴스 생성시 해시코드 계산

객체가 주로 해시의 키로 사용되지 않을 것 같을 때 = 지연 초기화 전략 (hashCode가 처음 불릴 때 계산)
```java
// hashCode method with lazily initialized cached hash code
private int hashCode; // Automatically initialized to 0

@Override public int hashCode() {
    int result = hashCode;
    if (result == 0) {
        result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        hashCode = result;
    }
    return result;
}
```
### Item12. toString 을 항상 재정의하자.

### Item13. clone 재정의는 주의해서 진행하자.

### Item14. Comparable 을 구현할지 고려하라.