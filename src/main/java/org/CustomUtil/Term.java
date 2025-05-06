package org.CustomUtil;

public class Term implements Comparable<Term> {
    private String term;
    private int df;

    public Term() {
        this.term = "";
        this.df = 0;
    }

    public Term(String term) {
        this.term = term;
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


    @Override
    public int compareTo(Term o) {
        return 0;
    }

    public static void main(String[] args) {
        Term term1 = new Term("example", 2);
        Term term2 = new Term("example", 3);
        System.out.println(term1);
        System.out.println(term2);
    }
}
