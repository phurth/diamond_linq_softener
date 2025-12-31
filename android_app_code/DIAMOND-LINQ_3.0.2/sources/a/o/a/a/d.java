package a.o.a.a;

import a.g.a.a.i;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class d extends i implements b {

    /* renamed from: b  reason: collision with root package name */
    private a f339b;
    private Context c;
    private ArgbEvaluator d;
    private Animator.AnimatorListener e;
    ArrayList<Object> f;
    final Drawable.Callback g;

    private static class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f340a;

        /* renamed from: b  reason: collision with root package name */
        k f341b;
        AnimatorSet c;
        ArrayList<Animator> d;
        a.d.b<Animator, String> e;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f340a = aVar.f340a;
                k kVar = aVar.f341b;
                if (kVar != null) {
                    Drawable.ConstantState constantState = kVar.getConstantState();
                    if (resources != null) {
                        this.f341b = (k) constantState.newDrawable(resources);
                    } else {
                        this.f341b = (k) constantState.newDrawable();
                    }
                    k kVar2 = this.f341b;
                    kVar2.mutate();
                    this.f341b = kVar2;
                    this.f341b.setCallback(callback);
                    this.f341b.setBounds(aVar.f341b.getBounds());
                    this.f341b.a(false);
                }
                ArrayList<Animator> arrayList = aVar.d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.d = new ArrayList<>(size);
                    this.e = new a.d.b<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.d.get(i);
                        Animator clone = animator.clone();
                        String str = aVar.e.get(animator);
                        clone.setTarget(this.f341b.a(str));
                        this.d.add(clone);
                        this.e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.d);
        }

        public int getChangingConfigurations() {
            return this.f340a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    d() {
        this((Context) null, (a) null, (Resources) null);
    }

    public static d a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        d dVar = new d(context);
        dVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return dVar;
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.a(drawable);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f339b.f341b.draw(canvas);
        if (this.f339b.c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.c(drawable);
        }
        return this.f339b.f341b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f339b.f340a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.d(drawable);
        }
        return this.f339b.f341b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f347a;
        if (drawable == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(drawable.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f339b.f341b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f339b.f341b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f339b.f341b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a2 = i.a(resources, theme, attributeSet, a.e);
                    int resourceId = a2.getResourceId(0, 0);
                    if (resourceId != 0) {
                        k a3 = k.a(resources, resourceId, theme);
                        a3.a(false);
                        a3.setCallback(this.g);
                        k kVar = this.f339b.f341b;
                        if (kVar != null) {
                            kVar.setCallback((Drawable.Callback) null);
                        }
                        this.f339b.f341b = a3;
                    }
                    a2.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.c;
                        if (context != null) {
                            a(string, f.a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f339b.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.f(drawable);
        }
        return this.f339b.f341b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f339b.c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f339b.f341b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f339b.f341b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f339b.f341b.setLevel(i);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f339b.f341b.setState(iArr);
    }

    public void setAlpha(int i) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f339b.f341b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, z);
        } else {
            this.f339b.f341b.setAutoMirrored(z);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b(drawable, i);
        } else {
            this.f339b.f341b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        } else {
            this.f339b.f341b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
        } else {
            this.f339b.f341b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f339b.f341b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f339b.c.isStarted()) {
            this.f339b.c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f339b.c.end();
        }
    }

    private d(Context context) {
        this(context, (a) null, (Resources) null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f347a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f339b.f341b.setColorFilter(colorFilter);
        }
    }

    private static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f342a;

        public b(Drawable.ConstantState constantState) {
            this.f342a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f342a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f342a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            d dVar = new d();
            dVar.f347a = this.f342a.newDrawable();
            dVar.f347a.setCallback(dVar.g);
            return dVar;
        }

        public Drawable newDrawable(Resources resources) {
            d dVar = new d();
            dVar.f347a = this.f342a.newDrawable(resources);
            dVar.f347a.setCallback(dVar.g);
            return dVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            d dVar = new d();
            dVar.f347a = this.f342a.newDrawable(resources, theme);
            dVar.f347a.setCallback(dVar.g);
            return dVar;
        }
    }

    private d(Context context, a aVar, Resources resources) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new c(this);
        this.c = context;
        if (aVar != null) {
            this.f339b = aVar;
        } else {
            this.f339b = new a(context, aVar, this.g, resources);
        }
    }

    private void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.d == null) {
                    this.d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.d);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.f339b.f341b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        a aVar = this.f339b;
        if (aVar.d == null) {
            aVar.d = new ArrayList<>();
            this.f339b.e = new a.d.b<>();
        }
        this.f339b.d.add(animator);
        this.f339b.e.put(animator, str);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }
}
