package labs;

public class BankAccountApp {
    public static void main(String[] args) {
        bankAccount account1 = new bankAccount("350592933", 1000);
        // bankAccount account2 = new bankAccount("360692829", 2000);
        // bankAccount account3 = new bankAccount("370792778", 3000);

        account1.setName("ismail");
        System.out.println(account1.getName());
        account1.payBill(400);
        account1.makeDeposit(600);
        account1.showBalance();
        account1.accrue();
        System.out.println(account1.toString());

        // account2.setName("ishaaq");
        // System.out.println(account2.getName());

        // account3.setName("yaquub");
        // System.out.println(account3.getName());

    }
}

class bankAccount implements interestrate {
    // properties of bank accounts

    private static int ID = 1000; // internal id
    private String accountName;
    private String accountNumber; // id + random 2 numbers + first 2 of the sort code number
    private static int sortCode = 500001;
    private String ssn;
    // private static final String routingNumber = "005400057";
    // private String reference;
    private double balance;

    // constructors

    public bankAccount(String ssn, double deposit) {
        System.out.println("new account created");
        this.ssn = ssn;
        balance = deposit;
        ID++;
        setaccountNumber();
        setsortCode();
        // setBalance();
    }

    private void setaccountNumber() {
        int random = (int) (Math.random() * 100);
        accountNumber = ID + "" + random + ssn.substring(0, 2);
        System.out.println("your account number is: " + accountNumber);
    }

    private void setsortCode() {
        sortCode++;
        System.out.println("your sortcode is " + sortCode);
    }

    public void setName(String accountName) {
        this.accountName = accountName;
    }

    public String getName() {
        return accountName;
    }

    public void payBill(double amount) {
        balance = balance - amount;
        System.out.println("bill amount: " + amount);
        showBalance();
    }

    public void makeDeposit(double amount) {
        balance = balance + amount;
        System.out.println("deposit amount: " + amount);
        showBalance();
    }

    public void showBalance() {
        System.out.println("balance: " + balance);
    }

    @Override
    public void accrue() {
        balance = balance * (1 + rate / 100);
        System.out.println("balance with interest: " + balance);
    }

    @Override
    public String toString() {
        return "Name: " + accountName + " account nnumber: " + accountNumber + " snn: " + ssn + " balance: " + balance;
    }

}