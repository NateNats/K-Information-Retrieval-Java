package org.example;

public class Term {
    private String term;
    private int df;

    public Term() {
        this.term = "";
        this.df = 0;
    }

    public Term(String term, int df) {
        this.term = term;
        this.df = df;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }


}
