package net.wmann.cloud.storage.webservice.interceptor;

import java.lang.reflect.Method;

import net.wmann.cloud.storage.webservice.annotation.TraceExecution;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TracingAdvisor extends AbstractPointcutAdvisor {

	private static final long serialVersionUID = 1L;

	private final StaticMethodMatcherPointcut pointcut = new StaticMethodMatcherPointcut() {
		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return method.isAnnotationPresent(TraceExecution.class);
		}
	};

	@Autowired
	private TraceMethodInterceptor interceptor;

	@Override
	public Pointcut getPointcut() {
		return this.pointcut;
	}

	@Override
	public Advice getAdvice() {
		return this.interceptor;
	}
}
