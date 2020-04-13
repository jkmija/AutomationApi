package com.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"color","shared","inbox_project"})
public class Project {

    @JsonProperty("id")
    private long id ;

    @JsonProperty("name")
    private String name;

    @JsonProperty("comment_count")
    private int commentCount;

    @JsonProperty("order")
    private int order;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public int getOrder() {
        return order;
    }



    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public static Project createProject(Map<String, String> entry) {
        Project project = new Project();
        project.setName(entry.get("name"));
//        project.setCommentCount(Integer.parseInt(entry.get("comment_count")));
//        project.setOrder(Integer.parseInt(entry.get("order")));
//        project.setId(Long.parseLong(entry.get("id")));
        return project;
    }
    public Map<String, Object> projectToMap() {
        Map<String, Object> entry = new HashMap<>();
        entry.put("name",name);
//        entry.put("comment_count",commentCount);
//        entry.put("order",order);
        return entry;
    }


}
