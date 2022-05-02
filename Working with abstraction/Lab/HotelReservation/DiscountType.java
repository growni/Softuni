package abstractions.Lab.HotelReservation;

public enum DiscountType {
    None(0),
    SecondVisit(10),
    VIP(20);

    private int discount;

    public int getDiscount() {
        return discount;
    }

    DiscountType(int discount) {
        this.discount = discount;
    }
}
