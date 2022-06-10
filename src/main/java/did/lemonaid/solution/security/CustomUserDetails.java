package did.lemonaid.solution.security;


import did.lemonaid.solution.domain.account.Account;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
@ToString
public class CustomUserDetails implements UserDetails {
    private String id;
    private String accountId;
    private String accountPwHash;
    private int accountPwFailCount;
    private String accountName;
    private Account.AccountStatus accountStatus;
    private String authIp;
    private Collection<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
//        auth.add(new SimpleGrantedAuthority(accountType.toString()));
        return auth;
    }

    @Override
    public String getPassword() {
        return accountPwHash;
    }

    @Override
    public String getUsername() {
        return accountName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountPwFailCount == 5 ? false:true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return accountStatus.equals(Account.AccountStatus.DEACTIVATE)?false:true;
    }
}
