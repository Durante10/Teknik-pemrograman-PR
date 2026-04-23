package com.p2p.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.p2p.domain.*;

public class LoanServiceTest{
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified(){
        Borrower borrower = new Borrower(false,700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        Exception excp = assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        }, "harusnya Lempar Exception ketika Borrower tidak terverifikasi");


        assertEquals("Borrower not verified", excp.getMessage());
    }

    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative(){
        Borrower borrower = new Borrower(true,700);
        LoanService loanService = new LoanService();

        BigDecimal amount = BigDecimal.valueOf(0);

        Exception excp = assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        }, "harusnya Lempar Exception ketika amount kurang atau sama dengan 0");


        assertEquals("Invalid loan amount", excp.getMessage());
    }

    @Test
    public void shouldApproveLoanWhenCreditScoreHigh(){
        Borrower borrower = new Borrower(true,1000);
        LoanService loanService = new LoanService();

        BigDecimal amount = BigDecimal.valueOf(700);

        Loan loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.APPROVED,loan.getStatus(), "Seharusnya disetujui karena credit nya tinggi");
    }

    @Test
    public void shouldRejectLoanWhenCreditScoreLow(){
        Borrower borrower = new Borrower(true,500);
        LoanService loanService = new LoanService();

        BigDecimal amount = BigDecimal.valueOf(700);

        Loan loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.REJECTED,loan.getStatus(), "Seharusnya ditolak karena credit nya rendah");
    }


    
}