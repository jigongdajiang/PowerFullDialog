package gjg.com.powerfulldialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import gjg.com.powerfulldialog.dialog.BaseDialog;
import gjg.com.powerfulldialog.dialog.DialogFactory;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * 使用Builder构建
     */
    public void showOtherLayout(View view) {
        BaseDialog dialog = new BaseDialog
                .Builder(R.layout.dialog_other,//指定Dialog的布局文件
                    this,//上下文对象
                    getSupportFragmentManager())//FragmentManager
                .setDialogAnim(R.style.normal_dialog_animation)//指定展示动画
                .builder();
        dialog.setViewClickCancel(R.id.btn_other)//给id为btn_other的控件添加点后默认消失的点击事件
                .showDialog();
    }

    /**
     * 使用工厂方法创建一个通用的Dialog
     */
    public void showWidthAnim(View view) {
        BaseDialog dialog  = DialogFactory
                .createDefalutMessageDialog(this,
                        getSupportFragmentManager(),
                        "标题",
                        "这Dialog吊炸天了",
                        null,
                        "是的",
                        null,
                        null,R.style.normal_dialog_animation);
        dialog.setViewClickCancel(R.id.btn_dialog_right);
        dialog.showDialog();
    }

    public void showConfirm(View view) {
        DialogFactory
                .createDefalutMessageDialog(this,
                        getSupportFragmentManager(),
                        "标题",
                        "这Dialog更叼",
                        "左按钮",
                        "右按钮",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this,"你点的左边按钮",Toast.LENGTH_LONG).show();
                            }
                        },
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this,"你点的右边按钮",Toast.LENGTH_LONG).show();
                            }
                        },0)
                .showDialog();
    }

    public void showeneral(View view) {
        DialogFactory
                .createDefalutMessageDialog(this, getSupportFragmentManager(), "标题", "这Dialog真叼")
                .showDialog();
    }
}
