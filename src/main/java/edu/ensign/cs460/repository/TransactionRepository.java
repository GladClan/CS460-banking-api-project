package edu.ensign.cs460.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import edu.ensign.cs460.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Long accountId);
    List<Transaction> findByAccountIdAndDateBetween(Long accountId, LocalDate startDate, LocalDate endDate);
    List<Transaction> findByTransactionType(String transactionType);
    List<Transaction> findByAmountGreaterThanEqual(BigDecimal threshold);
    long countByAccountId(Long accountId);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.accountId = :accountId AND t.transactionType = :type")
    BigDecimal sumByTypeAndAccountId(@Param("type") String transactionType, @Param("accountId") Long accountId);
}
