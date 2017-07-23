package gjg.com.powerfulldialog.dialog;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;

import gjg.com.powerfulldialog.R;

/**
 * @author : gongdaocai
 * @date : 2017/7/12
 * FileName:
 * @description: 提供创建几种默认Dialog的方法
 *  如果有其它的可用自由构建模式创建
 */


public class DialogFactory{
    /**
     * 项目中统一好的普通提示框(R.layout.dialog_message:标题，内容，左右按钮文字，左右按钮点击事件)
     * 样式在布局中已经指定好
     * 这里只设置内容显示情况
     */
    public static BaseDialog createDefalutMessageDialog(Context context,
                                                        FragmentManager fragmentManager,
                                                        String title,
                                                        String content,
                                                        String leftBtnText,
                                                        String rightBtnText,
                                                        View.OnClickListener leftBtnClickListener,
                                                        View.OnClickListener rightBtnClickListener,int animRes){
        BaseDialog dialog = new BaseDialog.Builder(R.layout.dialog_message,context,fragmentManager)
                .setCanceledOnTouchOutside(true)
                .setTextViewText(R.id.tv_dialog_title,title)
                .setTextViewText(R.id.tv_dialog_message,content)
                .setTextViewText(R.id.btn_dialog_left,leftBtnText)
                .setTextViewText(R.id.btn_dialog_right,rightBtnText)
                .setDialogAnim(animRes)
                .builder()
                .setViewOnClickListener(R.id.btn_dialog_left,leftBtnClickListener)
                .setViewOnClickListener(R.id.btn_dialog_right,rightBtnClickListener);
        return dialog;
    }

    /**
     * 只有内容的提示框 按钮为确定 点击确定消失
     */
    public static BaseDialog createDefalutMessageDialog(Context context,
                                                        FragmentManager fragmentManager,
                                                        String content){
        BaseDialog dialog = createDefalutMessageDialog(context, fragmentManager, null, content, null, "确定", null, null,0);
        dialog.setViewClickCancel(R.id.btn_dialog_right);
        return dialog;
    }
    /**
     * 只有标题 内容 的提示框 按钮为确定 点击确定消失
     */
    public static BaseDialog createDefalutMessageDialog(Context context,
                                                        FragmentManager fragmentManager,
                                                        String title,
                                                        String content){
        BaseDialog dialog = createDefalutMessageDialog(context, fragmentManager, title, content, null, "确定", null, null,0);
        dialog.setViewClickCancel(R.id.btn_dialog_right);
        return dialog;
    }
    /**
     * 只有标题 内容 的提示框 按钮为指定文字 点击消失
     */
    public static BaseDialog createDefalutMessageDialog(Context context,
                                                        FragmentManager fragmentManager,
                                                        String title,
                                                        String content,
                                                        String rightBtnText){
        BaseDialog dialog = createDefalutMessageDialog(context, fragmentManager, title, content, null, rightBtnText, null, null,0);
        dialog.setViewClickCancel(R.id.btn_dialog_right);
        return dialog;
    }
    /**
     * 只有标题 内容 的提示框 按钮为指定文字 点击有指定回调
     */
    public static BaseDialog createDefalutMessageDialog(Context context,
                                                        FragmentManager fragmentManager,
                                                        String title,
                                                        String content,
                                                        String rightBtnText,
                                                        View.OnClickListener rightBtnClickListener){
        return  createDefalutMessageDialog(context, fragmentManager, title, content, null, rightBtnText, null, rightBtnClickListener,0);
    }

    /**
     * 只有标题 内容 的提示框 左按钮文字为取消  右按钮文字为确定  确定有指定回调
     */
    public static BaseDialog createDefalutMessageDialog(Context context,
                                                        FragmentManager fragmentManager,
                                                        String title,
                                                        String content,
                                                        View.OnClickListener rightBtnClickListener){
        BaseDialog dialog = createDefalutMessageDialog(context, fragmentManager, title, content, "取消", "确定", null, rightBtnClickListener,0);
        dialog.setViewClickCancel(R.id.btn_dialog_left);
        return dialog;
    }

}
