package org.sample.reactive.bean;

public class Freelancer extends Employee {

    private int fid;

    public Freelancer(int id, String name, int fid) {
        super(id, name);
        this.fid = fid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "[id=" + super.getId() + ",name=" + super.getName() + ",fid=" + fid + "]";
    }
}
