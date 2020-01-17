package com.example.ek.recordapp.config.messages;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.yaml.snakeyaml.Yaml;

import lombok.Getter;
import lombok.NonNull;

public class YamlResourceBundle extends ResourceBundle {

	private static final List<String> YAML_FORMAT = new ArrayList<String>(Arrays.asList("yaml","yml"));
	
    /**
     * Entries.
     */
    private final Map<String, Object> entries;

    /**
     * Constructor.
     *
     * @param string YAML data.
     */
    public YamlResourceBundle(@NonNull String string) {
        entries = flattenYamlTree(new Yaml().loadAs(string, Map.class));
    }

    /**
     * Constructor.
     *
     * @param stream YAML data as input stream.
     */
    public YamlResourceBundle(@NonNull InputStream stream) {
        entries = flattenYamlTree(new Yaml().loadAs(stream, Map.class));
    }

    /**
     * Constructor.
     *
     * @param reader YAML data as input character stream.
     */
    public YamlResourceBundle(@NonNull Reader reader) {
        entries = flattenYamlTree(new Yaml().loadAs(reader, Map.class));
    }

    /**
     * Flatten yaml tree structure.
     *
     * @param map {@link Map} of yaml tree.
     * @return {@link Map} of entries.
     */
    private static Map<String, Object> flattenYamlTree(Map<?, ?> map) {
        return map.entrySet().stream()
                .flatMap(YamlResourceBundle::flattenYamlTree)
                .filter(e -> e.getValue() != null)
                .collect(toMap(
                        e -> e.getKey(),
                        e -> e.getValue(),
                        (oldValue, newValue) -> newValue
                ));
    }

    /**
     * Flatten yaml tree structure.
     *
     * @param entry {@link Entry} of yaml tree.
     * @return {@link Stream} of entries.
     */
    private static Stream<Entry<String, Object>> flattenYamlTree(Entry<?, ?> entry) {
        String key = entry.getKey().toString();
        Object value = entry.getValue();
        if (value instanceof Map) {
            Map<?, ?> valueAsMap = (Map<?, ?>) value;
            return valueAsMap.entrySet().stream()
                    .flatMap(YamlResourceBundle::flattenYamlTree)
                    .map(e -> new SimpleImmutableEntry<>(key + "." + e.getKey(), e.getValue()));
        } else if (value instanceof List) {
            List<?> valueAsList = (List<?>) value;
            value = valueAsList.stream().toArray(String[]::new);
            AtomicInteger index = new AtomicInteger();
            return Stream.concat(
                    Stream.of(new SimpleImmutableEntry<>(key, value)),
                    valueAsList.stream()
                            .map(v -> new SimpleImmutableEntry<>(key + "[" + index.getAndIncrement() + "]", v))
            );
        }
        return Stream.of(new SimpleImmutableEntry<>(key, value));
    }

    /** {@inheritDoc} */
    @Override
    protected Set<String> handleKeySet() {
        return entries.keySet();
    }

    /** {@inheritDoc} */
    @Override
    public Enumeration<String> getKeys() {
        return enumeration(keySet());
    }

    /** {@inheritDoc} */
    @Override
    protected Object handleGetObject(@NonNull String key) {
        return entries.get(key);
    }

    /**
     * {@link ResourceBundle.Control} for YAML format.
     */
    public static class Control extends ResourceBundle.Control {

        /**
         * Singleton instance.
         */
        public static final Control INSTANCE = new Control();

        /**
         * Constructor.
         */
        protected Control() {
        }

        /** {@inheritDoc} */
        @Override
        public List<String> getFormats(@NonNull String baseName) {
        	List<String> formats = new ArrayList<String>();
        	// デフォルト設定の拡張子も読み込むためスーパークラスの同名メソッドも呼び出す
        	for(String format : super.getFormats(baseName)) {
        		formats.add(format);
        	}
        	for(String yamls : YAML_FORMAT) {
        		formats.add(yamls);
        	}
            return unmodifiableList(formats);
        }
        

        /** {@inheritDoc} */
        @Override
        public ResourceBundle newBundle(@NonNull String baseName,
                @NonNull Locale locale, @NonNull String format, @NonNull ClassLoader loader, boolean reload)
                throws IllegalAccessException, InstantiationException, IOException {
            
        	if (YAML_FORMAT.contains(format)) {
                String bundleName = toBundleName(baseName, locale);
                String resourceName = toResourceName(bundleName, format);
                InputStream stream = loader.getResourceAsStream(resourceName);
                return new YamlResourceBundle(stream);
            }
        	// デフォルト設定の拡張子にも対応するためスーパークラスの同名メソッドも呼び出す
            return super.newBundle(baseName, locale, format, loader, reload);
        }


    }

}
