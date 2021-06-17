package com.ryanandvinicius.bomsomapp.fakeDatabase;


import com.ryanandvinicius.bomsomapp.model.Employee;
import com.ryanandvinicius.bomsomapp.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepo {
    private  static List<Project> projectList;

    static{
        projectList = new ArrayList<>();
    }

    public static void addProject(Project project){
        if (project != null){
            Integer newId = projectList.size() + 1;
            project.setId(newId.toString());
            projectList.add(project);
        }
    }

    public static void editProject(Project project){
        if (project != null){
            int index = findById(project.getId());
            if (index >= 0){
                projectList.add(index,project);
            }
        }
    }

    public static int findById(String id){
        for (int i = 0; i < projectList.size(); i++){
            Project p = projectList.get(i);
            if (p.getId().trim().equals(id.trim())){
                return i;
            }
        }
        return -1;
    }

    public static Project find(String id){
        for (Project p: projectList){
            if (p.getId().trim().equals(id.trim())){
                return p;
            }
        }
        return null;
    }

    public static List<String> getAllNames(){
        List<String> names = new ArrayList<>();

        for (Project p : projectList){
            names.add(p.getName());
        }
        return names;
    }

}
