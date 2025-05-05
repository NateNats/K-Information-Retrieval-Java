package org.example;

public class Document {
    private String document;
    private int tf;

    public Document() {
        this.document = "";
        this.tf = 0;
    }

    public Document(String document, int tf) {
        this.document = document;
        this.tf = tf;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getTf() {
        return tf;
    }

    public void setTf(int tf) {
        this.tf = tf;
    }

    @Override
    public String toString() {
        return "Document{" +
                "document='" + document + '\'' +
                ", tf=" + tf +
                '}';
    }
}
