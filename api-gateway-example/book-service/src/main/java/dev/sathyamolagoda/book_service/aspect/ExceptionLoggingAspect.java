package dev.sathyamolagoda.book_service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class ExceptionLoggingAspect {

    // Pointcut for all service layer methods
    @Pointcut("within(dev.sathyamolagoda.book_service.service..*)")
    public void serviceLayer() {}

    // Pointcut for all controller layer methods
    @Pointcut("within(dev.sathyamolagoda.book_service.controller..*)")
    public void controllerLayer() {}

    // Advice for exceptions in service layer
    @AfterThrowing(pointcut = "serviceLayer()", throwing = "ex")
    public void logServiceExceptions(JoinPoint joinPoint, Throwable ex) {
        log.error("Exception in SERVICE [{}]: {}", joinPoint.getSignature(), ex.getMessage(), ex);
    }

    // Advice for exceptions in controller layer
    @AfterThrowing(pointcut = "controllerLayer()", throwing = "ex")
    public void logControllerExceptions(JoinPoint joinPoint, Throwable ex) {
        log.error("Exception in CONTROLLER [{}]: {}", joinPoint.getSignature(), ex.getMessage(), ex);
    }
}
