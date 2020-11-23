package com.example.faithandroid.skyscraper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#J\b\u0010%\u001a\u00020\u001fH\u0014J\u0016\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u0017J\u000e\u0010(\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00190\n8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00190\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/example/faithandroid/skyscraper/SkyscraperViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_completedStatus", "Landroidx/lifecycle/MutableLiveData;", "", "_getStatus", "_removeStatus", "_shareStatus", "completedStatus", "Landroidx/lifecycle/LiveData;", "getCompletedStatus", "()Landroidx/lifecycle/LiveData;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getStatus", "getGetStatus", "removeStatus", "getRemoveStatus", "shareStatus", "getShareStatus", "test", "", "Lcom/example/faithandroid/models/GoalPost;", "testLive", "", "getTestLive", "testLiveData", "viewModelJob", "Lkotlinx/coroutines/CompletableJob;", "GetPostsOfSkyscraper", "", "email", "deleteGoal", "id", "", "goalBehaald", "onCleared", "postNewGoalPost", "goalPost", "shareGoal", "app_release"})
public final class SkyscraperViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _shareStatus = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _completedStatus = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _removeStatus = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _getStatus = null;
    private androidx.lifecycle.MutableLiveData<java.util.List<com.example.faithandroid.models.GoalPost>> testLiveData;
    private java.util.List<com.example.faithandroid.models.GoalPost> test;
    private kotlinx.coroutines.CompletableJob viewModelJob;
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getShareStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getCompletedStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getRemoveStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getGetStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.faithandroid.models.GoalPost>> getTestLive() {
        return null;
    }
    
    public final void GetPostsOfSkyscraper(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void goalBehaald(int id) {
    }
    
    public final void postNewGoalPost(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    com.example.faithandroid.models.GoalPost goalPost) {
    }
    
    public final void shareGoal(int id) {
    }
    
    public final void deleteGoal(int id) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public SkyscraperViewModel() {
        super();
    }
}