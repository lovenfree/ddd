package did.lemonaid.solution.domain.account;

import lombok.Getter;

@Getter
public class AccountInfo {
    private final Long id;
    private final String accountId;
    private final String accountName;
    private final String cellphoneNumber;
    private final String phoneNumber;
    private final Account.AccountStatus accountStatus;
    private final String authIp;


    public AccountInfo(Account account) {
        this.id = account.getId();
        this.accountId = account.getAccountId();
        this.accountName = account.getAccountName();
        this.cellphoneNumber = account.getCellphoneNumber();
        this.phoneNumber = account.getPhoneNumber();
        this.accountStatus = account.getAccountStatus();
        this.authIp = account.getAuthIp();
    }
}
