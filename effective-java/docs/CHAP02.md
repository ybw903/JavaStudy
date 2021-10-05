## 객체의 생성과 파괴
### Item1. 생성자 대신에 정적 팩토리 메서드 패턴을 고려하자

1. 생성자와 달리 정적 팩토리 메서드 패턴에서는 메서드 이름을 가질 수 있습니다.

2. 생성자와 달리 호출할 때마다 새 객체를 만들 필요가 없습니다.

3. 하위 클래스를 반환할 수 있는 유연성을 가질 수 있습니다.

4. 매개 변수에 따라 매번 다른 클래스의 객체를 반환할 수 있습니다.

5. 정적 팩토리 메서드를 작성하는 시점에는 해당 객체의 클래스가 존재하지 않아도 됩니다.

반면,

정적 팩토리 메서드패턴은 public 또는 protected 생성자가 없는 경우에는
하위 클래스에서 사용할 수 없습니다.

또한, 프로그래머가 생성자와 달리 찾기 어렵습니다.

따라서,

* from 하나의 파라미터를 입력받아 그에 상응하는 타입을 반환
     ```java
    Date d= Date.from(instance);
    ```

* of 여러 파라미터를 입력받아 구성하는 타입을 반환
    ```java
  Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);  
  ```

* valueOf

* instance or getInstance

* create or newInstance

* getType

* newType

* type

과 같은 규약에 맞춰 사용합니다.


