package com.alljedi.bottomnavigationapplication.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendCardContent {

    public static final List<RecommendCardItem> ITEMS = new ArrayList<RecommendCardItem>();

    public static final Map<String, RecommendCardItem> ITEM_MAP = new HashMap<String, RecommendCardItem>();

    private static final int COUNT = 25;

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A RecommendCard item representing a piece of content.
     */
    public static class RecommendCardItem {
        public final int id;
        public final String originImage;
        public final String originText;
        public final String title;
        public final String author;
        public final String photo;

        public RecommendCardItem(int id, String originImage, String originText, String title, String author, String photo) {
            this.id = id;
            this.originImage = originImage;
            this.originText = originText;
            this.title = title;
            this.author = author;
            this.photo = photo;
        }

        @Override
        public String toString() {
            return "RecommendCardItem{" +
                    "id='" + id + '\'' +
                    ", originImage='" + originImage + '\'' +
                    ", originText='" + originText + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", photo='" + photo + '\'' +
                    '}';
        }
    }
}
