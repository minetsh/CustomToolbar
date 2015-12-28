package me.kareluo.custom.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.TintTypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import static android.support.v7.appcompat.R.styleable;

/**
 * Created by felix on 15/12/28.
 */
public class TitleToolbar extends BaseToolbar implements View.OnClickListener {

    private TextView mTitleTextView;
    private TextView mCloseTextView;
    private TextView mBackTextView;
    private CharSequence mTitleText;
    private CharSequence mCloseText;
    private CharSequence mBackText;


    public TitleToolbar(Context context) {
        super(context);
    }

    public TitleToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TitleToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void initialize(Context context, AttributeSet attrs, int defStyleAttr) {
        super.initialize(context, attrs, defStyleAttr);
    }

    @Override
    protected void initCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                styleable.Toolbar, defStyleAttr, 0);

        if (!isChild(mTitleTextView)) {
            mTitleTextView = new TextView(context);
            mTitleTextView.setSingleLine();
            mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);

            int titleTextAppearance = a.getResourceId(styleable.Toolbar_titleTextAppearance, 0);

            if (titleTextAppearance != 0) {
                mTitleTextView.setTextAppearance(context, titleTextAppearance);
            }

            if (a.hasValue(styleable.Toolbar_titleTextColor)) {
                int titleColor = a.getColor(styleable.Toolbar_titleTextColor, Color.WHITE);
                mTitleTextView.setTextColor(titleColor);
            }

            setTitle(a.getText(styleable.Toolbar_title));

            addView(mTitleTextView, new LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        }

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleToolbar);

        if (!isChild(mCloseTextView)) {
            mCloseTextView = new TextView(context);
            mCloseTextView.setId(R.id.close);
            mCloseTextView.setSingleLine();
            mCloseTextView.setEllipsize(TextUtils.TruncateAt.END);

            int id = typedArray.getResourceId(R.styleable.TitleToolbar_closeTextAppearance, 0);
            if (id != 0) {
                mCloseTextView.setTextAppearance(context, id);
            }

            if (typedArray.hasValue(R.styleable.TitleToolbar_closeTextColor)) {
                mCloseTextView.setTextColor(
                        typedArray.getColor(R.styleable.TitleToolbar_closeTextColor, Color.WHITE));
            }

            if (typedArray.hasValue(R.styleable.TitleToolbar_closeTextSize)) {
                mCloseTextView.setTextSize(
                        typedArray.getFloat(R.styleable.TitleToolbar_closeTextSize, 20f));
            }

            setCloseText(typedArray.getText(R.styleable.TitleToolbar_closeText));

            int visible = typedArray.getInt(R.styleable.TitleToolbar_closeVisible, 0);
            mCloseTextView.setVisibility(visible == 1 ? VISIBLE : GONE);

            mCloseTextView.setClickable(true);

            mCloseTextView.setOnClickListener(this);

            addView(mCloseTextView,
                    new LayoutParams(LayoutParams.WRAP_CONTENT,
                            LayoutParams.WRAP_CONTENT, Gravity.LEFT | Gravity.CENTER_VERTICAL));

        }

        if (!isChild(mBackTextView)) {
            mBackTextView = new TextView(context);
            mBackTextView.setSingleLine();
            mBackTextView.setEllipsize(TextUtils.TruncateAt.END);

            typedArray.getResourceId(R.styleable.)

        }

        typedArray.recycle();
        a.recycle();
    }

    @Override
    public void setTitle(int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitleText = !TextUtils.isEmpty(title) ? title : "";
        if (mTitleTextView != null) {
            mTitleTextView.setText(title);
        }
    }

    public void setCloseText(CharSequence closeText) {
        mCloseText = !TextUtils.isEmpty(closeText) ? closeText : "";
        if (mCloseTextView != null) {
            mCloseTextView.setText(closeText);
        }
    }

    @Override
    public CharSequence getTitle() {
        return mTitleText;
    }

    @Override
    public void onClick(View v) {
        if (mOnOptionItemClickListener != null) {
            mOnOptionItemClickListener.onOptionItemClick(v);
        }
    }
}
