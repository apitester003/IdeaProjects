package Tutorial.Tut_DesignPatterns;

public class OnlineStoreAccount {
    private Long id;
    private String name;
    private String address;
    private Long budget;
    private Long discountRate;

    /*public OnlineStoreAccount(Long id, String name, String address, Long budget, Long discountRate){
            this.id = id;
            this.name = name;
            this.address = address;
            this.budget = budget;
            this.discountRate = discountRate;
    }*/

    public static class Builder{
        private Long id;
        private String name;
        private String address;
        private Long budget;
        private Long discountRate;

        public Builder(Long id){
            this.id = id;
        }

        public Builder withName(String name){
            this.name = name;

            return this;
        }

        public Builder withAdress(String address){
            this.address = address;

            return this;
        }

        public Builder withBuget(Long buget){
            this.budget = budget;

            return this;
        }

        public Builder withDiscount(Long discountRate){
            this.discountRate = discountRate;

            return this;
        }

        public OnlineStoreAccount build(){
            OnlineStoreAccount onlineStoreAccount = new OnlineStoreAccount();
            onlineStoreAccount.id = this.id;
            onlineStoreAccount.name = this.name;
            onlineStoreAccount.address = this.address;
            onlineStoreAccount.budget = this.budget;
            onlineStoreAccount.discountRate = this.discountRate;

            return onlineStoreAccount;
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Long getBudget() {
        return budget;
    }

    public Long getDiscountRate() {
        return discountRate;
    }
}
