//package com.sqzn.tea.Utils;
//
//import android.content.Context;
//import android.widget.ImageView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.RequestListener;
//
//public class GlideUtils {
//
//    /**
//     * 默认加载图片
//     *
//     * @parammContext
//     * @parampath
//     * @paramimageView
//     */
//
//    public static void loadImageView(Context mContext, String path, ImageView imageView) {
//
//        Glide.with(mContext).load(path).into(imageView);
//
//    }
//
//    /**
//     * 带默认图片的加载方式
//     *
//     * @parammContext
//     * @parampath
//     * @parammImageView
//     * @paramlodingImage
//     * @paramerrorImageView
//     */
//
//    public static void loadImageView(Context mContext, String path, ImageView mImageView, int lodingImage, int errorImageView) {
//
//        Glide.with(mContext).load(path).placeholder(lodingImage).error(errorImageView).into(mImageView);
//
//    }
//
//    /**
//     * 加载指定大小的图片
//     *
//     * @parammContext
//     * @parampath
//     * @paramwidth
//     * @paramheight
//     * @parammImageView
//     */
//
//    public static void loadImageView(Context mContext, String path, int width, int height, ImageView mImageView) {
//
//        Glide.with(mContext).load(path).override(width, height).into(mImageView);
//
//    }
//
//    /**
//     * 加载gif图
//     *
//     * @parammContext
//     * @parampath
//     * @parammImageView
//     */
//
//    public static void loadImageViewGif(Context mContext, String path, ImageView mImageView) {
//
//        Glide.with(mContext).load(path).asGif().into(mImageView);
//
//    }
//
//    /**
//     * 加载crop模式
//     *
//     * @parammContext
//     * @parampath
//     * @parammImageView
//     */
//
//    public static void loadImageViewCrop(Context mContext, String path, ImageView mImageView) {
//
//        Glide.with(mContext).load(path).centerCrop().into(mImageView);
//
//    }
//
//    /**
//     * 图片加载带监听接口 方便监听异常来源
//     *
//     * @parammContext
//     * @parampath
//     * @parammImageView
//     * @paramrequstlistener
//     */
//
//    public static void loadImageView(Context mContext, String path, ImageView mImageView, RequestListener requstlistener) {
//
//        Glide.with(mContext).load(path).listener(requstlistener).into(mImageView);
//
//    }
//
//    /**
//     * 清理图片内存缓存
//     *
//     * @parammContext
//     */
//
//    public static void GuideClearMemory(Context mContext) {
//
////清理内存缓存  可以在UI主线程中进行
//
//        Glide.get(mContext).clearMemory();
//
//    }
//
//    /**
//     * 模糊图片
//     *
//     * @parammContext
//     * @parampath
//     * @parammImageView
//     */
//
//    public static void fuzzyLoadImageView(Context mContext, String path, ImageView mImageView) {
//
//        Glide.with(mContext)
//
//                .load(path)
//
////                .bitmapTransform(new BlurTransformation(mContext, 25, 4))// “23”：设置模糊度(在0.0到25.0之间)，默认”25";"4":图片缩放比例,默认“1”。
//
//                .into(mImageView);
//
//    }
//
//}
//
