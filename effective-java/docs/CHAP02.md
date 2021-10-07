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

### Item2. 생성자의 매개변수가 많다면 빌더를 고려하자

정적 팩토리와 생성자는 대규모로 확장하는데 어려움을 가지고 있습니다.

```java
// Telescoping constructor pattern - does not scale well!
public class NutritionFacts {
    private final int servingSize; // (mL) required
    private final int servings; // (per container) required
    private final int calories; // (per serving) optional
    private final int fat; // (g/serving) optional
    private final int sodium; // (mg/serving) optional
    private final int carbohydrate; // (g/serving) optional

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }
    public NutritionFacts(int servingSize, int servings,
            int calories) {
        this(servingSize, servings, calories, 0);
    }
    public NutritionFacts(int servingSize, int servings,
            int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }
    public NutritionFacts(int servingSize, int servings,
            int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }
    public NutritionFacts(int servingSize, int servings,
            int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
```

점층적 생성자 패턴(Telescoping constructor pattern)은 필수 매개변수만 받는 생성자부터
 시작하여 필수 매개변수와 선택 매개변수 1개를 받는 생성자,
  선택 매개변수를 2개 받는 생성자, ..., 선택 매개변수를 전부 다 받는 생성자까지 모든 생성자를
   작성하는 방식입니다.
   
하지만 점층적 생성자 패턴은 선택적 매개변수가 많을 때 적절히 대응하기 어렵다는 단점과 
매개변수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다는 단점이 존재합니다.

```java
// JavaBeans Pattern - allows inconsistency, mandates mutability
public class NutritionFacts {
    // Parameters initialized to default values (if any)
    private int servingSize = -1; // Required; no default value
    private int servings = -1; // Required; no default value
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;
    public NutritionFacts() { }
    // Setters
    public void setServingSize(int val) { servingSize = val; }
    public void setServings(int val) { servings = val; }
    public void setCalories(int val) { calories = val; }
    public void setFat(int val) { fat = val; }
    public void setSodium(int val) { sodium = val; }
    public void setCarbohydrate(int val) { carbohydrate = val; }
}
```
자바빈즈 패턴은 매개변수가 없는 생성자로 객체를 만든 후, 
Setter메서드를 통해 매개변수의 값을 설정하는 방식입니다.

그러나 이러한 자바빈즈 패턴도 심각한 단점을 지니고 있습니다. 

객체 하나를 만들기 위해 여러 개의 메서드를 호출해야 하고, 객체가 완전히 생성되기 전까지는
 일관성(consistency)이 무너진 상태에 놓이게 된다는 것입니다.

따라서 자바빈즈 패턴에서는 클래스를 불변으로 만들 수 없으며, 스레드 안전성을 얻으려면 
프로그래머가 추가 작업을 해줘야만 합니다.

이러한 단점을 완화하고자 생성이 끝난 객체를 수동으로 freezing하기 전에는 사용할 수 없도록 
하기도 합니다.
 
그러나 이 방법은 다루기 어려울 뿐만 아니라 프로그래머가 freeze 메서드를 확실히 호출해줬는지를
 컴파일러가 보증할 방법이 없어 런타임 오류에 취약합니다.

```java
// Builder Pattern
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int val)
        { calories = val; return this; }
        public Builder fat(int val)
        { fat = val; return this; }
        public Builder sodium(int val)
        { sodium = val; return this; }
        public Builder carbohydrate(int val)
        { carbohydrate = val; return this; }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }
    private NutritionFacts(Builder builder) {
    servingSize = builder.servingSize;
    servings = builder.servings;
    calories = builder.calories;
    fat = builder.fat;
    sodium = builder.sodium;
    carbohydrate = builder.carbohydrate;
    }
}
```
빌더 패턴은 점층적 생성자 패턴의 안정성과 자바빈즈 패턴의 가독성을 겸비하였습니다.

클라이언트는 필요한 객체를 직접 만드는 대신, 필수 매개변수만으로 생성자를 호출해 
빌더 객체를 얻습니다. 그 후 빌더 객체가 제공하는 일종의 세터 메서드들로 원하는 
선택 매개변수들을 설정하고, 마지막으로 매개변수가 없는 build 메서드를 통해 
필요한 객체를 얻을 수 있습니다.

이러한 빌더 패턴의 단점으로 객체를 만들기 위해서 빌더부터 만들어야 한다는 것입니다. 
빌더 생성 비용이 크지는 않지만 성능에 민감한 상황에서는 문제가 될 수 있다.

### Item3. private 생성자 또는 enum type 으로 싱글톤에 적용해보자
싱글톤은 인스턴스를 오직 하나만 생성할 수 있는 클래스를 의미합니다.

싱글톤은 클라이언트에서 테스트 하기 어렵게 만듭니다.
```java
// Singleton with public final field
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() { ... }

    public void leaveTheBuilding() { ... }
}
```

```java
// Singleton with static factory
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() { ... }
    public static Elvis getInstance() { return INSTANCE; }

    public void leaveTheBuilding() { ... }
}
```

```java
// readResolve method to preserve singleton property
private Object readResolve() {
    // Return the one true Elvis and let the garbage collector
    // take care of the Elvis impersonator.
    return INSTANCE;
}
```

```java
// Enum singleton - the preferred approach
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() { ... }
}
```
대부분 상황에서 원소가 하나뿐인 열거타입이 싱글톤을 만드는 가장 좋은 방법입니다.


### Item4. 인스턴스화를 막으려면 private 생성자를 사용해보자
정적 메서드와 정적 필드만 포함된 클래스는 인스턴스화가 필요없을 것입니다.

이 때, 추상 클래스를 사용하여 인스턴스화를 막으려는 시도는 의도대로 되지 않을 것입니다.

추상 클래스는 상속을 의도로 사용되고, 하위클래스에서 인스턴스화될 수 있기 때문입니다.

이러한 경우, private 생성자를 사용하여 인스턴스화를 막을 수 있습니다.

```java
// Noninstantiable utility class
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }
    ... // Remainder omitted
}
```

### Item5. 자원을 직접 명시하지 말고 Dependency injection (의존성 주입)을 사용하자
다음 아래 코드는 리소스를 의존하는 정적 유틸리티와 싱글톤클래스 코드입니다.
```java
// Inappropriate use of static utility - inflexible & untestable!
public class SpellChecker {
    private static final Lexicon dictionary = ...;

    private SpellChecker() {} // Noninstantiable

    public static boolean isValid(String word) { ... }
    public static List<String> suggestions(String typo) { ... }
}
```

```java
// Inappropriate use of singleton - inflexible & untestable!
public class SpellChecker {
    private final Lexicon dictionary = ...;

    private SpellChecker(...) {}
    public static INSTANCE = new SpellChecker(...);

    public boolean isValid(String word) { ... }
    public List<String> suggestions(String typo) { ... }
}
```
위의 경우, dictionary 에 너무 밀접한 의존관계를 가지게 되어, 오직 단, 하나의 사전에 대해서만
코드가 동작 될 수 밖에 없어 유연하지 못하고 테스트코드를 작성 할 수 없습니다. 

이러한 경우, 인스턴스를 만들 때, 생성자에 리소스를 전달하는 의존성 주입을 통해 해결 할 수 있습니다.

```java
// Dependency injection provides flexibility and testability
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) { ... }
    public List<String> suggestions(String typo) { ... }
}
```
의존성 주입은 유연성과 테스트 가능성을 크게 향상시키지만, 일반적으로 수천 개의 종속성을 포함하는
대규모 프로젝트를 복잡하게 만들 수 있습니다. 하지만, 의존성 주입 프레임워크를 사용하게 되면 이를
해결 할 수 있습니다.

### Item6. 불필요한 객체생성을 피하자
새로운 기능을 생성하는 대신 단일 객체를 재사용하는 것이 종종 적절합니다.

정적 팩토리 메서드 패턴을 사용하여 불필요한 객체 생성을 방지할 수 있습니다.

생산 비용이 큰 객체가 있다면, 이는 매번 생성하기보다 객체 하나를 재사용하는 것이 훨씬 빠르고
효율적입니다.
```java
// Performance can be greatly improved!
static boolean isRomanNumeral(String s) {
    return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
}
```
위의 경우는, 유효한 로마 숫자인지 확인하는 메서드입니다. 

하지만 이 코드는 String.matches 에 의존하는 문제가 존재합니다.

String.match 는 문자열이 일치하는지 확인하는 가장 쉬운 방법이지만, 반복적으로
호출될 경우, 성능상에 큰 문제를 야기할 수 있습니다.

```java
// Reusing expensive object for improved performance
public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile(
        "^(?=.)M*(C[MD]|D?C{0,3})"
        + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
```

### Item7. 쓸모없는 객체참조를 제거하자
```java
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; //Eliminate obsolete reference
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
```

위의 코드에서 주석이 적혀있는 라인을 제거하게 되면, 장기적으로 프로그램이 동작하면서 메모리 누수가
발생하게 됩니다.
 
 따라서 더 이상 필요 없는 객체는 참조해제 해주어 메모리 누수를 예방해주어야 합니다.

### Item8. Finalizers 와 Cleaner 의 사용을 피하자
Finalizers 는 예측할 수 없고 종종 위험하며 일반적으로 불필요합니다.

Cleaner 는 Finalizers 보다 덜 위험하지만 여전히 예측할 수 없고 느리고
 일반적으로 불필요합니다.
 
### Item9. try-finally 보다는 try-with-resource 를 사용하자

```java
// try-finally - No longer the best way to close resources!
static String firstLineOfFile(String path) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(path));
    try {
        return br.readLine();
    } finally {
        br.close();
    }
}
```
역사적으로, try-finally 를 통해 예외 또는 return 에 직면하였을 때, 자원을
닫는 가장 좋은 방법이었습니다.

```java
// try-finally is ugly when used with more than one resource!
static void copy(String src, String dst) throws IOException {
    InputStream in = new FileInputStream(src);
    try {
        OutputStream out = new FileOutputStream(dst);
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        } finally {
            out.close();
        }
    } finally {
        in.close();
    }
}
```
먼저, 여러 자원을 사용할 때, try-finally 코드는 지저분해집니다.

또한, 예외는 try 블록과 finally 블록 모두에서 발생 할 수 있습니다.
finally 블록에서 예외가 발생된다면 앞에서 try 블록에서 예외가 발생했다는
정보를 얻을 수 없습니다.

이러한 문제는 Java7에서 추가된 try-with-resource 를 통해 해결 할 수 있게 되었습니다.

이 때, try-with-resource 구조를 사용하기 위해서는 close 메소드를 정의하기 위한 AutoClosable
인터페이스를 구현해 주어야 합니다.

앞의 예제 코드를 try-with-resource 로 구현하면 아래와 같이 작성할 수
있습니다.
```java
// try-with-resources - the the best way to close resources!
static String firstLineOfFile(String path) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        return br.readLine();
    }
}
```

```java
// try-with-resources on multiple resources - short and sweet
static void copy(String src, String dst) throws IOException {
    try (InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst)) {
        byte[] buf = new byte[BUFFER_SIZE];
        int n;
        while ((n = in.read(buf)) >= 0)
            out.write(buf, 0, n);
    }
}
```
try-with-resource 를 사용하게 되면 코드가 간결해지고, 가독성을 증가시킬 수 있습니다.

또한, try 블록 내부 코드가 실행완료 되면, 알아서 AutoClosable 의 close 메서드가 호출되어
자원을 닫습니다.

게다가, try-finally 와 다르게 close 에서 문제가 생기더라도 해당 예외가 숨겨진 채, try 블록에서
발생된 에러를 확인 할 수 있습니다.

```java
// try-with-resources with a catch clause
static String firstLineOfFile(String path, String defaultVal) {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        return br.readLine();
    } catch (IOException e) {
        return defaultVal;
    }
}
```

또한, try-finally 와 동일하게 try-with-resource 에서도 catch 절을 사용할 수 있어 try 문을
중첩하지 않고도 다수의 예외를 처리 할 수 있습니다.