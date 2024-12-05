package edu.ensign.cs460.repository;

import edu.ensign.cs460.domain.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionRepositoryTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Test
    public void testFindByAccountId() {
        // Given: Set up the conditions for the test
        Transaction mockTransaction1 = new Transaction();
        generateMockTransaction(mockTransaction1);

        Transaction mockTransaction2 = new Transaction();
        generateMockTransaction(mockTransaction2);
        mockTransaction2.setTransactionType("Withdrawal");
        mockTransaction2.setAmount(new BigDecimal("50.00"));
        mockTransaction2.setDescription("ATM withdrawal");
        
        // Define the behavior of the mock object
        when(transactionRepository.findByAccountId(1L)).thenReturn(Arrays.asList(mockTransaction1, mockTransaction2));

        // When: Execute the method under test
        List<Transaction> transactions = transactionRepository.findByAccountId(1L);

        // Then: Check the results
        assertThat(transactions).hasSize(2);
        assertThat(transactions).contains(mockTransaction1, mockTransaction2);
    }

    @Test
    public void testFindByAccountIdAndDateBetween() {
        // Given: Set up the conditions for the test
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        Transaction mockTransaction = new Transaction();
        generateMockTransaction(mockTransaction);

        // Define the behavior of the mock object
        when(transactionRepository.findByAccountIdAndDateBetween(1L, startDate, endDate)).thenReturn(Arrays.asList(mockTransaction));

        // When: Execute the method under test
        List<Transaction> transactions = transactionRepository.findByAccountIdAndDateBetween(1L, startDate, endDate);

        // Then: Check the results
        assertThat(transactions).hasSize(1);
        assertThat(transactions.get(0).getTransactionType()).isEqualTo("Deposit");
    }

    @Test
    public void testFindByTransactionType() {
        // Given: Set up the conditions for the test
        Transaction mockTransaction = new Transaction();
        generateMockTransaction(mockTransaction);

        // Define the behavior of the mock object
        when(transactionRepository.findByTransactionType("Deposit")).thenReturn(Arrays.asList(mockTransaction));

        // When: Execute the method under test
        List<Transaction> transactions = transactionRepository.findByTransactionType("Deposit");

        // Then: Check the results
        assertThat(transactions).hasSize(1);
        assertThat(transactions.get(0).getTransactionType()).isEqualTo("Deposit");
    }

    @Test
    public void testFindByAmountGreaterThanEqual() {
        // Given: Set up the conditions for the test
        Transaction mockTransaction = new Transaction();
        generateMockTransaction(mockTransaction);

        // Define the behavior of the mock object
        when(transactionRepository.findByAmountGreaterThanEqual(new BigDecimal("100.00"))).thenReturn(Arrays.asList(mockTransaction));

        // When: Execute the method under test
        List<Transaction> transactions = transactionRepository.findByAmountGreaterThanEqual(new BigDecimal("100.00"));

        // Then: Check the results
        assertThat(transactions).hasSize(1);
        assertThat(transactions.get(0).getAmount()).isEqualTo(new BigDecimal("100.00"));
    }

    @Test
    public void testCountByAccountId() {
        // Given: Set up the conditions for the test
        Long accountId = 1L;

        // Define the behavior of the mock object
        when(transactionRepository.countByAccountId(accountId)).thenReturn(5L);

        // When: Execute the method under test
        long count = transactionRepository.countByAccountId(accountId);

        // Then: Check the results
        assertThat(count).isEqualTo(5L);
    }

    @Test
    public void testSumByTypeAndAccountId() {
        // Given: Set up the conditions for the test
        String transactionType = "Deposit";
        Long accountId = 1L;
        BigDecimal expectedSum = new BigDecimal("500.00");

        // Define the behavior of the mock object
        when(transactionRepository.sumByTypeAndAccountId(transactionType, accountId)).thenReturn(expectedSum);

        // When: Execute the method under test
        BigDecimal sum = transactionRepository.sumByTypeAndAccountId(transactionType, accountId);

        // Then: Check the results
        assertThat(sum).isEqualTo(expectedSum);
    }

    private Transaction generateMockTransaction(Transaction transaction) {
        transaction.setAccountId(1L);
        transaction.setTransactionType("Deposit");
        transaction.setAmount(new BigDecimal("100.00"));
        transaction.setTransactionDate(Date.valueOf(LocalDate.now()));
        transaction.setStatus("Completed");
        transaction.setDescription("Initial deposit");
        return transaction;
    }
}
