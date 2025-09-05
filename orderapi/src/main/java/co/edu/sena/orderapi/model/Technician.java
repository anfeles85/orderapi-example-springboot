/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.orderapi.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author sena
 */
@Entity
@Table(name = "technician")
@NamedQueries({
    @NamedQuery(name = "Technician.findAll", query = "SELECT t FROM Technician t"),
    @NamedQuery(name = "Technician.findById", query = "SELECT t FROM Technician t WHERE t.id = :id"),
    @NamedQuery(name = "Technician.findByDocument", query = "SELECT t FROM Technician t WHERE t.document = :document"),
    @NamedQuery(name = "Technician.findByName", query = "SELECT t FROM Technician t WHERE t.name = :name"),
    @NamedQuery(name = "Technician.findByEspeciality", query = "SELECT t FROM Technician t WHERE t.especiality = :especiality"),
    @NamedQuery(name = "Technician.findByPhone", query = "SELECT t FROM Technician t WHERE t.phone = :phone"),
    @NamedQuery(name = "Technician.findByCreatedAt", query = "SELECT t FROM Technician t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "Technician.findByUpdatedAt", query = "SELECT t FROM Technician t WHERE t.updatedAt = :updatedAt")})
public class Technician implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "document")
    private long document;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "especiality")
    private String especiality;
    @Column(name = "phone")
    private String phone;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "technicianId")
    private Collection<Activity> activityCollection;

    public Technician() {
    }

    public Technician(Long id) {
        this.id = id;
    }

    public Technician(Long id, long document, String name) {
        this.id = id;
        this.document = document;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEspeciality() {
        return especiality;
    }

    public void setEspeciality(String especiality) {
        this.especiality = especiality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Technician)) {
            return false;
        }
        Technician other = (Technician) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.orderapi.model.Technician[ id=" + id + " ]";
    }
    
}
