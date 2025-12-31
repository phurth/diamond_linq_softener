package com.chandlersystemsinc.signatureappcore.controllers;

import android.content.BroadcastReceiver;

class W extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Z f1370a;

    W(Z z) {
        this.f1370a = z;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009a, code lost:
        if (r7.equals("com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.air_recharge_frequency") != false) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fd, code lost:
        if (r7.equals("com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.regen_day_override") != false) goto L_0x0101;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ba A[Catch:{ Exception -> 0x018b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r7, android.content.Intent r8) {
        /*
            r6 = this;
            java.lang.String r7 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_id"
            java.lang.String r7 = r8.getStringExtra(r7)
            java.lang.String r0 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_value"
            java.lang.String r8 = r8.getStringExtra(r0)
            r0 = 0
            r1 = 2
            com.chandlersystemsinc.signatureappcore.controllers.Z r2 = r6.f1370a     // Catch:{ Exception -> 0x0071 }
            b.a.a.wa r2 = r2.la     // Catch:{ Exception -> 0x0071 }
            b.a.a.wa r3 = b.a.a.wa.UltraFilter     // Catch:{ Exception -> 0x0071 }
            if (r2 != r3) goto L_0x003f
            java.lang.String[] r2 = com.chandlersystemsinc.signatureappcore.controllers.Z.V     // Catch:{ Exception -> 0x0071 }
            r2 = r2[r1]     // Catch:{ Exception -> 0x0071 }
            boolean r2 = r7.equals(r2)     // Catch:{ Exception -> 0x0071 }
            if (r2 == 0) goto L_0x0071
            com.chandlersystemsinc.signatureappcore.controllers.Z r2 = r6.f1370a     // Catch:{ Exception -> 0x0071 }
            byte[] r2 = r2.Ea     // Catch:{ Exception -> 0x0071 }
            java.lang.Byte r3 = java.lang.Byte.valueOf(r8)     // Catch:{ Exception -> 0x0071 }
            byte r3 = r3.byteValue()     // Catch:{ Exception -> 0x0071 }
            r2[r1] = r3     // Catch:{ Exception -> 0x0071 }
            com.chandlersystemsinc.signatureappcore.controllers.Z r2 = r6.f1370a     // Catch:{ Exception -> 0x0071 }
            b.a.a.la[] r2 = r2.Ga     // Catch:{ Exception -> 0x0071 }
            b.a.a.la r3 = b.a.a.la.Pending     // Catch:{ Exception -> 0x0071 }
            r2[r1] = r3     // Catch:{ Exception -> 0x0071 }
            goto L_0x0071
        L_0x003f:
            r2 = 0
        L_0x0040:
            com.chandlersystemsinc.signatureappcore.controllers.Z r3 = r6.f1370a     // Catch:{ Exception -> 0x0071 }
            int r3 = r3.Ba     // Catch:{ Exception -> 0x0071 }
            if (r2 >= r3) goto L_0x0071
            java.lang.String[] r3 = com.chandlersystemsinc.signatureappcore.controllers.Z.V     // Catch:{ Exception -> 0x0071 }
            r3 = r3[r2]     // Catch:{ Exception -> 0x0071 }
            boolean r3 = r7.equals(r3)     // Catch:{ Exception -> 0x0071 }
            if (r3 == 0) goto L_0x006e
            com.chandlersystemsinc.signatureappcore.controllers.Z r3 = r6.f1370a     // Catch:{ Exception -> 0x0071 }
            byte[] r3 = r3.Ea     // Catch:{ Exception -> 0x0071 }
            java.lang.Byte r4 = java.lang.Byte.valueOf(r8)     // Catch:{ Exception -> 0x0071 }
            byte r4 = r4.byteValue()     // Catch:{ Exception -> 0x0071 }
            r3[r2] = r4     // Catch:{ Exception -> 0x0071 }
            com.chandlersystemsinc.signatureappcore.controllers.Z r3 = r6.f1370a     // Catch:{ Exception -> 0x0071 }
            b.a.a.la[] r3 = r3.Ga     // Catch:{ Exception -> 0x0071 }
            b.a.a.la r4 = b.a.a.la.Pending     // Catch:{ Exception -> 0x0071 }
            r3[r2] = r4     // Catch:{ Exception -> 0x0071 }
        L_0x006e:
            int r2 = r2 + 1
            goto L_0x0040
        L_0x0071:
            com.chandlersystemsinc.signatureappcore.controllers.Z r2 = r6.f1370a
            boolean r2 = r2.ka()
            r3 = -1
            r4 = 1
            if (r2 == 0) goto L_0x00d0
            int r1 = r7.hashCode()
            r2 = -916905445(0xffffffffc959221b, float:-889377.7)
            if (r1 == r2) goto L_0x0094
            r0 = -90979842(0xfffffffffa93c1fe, float:-3.8360113E35)
            if (r1 == r0) goto L_0x008a
            goto L_0x009d
        L_0x008a:
            java.lang.String r0 = "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.pulse_chlorine"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x009d
            r0 = 1
            goto L_0x009e
        L_0x0094:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.air_recharge_frequency"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x009d
            goto L_0x009e
        L_0x009d:
            r0 = -1
        L_0x009e:
            if (r0 == 0) goto L_0x00ba
            if (r0 == r4) goto L_0x00a4
            goto L_0x018b
        L_0x00a4:
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch:{ Exception -> 0x018b }
            byte r8 = r8.byteValue()     // Catch:{ Exception -> 0x018b }
            byte unused = r7.Aa = r8     // Catch:{ Exception -> 0x018b }
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            b.a.a.la r8 = b.a.a.la.Pending     // Catch:{ Exception -> 0x018b }
            b.a.a.la unused = r7.Na = r8     // Catch:{ Exception -> 0x018b }
            goto L_0x018b
        L_0x00ba:
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch:{ Exception -> 0x018b }
            byte r8 = r8.byteValue()     // Catch:{ Exception -> 0x018b }
            byte unused = r7.za = r8     // Catch:{ Exception -> 0x018b }
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            b.a.a.la r8 = b.a.a.la.Pending     // Catch:{ Exception -> 0x018b }
            b.a.a.la unused = r7.Ma = r8     // Catch:{ Exception -> 0x018b }
            goto L_0x018b
        L_0x00d0:
            int r2 = r7.hashCode()
            r5 = 3
            switch(r2) {
                case -960335341: goto L_0x00f7;
                case -749090401: goto L_0x00ed;
                case 419606469: goto L_0x00e3;
                case 936252860: goto L_0x00d9;
                default: goto L_0x00d8;
            }
        L_0x00d8:
            goto L_0x0100
        L_0x00d9:
            java.lang.String r0 = "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.brine_soak_duration"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0100
            r0 = 3
            goto L_0x0101
        L_0x00e3:
            java.lang.String r0 = "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.resin_grains_capacity"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0100
            r0 = 2
            goto L_0x0101
        L_0x00ed:
            java.lang.String r0 = "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.reserve_capacity"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0100
            r0 = 1
            goto L_0x0101
        L_0x00f7:
            java.lang.String r2 = "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.regen_day_override"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0100
            goto L_0x0101
        L_0x0100:
            r0 = -1
        L_0x0101:
            if (r0 == 0) goto L_0x0177
            if (r0 == r4) goto L_0x0162
            if (r0 == r1) goto L_0x0120
            if (r0 == r5) goto L_0x010b
            goto L_0x018b
        L_0x010b:
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch:{ Exception -> 0x018b }
            byte r8 = r8.byteValue()     // Catch:{ Exception -> 0x018b }
            byte unused = r7.ya = r8     // Catch:{ Exception -> 0x018b }
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            b.a.a.la r8 = b.a.a.la.Pending     // Catch:{ Exception -> 0x018b }
            b.a.a.la unused = r7.La = r8     // Catch:{ Exception -> 0x018b }
            goto L_0x018b
        L_0x0120:
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            b.a.a.ca r7 = r7.ba     // Catch:{ Exception -> 0x018b }
            b.a.a.ca r0 = b.a.a.C0176ca.Standard     // Catch:{ Exception -> 0x018b }
            if (r7 != r0) goto L_0x0138
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x018b }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x018b }
            int unused = r7.va = r8     // Catch:{ Exception -> 0x018b }
            goto L_0x015a
        L_0x0138:
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            b.a.a.ra r0 = b.a.a.ra.Grams     // Catch:{ Exception -> 0x018b }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x018b }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x018b }
            int r8 = b.a.a.ka.a((b.a.a.ra) r0, (int) r8)     // Catch:{ Exception -> 0x018b }
            double r0 = (double) r8
            r2 = 4652007308841189376(0x408f400000000000, double:1000.0)
            java.lang.Double.isNaN(r0)
            double r0 = r0 / r2
            double r0 = java.lang.Math.ceil(r0)     // Catch:{ Exception -> 0x018b }
            int r8 = (int) r0     // Catch:{ Exception -> 0x018b }
            int unused = r7.va = r8     // Catch:{ Exception -> 0x018b }
        L_0x015a:
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            b.a.a.la r8 = b.a.a.la.Pending     // Catch:{ Exception -> 0x018b }
            b.a.a.la unused = r7.Ja = r8     // Catch:{ Exception -> 0x018b }
            goto L_0x018b
        L_0x0162:
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch:{ Exception -> 0x018b }
            byte r8 = r8.byteValue()     // Catch:{ Exception -> 0x018b }
            byte unused = r7.ua = r8     // Catch:{ Exception -> 0x018b }
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            b.a.a.la r8 = b.a.a.la.Pending     // Catch:{ Exception -> 0x018b }
            b.a.a.la unused = r7.Ia = r8     // Catch:{ Exception -> 0x018b }
            goto L_0x018b
        L_0x0177:
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch:{ Exception -> 0x018b }
            byte r8 = r8.byteValue()     // Catch:{ Exception -> 0x018b }
            byte unused = r7.ta = r8     // Catch:{ Exception -> 0x018b }
            com.chandlersystemsinc.signatureappcore.controllers.Z r7 = r6.f1370a     // Catch:{ Exception -> 0x018b }
            b.a.a.la r8 = b.a.a.la.Pending     // Catch:{ Exception -> 0x018b }
            b.a.a.la unused = r7.Ha = r8     // Catch:{ Exception -> 0x018b }
        L_0x018b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chandlersystemsinc.signatureappcore.controllers.W.onReceive(android.content.Context, android.content.Intent):void");
    }
}
