package com.nilhcem.fakesmtp.check;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Map;

/**
 * @author Marco Grunert (magomi@gmail.com)
 */
public class MailCache {
    private Map<String, String> sessions;

    private static MailCache instance = new MailCache();

    private MailCache() {
        Cache<String, String> cache = CacheBuilder.newBuilder().build();
        sessions = cache.asMap();
    }

    public static MailCache getInstance() {
        return instance;
    }

    public String getMailData(String id) {
        return sessions.get(id);
    }

    public void putMailData(String id, String mailData) {
        sessions.put(id, mailData);
    }

}
