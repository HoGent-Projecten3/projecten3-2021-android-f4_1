package com.example.faithandroid.databinding;
import com.example.faithandroid.R;
import com.example.faithandroid.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class VideoToevoegenBindingImpl extends VideoToevoegenBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearLayout2, 3);
        sViewsWithIds.put(R.id.videocam, 4);
        sViewsWithIds.put(R.id.album, 5);
        sViewsWithIds.put(R.id.filled_exposed_dropdown, 6);
        sViewsWithIds.put(R.id.titelVeld, 7);
        sViewsWithIds.put(R.id.titel, 8);
        sViewsWithIds.put(R.id.videoToevoegenButton, 9);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.FrameLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public VideoToevoegenBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private VideoToevoegenBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[5]
            , (android.widget.AutoCompleteTextView) bindings[6]
            , (android.widget.LinearLayout) bindings[3]
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (com.google.android.material.textfield.TextInputEditText) bindings[8]
            , (com.google.android.material.textfield.TextInputLayout) bindings[7]
            , (android.widget.Button) bindings[9]
            , (android.widget.ImageView) bindings[4]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.FrameLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.recyclerView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.videoGekozen == variableId) {
            setVideoGekozen((java.lang.Boolean) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.example.faithandroid.PostViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVideoGekozen(@Nullable java.lang.Boolean VideoGekozen) {
        this.mVideoGekozen = VideoGekozen;
    }
    public void setViewModel(@Nullable com.example.faithandroid.PostViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelPostListFiltered((androidx.lifecycle.LiveData<java.util.List<com.example.faithandroid.models.Post>>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelPostListFiltered(androidx.lifecycle.LiveData<java.util.List<com.example.faithandroid.models.Post>> ViewModelPostListFiltered, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        androidx.lifecycle.LiveData<java.util.List<com.example.faithandroid.models.Post>> viewModelPostListFiltered = null;
        java.util.List<com.example.faithandroid.models.Post> viewModelPostListFilteredGetValue = null;
        com.example.faithandroid.PostViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xdL) != 0) {



                if (viewModel != null) {
                    // read viewModel.postListFiltered
                    viewModelPostListFiltered = viewModel.getPostListFiltered();
                }
                updateLiveDataRegistration(0, viewModelPostListFiltered);


                if (viewModelPostListFiltered != null) {
                    // read viewModel.postListFiltered.getValue()
                    viewModelPostListFilteredGetValue = viewModelPostListFiltered.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            com.example.faithandroid.BindingAdaptersKt.bindRecyclerViewFilteredPost(this.recyclerView, viewModelPostListFilteredGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.postListFiltered
        flag 1 (0x2L): videoGekozen
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}