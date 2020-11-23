package com.example.faithandroid.databinding;
import com.example.faithandroid.R;
import com.example.faithandroid.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BulletinboardTextpostBindingImpl extends BulletinboardTextpostBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.bulletinboardCard, 4);
        sViewsWithIds.put(R.id.bulletinboardOpenButton, 5);
        sViewsWithIds.put(R.id.bulletinboardUnpinButton, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public BulletinboardTextpostBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private BulletinboardTextpostBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.Button) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (android.widget.Button) bindings[6]
            );
        this.bulletinboardInhoud.setTag(null);
        this.bulletinboardTittle.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.date == variableId) {
            setDate((java.lang.String) variable);
        }
        else if (BR.post == variableId) {
            setPost((com.example.faithandroid.models.Post) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setDate(@Nullable java.lang.String Date) {
        this.mDate = Date;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.date);
        super.requestRebind();
    }
    public void setPost(@Nullable com.example.faithandroid.models.Post Post) {
        this.mPost = Post;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.post);
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
        java.lang.String postDataSubstringInt0Int50JavaLangString = null;
        java.lang.String postDataLengthInt49PostDataSubstringInt0Int50JavaLangStringPostData = null;
        boolean postDataLengthInt49 = false;
        java.lang.String date = mDate;
        int postDataLength = 0;
        java.lang.String postTitle = null;
        java.lang.String postData = null;
        java.lang.String postDataSubstringInt0Int50 = null;
        com.example.faithandroid.models.Post post = mPost;

        if ((dirtyFlags & 0x5L) != 0) {
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (post != null) {
                    // read post.title
                    postTitle = post.getTitle();
                    // read post.data
                    postData = post.getData();
                }


                if (postData != null) {
                    // read post.data.length()
                    postDataLength = postData.length();
                }


                // read post.data.length() >= 49
                postDataLengthInt49 = (postDataLength) >= (49);
            if((dirtyFlags & 0x6L) != 0) {
                if(postDataLengthInt49) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x10L) != 0) {

                if (postData != null) {
                    // read post.data.substring(0, 50)
                    postDataSubstringInt0Int50 = postData.substring(0, 50);
                }


                // read (post.data.substring(0, 50)) + ("...")
                postDataSubstringInt0Int50JavaLangString = (postDataSubstringInt0Int50) + ("...");
        }

        if ((dirtyFlags & 0x6L) != 0) {

                // read post.data.length() >= 49 ? (post.data.substring(0, 50)) + ("...") : post.data
                postDataLengthInt49PostDataSubstringInt0Int50JavaLangStringPostData = ((postDataLengthInt49) ? (postDataSubstringInt0Int50JavaLangString) : (postData));
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.bulletinboardInhoud, postDataLengthInt49PostDataSubstringInt0Int50JavaLangStringPostData);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.bulletinboardTittle, postTitle);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, date);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): date
        flag 1 (0x2L): post
        flag 2 (0x3L): null
        flag 3 (0x4L): post.data.length() >= 49 ? (post.data.substring(0, 50)) + ("...") : post.data
        flag 4 (0x5L): post.data.length() >= 49 ? (post.data.substring(0, 50)) + ("...") : post.data
    flag mapping end*/
    //end
}