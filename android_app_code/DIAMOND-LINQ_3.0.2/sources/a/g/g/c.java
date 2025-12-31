package a.g.g;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;

public class c implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f177a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Executor f178b = null;
    private final Spannable c;
    private final a d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f179a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f180b;
        private final int c;
        private final int d;
        final PrecomputedText.Params e = null;

        /* renamed from: a.g.g.c$a$a  reason: collision with other inner class name */
        public static class C0006a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f181a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f182b;
            private int c;
            private int d;

            public C0006a(TextPaint textPaint) {
                this.f181a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f182b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f182b = null;
                }
            }

            public C0006a a(int i) {
                this.c = i;
                return this;
            }

            public C0006a b(int i) {
                this.d = i;
                return this;
            }

            public C0006a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f182b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.f181a, this.f182b, this.c, this.d);
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            this.f179a = textPaint;
            this.f180b = textDirectionHeuristic;
            this.c = i;
            this.d = i2;
        }

        public int a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }

        public TextDirectionHeuristic c() {
            return this.f180b;
        }

        public TextPaint d() {
            return this.f179a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f180b == aVar.c();
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return a.g.h.c.a(Float.valueOf(this.f179a.getTextSize()), Float.valueOf(this.f179a.getTextScaleX()), Float.valueOf(this.f179a.getTextSkewX()), Float.valueOf(this.f179a.getLetterSpacing()), Integer.valueOf(this.f179a.getFlags()), this.f179a.getTextLocales(), this.f179a.getTypeface(), Boolean.valueOf(this.f179a.isElegantTextHeight()), this.f180b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            } else if (i >= 21) {
                return a.g.h.c.a(Float.valueOf(this.f179a.getTextSize()), Float.valueOf(this.f179a.getTextScaleX()), Float.valueOf(this.f179a.getTextSkewX()), Float.valueOf(this.f179a.getLetterSpacing()), Integer.valueOf(this.f179a.getFlags()), this.f179a.getTextLocale(), this.f179a.getTypeface(), Boolean.valueOf(this.f179a.isElegantTextHeight()), this.f180b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            } else if (i >= 18) {
                return a.g.h.c.a(Float.valueOf(this.f179a.getTextSize()), Float.valueOf(this.f179a.getTextScaleX()), Float.valueOf(this.f179a.getTextSkewX()), Integer.valueOf(this.f179a.getFlags()), this.f179a.getTextLocale(), this.f179a.getTypeface(), this.f180b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            } else if (i >= 17) {
                return a.g.h.c.a(Float.valueOf(this.f179a.getTextSize()), Float.valueOf(this.f179a.getTextScaleX()), Float.valueOf(this.f179a.getTextSkewX()), Integer.valueOf(this.f179a.getFlags()), this.f179a.getTextLocale(), this.f179a.getTypeface(), this.f180b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            } else {
                return a.g.h.c.a(Float.valueOf(this.f179a.getTextSize()), Float.valueOf(this.f179a.getTextScaleX()), Float.valueOf(this.f179a.getTextSkewX()), Integer.valueOf(this.f179a.getFlags()), this.f179a.getTypeface(), this.f180b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f179a.getTextSize());
            sb.append(", textScaleX=" + this.f179a.getTextScaleX());
            sb.append(", textSkewX=" + this.f179a.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f179a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f179a.isElegantTextHeight());
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                sb.append(", textLocale=" + this.f179a.getTextLocales());
            } else if (i >= 17) {
                sb.append(", textLocale=" + this.f179a.getTextLocale());
            }
            sb.append(", typeface=" + this.f179a.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f179a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f180b);
            sb.append(", breakStrategy=" + this.c);
            sb.append(", hyphenationFrequency=" + this.d);
            sb.append("}");
            return sb.toString();
        }

        public boolean a(a aVar) {
            PrecomputedText.Params params = this.e;
            if (params != null) {
                return params.equals(aVar.e);
            }
            if ((Build.VERSION.SDK_INT >= 23 && (this.c != aVar.a() || this.d != aVar.b())) || this.f179a.getTextSize() != aVar.d().getTextSize() || this.f179a.getTextScaleX() != aVar.d().getTextScaleX() || this.f179a.getTextSkewX() != aVar.d().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f179a.getLetterSpacing() != aVar.d().getLetterSpacing() || !TextUtils.equals(this.f179a.getFontFeatureSettings(), aVar.d().getFontFeatureSettings()))) || this.f179a.getFlags() != aVar.d().getFlags()) {
                return false;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                if (!this.f179a.getTextLocales().equals(aVar.d().getTextLocales())) {
                    return false;
                }
            } else if (i >= 17 && !this.f179a.getTextLocale().equals(aVar.d().getTextLocale())) {
                return false;
            }
            if (this.f179a.getTypeface() == null) {
                if (aVar.d().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f179a.getTypeface().equals(aVar.d().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public a(PrecomputedText.Params params) {
            this.f179a = params.getTextPaint();
            this.f180b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
        }
    }

    public a a() {
        return this.d;
    }

    public char charAt(int i) {
        return this.c.charAt(i);
    }

    public int getSpanEnd(Object obj) {
        return this.c.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.c.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.c.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return this.c.getSpans(i, i2, cls);
    }

    public int length() {
        return this.c.length();
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.c.nextSpanTransition(i, i2, cls);
    }

    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.c.removeSpan(obj);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.c.setSpan(obj, i, i2, i3);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    public CharSequence subSequence(int i, int i2) {
        return this.c.subSequence(i, i2);
    }

    public String toString() {
        return this.c.toString();
    }
}
