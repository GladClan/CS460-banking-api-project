package edu.ensign.cs460.repository;

import edu.ensign.cs460.domain.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountRepositoryTest {

    @Mock
    private AccountRepository accountRepository;

    @Test
    public void testFindByUserId() {
        // Given: Set up the conditions for the test
        Account mockAccount1 = new Account();
        mockAccount1.setUserId(1L);
        mockAccount1.setAccountNumber("1234567890");
        mockAccount1.setAccountType("Savings");
        mockAccount1.setBalance(new BigDecimal("1000.00"));
        mockAccount1.setCreationDate(new Date());
        mockAccount1.setStatus("Active");
        
        Account mockAccount2 = new Account();
        mockAccount2.setUserId(1L);
        mockAccount2.setAccountNumber("1234567891");
        mockAccount2.setAccountType("Checking");
        mockAccount2.setBalance(new BigDecimal("2000.00"));
        mockAccount2.setCreationDate(new Date());
        mockAccount2.setStatus("Active");

        // Define the behavior of the mock object
        when(accountRepository.findByUserId(1L)).thenReturn(Arrays.asList(mockAccount1, mockAccount2));

        // When: Execute the method under test
        List<Account> found = accountRepository.findByUserId(1L);

        // Then: Check the results
        assertThat(found).hasSize(2);
        assertThat(found.get(0).getAccountNumber().equals("1234567890"));
        assertThat(found.get(0).getAccountType().equals("Savings"));
        assertThat(found.get(0).getBalance()).isEqualTo(new BigDecimal("1000.00"));
    }

    @Test
    public void testFindByAccountType() {
        // Given: Set up the conditions for the test
        Account mockAccount = new Account();
        mockAccount.setUserId(1L);
        mockAccount.setAccountNumber("1234567890");
        mockAccount.setAccountType("Savings");
        mockAccount.setBalance(new BigDecimal("1000.00"));
        mockAccount.setCreationDate(new Date());
        mockAccount.setStatus("Active");

        // Define the behavior of the mock object
        when(accountRepository.findByAccountType("Savings")).thenReturn(Arrays.asList(mockAccount));

        // When: Execute the method under test
        List<Account> accounts = accountRepository.findByAccountType("Savings");

        // Then: Check the results
        assertThat(accounts).hasSize(1);
        assertThat(accounts.get(0).getAccountType()).isEqualTo("Savings");
    }

    @Test
    public void testFindByBalanceGreaterThanEqual() {
        // Given: Set up the conditions for the test
        Account mockAccount = new Account();
        mockAccount.setUserId(1L);
        mockAccount.setAccountNumber("1234567890");
        mockAccount.setAccountType("Savings");
        mockAccount.setBalance(new BigDecimal("1000.00"));
        mockAccount.setCreationDate(new Date());
        mockAccount.setStatus("Active");

        // Define the behavior of the mock object
        when(accountRepository.findByBalanceGreaterThanEqual(new BigDecimal("1000.00"))).thenReturn(Arrays.asList(mockAccount));

        // When: Execute the method under test
        List<Account> accounts = accountRepository.findByBalanceGreaterThanEqual(new BigDecimal("1000.00"));

        // Then: Check the results
        assertThat(accounts).hasSize(1);
        assertThat(accounts.get(0).getBalance()).isEqualTo(new BigDecimal("1000.00"));
    }

    @Test
    public void testFindByBalanceLessThanEqual() {
        // Given: Set up the conditions for the test
        Account mockAccount = new Account();
        mockAccount.setUserId(1L);
        mockAccount.setAccountNumber("1234567890");
        mockAccount.setAccountType("Savings");
        mockAccount.setBalance(new BigDecimal("500.00"));
        mockAccount.setCreationDate(new Date());
        mockAccount.setStatus("Active");

        // Define the behavior of the mock object
        when(accountRepository.findByBalanceLessThanEqual(new BigDecimal("500.00"))).thenReturn(Arrays.asList(mockAccount));

        // When: Execute the method under test
        List<Account> accounts = accountRepository.findByBalanceLessThanEqual(new BigDecimal("500.00"));

        // Then: Check the results
        assertThat(accounts).hasSize(1);
        assertThat(accounts.get(0).getBalance()).isEqualTo(new BigDecimal("500.00"));
    }

    @Test
    public void testUpdateBalance() {
        // Given: Set up the conditions for the test
        BigDecimal newBalance = new BigDecimal("1500.00");
        Long accountId = 1L;

        // Define the behavior of the mock object
        when(accountRepository.updateBalance(newBalance, accountId)).thenReturn(1);

        // When: Execute the method under test
        int updatedRows = accountRepository.updateBalance(newBalance, accountId);

        // Then: Check the results
        assertThat(updatedRows).isEqualTo(1);
    }
}