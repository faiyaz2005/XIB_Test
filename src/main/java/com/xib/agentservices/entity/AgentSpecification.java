package com.xib.agentservices.entity;

import com.xib.agentservices.filter.AgentManagerFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

public class AgentSpecification {

	public static Specification<Agent> searchAgent(AgentManagerFilter agentManagerFilter) {
		return (root, cq, cb) -> {

			List<Predicate> resultPredicates = new ArrayList<>();


			Optional<Predicate> filterPredicateOptional = filterPredicate(agentManagerFilter, root, cb);
			filterPredicateOptional.ifPresent(resultPredicates::add);
			return cb.and(resultPredicates.toArray(new Predicate[resultPredicates.size()]));
		};
	}

	private static Optional<Predicate> filterPredicate(AgentManagerFilter filter, Root<Agent> root, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();
		if (!Objects.isNull(filter)) {
			if (filter.getFirstName() != null) {
				final Predicate modelPredicate = cb.like(cb.lower(root.get("firstName")), "%" + filter.getFirstName().toLowerCase() + "%");
				predicates.add(modelPredicate);
			}

			if (filter.getLastName() != null) {
				final Predicate modelPredicate = cb.like(cb.lower(root.get("lastName")), "%" + filter.getLastName().toLowerCase() + "%");
				predicates.add(modelPredicate);
			}

			if (filter.getIdNumber() != null) {
				final Predicate modelPredicate = cb.like(cb.lower(root.get("idNumber")), "%" + filter.getIdNumber().toLowerCase() + "%");
				predicates.add(modelPredicate);
			}

		}

		if (!predicates.isEmpty()) return Optional.of(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		return Optional.empty();
	}


}
