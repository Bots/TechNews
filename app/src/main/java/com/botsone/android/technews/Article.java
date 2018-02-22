package com.botsone.android.technews;

/**
 * Created by bots on 2/18/18.
 */

public class Article {

    private String mImageUrl;

    private String mTitle;

    private String mSection;

    private String mAuthor;

    private String mDate;

    private String mBody;

    private String mUrl;

    public Article(String imageUrl, String title, String section, String author,
                   String date, String body, String url) {

        mImageUrl = imageUrl;
        mTitle = title;
        mSection = section;
        mAuthor = author;
        mDate = date;
        mBody = body;
        mUrl = url;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSection() {
        return mSection;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDate() {
        return mDate;
    }

    public String getBody() {
        return mBody;
    }

    public String getUrl() {
        return mUrl;
    }
}
