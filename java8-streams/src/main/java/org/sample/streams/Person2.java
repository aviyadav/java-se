package org.sample.streams;

public class Person2 {
    
    private String name;
    private String country;

    public Person2(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return getName();
        //"Person2{" + "name=" + name + ", country=" + country + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        
        if(obj == null) {
            return false;
        }
        
        if(getClass() != obj.getClass()) {
            return false;
        }
        
        Person2 other = (Person2) obj;
        if(country == null) {
            if(other.country != null) {
                return false;
            }
        } else if(!country.equals(other.country)) {
            return false;
        }
        
        if(name == null) {
            if(other.name != null) {
                return false;
            }
        } else if(!name.equals(other.name)) {
            return false;
        }
        
        return true;
    }
}
