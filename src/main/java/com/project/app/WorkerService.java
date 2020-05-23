package com.project.app;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named("allWorkers")
@RequestScoped
public class WorkerService {
	private List<Worker> workers;
	
	private GetAllWorkers all = new GetAllWorkers();
	
	@PostConstruct
	public void init() {
		workers = all.getAllWorkers();
	}

	public List<Worker> getWorkers() {
		return workers;
	}

}
