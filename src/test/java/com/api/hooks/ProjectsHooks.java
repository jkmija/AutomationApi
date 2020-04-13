package com.api.hooks;

import com.api.entities.Project;
import com.api.manage.ProjectManager;
import com.api.steps.ProjectSteps;
import cucumber.api.java.After;


public class ProjectsHooks {

  ProjectSteps projectSteps;
  ProjectManager projectManager;
  public ProjectsHooks(ProjectSteps projectSteps, ProjectManager projectManager){

this.projectManager=projectManager;
this.projectSteps = projectSteps;
  }

  @After("@RemoveProjectCreated")
  public void RemoveProjectCreate(){
    System.out.println(projectSteps.getProject().getName());
    projectManager.deleteProject(projectSteps.getProject());
  }
}
