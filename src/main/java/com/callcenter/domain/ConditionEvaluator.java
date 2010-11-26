/*
 * ConditionEvaluator.java
 */
package com.callcenter.domain;

/**
 * This is an Evaluator class used with a specific type.  This interface will be used by @see CollectionUtil class.
 * whenever we want to iterate over a collection and invoke a specific method on all of the collection elements,
 * we use an instance of this Interface and implement the evaluate method to return true of false base on the
 * implementation. Since Java does not have closures yet! we use this technique to achive functionality like
 * findAll, returnTrueIfAllTrue on a collection.
 * For valid examples have a look at @see AgreementItemCollection class.
 *
 * @param <T> the generic type.  Could be any class such as AgreementItem, Reservation etc.
 * @author deep
 */
public interface ConditionEvaluator<T> {

	/**
	 * Implement this method to return true of false based on a specific condition.
     * The type object is passed as argument, so that we maintain type safety.
	 *
	 * @param entity the entity instance.
	 * @return true, if the condition we are interested in is true.
	 */
	boolean evaluate(T entity);
}
