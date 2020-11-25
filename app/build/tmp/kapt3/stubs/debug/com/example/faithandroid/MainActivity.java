package com.example.faithandroid;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0012\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/faithandroid/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/faithandroid/DrawerInterface;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "()V", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "toggle", "Landroidx/appcompat/app/ActionBarDrawerToggle;", "username", "", "viewModel", "Lcom/example/faithandroid/login/uilogin/LoginViewModel;", "ClickBack", "", "view", "Landroid/view/View;", "ClickMenu", "lockDrawer", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "onOptionsItemSelected", "item", "openDrawer", "unlockDrawer", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.faithandroid.DrawerInterface, com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
    private androidx.drawerlayout.widget.DrawerLayout drawerLayout;
    private androidx.appcompat.app.ActionBarDrawerToggle toggle;
    private com.example.faithandroid.login.uilogin.LoginViewModel viewModel;
    private java.lang.String username = "";
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public final void ClickMenu(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void openDrawer(androidx.drawerlayout.widget.DrawerLayout drawerLayout) {
    }
    
    public final void ClickBack(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void lockDrawer() {
    }
    
    @java.lang.Override()
    public void unlockDrawer() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onNavigationItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem menuItem) {
        return false;
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public MainActivity() {
        super();
    }
}