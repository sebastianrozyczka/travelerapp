package pl.sebroz.travelerapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "country")
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "name", columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "description", columnDefinition = "varchar(1000)")
    private String description;

    @Column(name = "average_temperature", columnDefinition = "decimal(10,2)")
    private BigDecimal averageTemperature;

    @Column(name = "image_url", columnDefinition = "varchar(255)")
    private String imageUrl;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Region> regions = new ArrayList<>();
}
