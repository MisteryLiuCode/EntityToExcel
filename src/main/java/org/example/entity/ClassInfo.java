package org.example.entity;

import java.util.List;

/**
 * @author liushuaibiao
 * @date 2023/7/5 11:05
 */
public class ClassInfo {
    private List<String> propertyNames;
    private List<String> typeNames;

    public List<String> getPropertyNames() {
        return propertyNames;
    }

    public void setPropertyNames(List<String> propertyNames) {
        this.propertyNames = propertyNames;
    }

    public List<String> getTypeNames() {
        return typeNames;
    }

    public void setTypeNames(List<String> typeNames) {
        this.typeNames = typeNames;
    }
}
