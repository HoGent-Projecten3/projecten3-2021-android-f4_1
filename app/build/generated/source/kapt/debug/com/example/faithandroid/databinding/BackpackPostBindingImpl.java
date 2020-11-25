package com.example.faithandroid.databinding;
import com.example.faithandroid.R;
import com.example.faithandroid.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BackpackPostBindingImpl extends BackpackPostBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.backpackCard, 7);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public BackpackPostBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private BackpackPostBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.LinearLayout) bindings[7]
            );
        this.BackpackAudio.setTag(null);
        this.BackpackImage.setTag(null);
        this.BackpackTextContent.setTag(null);
        this.BackpackTextTitle.setTag(null);
        this.BackpackVideo.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
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
        if (BR.date == variableId) {
            setDate((java.lang.String) variable);
        }
        else if (BR.post == variableId) {
            setPost((com.example.faithandroid.models.Post) variable);
        }
        else if (BR.posttype == variableId) {
            setPosttype((com.example.faithandroid.models.PostType) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setDate(@Nullable java.lang.String Date) {
        this.mDate = Date;
    }
    public void setPost(@Nullable com.example.faithandroid.models.Post Post) {
        this.mPost = Post;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.post);
        super.requestRebind();
    }
    public void setPosttype(@Nullable com.example.faithandroid.models.PostType Posttype) {
        this.mPosttype = Posttype;
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
        int postPostTypePosttypeVideoOrdinalViewVISIBLEViewGONE = 0;
        boolean postPostTypePosttypeAudioOrdinal = false;
        boolean postPostTypePosttypeTextOrdinal = false;
        java.lang.String postDataSubstringInt0Int50JavaLangString = null;
        java.lang.String postDataLengthInt49PostDataSubstringInt0Int50JavaLangStringPostData = null;
        boolean postDataLengthInt49 = false;
        int postPostType = 0;
        java.lang.String postTitle = null;
        java.lang.String postData = null;
        int postPostTypePosttypeImageOrdinalViewVISIBLEViewGONE = 0;
        com.example.faithandroid.models.Post post = mPost;
        int postPostTypePosttypeTextOrdinalViewVISIBLEViewGONE = 0;
        int postPostTypePosttypeAudioOrdinalViewVISIBLEViewGONE = 0;
        boolean postPostTypePosttypeImageOrdinal = false;
        boolean postPostTypePosttypeVideoOrdinal = false;
        int postDataLength = 0;
        java.lang.String postDataSubstringInt0Int50 = null;

        if ((dirtyFlags & 0xaL) != 0) {



                if (post != null) {
                    // read post.PostType
                    postPostType = post.getPostType();
                    // read post.title
                    postTitle = post.getTitle();
                    // read post.data
                    postData = post.getData();
                }


                // read post.PostType == PostType.Audio.ordinal()
                postPostTypePosttypeAudioOrdinal = (postPostType) == (com.example.faithandroid.models.PostType.Audio.ordinal());
                // read post.PostType == PostType.Text.ordinal()
                postPostTypePosttypeTextOrdinal = (postPostType) == (com.example.faithandroid.models.PostType.Text.ordinal());
                // read post.PostType == PostType.Image.ordinal()
                postPostTypePosttypeImageOrdinal = (postPostType) == (com.example.faithandroid.models.PostType.Image.ordinal());
                // read post.PostType == PostType.Video.ordinal()
                postPostTypePosttypeVideoOrdinal = (postPostType) == (com.example.faithandroid.models.PostType.Video.ordinal());
            if((dirtyFlags & 0xaL) != 0) {
                if(postPostTypePosttypeAudioOrdinal) {
                        dirtyFlags |= 0x2000L;
                }
                else {
                        dirtyFlags |= 0x1000L;
                }
            }
            if((dirtyFlags & 0xaL) != 0) {
                if(postPostTypePosttypeTextOrdinal) {
                        dirtyFlags |= 0x800L;
                }
                else {
                        dirtyFlags |= 0x400L;
                }
            }
            if((dirtyFlags & 0xaL) != 0) {
                if(postPostTypePosttypeImageOrdinal) {
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x100L;
                }
            }
            if((dirtyFlags & 0xaL) != 0) {
                if(postPostTypePosttypeVideoOrdinal) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }
                if (postData != null) {
                    // read post.data.length()
                    postDataLength = postData.length();
                }


                // read post.PostType == PostType.Audio.ordinal() ? View.VISIBLE : View.GONE
                postPostTypePosttypeAudioOrdinalViewVISIBLEViewGONE = ((postPostTypePosttypeAudioOrdinal) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read post.PostType == PostType.Text.ordinal() ? View.VISIBLE : View.GONE
                postPostTypePosttypeTextOrdinalViewVISIBLEViewGONE = ((postPostTypePosttypeTextOrdinal) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read post.PostType == PostType.Image.ordinal() ? View.VISIBLE : View.GONE
                postPostTypePosttypeImageOrdinalViewVISIBLEViewGONE = ((postPostTypePosttypeImageOrdinal) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read post.PostType == PostType.Video.ordinal() ? View.VISIBLE : View.GONE
                postPostTypePosttypeVideoOrdinalViewVISIBLEViewGONE = ((postPostTypePosttypeVideoOrdinal) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read post.data.length() >= 49
                postDataLengthInt49 = (postDataLength) >= (49);
            if((dirtyFlags & 0xaL) != 0) {
                if(postDataLengthInt49) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x80L) != 0) {

                if (postData != null) {
                    // read post.data.substring(0, 50)
                    postDataSubstringInt0Int50 = postData.substring(0, 50);
                }


                // read (post.data.substring(0, 50)) + ("...")
                postDataSubstringInt0Int50JavaLangString = (postDataSubstringInt0Int50) + ("...");
        }

        if ((dirtyFlags & 0xaL) != 0) {

                // read post.data.length() >= 49 ? (post.data.substring(0, 50)) + ("...") : post.data
                postDataLengthInt49PostDataSubstringInt0Int50JavaLangStringPostData = ((postDataLengthInt49) ? (postDataSubstringInt0Int50JavaLangString) : (postData));
        }
        // batch finished
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            this.BackpackAudio.setVisibility(postPostTypePosttypeAudioOrdinalViewVISIBLEViewGONE);
            this.BackpackImage.setVisibility(postPostTypePosttypeImageOrdinalViewVISIBLEViewGONE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.BackpackTextContent, postDataLengthInt49PostDataSubstringInt0Int50JavaLangStringPostData);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.BackpackTextTitle, postTitle);
            this.BackpackVideo.setVisibility(postPostTypePosttypeVideoOrdinalViewVISIBLEViewGONE);
            this.mboundView1.setVisibility(postPostTypePosttypeTextOrdinalViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): date
        flag 1 (0x2L): post
        flag 2 (0x3L): posttype
        flag 3 (0x4L): null
        flag 4 (0x5L): post.PostType == PostType.Video.ordinal() ? View.VISIBLE : View.GONE
        flag 5 (0x6L): post.PostType == PostType.Video.ordinal() ? View.VISIBLE : View.GONE
        flag 6 (0x7L): post.data.length() >= 49 ? (post.data.substring(0, 50)) + ("...") : post.data
        flag 7 (0x8L): post.data.length() >= 49 ? (post.data.substring(0, 50)) + ("...") : post.data
        flag 8 (0x9L): post.PostType == PostType.Image.ordinal() ? View.VISIBLE : View.GONE
        flag 9 (0xaL): post.PostType == PostType.Image.ordinal() ? View.VISIBLE : View.GONE
        flag 10 (0xbL): post.PostType == PostType.Text.ordinal() ? View.VISIBLE : View.GONE
        flag 11 (0xcL): post.PostType == PostType.Text.ordinal() ? View.VISIBLE : View.GONE
        flag 12 (0xdL): post.PostType == PostType.Audio.ordinal() ? View.VISIBLE : View.GONE
        flag 13 (0xeL): post.PostType == PostType.Audio.ordinal() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}