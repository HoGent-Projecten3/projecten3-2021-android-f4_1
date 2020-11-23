package com.example.faithandroid.bulletinboard;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/faithandroid/bulletinboard/BulletinBoardViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_postList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/faithandroid/models/Post;", "_requestConsultationStatus", "", "_status", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mockData", "", "getMockData", "()Ljava/util/List;", "setMockData", "(Ljava/util/List;)V", "postList", "Landroidx/lifecycle/LiveData;", "getPostList", "()Landroidx/lifecycle/LiveData;", "requestConsultationStatus", "getRequestConsultationStatus", "status", "getStatus", "viewModelJob", "Lkotlinx/coroutines/CompletableJob;", "addNewPostToBulletinBoard", "", "post", "getPostsOfBulletinBoard", "requestConsultation", "app_release"})
public final class BulletinBoardViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _status = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _requestConsultationStatus = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.faithandroid.models.Post> mockData;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.faithandroid.models.Post>> _postList = null;
    private kotlinx.coroutines.CompletableJob viewModelJob;
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getRequestConsultationStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.faithandroid.models.Post> getMockData() {
        return null;
    }
    
    public final void setMockData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.faithandroid.models.Post> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.faithandroid.models.Post>> getPostList() {
        return null;
    }
    
    public final void getPostsOfBulletinBoard() {
    }
    
    public final void addNewPostToBulletinBoard(@org.jetbrains.annotations.NotNull()
    com.example.faithandroid.models.Post post) {
    }
    
    public final void requestConsultation() {
    }
    
    public BulletinBoardViewModel() {
        super();
    }
}