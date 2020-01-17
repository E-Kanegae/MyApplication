package com.example.ek.recordapp.config.messages;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.springframework.context.support.ResourceBundleMessageSource;


/**
 * record-app
 * com.example.ek.recordapp.config.messages.YamlMessageSource.java
 *
 * ResouceBundleでYAMLを扱えるようにするためのクラス
 *
 * @author E-Kanegae
 *
 */
public class YamlMessageSource extends ResourceBundleMessageSource {

	@Override
	protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {
        return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
    }

}
