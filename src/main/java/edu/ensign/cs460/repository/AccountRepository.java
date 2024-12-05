package edu.ensign.cs460.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.ensign.cs460.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserId(Long userId);
    List<Account> findByAccountType(String accountType);
    List<Account> findByBalanceGreaterThanEqual(BigDecimal threshold); 
    List<Account> findByBalanceLessThanEqual(BigDecimal threshold);

    @Modifying 
    @Query("update Account a set a.balance = ?1 where a.id = ?2") 
    int updateBalance(BigDecimal newBalance, Long accountId);
}
