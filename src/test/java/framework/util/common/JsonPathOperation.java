package framework.util.common;

import com.jayway.jsonpath.DocumentContext;

public interface JsonPathOperation {
    DocumentContext perform(DocumentContext context);

    static JsonPathOperation set(String path, Object value) {
        return context -> context.set(path, value);
    }

    static JsonPathOperation delete(String path) {
        return context -> context.delete(path);
    }

    static JsonPathOperation put(String path, String key, Object value) {
        return context -> context.put(path, key, value);
    }

    static JsonPathOperation add(String path, Object value) {
        return context -> context.add(path, value);
    }
}
