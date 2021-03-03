package chaptor.lambdaExpression.functionalInterfaceOfStandardAPI.andThenAndComposeMethod;

public class Address {
    private String country;
    private String city;

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }
}
