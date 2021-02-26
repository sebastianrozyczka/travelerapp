package pl.sebroz.travelerapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "region")
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long id;

    @Column(name = "name", columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "description", columnDefinition = "varchar(1000)")
    private String description;

    @Column(name = "image_url", columnDefinition = "varchar(255)")
    private String imageUrl;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "region", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<City> cities = new ArrayList<>();
}
