package edu.ensign.cs460.domain;

import java.util.Date;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRANSFER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSFER_ID")
    private Long id;

    //Foreign key to ACCOUNT_ID in ACCOUNT table
    @Column(name = "FROM_ACCOUNT_ID", nullable = false)
    private Long fromAccountId;

    //Foreign key to ACCOUNT_ID in ACCOUNT table
    @Column(name = "TO_ACCOUNT_ID", nullable = false)
    private Long toAccountId;

    @Column(name = "AMOUNT", nullable = false, precision = 2)
    private BigDecimal amount;

    @Column(name = "TRANSFER_DATE", nullable = false)
    private Date transferDate;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;
}

/*
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
*/