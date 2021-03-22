package jp.techacademy.kenji.takada.taskapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0014J\b\u0010\u000e\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Ljp/techacademy/kenji/takada/taskapp/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mRealm", "Lio/realm/Realm;", "mRealmListener", "Lio/realm/RealmChangeListener;", "mTaskAdapter", "Ljp/techacademy/kenji/takada/taskapp/TaskAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "reloadListView", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private io.realm.Realm mRealm;
    private final io.realm.RealmChangeListener<io.realm.Realm> mRealmListener = null;
    private jp.techacademy.kenji.takada.taskapp.TaskAdapter mTaskAdapter;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void reloadListView() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public MainActivity() {
        super();
    }
}