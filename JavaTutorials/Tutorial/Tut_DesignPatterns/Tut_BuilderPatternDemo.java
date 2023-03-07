package Tutorial.Tut_DesignPatterns;

public class Tut_BuilderPatternDemo {
    public static void main(String[] args) {
        OnlineStoreAccount johnSmith = new OnlineStoreAccount.Builder(1L)
                .withName("John Smith")
                .withAdress("Liberty Lane 23")
                .withBuget(100L)
                .withDiscount(2L)
                .build();
        System.out.println(johnSmith.getName());
    }
}
