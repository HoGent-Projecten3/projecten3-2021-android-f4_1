package com.example.faithandroid.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'J%\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0001\u0010\u000b\u001a\u00020\fH\'J\u001e\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00122\b\b\u0001\u0010\u000b\u001a\u00020\fH\'J2\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH\'J\u001e\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150\u00122\b\b\u0001\u0010\u000b\u001a\u00020\fH\'J\u001e\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150\u00122\b\b\u0001\u0010\u000b\u001a\u00020\fH\'J(\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH\'J\u001e\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00122\b\b\u0001\u0010\u000b\u001a\u00020\fH\'J\u001e\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150\u00122\b\b\u0001\u0010\u000b\u001a\u00020\fH\'J\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00150\u0012H\'J\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010!\u001a\u00020\"H\'J%\u0010#\u001a\u00020\u000e2\b\b\u0001\u0010$\u001a\u00020\u00162\b\b\u0001\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\"\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\'2\b\b\u0001\u0010\u000b\u001a\u00020\fH\'J\u001c\u0010(\u001a\u00020\u000e2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH\'J\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\fH\'J\u001c\u0010*\u001a\u00020\u000e2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lcom/example/faithandroid/network/FaithApiService;", "", "addExistingPostToPlace", "Lretrofit2/Call;", "Ljava/lang/Void;", "id", "", "placeType", "addPostByEmail", "post", "Lcom/example/faithandroid/models/Post;", "email", "", "checkGoal", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePostByEmail", "getAdolescent", "Lkotlinx/coroutines/Deferred;", "Lcom/example/faithandroid/models/Adolescent;", "getBillboardGoalsByAdolescentEmail", "", "Lcom/example/faithandroid/models/GoalPost;", "getFilteredFromPlace", "postType", "getPostsOfBackpackByAdolescentEmail", "getPostsOfBulletinBoardByAdolescentEmail", "getPostsOfPlaceByAdolescentEmail", "getPostsOfSkyScraperByAdolescentEmail", "getPostsOfTreasureChestByAdolescentEmail", "getProperties", "Lcom/example/faithandroid/network/FaithProperty;", "loginAdolescent", "adolescent", "Lcom/example/faithandroid/login/data/User;", "postGoalPost", "goal", "(Lcom/example/faithandroid/models/GoalPost;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postPost", "Lcom/example/faithandroid/models/TextPost;", "removeGoal", "requestConsultation", "shareGoal", "app_debug"})
public abstract interface FaithApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "Account/CreateToken")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<java.lang.String> loginAdolescent(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.faithandroid.login.data.User adolescent);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "Account/GetAdolescent")
    public abstract kotlinx.coroutines.Deferred<com.example.faithandroid.models.Adolescent> getAdolescent(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email);
    
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
    @retrofit2.http.GET(value = "City/GetPostsOfBackpackByAdolescentEmail")
    public abstract kotlinx.coroutines.Deferred<java.util.List<com.example.faithandroid.models.Post>> getPostsOfBackpackByAdolescentEmail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "City/GetPostsOfTreasureChestByAdolescentEmail")
    public abstract kotlinx.coroutines.Deferred<java.util.List<com.example.faithandroid.models.Post>> getPostsOfTreasureChestByAdolescentEmail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "City/GetBillboardGoalsByAdolescentMail")
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
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "City/GetFilteredPostsFromPlace")
    public abstract retrofit2.Call<java.util.List<com.example.faithandroid.models.Post>> getFilteredFromPlace(@retrofit2.http.Query(value = "placeType")
    int placeType, @retrofit2.http.Query(value = "postType")
    int postType, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "City/GetPostsOfPlaceByAdolescentEmail")
    public abstract retrofit2.Call<java.util.List<com.example.faithandroid.models.Post>> getPostsOfPlaceByAdolescentEmail(@retrofit2.http.Query(value = "placeType")
    int placeType, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "City/AddPostByEmail")
    @retrofit2.http.Headers(value = {"Content-Type: application/json", "accept: application/json"})
    public abstract retrofit2.Call<java.lang.Void> addPostByEmail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.faithandroid.models.Post post, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email, @retrofit2.http.Query(value = "placeType")
    int placeType);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PUT(value = "City/DeletePostByEmail")
    @retrofit2.http.Headers(value = {"Content-Type: application/json", "accept: application/json"})
    public abstract retrofit2.Call<java.lang.Void> deletePostByEmail(@retrofit2.http.Query(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "email")
    java.lang.String email, @retrofit2.http.Query(value = "placeType")
    int placeType);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PUT(value = "City/AddExistingPostToPlace")
    @retrofit2.http.Headers(value = {"Content-Type: application/json", "accept: application/json"})
    public abstract retrofit2.Call<java.lang.Void> addExistingPostToPlace(@retrofit2.http.Query(value = "postId")
    int id, @retrofit2.http.Query(value = "placeType")
    int placeType);
}