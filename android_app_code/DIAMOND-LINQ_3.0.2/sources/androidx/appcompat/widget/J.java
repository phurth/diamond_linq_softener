package androidx.appcompat.widget;

import a.g.h.g;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

final class J {

    /* renamed from: a  reason: collision with root package name */
    private TextView f525a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f526b;

    J(TextView textView) {
        g.a(textView);
        this.f525a = textView;
    }

    public void a(TextClassifier textClassifier) {
        this.f526b = textClassifier;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f526b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f525a.getContext().getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }
}
