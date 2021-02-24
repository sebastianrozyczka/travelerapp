package pl.sebroz.travelerapp.specifications;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import pl.sebroz.travelerapp.model.City;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CitySpecification {

    private static final String NAME = "name";
    private static final String PERCENT = "%";

    public static Specification<City> hasNameLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(NAME)), PERCENT + name.toLowerCase() + PERCENT);
    }
}
