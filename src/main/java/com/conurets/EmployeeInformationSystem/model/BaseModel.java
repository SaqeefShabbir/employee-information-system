package com.conurets.EmployeeInformationSystem.model;

import io.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public class BaseModel extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //    @Version
    //    Long version;

    @Column(columnDefinition = "BOOLEAN", name = "is_active", nullable = false)
    Boolean active = Boolean.TRUE;

    @Basic(optional = false)
    @Column(columnDefinition = "TIMESTAMP", name = "created_date", updatable = false, nullable = false)
    Timestamp createdDate;

    @Basic(optional = false)
    @Column(columnDefinition = "TIMESTAMP", name = "updated_date", insertable = false)
    Timestamp updatedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }
}
