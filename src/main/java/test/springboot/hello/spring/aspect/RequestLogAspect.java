/**
 * @author:liyiming
 * @date:2018年4月9日
 * Description:
 **/
package test.springboot.hello.spring.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Title: RequestLogAspect Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年4月9日
 **/
@Component
@Aspect
public class RequestLogAspect{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Pointcut("execution(* test.springboot.hello.GreetingController.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void deBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		logger.debug("URL : " + request.getRequestURL().toString());
		logger.debug("HTTP_METHOD : " + request.getMethod());
		logger.debug("IP : " + request.getRemoteAddr());
		logger.debug("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.debug("ARGS : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		logger.debug("方法的返回值 : " + ret);
	}

	// 后置异常通知
	@AfterThrowing("webLog()")
	public void throwss(JoinPoint jp) {
		logger.debug("方法异常时执行.....");
	}

	// 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
	@After("webLog()")
	public void after(JoinPoint jp) {
		logger.debug("方法最后执行.....");
	}

	// 环绕通知,环绕增强，相当于MethodInterceptor
	@Around("webLog()")
	public Object arround(ProceedingJoinPoint pjp) {
		logger.debug("方法环绕start.....");
		try {
			Object o = pjp.proceed();
			logger.debug("方法环绕proceed，结果是 :" + o);
			return o;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
}
