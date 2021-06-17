package com.ryanandvinicius.bomsomapp.fakeDatabase;


import com.ryanandvinicius.bomsomapp.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepo {
    private List<Project> projectList;

    public ProjectRepo(){
        projectList = new ArrayList<>();
    }

    public void addProject(Project project){
        if (project != null){
            Integer newId = projectList.size() + 1;
            project.setId(newId.toString());
            projectList.add(project);
        }
    }

    public void editProject(Project project){
        if (project != null){
            int index = findById(project.getId());
            if (index >= 0){
                projectList.add(index,project);
            }
        }
    }

    private int findById(String id){
        for (int i = 0; i < projectList.size(); i++){
            Project p = projectList.get(i);
            if (p.getId().trim().equals(id.trim())){
                return i;
            }
        }
        return -1;
    }
}
