package com.example.faithandroid.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\'J\u001e\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\n2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\'J\u001e\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b0\nH\'J%\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010\u0013\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\b\u0001\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\'J\u001c\u0010\u001a\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\'J\u001c\u0010\u001c\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/example/faithandroid/network/FaithApiService;", "", "checkGoal", "", "email", "", "id", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBillboardGoalsByAdolescentEmail", "Lkotlinx/coroutines/Deferred;", "", "Lcom/example/faithandroid/models/GoalPost;", "getPostsOfBulletinBoardByAdolescentEmail", "Lcom/example/faithandroid/models/Post;", "getPostsOfSkyScraperByAdolescentEmail", "getProperties", "Lcom/example/faithandroid/network/FaithProperty;", "postGoalPost", "goal", "(Lcom/example/faithandroid/models/GoalPost;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postPost", "Lretrofit2/Call;", "Ljava/lang/Void;", "post", "Lcom/example/faithandroid/models/TextPost;", "removeGoal", "requestConsultation", "shareGoal", "app_release"})
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
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.PUT(value = "City/MarkGoalAsCompleted")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract java.lang.Object checkGoal(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email, @retrofit2.http.Query(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "City/GetPostsOfSkyScraperByAdolescentEmail")
    public abstract kotlinx.coroutines.Deferred<java.util.List<com.example.faithandroid.models.GoalPost>> getPostsOfSkyScraperByAdolescentEmail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "City/GetPostsOfBulletinBoardByAdolescentEmail")
    public abstract kotlinx.coroutines.Deferred<java.util.List<com.example.faithandroid.models.Post>> getPostsOfBulletinBoardByAdolescentEmail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "City/GetBillboardGoalsByAdolescentEmail")
    public abstract kotlinx.coroutines.Deferred<java.util.List<com.example.faithandroid.models.GoalPost>> getBillboardGoalsByAdolescentEmail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PUT(value = "Account/PostConsultationRequest")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<java.lang.Void> requestConsultation(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email);
    
    @retrofit2.http.PUT(value = "City/ShareGoalWithBillboard")
    public abstract void shareGoal(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email, @retrofit2.http.Query(value = "id")
    int id);
    
    @retrofit2.http.POST(value = "City/DeleteGoalByEmail")
    public abstract void removeGoal(@retrofit2.http.Query(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email);
}