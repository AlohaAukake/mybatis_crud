package mapper;

import domain.Account;
import domain.UserAccount;

import java.util.List;

public interface AccountMapper {
    List<UserAccount> getAllAccount();

    List<Account> getAllAccountByResMap();
}
