package com.example.faithandroid.databinding;
import com.example.faithandroid.R;
import com.example.faithandroid.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class SkyscraperGoaldetailsBindingImpl extends SkyscraperGoaldetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.include2, 1);
        sViewsWithIds.put(R.id.titelText, 2);
        sViewsWithIds.put(R.id.linearLayout, 3);
        sViewsWithIds.put(R.id.beschrijving, 4);
        sViewsWithIds.put(R.id.beschrijvingText, 5);
        sViewsWithIds.put(R.id.textView7, 6);
        sViewsWithIds.put(R.id.stepList, 7);
        sViewsWithIds.put(R.id.btnBehaald, 8);
        sViewsWithIds.put(R.id.btnDelen, 9);
        sViewsWithIds.put(R.id.btnVerwijder, 10);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public SkyscraperGoaldetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private SkyscraperGoaldetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.Button) bindings[8]
            , (android.widget.Button) bindings[9]
            , (android.widget.Button) bindings[10]
            , (android.view.View) bindings[1]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.goalDetailViewModel == variableId) {
            setGoalDetailViewModel((com.example.faithandroid.skyscraper.SkyscraperViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setGoalDetailViewModel(@Nullable com.example.faithandroid.skyscraper.SkyscraperViewModel GoalDetailViewModel) {
        this.mGoalDetailViewModel = GoalDetailViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): goalDetailViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}