package com.alljedi.bottomnavigationapplication.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO: get data
public class JournalContent {

        public static final List<JournalItem> ITEMS = new ArrayList<JournalItem>();

        public static final Map<String, JournalItem> ITEM_MAP = new HashMap<String, JournalItem>();

        private static final int COUNT = 25;

        static {
            for (int i = 1; i <= COUNT; i++) {
                addItem(createJournalItem(i));
            }
        }

        private static void addItem(JournalItem item) {
            ITEMS.add(item);
            ITEM_MAP.put(item.id, item);
        }

        private static JournalItem createJournalItem(int position) {
            return new JournalItem(String.valueOf(position), "Item " + position, makeDetails(position));
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
         * A journal item representing a piece of content.
         */
        public static class JournalItem {
            public final String id;
            public final String content;
            public final String details;

            public JournalItem(String id, String content, String details) {
                this.id = id;
                this.content = content;
                this.details = details;
            }

            @Override
            public String toString() {
                return content;
            }
        }

}
