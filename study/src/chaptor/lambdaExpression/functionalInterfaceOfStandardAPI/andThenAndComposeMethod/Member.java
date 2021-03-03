package chaptor.lambdaExpression.functionalInterfaceOfStandardAPI.andThenAndComposeMethod;

public class Member {
    private String name;
    private String id;
    private Address address;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public Member(String name, String id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }
}
