package com.tc.Qrcode;

/**
 * 二维码的纠错级别
 * 纠错级别越高，那么存放的信息就越少。
 * Created by tangc on 2016/5/13.
 */
public enum CorrectErrorLevel {
    L, //大约7%
    M, //大约15%
    Q, //大约25%
    H  //大约30%
}
