package com.example.faithandroid.login.uilogin;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/example/faithandroid/login/uilogin/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "loginRepository", "Lcom/example/faithandroid/login/data/LoginRepository;", "(Lcom/example/faithandroid/login/data/LoginRepository;)V", "_adolescent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/faithandroid/models/Adolescent;", "_loginForm", "Lcom/example/faithandroid/login/uilogin/LoginFormState;", "_loginResult", "Lcom/example/faithandroid/login/uilogin/LoginResult;", "adolescent", "Landroidx/lifecycle/LiveData;", "getAdolescent", "()Landroidx/lifecycle/LiveData;", "loginFormState", "getLoginFormState", "loginResult", "getLoginResult", "isPasswordValid", "", "password", "", "isUserNameValid", "username", "login", "", "loginDataChanged", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private androidx.lifecycle.MutableLiveData<com.example.faithandroid.models.Adolescent> _adolescent;
    private final androidx.lifecycle.MutableLiveData<com.example.faithandroid.login.uilogin.LoginFormState> _loginForm = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.faithandroid.login.uilogin.LoginFormState> loginFormState = null;
    private final androidx.lifecycle.MutableLiveData<com.example.faithandroid.login.uilogin.LoginResult> _loginResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.faithandroid.login.uilogin.LoginResult> loginResult = null;
    private final com.example.faithandroid.login.data.LoginRepository loginRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.faithandroid.models.Adolescent> getAdolescent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.faithandroid.login.uilogin.LoginFormState> getLoginFormState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.faithandroid.login.uilogin.LoginResult> getLoginResult() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    public final void loginDataChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    private final boolean isUserNameValid(java.lang.String username) {
        return false;
    }
    
    private final boolean isPasswordValid(java.lang.String password) {
        return false;
    }
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.example.faithandroid.login.data.LoginRepository loginRepository) {
        super();
    }
}