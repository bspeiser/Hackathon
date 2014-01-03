package com.mongotest;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Parent {
		@SerializedName("empID")
	    private static final long serialVersionUID = 1L;
	    private long no;
	    private String name;

	    public Parent() {
	    }

	    public long getNo() {
	        return no;
	    }

	    public void setNo(long no) {
	        this.no = no;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

		@Override
		public String toString() {
			return "Employee [no=" + no + ", name=" + name + "]";
		}

	}


