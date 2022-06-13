package did.lemonaid.solution.domain.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
public class AccountCommand {

    String accountId;
    String accountPw;
    String accountName;
    String cellphoneNumber;
    String email;
    String authIp;

    public Account toEntity() {
        return Account.builder()
                .accountId(accountId)
                .accountName(accountName)
                .cellphoneNumber(cellphoneNumber)
                .email(email)
                .authIp(authIp)
                .build();
    }
}
