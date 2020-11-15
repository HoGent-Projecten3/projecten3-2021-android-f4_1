package com.example.faithandroid.databinding;
import com.example.faithandroid.R;
import com.example.faithandroid.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class GridViewItemBindingImpl extends GridViewItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public GridViewItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 1, sIncludes, sViewsWithIds));
    }
    private GridViewItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[0]
            );
        this.faithFirstname.setTag(null);
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
            setProperty((com.example.faithandroid.network.FaithProperty) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setProperty(@Nullable com.example.faithandroid.network.FaithProperty Property) {
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
        java.lang.String propertyFirstNamePropertyNamePropertyEmail = null;
        com.example.faithandroid.network.FaithProperty property = mProperty;
        java.lang.String propertyName = null;
        java.lang.String propertyEmail = null;
        java.lang.String propertyFirstName = null;
        java.lang.String propertyFirstNamePropertyName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (property != null) {
                    // read property.name
                    propertyName = property.getName();
                    // read property.email
                    propertyEmail = property.getEmail();
                    // read property.firstName
                    propertyFirstName = property.getFirstName();
                }


                // read (property.firstName) + (property.name)
                propertyFirstNamePropertyName = (propertyFirstName) + (propertyName);


                // read ((property.firstName) + (property.name)) + (property.email)
                propertyFirstNamePropertyNamePropertyEmail = (propertyFirstNamePropertyName) + (propertyEmail);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.faithFirstname, propertyFirstNamePropertyNamePropertyEmail);
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