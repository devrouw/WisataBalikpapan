package com.hermawan.wisatabalikpapan.util;

import java.io.IOException;

public class NoConnectivityException extends IOException {
    @Override
    public String getMessage() {
        return "Tidak Terhubung dengan Internet";
        // You can send any message whatever you want from here.
    }
}
