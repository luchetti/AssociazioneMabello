package it.associazionemabello.services.extension;

import java.util.List;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessBean;

import it.associazionemabello.interfaces.Eager;

public class EagerExtension implements Extension{

	private List<Bean<?>> eagerBeansList = new ArrayList<Bean<?>>();
	
	public <T> void collect(@Observes ProcessBean<T> event){
		if (event.getAnnotated().isAnnotationPresent(Eager.class) && event.getAnnotated().isAnnotationPresent(ApplicationScoped.class)) {
			eagerBeansList.add(event.getBean());
		}
	}
	
	public void load (@Observes AfterDeploymentValidation event, BeanManager beanManager){
		for (Bean<?> bean : eagerBeansList){
			// toString fondamentale per inizializzare correttamente il bean
			beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean)).toString();
		}
	}
	
}
