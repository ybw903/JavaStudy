package chaptor.exception.runtimeException;

public class ClassCastExceptionExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        changeDog(dog);

        Cat cat = new Cat();
        changeDog(cat);

    }

    public static void changeDog(Animal animal) {
        Dog dog = (Dog) animal;
        // instanceof를 사용하여 타입 변환이 가능한지 확인하는 것이 좋음
    }
}

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}
