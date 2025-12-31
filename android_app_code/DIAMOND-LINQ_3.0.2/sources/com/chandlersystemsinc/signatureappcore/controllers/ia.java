package com.chandlersystemsinc.signatureappcore.controllers;

import android.content.BroadcastReceiver;

class ia extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ la f1389a;

    ia(la laVar) {
        this.f1389a = laVar;
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
            r2 = 1
            r3 = 0
            switch(r1) {
                case -2067033233: goto L_0x00d9;
                case -2048977443: goto L_0x00ce;
                case -2001441710: goto L_0x00c4;
                case -1987197378: goto L_0x00ba;
                case -1804534657: goto L_0x00b0;
                case -1778875398: goto L_0x00a5;
                case -1702486078: goto L_0x009a;
                case -1627427417: goto L_0x008f;
                case -1576076898: goto L_0x0085;
                case -1177505804: goto L_0x007b;
                case -992141240: goto L_0x006f;
                case -101161713: goto L_0x0063;
                case 151249053: goto L_0x0058;
                case 521390915: goto L_0x004c;
                case 1150805927: goto L_0x0040;
                case 1306984865: goto L_0x0035;
                case 1958745953: goto L_0x0029;
                case 1981730990: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x00e3
        L_0x001d:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_confirm_download"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 15
            goto L_0x00e4
        L_0x0029:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_new_password"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 16
            goto L_0x00e4
        L_0x0035:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.enter_password_timeout"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 3
            goto L_0x00e4
        L_0x0040:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_confirm_upload"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 10
            goto L_0x00e4
        L_0x004c:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_upload_new_version_confirm"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 13
            goto L_0x00e4
        L_0x0058:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.enter_new_pair_password"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 1
            goto L_0x00e4
        L_0x0063:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_download"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 14
            goto L_0x00e4
        L_0x006f:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_upload"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 9
            goto L_0x00e4
        L_0x007b:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.enter_password_timeout_classic"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 4
            goto L_0x00e4
        L_0x0085:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.label_device"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 6
            goto L_0x00e4
        L_0x008f:
            java.lang.String r1 = "com.chandlersystemsinc.signatureappcore.controllers.pair_request"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 17
            goto L_0x00e4
        L_0x009a:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_upload_new_version"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 12
            goto L_0x00e4
        L_0x00a5:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_timeout"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 8
            goto L_0x00e4
        L_0x00b0:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.enter_password"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 0
            goto L_0x00e4
        L_0x00ba:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.enter_new_password"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 5
            goto L_0x00e4
        L_0x00c4:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.reset"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 7
            goto L_0x00e4
        L_0x00ce:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_upload_crossover"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 11
            goto L_0x00e4
        L_0x00d9:
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.check_firmware"
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x00e3
            r9 = 2
            goto L_0x00e4
        L_0x00e3:
            r9 = -1
        L_0x00e4:
            r1 = 9999(0x270f, float:1.4012E-41)
            switch(r9) {
                case 0: goto L_0x02e1;
                case 1: goto L_0x02ae;
                case 2: goto L_0x02a8;
                case 3: goto L_0x02a2;
                case 4: goto L_0x029c;
                case 5: goto L_0x0254;
                case 6: goto L_0x01e8;
                case 7: goto L_0x01e1;
                case 8: goto L_0x01e1;
                case 9: goto L_0x01d5;
                case 10: goto L_0x01c9;
                case 11: goto L_0x01ad;
                case 12: goto L_0x0150;
                case 13: goto L_0x013f;
                case 14: goto L_0x011e;
                case 15: goto L_0x0112;
                case 16: goto L_0x00fc;
                case 17: goto L_0x00eb;
                default: goto L_0x00e9;
            }
        L_0x00e9:
            goto L_0x0305
        L_0x00eb:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.Ca = r3
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.qb = r3
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.Aa()
            goto L_0x0305
        L_0x00fc:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.ub = r3
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.Fa = r3
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.Ga = r2
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.Ba = r2
            goto L_0x0305
        L_0x0112:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.ta()
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.Ha = r3
            goto L_0x0305
        L_0x011e:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            int r8 = r8.wa
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a
            int r9 = r9.va
            if (r8 <= r9) goto L_0x0138
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.ta()
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.Ha = r3
            goto L_0x0305
        L_0x0138:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.ra()
            goto L_0x0305
        L_0x013f:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.Ia = r3
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.La = r2
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.Ia()
            goto L_0x0305
        L_0x0150:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            int r8 = r8.wa
            r9 = 206(0xce, float:2.89E-43)
            if (r8 > r9) goto L_0x019c
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            b.a.a.ca r8 = r8.ha
            b.a.a.ca r9 = b.a.a.C0176ca.Standard
            if (r8 != r9) goto L_0x016d
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            int r9 = b.a.a.Fa.fw_data_loss_warning_message
            java.lang.String r8 = r8.a((int) r9)
            goto L_0x0175
        L_0x016d:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            int r9 = b.a.a.Fa.fw_data_loss_warning_metric_message
            java.lang.String r8 = r8.a((int) r9)
        L_0x0175:
            r3 = r8
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            androidx.fragment.app.o r0 = r8.fa
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            int r9 = b.a.a.Fa.fw_data_loss_warning_title
            java.lang.String r2 = r8.a((int) r9)
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            int r9 = b.a.a.Fa.fw_continue_upload
            java.lang.String r4 = r8.a((int) r9)
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            int r9 = b.a.a.Fa.fw_cancel_upload
            java.lang.String r5 = r8.a((int) r9)
            r6 = 0
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_confirm_upload"
            b.a.a.W.a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0305
        L_0x019c:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.Ia = r3
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.La = r2
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.Ia()
            goto L_0x0305
        L_0x01ad:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            int r8 = r8.wa
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a
            int r9 = r9.va
            if (r8 >= r9) goto L_0x01c2
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.Ia()
            goto L_0x0305
        L_0x01c2:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.Fa()
            goto L_0x0305
        L_0x01c9:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.Ia()
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.Ha = r3
            goto L_0x0305
        L_0x01d5:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.Ia()
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.Ha = r3
            goto L_0x0305
        L_0x01e1:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.Aa()
            goto L_0x0305
        L_0x01e8:
            boolean r9 = b.a.a.ia.a((java.lang.String) r8)
            if (r9 == 0) goto L_0x0222
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            java.util.HashMap r8 = r8.ta
            r8.remove(r0)
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            com.chandlersystemsinc.signatureappcore.controllers.la$a r8 = r8.pa
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a
            int r9 = r9.ra
            java.lang.String r1 = ""
            r8.a((int) r9, (java.lang.String) r1)
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            com.chandlersystemsinc.signatureappcore.controllers.la$a r8 = r8.pa
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a
            int r9 = r9.ra
            r8.c((int) r9)
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            android.content.Context r8 = r8.ea
            b.a.a.ma.b((android.content.Context) r8, (java.lang.String) r0)
            goto L_0x0305
        L_0x0222:
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a
            java.util.HashMap r9 = r9.ta
            r9.put(r0, r8)
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a
            com.chandlersystemsinc.signatureappcore.controllers.la$a r9 = r9.pa
            com.chandlersystemsinc.signatureappcore.controllers.la r1 = r7.f1389a
            int r1 = r1.ra
            r9.a((int) r1, (java.lang.String) r8)
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a
            com.chandlersystemsinc.signatureappcore.controllers.la$a r9 = r9.pa
            com.chandlersystemsinc.signatureappcore.controllers.la r1 = r7.f1389a
            int r1 = r1.ra
            r9.c((int) r1)
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a
            android.content.Context r9 = r9.ea
            b.a.a.ma.a(r9, r0, r8)
            goto L_0x0305
        L_0x0254:
            boolean r9 = b.a.a.ia.a((java.lang.String) r8)
            if (r9 != 0) goto L_0x0305
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0305 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0305 }
            int unused = r9.pb = r0     // Catch:{ Exception -> 0x0305 }
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            boolean unused = r9.rb = r3     // Catch:{ Exception -> 0x0305 }
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            b.a.a.la r0 = b.a.a.la.Pending     // Catch:{ Exception -> 0x0305 }
            b.a.a.la unused = r9.wb = r0     // Catch:{ Exception -> 0x0305 }
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            b.a.a.oa r9 = r9.oa     // Catch:{ Exception -> 0x0305 }
            if (r9 == 0) goto L_0x028e
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            android.content.Context r9 = r9.ea     // Catch:{ Exception -> 0x0305 }
            com.chandlersystemsinc.signatureappcore.controllers.la r0 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            b.a.a.oa r0 = r0.oa     // Catch:{ Exception -> 0x0305 }
            java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x0305 }
            b.a.a.ma.b(r9, r0, r8)     // Catch:{ Exception -> 0x0305 }
        L_0x028e:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            boolean r8 = r8.ma     // Catch:{ Exception -> 0x0305 }
            if (r8 == 0) goto L_0x0305
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            r8.j((boolean) r3)     // Catch:{ Exception -> 0x0305 }
            goto L_0x0305
        L_0x029c:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.ya()
            goto L_0x0305
        L_0x02a2:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.na()
            goto L_0x0305
        L_0x02a8:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            r8.Aa()
            goto L_0x0305
        L_0x02ae:
            boolean r9 = b.a.a.ia.a((java.lang.String) r8)
            if (r9 != 0) goto L_0x0305
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x0305 }
            if (r8 < 0) goto L_0x02db
            if (r8 > r1) goto L_0x02db
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            int unused = r9.pb = r8     // Catch:{ Exception -> 0x0305 }
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            b.a.a.la r9 = b.a.a.la.Pending     // Catch:{ Exception -> 0x0305 }
            b.a.a.la unused = r8.wb = r9     // Catch:{ Exception -> 0x0305 }
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            boolean unused = r8.Fa = r2     // Catch:{ Exception -> 0x0305 }
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            boolean r8 = r8.ma     // Catch:{ Exception -> 0x0305 }
            if (r8 == 0) goto L_0x0305
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            r8.j((boolean) r2)     // Catch:{ Exception -> 0x0305 }
            goto L_0x0305
        L_0x02db:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a     // Catch:{ Exception -> 0x0305 }
            r8.ya()     // Catch:{ Exception -> 0x0305 }
            goto L_0x0305
        L_0x02e1:
            boolean r9 = b.a.a.ia.a((java.lang.String) r8)
            if (r9 != 0) goto L_0x0300
            int r9 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x0300 }
            java.lang.String r2 = "✝"
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x0300 }
            if (r9 < 0) goto L_0x0300
            if (r9 > r1) goto L_0x0300
            com.chandlersystemsinc.signatureappcore.controllers.la r9 = r7.f1389a     // Catch:{ Exception -> 0x0300 }
            android.content.Context r9 = r9.ea     // Catch:{ Exception -> 0x0300 }
            r0 = r0[r3]     // Catch:{ Exception -> 0x0300 }
            b.a.a.ma.b(r9, r0, r8)     // Catch:{ Exception -> 0x0300 }
        L_0x0300:
            com.chandlersystemsinc.signatureappcore.controllers.la r8 = r7.f1389a
            boolean unused = r8.sb = r3
        L_0x0305:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chandlersystemsinc.signatureappcore.controllers.ia.onReceive(android.content.Context, android.content.Intent):void");
    }
}
