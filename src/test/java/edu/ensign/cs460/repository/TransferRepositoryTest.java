package edu.ensign.cs460.repository;

import edu.ensign.cs460.domain.Transfer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransferRepositoryTest {

    @Mock
    private TransferRepository transferRepository;

    @Test
    public void testFindBySourceAccountId() {
        // Given: Set up the conditions for the test
        Transfer mockTransfer1 = new Transfer();
        mockTransfer1.setFromAccountId(1L);
        mockTransfer1.setToAccountId(2L);
        mockTransfer1.setAmount(new BigDecimal("100.00"));
        mockTransfer1.setTransferDate(new Date());
        mockTransfer1.setStatus("Completed");

        Transfer mockTransfer2 = new Transfer();
        mockTransfer2.setFromAccountId(1L);
        mockTransfer2.setToAccountId(3L);
        mockTransfer2.setAmount(new BigDecimal("200.00"));
        mockTransfer2.setTransferDate(new Date());
        mockTransfer2.setStatus("Completed");

        // Define the behavior of the mock object
        when(transferRepository.findBySourceAccountId(1L)).thenReturn(Arrays.asList(mockTransfer1, mockTransfer2));

        // When: Execute the method under test
        List<Transfer> transfers = transferRepository.findBySourceAccountId(1L);

        // Then: Check the results
        assertThat(transfers).hasSize(2);
        assertThat(transfers).contains(mockTransfer1, mockTransfer2);
    }

    @Test
    public void testFindByDestinationAccountId() {
        // Given: Set up the conditions for the test
        Transfer mockTransfer = new Transfer();
        mockTransfer.setFromAccountId(1L);
        mockTransfer.setToAccountId(2L);
        mockTransfer.setAmount(new BigDecimal("100.00"));
        mockTransfer.setTransferDate(new Date());
        mockTransfer.setStatus("Completed");

        // Define the behavior of the mock object
        when(transferRepository.findByDestinationAccountId(2L)).thenReturn(Arrays.asList(mockTransfer));

        // When: Execute the method under test
        List<Transfer> transfers = transferRepository.findByDestinationAccountId(2L);

        // Then: Check the results
        assertThat(transfers).hasSize(1);
        assertThat(transfers.get(0).getToAccountId()).isEqualTo(2L);
    }

    @Test
    public void testFindByTransferDateBetween() {
        // Given: Set up the conditions for the test
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        Transfer mockTransfer = new Transfer();
        mockTransfer.setFromAccountId(1L);
        mockTransfer.setToAccountId(2L);
        mockTransfer.setAmount(new BigDecimal("100.00"));
        mockTransfer.setTransferDate(new Date());
        mockTransfer.setStatus("Completed");

        // Define the behavior of the mock object
        when(transferRepository.findByTransferDateBetween(startDate, endDate)).thenReturn(Arrays.asList(mockTransfer));

        // When: Execute the method under test
        List<Transfer> transfers = transferRepository.findByTransferDateBetween(startDate, endDate);

        // Then: Check the results
        assertThat(transfers).hasSize(1);
        assertThat(transfers.get(0).getTransferDate()).isEqualTo(mockTransfer.getTransferDate());
    }

    @Test
    public void testFindByStatus() {
        // Given: Set up the conditions for the test
        Transfer mockTransfer = new Transfer();
        mockTransfer.setFromAccountId(1L);
        mockTransfer.setToAccountId(2L);
        mockTransfer.setAmount(new BigDecimal("100.00"));
        mockTransfer.setTransferDate(new Date());
        mockTransfer.setStatus("Completed");

        // Define the behavior of the mock object
        when(transferRepository.findByStatus("Completed")).thenReturn(Arrays.asList(mockTransfer));

        // When: Execute the method under test
        List<Transfer> transfers = transferRepository.findByStatus("Completed");

        // Then: Check the results
        assertThat(transfers).hasSize(1);
        assertThat(transfers.get(0).getStatus()).isEqualTo("Completed");
    }

    @Test
    public void testFindByUserId() {
        // Given: Set up the conditions for the test
        Transfer mockTransfer = new Transfer();
        mockTransfer.setFromAccountId(1L);
        mockTransfer.setToAccountId(2L);
        mockTransfer.setAmount(new BigDecimal("100.00"));
        mockTransfer.setTransferDate(new Date());
        mockTransfer.setStatus("Completed");

        // Define the behavior of the mock object
        when(transferRepository.findByUserId(1L)).thenReturn(Arrays.asList(mockTransfer));

        // When: Execute the method under test
        List<Transfer> transfers = transferRepository.findByUserId(1L);

        // Then: Check the results
        assertThat(transfers).hasSize(1);
        assertThat(transfers.get(0).getFromAccountId()).isEqualTo(1L);
    }

    @Test
    public void testCountByTypeAndTransferDateBetween() {
        // Given: Set up the conditions for the test
        String type = "Transfer";
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        // Define the behavior of the mock object
        when(transferRepository.countByTypeAndTransferDateBetween(type, startDate, endDate)).thenReturn(5L);

        // When: Execute the method under test
        long count = transferRepository.countByTypeAndTransferDateBetween(type, startDate, endDate);

        // Then: Check the results
        assertThat(count).isEqualTo(5L);
    }

    @Test
    public void testSumTransferredByAccountIdAndDateRange() {
        // Given: Set up the conditions for the test
        Long accountId = 1L;
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        BigDecimal expectedSum = new BigDecimal("500.00");

        // Define the behavior of the mock object
        when(transferRepository.sumTransferredByAccountIdAndDateRange(accountId, startDate, endDate)).thenReturn(expectedSum);

        // When: Execute the method under test
        BigDecimal sum = transferRepository.sumTransferredByAccountIdAndDateRange(accountId, startDate, endDate);

        // Then: Check the results
        assertThat(sum).isEqualTo(expectedSum);
    }
}
