/*
 * ExpressionEvaluator.java
 */
package com.callcenter.domain;

/**
 * This class is supposed to invoke a specific method on all elements of a collection.
 * It is not expected to return anything, hence the return type of evaluate is void.
 * For e.g. we want to invoke checkIn method on all AgreementItem instances then,
 * we just create an instance of ExpressionEvaluator and pass it as argument to CollectionUtils doInLoop method
 * and invoke the desired checkIn method on each entity instance.  For examples look at AgreementItemCollection code.
 *
 * @param <T> the generic type.  Could be any class such as AgreementItem or Reservation etc.
 * @author deep
 */
public interface ExpressionEvaluator<T> {

	/**
	 * This method will be invoked for every entity in the collection.
	 *
	 * @param entity the object, i.e. one of the instance in the collection.
	 */
	void evaluate(T entity);
}
