package com.luizacode.programadoras.models;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@MappedSuperclass
public class EntidadeAbstrata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        EntidadeAbstrata other = (EntidadeAbstrata) obj;
        if (id == null) {
            if (other.id == null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}