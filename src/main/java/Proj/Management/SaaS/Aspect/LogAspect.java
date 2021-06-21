package Proj.Management.SaaS.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Aspect
@Service
public class LogAspect {
	
protected Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	
	@Before("within(Proj.Management.SaaS..*)")
	public void logBefore(JoinPoint joinPoint) {
		// Log method name
		logger.info("INVOKE METHOD: " + joinPoint.getSignature().toLongString());
		// Log arguments
		if(joinPoint.getArgs() != null) {
			for(Object obj : joinPoint.getArgs()) {
				logger.info("ARGUMENT: " + obj.toString());}}}
	
	
	
	@AfterReturning(pointcut =  "within(Proj.Management.SaaS..*)", returning = "returnObject")
	public void logAfterReturning(JoinPoint joinPoint, Object returnObject) {
		// Log method name
		logger.info("RETURN FROM METHOD: " + joinPoint.getSignature().toLongString());
		// Log the return value
		logger.info("RETURN OBJECT: " + returnObject);}
	
	
	
	@AfterThrowing(pointcut = "within(Proj.Management.SaaS..*)", throwing = "ex")
	public void logAfterThrowing(Exception ex) {
		// Log the exception message
		logger.error("ERROR: " + ex.getMessage());}

}
