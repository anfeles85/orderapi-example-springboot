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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "activity")
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a"),
    @NamedQuery(name = "Activity.findById", query = "SELECT a FROM Activity a WHERE a.id = :id"),
    @NamedQuery(name = "Activity.findByDescription", query = "SELECT a FROM Activity a WHERE a.description = :description"),
    @NamedQuery(name = "Activity.findByHours", query = "SELECT a FROM Activity a WHERE a.hours = :hours"),
    @NamedQuery(name = "Activity.findByCreatedAt", query = "SELECT a FROM Activity a WHERE a.createdAt = :createdAt"),
    @NamedQuery(name = "Activity.findByUpdatedAt", query = "SELECT a FROM Activity a WHERE a.updatedAt = :updatedAt")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "hours")
    private int hours;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "technician_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Technician technicianId;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeActivity typeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activityId")
    private Collection<OrdersActivity> ordersActivityCollection;

    public Activity() {
    }

    public Activity(Long id) {
        this.id = id;
    }

    public Activity(Long id, String description, int hours) {
        this.id = id;
        this.description = description;
        this.hours = hours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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

    public Technician getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Technician technicianId) {
        this.technicianId = technicianId;
    }

    public TypeActivity getTypeId() {
        return typeId;
    }

    public void setTypeId(TypeActivity typeId) {
        this.typeId = typeId;
    }

    public Collection<OrdersActivity> getOrdersActivityCollection() {
        return ordersActivityCollection;
    }

    public void setOrdersActivityCollection(Collection<OrdersActivity> ordersActivityCollection) {
        this.ordersActivityCollection = ordersActivityCollection;
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
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.orderapi.model.Activity[ id=" + id + " ]";
    }
    
}
