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
@Table(name = "orders")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id"),
    @NamedQuery(name = "Orders.findByLegalizationDate", query = "SELECT o FROM Orders o WHERE o.legalizationDate = :legalizationDate"),
    @NamedQuery(name = "Orders.findByAddress", query = "SELECT o FROM Orders o WHERE o.address = :address"),
    @NamedQuery(name = "Orders.findByCity", query = "SELECT o FROM Orders o WHERE o.city = :city"),
    @NamedQuery(name = "Orders.findByCreatedAt", query = "SELECT o FROM Orders o WHERE o.createdAt = :createdAt"),
    @NamedQuery(name = "Orders.findByUpdatedAt", query = "SELECT o FROM Orders o WHERE o.updatedAt = :updatedAt")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "legalization_date")
    @Temporal(TemporalType.DATE)
    private Date legalizationDate;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "causal_id", referencedColumnName = "id")
    @ManyToOne
    private Causal causalId;
    @JoinColumn(name = "observation_id", referencedColumnName = "id")
    @ManyToOne
    private Observation observationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordersId")
    private Collection<OrdersActivity> ordersActivityCollection;

    public Orders() {
    }

    public Orders(Long id) {
        this.id = id;
    }

    public Orders(Long id, Date legalizationDate, String address, String city) {
        this.id = id;
        this.legalizationDate = legalizationDate;
        this.address = address;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLegalizationDate() {
        return legalizationDate;
    }

    public void setLegalizationDate(Date legalizationDate) {
        this.legalizationDate = legalizationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Causal getCausalId() {
        return causalId;
    }

    public void setCausalId(Causal causalId) {
        this.causalId = causalId;
    }

    public Observation getObservationId() {
        return observationId;
    }

    public void setObservationId(Observation observationId) {
        this.observationId = observationId;
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.orderapi.model.Orders[ id=" + id + " ]";
    }
    
}
