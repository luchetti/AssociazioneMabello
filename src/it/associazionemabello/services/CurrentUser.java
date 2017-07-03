package it.associazionemabello.services;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.Identity.AuthenticationResult;
import org.picketlink.authentication.levels.Level;

import java.io.Serializable;

@Named
@SessionScoped
public class CurrentUser implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	Identity identity;
	
	public void login(){
		AuthenticationResult result = identity.login();
		
		if(identity.isLoggedIn())
		if(AuthenticationResult.FAILED.equals(result)){
			System.out.println("Errore nell'autenticazione, si prega di riprovare");
		}
		else{
			System.out.println("Autenticazione avvenuta correttamente");
			
		}
		
		/*String originalPassword = "password";
        String generatedSecuredPasswordHash = SCryptUtil.scrypt(originalPassword, 16, 16, 16);
        System.out.println(generatedSecuredPasswordHash);
         
        boolean matched = SCryptUtil.check("password", generatedSecuredPasswordHash);
        System.out.println(matched);
         
        matched = SCryptUtil.check("passwordno", generatedSecuredPasswordHash);
        System.out.println(matched);
        */
	}
	
	public Level getRole(){
		return identity.getLevel();
	}
}
