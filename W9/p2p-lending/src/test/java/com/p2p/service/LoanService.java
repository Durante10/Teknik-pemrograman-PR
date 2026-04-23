package com.p2p.service;
import com.p2p.domain.*;
import org.apache.logging.log4j.*;
import java.math.BigDecimal;

public class LoanService {
    private static final Logger logger = LogManager.getLogger(LoanService.class);
    
    public Loan createLoan(Borrower borrower,BigDecimal amount ){
        logger.info("Memulai proses pengajuan peminjaman dengan jumlah " + amount);
        validateBorrower(borrower);

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            logger.error("Gagal melakukan peminjaman karna amount kurang dari sama dengan 0");
            throw new IllegalArgumentException("Invalid loan amount");
        }

        Loan loan = new Loan();

        if (borrower.getCreditScore() >= 600){
            logger.info("Pinjaman Diterima");
            loan.approve();
        } else {
            logger.warn("Pinjaman Ditolak, Credit skor kurang dari 600");
            loan.reject();
        }
        return loan;

    }

    public void validateBorrower(Borrower borrower){
        if (!borrower.canApplyLoan()) {
            logger.error("Borrower tidak terverifikasi!");
            throw new IllegalArgumentException("Borrower not verified");
        }
    }
}