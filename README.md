# PowerFullDialog 通用Dialog封装
## 1.功能简介
继承自DialogFragment,
基于Bulder模式构建，
将Dialog的View布局话,对View上的操作如设置文字，设置点击事件等采用了ViewHolder的思想,
最后提供了一个生成常用Dialog的工厂类。
## 2.效果展示
![示例图片1](https://github.com/jigongdajiang/PowerFullDialog/raw/master/app/show/show_01.gif "示例图片1")
![示例图片2](https://github.com/jigongdajiang/PowerFullDialog/raw/master/app/show/show_02.gif "示例图片2")
## 3.实例代码
```Java
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
```
