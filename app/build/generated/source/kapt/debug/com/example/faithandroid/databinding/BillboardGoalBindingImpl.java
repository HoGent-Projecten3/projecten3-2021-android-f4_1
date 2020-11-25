package com.example.faithandroid.databinding;
import com.example.faithandroid.R;
import com.example.faithandroid.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BillboardGoalBindingImpl extends BillboardGoalBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.button, 3);
        sViewsWithIds.put(R.id.cardprofile, 4);
        sViewsWithIds.put(R.id.profilepicture, 5);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public BillboardGoalBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private BillboardGoalBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[3]
            , (androidx.cardview.widget.CardView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[2]
            );
        this.description.setTag(null);
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.titleGoal.setTag(null);
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
        if (BR.property == variableId) {
            setProperty((com.example.faithandroid.models.GoalPost) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setProperty(@Nullable com.example.faithandroid.models.GoalPost Property) {
        this.mProperty = Property;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.property);
        super.requestRebind();
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
        com.example.faithandroid.models.GoalPost property = mProperty;
        java.lang.String propertyTitle = null;
        java.lang.String propertyDescription = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (property != null) {
                    // read property.title
                    propertyTitle = property.getTitle();
                    // read property.description
                    propertyDescription = property.getDescription();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.description, propertyDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.titleGoal, propertyTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): property
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}