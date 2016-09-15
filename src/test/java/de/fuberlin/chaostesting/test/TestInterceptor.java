package de.fuberlin.chaostesting.test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.fuberlin.chaostesting.ioc.InjectionProvider;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.controller.ExecutionContext;
import net.sourceforge.stripes.controller.Interceptor;
import net.sourceforge.stripes.controller.Intercepts;
import net.sourceforge.stripes.controller.LifecycleStage;

@Intercepts(LifecycleStage.ActionBeanResolution)
public class TestInterceptor implements Interceptor, InjectionProvider {

	private static Injector injector;

	@Override
	public Resolution intercept(ExecutionContext context) throws Exception {
		Resolution resolution = context.proceed();
		
		ActionBean actionBean = context.getActionBean();
		
		getInjector().injectMembers(actionBean);
		
		return resolution;
	}
	
	public static Injector getInjector() {
		if(injector == null) {
			injector = Guice.createInjector(new TestGuiceModule());
		}
		
		return injector;
	}

	@Override
	public Injector provideInjector() {
		return getInjector();
	}
}
