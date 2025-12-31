package androidx.swiperefreshlayout.widget;

import a.g.i.y;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

class a extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Animation.AnimationListener f1005a;

    /* renamed from: b  reason: collision with root package name */
    int f1006b;

    /* renamed from: androidx.swiperefreshlayout.widget.a$a  reason: collision with other inner class name */
    private class C0030a extends OvalShape {

        /* renamed from: a  reason: collision with root package name */
        private RadialGradient f1007a;

        /* renamed from: b  reason: collision with root package name */
        private Paint f1008b = new Paint();

        C0030a(int i) {
            a.this.f1006b = i;
            a((int) rect().width());
        }

        private void a(int i) {
            float f = (float) (i / 2);
            this.f1007a = new RadialGradient(f, f, (float) a.this.f1006b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f1008b.setShader(this.f1007a);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = a.this.getWidth() / 2;
            float f = (float) width;
            float height = (float) (a.this.getHeight() / 2);
            canvas.drawCircle(f, height, f, this.f1008b);
            canvas.drawCircle(f, height, (float) (width - a.this.f1006b), paint);
        }

        /* access modifiers changed from: protected */
        public void onResize(float f, float f2) {
            super.onResize(f, f2);
            a((int) f);
        }
    }

    a(Context context, int i) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.f1006b = (int) (3.5f * f);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            y.a((View) this, f * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0030a(this.f1006b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f1006b, (float) i3, (float) i2, 503316480);
            int i4 = this.f1006b;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        y.a((View) this, (Drawable) shapeDrawable);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f1005a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f1005a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f1006b * 2), getMeasuredHeight() + (this.f1006b * 2));
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public void a(Animation.AnimationListener animationListener) {
        this.f1005a = animationListener;
    }
}
