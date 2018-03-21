package vip.yoxiang.netty.chapter10;

import java.util.List;

/**
 * Author: RiversLau
 * Date: 2018/3/21 16:06
 */
public class Customer {

    private long id;
    private String firstName;
    private String lastName;

    private List<String> middleNames;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }
}
