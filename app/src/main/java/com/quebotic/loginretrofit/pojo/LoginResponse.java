package com.quebotic.loginretrofit.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse {



    @SerializedName("message")
    @Expose
    public String message;

    public String id;
    public String code;
    public String agent;








}
