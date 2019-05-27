package com.alljedi.bottomnavigationapplication.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO: get data
public class StarItemContent {

        public static final List<StarItem> ITEMS = new ArrayList<StarItem>();

        public static final Map<String, StarItem> ITEM_MAP = new HashMap<String, StarItem>();

        private static final int COUNT = 25;


        private static void addItem(StarItem item) {
            ITEMS.add(item);
            ITEM_MAP.put(item.id, item);
        }

        private static String makeDetails(int position) {
            StringBuilder builder = new StringBuilder();
            builder.append("Details about Item: ").append(position);
            for (int i = 0; i < position; i++) {
                builder.append("\nMore details information here.");
            }
            return builder.toString();
        }

        /**
         * A dummy item representing a piece of content.
         */
        public static class StarItem {
            public final String id;
            public final String title;
            public final String author;
            public final String summary;

            public StarItem(String id, String title, String author, String summary) {
                this.id = id;
                this.title = title;
                this.author = author;
                this.summary = summary;
            }

            @Override
            public String toString() {
                return "StarItem{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", author='" + author + '\'' +
                        ", summary='" + summary + '\'' +
                        '}';
            }
        }

}
