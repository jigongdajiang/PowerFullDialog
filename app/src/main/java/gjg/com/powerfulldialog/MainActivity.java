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

    public void showOtherLayout(View view) {
        BaseDialog dialog = new BaseDialog.Builder(R.layout.dialog_other,this,getSupportFragmentManager())
                .setDialogAnim(R.style.normal_dialog_animation)
                .builder();
        dialog.setViewClickCancel(R.id.btn_other).showDialog();
    }

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
