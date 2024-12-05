package edu.ensign.cs460.domain;

import java.sql.Date;
import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRANSACTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long id;

    //Foreign ket to ACCOUNT_ID in ACCOUNT table
    @Column(name = "ACCOUNT_ID", nullable = false)
    private Long accountId;

    @Column(name = "TYPE", nullable = false, length = 50)
    private String transactionType;

    @Column(name = "AMOUNT", nullable = false, precision = 2)
    private BigDecimal amount;

    @Column(name = "TRANSACTION_DATE", nullable = false)
    private Date transactionDate;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;

    @Column(name = "DESCRIPTION", nullable = false, length = 255)
    private String description;
}
