package com.example.faithandroid.login.data;

import java.lang.System;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/example/faithandroid/login/data/LoginRepository;", "", "dataSource", "Lcom/example/faithandroid/login/data/LoginDataSource;", "(Lcom/example/faithandroid/login/data/LoginDataSource;)V", "getDataSource", "()Lcom/example/faithandroid/login/data/LoginDataSource;", "isLoggedIn", "", "()Z", "<set-?>", "Lcom/example/faithandroid/login/data/LoggedInUser;", "user", "getUser", "()Lcom/example/faithandroid/login/data/LoggedInUser;", "login", "Lcom/example/faithandroid/login/data/Result;", "username", "", "password", "logout", "", "setLoggedInUser", "loggedInUser", "app_release"})
public final class LoginRepository {
    @org.jetbrains.annotations.Nullable()
    private com.example.faithandroid.login.data.LoggedInUser user;
    @org.jetbrains.annotations.NotNull()
    private final com.example.faithandroid.login.data.LoginDataSource dataSource = null;
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.faithandroid.login.data.LoggedInUser getUser() {
        return null;
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    public final void logout() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.faithandroid.login.data.Result<com.example.faithandroid.login.data.LoggedInUser> login(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
    
    private final void setLoggedInUser(com.example.faithandroid.login.data.LoggedInUser loggedInUser) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.faithandroid.login.data.LoginDataSource getDataSource() {
        return null;
    }
    
    public LoginRepository(@org.jetbrains.annotations.NotNull()
    com.example.faithandroid.login.data.LoginDataSource dataSource) {
        super();
    }
}