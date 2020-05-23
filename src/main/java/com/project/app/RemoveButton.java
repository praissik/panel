package com.project.app;


import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named
@RequestScoped
public class RemoveButton {
	
    private boolean attemp;

	public void removeWorker(int id) {

		DeleteWorker delete = new DeleteWorker();
		attemp = delete.deleteWorker(id);

    	if(attemp) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Pracownik został usunięty"));
    	}else{
    		FacesContext.getCurrentInstance().addMessage(null, 
    				new FacesMessage("Wystąpił błąd. Spróbuj ponownie."));
    	}
	}
}
