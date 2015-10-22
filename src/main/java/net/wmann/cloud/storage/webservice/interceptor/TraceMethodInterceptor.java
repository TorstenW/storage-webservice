package net.wmann.cloud.storage.webservice.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TraceMethodInterceptor implements MethodInterceptor {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		try {
			log.trace("Starting: {}", invocation.getMethod().getName());
			return invocation.proceed();
		} finally {
			log.trace("Ending: {}", invocation.getMethod().toGenericString());
		}
	}
}
