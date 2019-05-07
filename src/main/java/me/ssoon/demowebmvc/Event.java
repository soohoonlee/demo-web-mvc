package me.ssoon.demowebmvc;

import javax.validation.constraints.Min;

public class Event {

    private Integer id;
    private String name;
    @Min(0)
    private Integer limit;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(final Integer limit) {
        this.limit = limit;
    }
}
