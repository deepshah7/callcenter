/**
 * LoggingAspect.java
 */
package com.callcenter.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * This is an looging aspect that will log the error, exceptions thrown from action and controller packages in the
 * log file.
 *
 * @author Deep Shah
 */
@Aspect
@Component(value = "loggingAspect")
public class LoggingAspect {

    /**
     * The logging aspect which will log any exceptions thrown out of action and controller packages.
     * @param e the exception that was thrown by the action or the controller class.
     */
    @AfterThrowing(
            pointcut = "(within(com.callcenter.controller..*)) && execution(* *(..))",
            throwing = "e")
    public void logExceptions(final JoinPoint jp, final Throwable e) {
        final Signature signature = jp.getSignature();
        final Logger logger = Logger.getLogger(signature.getDeclaringTypeName());
        logger.error("Exception thrown by: " + signature.toShortString());
        logger.error(e.getMessage(), e);
    }
}
