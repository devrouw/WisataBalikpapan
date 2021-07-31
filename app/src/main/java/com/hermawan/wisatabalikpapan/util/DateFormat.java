package com.hermawan.wisatabalikpapan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class DateFormat {
    private Locale locale = new Locale("in","ID");
    private SimpleDateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
    private SimpleDateFormat dateOnly = new SimpleDateFormat("dd", locale);
    private SimpleDateFormat localeListDate = new SimpleDateFormat("d MMM y · HH:mm", locale);
    private SimpleDateFormat timeWithoutMinutes = new SimpleDateFormat("HH:mm", locale);
    private SimpleDateFormat dateYear = new SimpleDateFormat("MMMM y ", locale);

    public String localeDateParseDay(String tanggal){
        String tgl = "";
        try {
            tgl = dateOnly.format(Objects.requireNonNull(timestamp.parse(tanggal)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tgl;
    }

    public String localeDateParseMonth(String tanggal){
        String tgl = "";
        try {
            tgl = dateYear.format(Objects.requireNonNull(timestamp.parse(tanggal)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tgl;
    }
    public String localeTimeWithoutMinutes(String tanggal){
        String tgl = "";
        try {
            tgl = timeWithoutMinutes.format(Objects.requireNonNull(timestamp.parse(tanggal)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tgl;
    }
}
