package gov.irs;

public interface IRS {
    public void collectTaxes();
    public void register(TaxPayer payer);

    // static factory method - clients MUST come here for the instance
    public static IRS getInstance() {
        return IRSEnum.INSTANCE;
    }
}
