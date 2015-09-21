package com.almasb.libraryloan;

import java.util.Arrays;
import java.util.List;

public class Book {

    private long uniqueID;
    private String name;
    private List<String> authors;
    private int publishedYear;
    private boolean available;

    public String getAuthors() {
        String result = "";
        for (String author : authors)
            result += author + "_";
        return result.substring(0, result.length() - 1);
    }

    public void setAuthors(String authors) {
        this.authors = Arrays.asList(authors.split("_"));
    }

    public final long getUniqueID() {
        return uniqueID;
    }
    public final void setUniqueID(long uniqueID) {
        this.uniqueID = uniqueID;
    }
    public final String getName() {
        return name;
    }
    public final void setName(String name) {
        this.name = name;
    }
    public final int getPublishedYear() {
        return publishedYear;
    }
    public final void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
    public final boolean isAvailable() {
        return available;
    }
    public final void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Book [uniqueID=");
        builder.append(uniqueID);
        builder.append(", name=");
        builder.append(name);
        builder.append(", authors=");
        builder.append(authors);
        builder.append(", publishedYear=");
        builder.append(publishedYear);
        builder.append(", available=");
        builder.append(available);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((authors == null) ? 0 : authors.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + publishedYear;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (authors == null) {
            if (other.authors != null)
                return false;
        }
        else if (!authors.equals(other.authors))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (publishedYear != other.publishedYear)
            return false;
        return true;
    }
}
