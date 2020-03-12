package proxy;

/**
 * @Author: Sandro
 * @Create: 2019-06-20 14:30
 * @Info:
 **/
public class AccountWithChecker implements Account {
    private Account account;

    public AccountWithChecker(Account account) {
        this.account = account;
    }

    @Override
    public void operation() {
        PrivacyChecker.checkPrivacy();
        account.operation();
    }

    public static void main(String[] args) {
        AccountWithChecker accountWithChecker = new AccountWithChecker(new AccountImpl());
        accountWithChecker.operation();
    }
}