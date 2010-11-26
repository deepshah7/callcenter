/*
 * Copyright 2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.callcenter.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class Collection<T> {
    /** The entities. */
    private final java.util.Collection<T> entities;

    public Collection(final java.util.Collection<T> entities) {
        this.entities = entities;
    }

    /**
     * Return entities if condition is true.
     *
     * @param evaluator the evaluator
     * @return the list
     */
    public List<T> returnEntitiesIfConditionIsTrue(final ConditionEvaluator<T> evaluator) {
        final List<T> matchingEntities = new ArrayList<T>();
        for (final T entity : entities) {
            if (evaluator.evaluate(entity)) {
                matchingEntities.add(entity);
            }
        }
        return matchingEntities;
    }

    /**
     * Do in loop.
     *
     * @param evaluator the evaluator
     */
    public void doInLoop(final ExpressionEvaluator<T> evaluator) {
        for (final T entity : entities) {
            evaluator.evaluate(entity);
        }
    }

    /**
     * Return entity if condition is true.
     *
     * @param evaluator the evaluator
     * @return the t
     */
    public T returnEntityIfConditionIsTrue(final ConditionEvaluator<T> evaluator) {
        for (final T entity : entities) {
            if (evaluator.evaluate(entity)) {
                return entity;
            }
        }
        return null;
    }

    /**
     * Return false if any condition is false.
     *
     * @param evaluator the evaluator
     * @return true, if successful
     */
    protected boolean returnFalseIfAnyConditionIsFalse(final ConditionEvaluator<T> evaluator) {
        for (final T entity : entities) {
            if (!evaluator.evaluate(entity)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return true if any condition is true.
     *
     * @param evaluator the evaluator
     * @return true, if successful
     */
    protected boolean returnTrueIfAnyConditionIsTrue(final ConditionEvaluator<T> evaluator) {
        for (final T entity : entities) {
            if (evaluator.evaluate(entity)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the entities.
     *
     * @return the entities
     */
    protected java.util.Collection<T> getEntities() {
        return entities;
    }
}
