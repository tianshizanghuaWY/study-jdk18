package com.qianyang.study.jdk18.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * <br>
 *
 * @author wangyuan
 */
public class AreaNode {
    private String name;
    private String value;
    private List<AreaNode> children = new ArrayList<>(10);

    public AreaNode(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<AreaNode> getChildren() {
        return children;
    }

    public void setChildren(List<AreaNode> children) {
        this.children = children;
    }


    public void addChild(AreaNode child){
        if(this.children == null){
            this.children = new ArrayList<AreaNode>(10);
        }

        this.children.add(child);
    }
}
