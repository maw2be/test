package com.redbite.test.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdevice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDevice {

    @Id
    @Column(name = "serial")
    @JsonProperty("serial")
    private String serial;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

}
