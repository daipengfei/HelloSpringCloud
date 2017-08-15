package com.hello.spring.guava.cache;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import javax.annotation.Nonnull;
import java.util.*;

/**
 * Created by daipengfei
 * on 2017/8/15.
 */
public class CaffeineTest {
    static final Map<String, Integer> MAP = new HashMap<>();

    static {
        MAP.put("a", 1);
        MAP.put("b", 1);
        MAP.put("c", 1);
        MAP.put("d", 1);
    }

    public static void main(String[] args) {
        LoadingCache<String, Integer> cache = Caffeine.newBuilder().build(
                new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(@Nonnull String key) throws Exception {
                        System.out.println("single : "  + key);
                        return MAP.get(key);
                    }

                    @Nonnull
                    @Override
                    public Map<String, Integer> loadAll(@Nonnull Iterable<? extends String> keys) throws Exception {
                        List<String> ids = new ArrayList<>();
                        keys.forEach(ids::add);
                        System.out.println("batch : " + ids);
                        return getBatch(ids);
                    }
                }
        );
        cache.put("a", 1);
        cache.put("b", 2);
        System.out.println(cache.getAll(Arrays.asList("a", "b","c","d")));
    }

    private static Map<String, Integer> getBatch(List<String> ids) {
        Map<String, Integer> list = new HashMap<>();
        for (String s : ids) {
            Integer v = MAP.get(s);
            if (v != null) {
                list.put(s, v);
            }
        }
        return list;
    }
}
