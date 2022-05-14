package com.holovko.haircutservie.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name="name")
    private String name;

    @Column(name="enabled")
    private Boolean enabled;

    @Column(name="filepath")
    private String filepath;

    @Column(name="logo")
    private String logo;

    @Column(name="description")
    private String description;

    @Column(name="contacts")
    private String contacts;

    @Column(name="type")
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company parent;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "parent_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Company> children;

    @JsonIgnore
    public Set<Company> getChildren() {
        return children;
    }
}
