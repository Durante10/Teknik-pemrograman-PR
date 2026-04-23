package com.p2p.domain;

public class Borrower{
    private boolean verified;
    private int creditscore;
    
    public Borrower(boolean verified, int creditscore){
        this.verified = verified;
        this.creditscore = creditscore;
    }


    public int getCreditScore(){
        return creditscore;
    }
    
    public boolean canApplyLoan(){
        return verified;
    }

}