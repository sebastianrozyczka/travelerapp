package pl.sebroz.travelerapp.specifications;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import pl.sebroz.travelerapp.model.Country;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CountrySpecification {

    public static final String NAME = "name";
    public static final String PERCENT = "%";

    public static Specification<Country> hasNameLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(NAME)), PERCENT + name.toLowerCase() + PERCENT);
    }
}
