package com.project.app;


import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;


@Named
@RequestScoped
public class EditButton {

	public void onRowEdit(RowEditEvent<Worker> event) {
		
		EditWorker edit = new EditWorker();
		edit.editWorker(event.getObject());

        FacesMessage msg = new FacesMessage("Zmiany zapisane");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent<Worker> event) {
        FacesMessage msg = new FacesMessage("Zmiany przywrócone");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
