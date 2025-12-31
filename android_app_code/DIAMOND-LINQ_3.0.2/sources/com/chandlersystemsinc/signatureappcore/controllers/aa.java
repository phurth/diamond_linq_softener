package com.chandlersystemsinc.signatureappcore.controllers;

import android.content.BroadcastReceiver;

class aa extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ea f1374a;

    aa(ea eaVar) {
        this.f1374a = eaVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r8, android.content.Intent r9) {
        /*
            r7 = this;
            java.lang.String r8 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_value"
            java.lang.String r8 = r9.getStringExtra(r8)
            java.lang.String r0 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_extra"
            java.lang.String r0 = r9.getStringExtra(r0)
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_id"
            java.lang.String r9 = r9.getStringExtra(r1)
            int r1 = r9.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            switch(r1) {
                case -1105284544: goto L_0x0047;
                case -742385600: goto L_0x003d;
                case -603914299: goto L_0x0033;
                case 1470320416: goto L_0x0029;
                case 2052992153: goto L_0x001f;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0051
        L_0x001f:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.backwash_frequency"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x0051
            r9 = 2
            goto L_0x0052
        L_0x0029:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.water_hardness"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x0051
            r9 = 1
            goto L_0x0052
        L_0x0033:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.regen_time"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x0051
            r9 = 3
            goto L_0x0052
        L_0x003d:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.set_time"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x0051
            r9 = 0
            goto L_0x0052
        L_0x0047:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.share_data"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x0051
            r9 = 4
            goto L_0x0052
        L_0x0051:
            r9 = -1
        L_0x0052:
            if (r9 == 0) goto L_0x0110
            if (r9 == r6) goto L_0x00d6
            if (r9 == r4) goto L_0x00bb
            if (r9 == r3) goto L_0x007b
            if (r9 == r2) goto L_0x005e
            goto L_0x0117
        L_0x005e:
            boolean r8 = b.a.a.ia.a((java.lang.String) r0)
            if (r8 != 0) goto L_0x0117
            com.chandlersystemsinc.signatureappcore.controllers.ea r8 = r7.f1374a
            android.content.Context r8 = r8.V
            boolean r8 = b.a.a.Y.a(r8, r0)
            if (r8 == 0) goto L_0x0117
            com.chandlersystemsinc.signatureappcore.controllers.ea r8 = r7.f1374a     // Catch:{ Exception -> 0x0117 }
            android.content.Context r8 = r8.V     // Catch:{ Exception -> 0x0117 }
            b.a.a.Y.c(r8, r0)     // Catch:{ Exception -> 0x0117 }
            goto L_0x0117
        L_0x007b:
            java.lang.String r9 = " "
            java.lang.String[] r8 = r8.split(r9)
            r9 = r8[r5]
            boolean r9 = b.a.a.ia.a((java.lang.String) r9)
            if (r9 != 0) goto L_0x0117
            com.chandlersystemsinc.signatureappcore.controllers.ea r9 = r7.f1374a     // Catch:{ Exception -> 0x0117 }
            r0 = r8[r5]     // Catch:{ Exception -> 0x0117 }
            java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ Exception -> 0x0117 }
            byte r0 = r0.byteValue()     // Catch:{ Exception -> 0x0117 }
            byte unused = r9.la = r0     // Catch:{ Exception -> 0x0117 }
            com.chandlersystemsinc.signatureappcore.controllers.ea r9 = r7.f1374a     // Catch:{ Exception -> 0x0117 }
            r8 = r8[r6]     // Catch:{ Exception -> 0x0117 }
            com.chandlersystemsinc.signatureappcore.controllers.ea r0 = r7.f1374a     // Catch:{ Exception -> 0x0117 }
            int r1 = b.a.a.Fa.am     // Catch:{ Exception -> 0x0117 }
            java.lang.String r0 = r0.a((int) r1)     // Catch:{ Exception -> 0x0117 }
            boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x0117 }
            if (r8 == 0) goto L_0x00ab
            goto L_0x00ac
        L_0x00ab:
            r5 = 1
        L_0x00ac:
            b.a.a.B r8 = b.a.a.B.a(r5)     // Catch:{ Exception -> 0x0117 }
            b.a.a.B unused = r9.ma = r8     // Catch:{ Exception -> 0x0117 }
            com.chandlersystemsinc.signatureappcore.controllers.ea r8 = r7.f1374a     // Catch:{ Exception -> 0x0117 }
            b.a.a.la r9 = b.a.a.la.Pending     // Catch:{ Exception -> 0x0117 }
            b.a.a.la unused = r8.qa = r9     // Catch:{ Exception -> 0x0117 }
            goto L_0x0117
        L_0x00bb:
            boolean r9 = b.a.a.ia.a((java.lang.String) r8)
            if (r9 != 0) goto L_0x0117
            com.chandlersystemsinc.signatureappcore.controllers.ea r9 = r7.f1374a     // Catch:{ Exception -> 0x0117 }
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch:{ Exception -> 0x0117 }
            byte r8 = r8.byteValue()     // Catch:{ Exception -> 0x0117 }
            byte unused = r9.ka = r8     // Catch:{ Exception -> 0x0117 }
            com.chandlersystemsinc.signatureappcore.controllers.ea r8 = r7.f1374a     // Catch:{ Exception -> 0x0117 }
            b.a.a.la r9 = b.a.a.la.Pending     // Catch:{ Exception -> 0x0117 }
            b.a.a.la unused = r8.pa = r9     // Catch:{ Exception -> 0x0117 }
            goto L_0x0117
        L_0x00d6:
            boolean r9 = b.a.a.ia.a((java.lang.String) r8)
            if (r9 != 0) goto L_0x0117
            com.chandlersystemsinc.signatureappcore.controllers.ea r9 = r7.f1374a     // Catch:{ Exception -> 0x0117 }
            b.a.a.ca r9 = r9.Z     // Catch:{ Exception -> 0x0117 }
            b.a.a.ca r0 = b.a.a.C0176ca.Standard     // Catch:{ Exception -> 0x0117 }
            if (r9 != r0) goto L_0x00f4
            com.chandlersystemsinc.signatureappcore.controllers.ea r9 = r7.f1374a     // Catch:{ Exception -> 0x0117 }
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch:{ Exception -> 0x0117 }
            byte r8 = r8.byteValue()     // Catch:{ Exception -> 0x0117 }
            byte unused = r9.ja = r8     // Catch:{ Exception -> 0x0117 }
            goto L_0x0108
        L_0x00f4:
            b.a.a.ra r9 = b.a.a.ra.MgL     // Catch:{ Exception -> 0x0117 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0117 }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x0117 }
            int r8 = b.a.a.ka.a((b.a.a.ra) r9, (int) r8)     // Catch:{ Exception -> 0x0117 }
            com.chandlersystemsinc.signatureappcore.controllers.ea r9 = r7.f1374a     // Catch:{ Exception -> 0x0117 }
            byte r8 = (byte) r8     // Catch:{ Exception -> 0x0117 }
            byte unused = r9.ja = r8     // Catch:{ Exception -> 0x0117 }
        L_0x0108:
            com.chandlersystemsinc.signatureappcore.controllers.ea r8 = r7.f1374a     // Catch:{ Exception -> 0x0117 }
            b.a.a.la r9 = b.a.a.la.Pending     // Catch:{ Exception -> 0x0117 }
            b.a.a.la unused = r8.oa = r9     // Catch:{ Exception -> 0x0117 }
            goto L_0x0117
        L_0x0110:
            com.chandlersystemsinc.signatureappcore.controllers.ea r8 = r7.f1374a
            b.a.a.la r9 = b.a.a.la.Pending
            b.a.a.la unused = r8.na = r9
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chandlersystemsinc.signatureappcore.controllers.aa.onReceive(android.content.Context, android.content.Intent):void");
    }
}
