package org.dmfs.cmad;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmcm.baseapi.ads.INativeAd;

import org.dmfs.tasks.R;

public class OrionNativeBrandingAdview extends FrameLayout {

    final protected Context mContext;
    public INativeAd mNativeAd;
    protected View mNativeAdView;

    public static OrionNativeBrandingAdview createAdView(Context context, INativeAd ad) {
        OrionNativeBrandingAdview view = new OrionNativeBrandingAdview(context);
        view.initAdView(ad);

        return view;
    }

    public OrionNativeBrandingAdview(Context context) {
        super(context);
        mContext = context;
        init(null, 0);
    }

    public OrionNativeBrandingAdview(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs, 0);
    }

    public OrionNativeBrandingAdview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
    }

    public void initAdView(INativeAd ad) {
        mNativeAdView = View.inflate(mContext, R.layout.native_branding_layout, this);

        String iconUrl = ad.getAdIconUrl();
        ImageView iconImageView = (ImageView) mNativeAdView
                .findViewById(R.id.big_iv_icon);
        if (iconUrl != null) {
            VolleyUtil.loadImage(iconImageView, iconUrl);
        }

        TextView titleTextView = (TextView) mNativeAdView.findViewById(R.id.big_main_title);

        titleTextView.setText(ad.getAdTitle());

        if (mNativeAd != null) {
            mNativeAd.unregisterView();
        }
        //保存广告对象
        mNativeAd = ad;
        //将广告View和广告对象绑定起来
        mNativeAd.registerViewForInteraction(mNativeAdView);
    }



}
