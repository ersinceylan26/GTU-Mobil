package com.mobil.gtu.gtumobil.Haberler;

import org.jsoup.nodes.Document;

public interface PageDownloaded {
    void downloadCompleted(boolean status, Document document);
}
