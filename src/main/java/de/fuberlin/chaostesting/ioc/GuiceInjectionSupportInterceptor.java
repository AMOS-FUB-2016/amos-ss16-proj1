package de.fuberlin.chaostesting.ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.controller.ExecutionContext;
import net.sourceforge.stripes.controller.Interceptor;
import net.sourceforge.stripes.controller.Intercepts;
import net.sourceforge.stripes.controller.LifecycleStage;

/**
 * Performs dependency injection for Stripes ActionBeans with Guice.
 */
@Intercepts(LifecycleStage.ActionBeanResolution)
public class GuiceInjectionSupportInterceptor implements Interceptor {

	@Override
	public Resolution intercept(ExecutionContext context) throws Exception {
		Injector injector = IOC.getMainInjectorInstance();
		
		Resolution resolution = context.proceed();
		
		ActionBean actionBean = context.getActionBean();
		
		injector.injectMembers(actionBean);
		
		return resolution;
	}

}
