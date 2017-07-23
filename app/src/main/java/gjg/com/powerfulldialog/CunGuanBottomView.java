package gjg.com.powerfulldialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Arrays;

/**
 * @author : gongdaocai
 * @date : 2017/6/15
 * FileName:
 * @description: 一个展示固定底部内容的自定义View
 */


public class CunGuanBottomView extends View {
    private Paint mPaint;
    private Paint mPaintText;
    private int mWidth;
    private int mHeight;
    private int mBorderColor = Color.RED;
    private Bitmap mImage;
    private int mStrokeWith = 5;
    private String mText ="";
    private int mTextSize = 48;
    private int offsetText2Image = 10;
    private int offsetText2Border = 15;
    private int offsetImage2Border = 12;
    public CunGuanBottomView(Context context) {
        this(context,null);
    }

    public CunGuanBottomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CunGuanBottomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.CunGuanBottomView);
        mBorderColor = ta.getColor(R.styleable.CunGuanBottomView_border_color,Color.RED);
        mImage = BitmapFactory.decodeResource(getResources(),
                ta.getResourceId(R.styleable.CunGuanBottomView_left_icon, R.mipmap.ic_launcher));
        mText = ta.getString(R.styleable.CunGuanBottomView_text);

        mTextSize = ta.getDimensionPixelSize(R.styleable.CunGuanBottomView_text_size,48);
        offsetText2Border = ta.getDimensionPixelOffset(R.styleable.CunGuanBottomView_text_border_offset,10);
        offsetText2Image = ta.getDimensionPixelOffset(R.styleable.CunGuanBottomView_text_image_offset,10);
        offsetImage2Border = ta.getDimensionPixelOffset(R.styleable.CunGuanBottomView_image_border_offset,10);
        if(TextUtils.isEmpty(mText)){
            mText = "集美金服";
        }
        ta.recycle();
        init();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        // 测量文字的宽高
        Rect textBounds = new Rect();
        mPaintText.getTextBounds(mText, 0, mText.length(), textBounds);
        int tW = textBounds.width();
        int tH = textBounds.height();
        mHeight = tH + mStrokeWith*2 + offsetText2Border*2;

        int imgH = mImage.getHeight();

        float desWH = mHeight - offsetImage2Border*2 - mStrokeWith*2;
        int imgW = mImage.getWidth();
        int imgDesW = (int) (imgW * (desWH/imgH));

        mWidth = mHeight/2 + imgDesW + offsetText2Image + tW + mHeight/2 + mStrokeWith*2 + offsetText2Image;
        setMeasuredDimension(mWidth + mStrokeWith*2,mHeight + mStrokeWith*2);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mBorderColor);
        mPaint.setStrokeWidth(mStrokeWith);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);

        mPaintText = new Paint();
        mPaintText.setColor(mBorderColor);
        mPaintText.setTextSize(mTextSize);
        mPaintText.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mStrokeWith,mStrokeWith);
        RectF rectFRoundRect = new RectF(0,0,mWidth,mHeight);
        canvas.drawRoundRect(rectFRoundRect,mHeight/2,mHeight/2,mPaint);

        int imgH = mImage.getHeight();
        float desWH = mHeight - offsetImage2Border*2 - mStrokeWith*2;
        Matrix matrix = new Matrix();
        matrix.setScale(desWH/imgH,desWH/imgH);
        matrix.postTranslate(mHeight/2,mHeight/2 - desWH/2);
        canvas.drawBitmap(mImage,matrix,mPaint);

        float[] values = new float[9];
        matrix.getValues(values);
        float imgOff = values[2];

        // 测量文字的宽高
        Rect textBounds = new Rect();
        mPaintText.getTextBounds(mText, 0, mText.length(), textBounds);
        float dx = imgOff + desWH + offsetText2Image;
        // 获取画笔的FontMetrics
        Paint.FontMetrics fontMetrics = mPaintText.getFontMetrics();
        // 计算文字的基线
        int baseLine = (int) ( mHeight/2 + (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom);
        // 绘制步数文字
        canvas.drawText(mText, dx, baseLine, mPaintText);
    }
}
