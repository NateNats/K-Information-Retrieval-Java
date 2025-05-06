package org.CustomUtil;

public class Document implements Comparable<Document> {
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
        return "document: " + document + ", tf: " + tf;
    }

    @Override
    public int compareTo(Document o) {
        String doc2 = o.getDocument();
        String thisDoc = this.getDocument();

        if (thisDoc.equals(doc2)) {
            return 0;
        } else if (thisDoc.compareTo(doc2) > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
