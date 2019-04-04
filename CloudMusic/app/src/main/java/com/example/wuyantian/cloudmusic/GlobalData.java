package com.example.wuyantian.cloudmusic;

import android.app.Application;

public class GlobalData extends Application {
    String globalAccount;
    String globalPassword;

    public String getGlobalPassword() {
        return globalPassword;

    }

    public String getGlobalAccount() {
        return globalAccount;
    }

    public void setGlobalPassword(String globalPassword) {
        this.globalPassword = globalPassword;
    }

    public void setGlobalAccount(String globalAccount) {
        this.globalAccount = globalAccount;
    }
}
