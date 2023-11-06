package entity;

import java.util.Objects;

public class Author {
    private String Firstname;
    private String Lastname;
    
    public Author(){
        
    }

    public Author(String Firstname, String Lastname) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
    }
    
    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.Firstname);
        hash = 73 * hash + Objects.hashCode(this.Lastname);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (!Objects.equals(this.Firstname, other.Firstname)) {
            return false;
        }
        if (!Objects.equals(this.Lastname, other.Lastname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Author{" 
                + "Firstname=" + Firstname
                + ", Lastname=" + Lastname
                + '}';
    }
    
    
}
