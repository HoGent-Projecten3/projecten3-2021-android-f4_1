package com.example.faithandroid;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0007\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005H\u0007\u00a8\u0006\t"}, d2 = {"bindRecyclerViewBillboard", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "", "Lcom/example/faithandroid/models/GoalPost;", "bindRecyclerViewBulletinboard", "Lcom/example/faithandroid/models/Post;", "app_release"})
public final class BindingAdaptersKt {
    
    @androidx.databinding.BindingAdapter(value = {"listData"})
    public static final void bindRecyclerViewBulletinboard(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.faithandroid.models.Post> data) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"BillboardListData"})
    public static final void bindRecyclerViewBillboard(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.faithandroid.models.GoalPost> data) {
    }
}