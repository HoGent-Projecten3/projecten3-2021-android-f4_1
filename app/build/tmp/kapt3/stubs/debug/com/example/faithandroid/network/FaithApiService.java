package com.example.faithandroid.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003H\'J%\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/faithandroid/network/FaithApiService;", "", "getPostsOfSkyScraperByAdolescentEmail", "Lkotlinx/coroutines/Deferred;", "", "Lcom/example/faithandroid/models/GoalPost;", "email", "", "getProperties", "Lcom/example/faithandroid/network/FaithProperty;", "postGoalPost", "", "goal", "(Lcom/example/faithandroid/models/GoalPost;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postPost", "Lretrofit2/Call;", "Ljava/lang/Void;", "post", "Lcom/example/faithandroid/models/TextPost;", "app_debug"})
public abstract interface FaithApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "Account/GetAdolescentsByCounselorEmail/bob.debouwer1998@gmail.com")
    public abstract kotlinx.coroutines.Deferred<java.util.List<com.example.faithandroid.network.FaithProperty>> getProperties();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "City/AddPostByEmail")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<java.lang.Void> postPost(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.faithandroid.models.TextPost post, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "City/AddGoalByEmail")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract java.lang.Object postGoalPost(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.faithandroid.models.GoalPost goal, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "City/GetPostsOfSkyScraperByAdolescentEmail")
    public abstract kotlinx.coroutines.Deferred<java.util.List<com.example.faithandroid.models.GoalPost>> getPostsOfSkyScraperByAdolescentEmail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email);
}