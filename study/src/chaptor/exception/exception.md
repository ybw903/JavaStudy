### 예외와 예외 클래스
**예외**란 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인해 발생하는 프로그램 오류입니다.

예외가 발생되면 프로그램은 곧바로 종료된지만 **예외 처리**를 통해 프로그램을 종료하지 않고 정상 실행 상태가 유지되도록 할 수 있습니다.

---
예외는 **Checked Exception**과 **Unchecked Exception(Runtime Exception)** 두 가지 종류가 있습니다.

Checked Exception의 경우 컴파일하는 과정에서 예외 처리 코드가 필요한지 검사하여 없다면 컴파일 오류를 발생시킵니다.

Unchecked Exception의 경우 컴파일 하는 과정에서 예외 처리 코드를 검사하지 않는 예외를 말합니다.

**두 가지 예외는 모두 예외 처리가 필요합니다.**

---
자바에서는 예외를 클래스로 관리합니다.

JVM은 프로그램을 실행하는 도중에 예외가 발생하면 해당 예외 클래스로 객체를 생성합니다.

그리고 나서 예외 처리 코드에서 예외 객체를 이용할 수 있도록 해줍니다.

모든 예외 클래스들은 java.lang.Exception 클래스를 상속받습니다.

**Checked Exception : Exception 상속 O, Runtime Exception 상속 X**

**Unchecked Exception : Runtime Exception 상속 O**

Runtime Exception 역시 Exception을 상속받지만, **JVM은 RuntimeException을 상속했는지
여부를 부고 실행 예외를 판단합니다.**