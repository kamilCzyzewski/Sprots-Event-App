package com.event.app.sports.service.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface MapperInt<S, T> {
    Optional<S> toSource(T target);

    Optional<T> toTarget(S source);

    default List<Optional<S>> toSource(List<T> targets) {
        return targets.stream()
                .map(this::toSource)
                .collect(Collectors.toList());
    }

    default List<Optional<T>> toTarget(List<S> sources) {
        return sources.stream()
                .map(this::toTarget)
                .collect(Collectors.toList());
    }
}