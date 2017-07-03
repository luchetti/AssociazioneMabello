package it.associazionemabello.startup;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import it.associazionemabello.interfaces.Eager;

@Named
@Startup
@Eager
@ApplicationScoped
public class StartupConfiguration {
	
	@PostConstruct
	public void init(){
	}
}