package System;

public enum BillType {
    PURCHASED_ITEMS("PURCHASED_ITEMS"),
    SCHOOL("SCHOOL"),
    ELECTRICITY("ELECTRICITY"),
    GAS("GAS"),
    LICENSE_RENEWAL("LICENSE_RENEWAL"),
    MOBILE_CREDIT_CHARGE("MOBILE_CREDIT_CHARGE"),
    SUBSCRIPTION("SUBSCRIPTION"),
    WATER_BILL("WATER_BILL");
    private String billType;

    BillType(String bt) {
        this.billType = bt;
    }
    BillType() {
    }

    public String BillType() { return billType; }

    @Override public String toString() { return billType; }
}
