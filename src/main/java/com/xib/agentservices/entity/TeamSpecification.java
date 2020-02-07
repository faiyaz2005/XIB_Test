package com.xib.agentservices.entity;

import com.xib.agentservices.filter.AgentManagerFilter;
import com.xib.agentservices.filter.TeamFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

public class TeamSpecification {

	public static Specification<Team> searchTeam(TeamFilter teamFilter) {
		return (root, cq, cb) -> {

			List<Predicate> resultPredicates = new ArrayList<>();


			Optional<Predicate> filterPredicateOptional = filterPredicate(teamFilter, root, cb);
			filterPredicateOptional.ifPresent(resultPredicates::add);
			return cb.and(resultPredicates.toArray(new Predicate[resultPredicates.size()]));
		};
	}

	private static Optional<Predicate> filterPredicate(TeamFilter filter, Root<Team> root, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();
		if (!Objects.isNull(filter)) {
			if (filter.getName() != null) {
				final Predicate modelPredicate = cb.like(cb.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%");
				predicates.add(modelPredicate);
			}


		}

		if (!predicates.isEmpty()) return Optional.of(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		return Optional.empty();
	}


}
