package gjg.com.powerfulldialog.dialog;

import android.app.Application;

/**
 * @author : gongdaocai
 * @date : 2017/6/16
 * FileName:
 * @description:
 */


public class MyApplication extends Application {
    public static BaseDialog.Builder.Params params;
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
