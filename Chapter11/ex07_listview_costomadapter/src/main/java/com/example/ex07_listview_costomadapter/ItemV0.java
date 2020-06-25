package com.example.ex07_listview_costomadapter;

class ItemV0 {
    private String typeStr;
    private String titleStr;
    private String contentStr;

    public ItemV0(String typeStr, String titleStr, String contentStr) {
        this.typeStr = typeStr;
        this.titleStr = titleStr;
        this.contentStr = contentStr;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public String getTitleStr() {
        return titleStr;
    }

    public String getContentStr() {
        return contentStr;
    }
}