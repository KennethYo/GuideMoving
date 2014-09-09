package com.example.kenneth.guidemoving;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class CarAnimView extends View {

	private int mPosition = 0;
	private float mOffset = 0;

	private static final int DRAWABLE_CAR = R.drawable.ic_car;
	private Bitmap mCarBitmap;
	private Paint mPint;
	private int mCarHeight;
	private int mOffsetWidth;
	private int mAdapterCount;

	public CarAnimView(Context context) {
		super(context);
		init();
	}

	public CarAnimView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CarAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		mCarBitmap = BitmapFactory.decodeResource(getResources(), DRAWABLE_CAR);
		mPint = new Paint();
		mCarHeight = mCarBitmap.getHeight();
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		float x = (mPosition+mOffset)*mOffsetWidth;
		canvas.drawBitmap(mCarBitmap, x, getHeight()-mCarHeight, mPint);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		mOffsetWidth = (w)/mAdapterCount;
		super.onSizeChanged(w, h, oldw, oldh);
	}

	// 获取偏移量并重绘
	public void onPageScrolled(int adapterCount,int position, float offset) {
		mAdapterCount = adapterCount;
		mPosition = position;
		mOffset = offset;
		invalidate();
	}

}
