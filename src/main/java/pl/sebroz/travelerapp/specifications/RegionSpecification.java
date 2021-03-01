package pl.sebroz.travelerapp.specifications;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import pl.sebroz.travelerapp.model.Region;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegionSpecification {

    private static final String NAME = "name";
    private static final String PERCENT = "%";

    public static Specification<Region> hasNameLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(NAME)), PERCENT + name.toLowerCase() + PERCENT);
    }
}
