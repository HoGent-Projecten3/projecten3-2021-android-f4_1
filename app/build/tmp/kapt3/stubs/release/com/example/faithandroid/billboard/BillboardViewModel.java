package com.example.faithandroid.billboard;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0018H\u0014R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/faithandroid/billboard/BillboardViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_properties", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/faithandroid/models/GoalPost;", "_status", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mockData", "", "getMockData", "()Ljava/util/List;", "properties", "Landroidx/lifecycle/LiveData;", "getProperties", "()Landroidx/lifecycle/LiveData;", "status", "getStatus", "viewModelJob", "Lkotlinx/coroutines/CompletableJob;", "getPosts", "", "onCleared", "app_release"})
public final class BillboardViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _status = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.faithandroid.models.GoalPost> mockData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.faithandroid.models.GoalPost>> _properties = null;
    private kotlinx.coroutines.CompletableJob viewModelJob;
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.faithandroid.models.GoalPost> getMockData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.faithandroid.models.GoalPost>> getProperties() {
        return null;
    }
    
    public final void getPosts() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public BillboardViewModel() {
        super();
    }
}