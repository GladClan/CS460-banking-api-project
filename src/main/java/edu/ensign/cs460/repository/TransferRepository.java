package edu.ensign.cs460.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.ensign.cs460.domain.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findBySourceAccountId(Long sourceAccountId);
    List<Transfer> findByDestinationAccountId(Long destinationAccountId);
    List<Transfer> findByTransferDateBetween(LocalDate startDate, LocalDate endDate);
    List<Transfer> findByStatus(String status);
    List<Transfer> findByUserId(Long userId);
    long countByTypeAndTransferDateBetween(String type, LocalDate startDate, LocalDate endDate);

    @Query("SELECT SUM(t.amount) FROM Transfer t WHERE t.sourceAccountId = :accountId AND t.transferDate BETWEEN :startDate AND :endDate")
    BigDecimal sumTransferredByAccountIdAndDateRange(@Param("accountId") Long accountId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
