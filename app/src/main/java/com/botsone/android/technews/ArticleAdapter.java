package com.botsone.android.technews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by bots on 2/18/18.
 */

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.article_list_item, parent, false);
        }

        // Get article object at current position
        Article currentArticle = getItem(position);

        // Set the imageView to display the current image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        Picasso.with(getContext()).load(currentArticle.getImageUrl()).resize(250, 250).centerCrop().into(imageView);

        // Set the title textView to display the current title
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_textview);
        titleTextView.setText(currentArticle.getTitle());

        // Set the section textView to display the current section
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section_textview);
        sectionTextView.setText(getContext().getString(R.string.section) + currentArticle.getSection());

        // Set the author textView to display the current author
        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author_textview);
        authorTextView.setText(getContext().getString(R.string.author) + currentArticle.getAuthor());

        // Set the date textView to display the current date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_textview);
        dateTextView.setText(getContext().getString(R.string.date) + formatDate(currentArticle.getDate()));

        // Set the article body textView to display the current article body
        TextView bodyTextView = (TextView) listItemView.findViewById(R.id.body_textview);
        bodyTextView.setText(Html.fromHtml(currentArticle.getBody()));

        return listItemView;
    }

    private String formatDate(String date) {
        SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault());
        String formattedDate = "";

        try {
            Date formatDate = sdfSource.parse(date);
            formattedDate = formatDate.toString();
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

}
