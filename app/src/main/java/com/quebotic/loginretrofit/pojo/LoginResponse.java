package com.quebotic.loginretrofit.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse implements Serializable {


    @SerializedName("statusCode")
    @Expose
    public Integer statusCode;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("accessToken")
    @Expose
    public String accessToken;
    @SerializedName("Data")
    @Expose
    public Data data;


    public class Data implements Serializable {

        @SerializedName("Logins")
        @Expose
        public Logins logins;
        @SerializedName("UserInfo")
        @Expose
        public UserInfo userInfo;
    }


    public class Logins implements Serializable {

        @SerializedName("LoginID")
        @Expose
        public String loginID;
        @SerializedName("ModuleID")
        @Expose
        public String moduleID;
        @SerializedName("UserID")
        @Expose
        public String userID;
        @SerializedName("Username")
        @Expose
        public String username;
        @SerializedName("LoginModeID")
        @Expose
        public String loginModeID;
        @SerializedName("LoginModeName")
        @Expose
        public String loginModeName;
        @SerializedName("IsActive")
        @Expose
        public String isActive;
        @SerializedName("IsSystem")
        @Expose
        public String isSystem;
        @SerializedName("IsReadOnly")
        @Expose
        public String isReadOnly;
    }

    public class UserInfo implements Serializable {

        @SerializedName("FirstName")
        @Expose
        public String firstName;
        @SerializedName("SurName")
        @Expose
        public String surName;
        @SerializedName("EmailID")
        @Expose
        public String emailID;
        @SerializedName("PhoneNo")
        @Expose
        public String phoneNo;
        @SerializedName("UserTypeID")
        @Expose
        public String userTypeID;
        @SerializedName("SalutationID")
        @Expose
        public String salutationID;
        @SerializedName("DepartmentID")
        @Expose
        public String departmentID;
        @SerializedName("JobTitleID")
        @Expose
        public String jobTitleID;
        @SerializedName("ReportingToID")
        @Expose
        public String reportingToID;
        @SerializedName("OrganisationID")
        @Expose
        public String organisationID;
        @SerializedName("RoleID")
        @Expose
        public String roleID;
        @SerializedName("IsSystem")
        @Expose
        public String isSystem;
        @SerializedName("IsActive")
        @Expose
        public String isActive;
        @SerializedName("IsReadOnly")
        @Expose
        public String isReadOnly;
        @SerializedName("UserTypeName")
        @Expose
        public String userTypeName;
    }

}
