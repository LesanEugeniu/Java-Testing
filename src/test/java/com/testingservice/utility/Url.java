package com.testingservice.utility;

public enum Url {
    DEMOQA_FORM("https://demoqa.com/automation-practice-form"),
    MOBILA("https://www.mobiland.md/"),
    GITHUB("https://github.com/"),
    SAUCEDEMO("https://www.saucedemo.com/"),
    DEMOQA_TEXT_BOX("https://demoqa.com/text-box");

    private final String url;

    private Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
