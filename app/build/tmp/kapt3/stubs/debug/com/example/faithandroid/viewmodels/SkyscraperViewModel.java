package com.example.faithandroid.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0007J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\u0016\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/faithandroid/viewmodels/SkyscraperViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "test", "", "Lcom/example/faithandroid/models/GoalPost;", "getTest", "()Ljava/util/List;", "setTest", "(Ljava/util/List;)V", "testLive", "Landroidx/lifecycle/LiveData;", "", "getTestLive", "()Landroidx/lifecycle/LiveData;", "testLiveData", "Landroidx/lifecycle/MutableLiveData;", "viewModelJob", "Lkotlinx/coroutines/CompletableJob;", "GetPostsOfSkyscraper", "", "email", "", "addGoalPost", "goal", "onCleared", "postNewGoalPost", "goalPost", "app_debug"})
public final class SkyscraperViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.faithandroid.models.GoalPost> test;
    private androidx.lifecycle.MutableLiveData<java.util.List<com.example.faithandroid.models.GoalPost>> testLiveData;
    private kotlinx.coroutines.CompletableJob viewModelJob;
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.faithandroid.models.GoalPost> getTest() {
        return null;
    }
    
    public final void setTest(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.faithandroid.models.GoalPost> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.faithandroid.models.GoalPost>> getTestLive() {
        return null;
    }
    
    public final void addGoalPost(@org.jetbrains.annotations.NotNull()
    com.example.faithandroid.models.GoalPost goal) {
    }
    
    private final void GetPostsOfSkyscraper(java.lang.String email) {
    }
    
    public final void postNewGoalPost(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    com.example.faithandroid.models.GoalPost goalPost) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public SkyscraperViewModel() {
        super();
    }
}