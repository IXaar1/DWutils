package com.ixaar.dwutils.handlers;

import com.google.common.collect.Lists;
import net.minecraft.util.text.translation.I18n;

import java.util.List;


public class LanguageHandler {

    public static final char CHAR = '|';
    private static final String REGEX = "\\|";
    private final String prefix;

    public LanguageHandler(String locKey) {
        this.prefix = locKey.concat(".");
    }

    public String getPrefix() {
        return prefix;
    }

    public String addPrefix(String suffix) {
        return this.prefix.concat(suffix);
    }

    public String localize(String unloc, Object... args) {
        return localizeExact(addPrefix(unloc), args);
    }

    public String localize(String unloc) {
        return localizeExact(addPrefix(unloc));
    }

    public String localizeExact(String unloc, Object... args) {
        return I18n.translateToLocalFormatted(unloc, args);
    }

    public String localizeExact(String unloc) {
        return I18n.translateToLocal(unloc);
    }

    public String[] localizeList(String unloc, String... args) {
        return splitList(localize(unloc, (Object[]) args));
    }

    public String[] localizeList(String unloc) {
        return splitList(localize(unloc));
    }

    public List<String> localizeAll(List<String> unloc) {
        List<String> ret = Lists.newArrayList();
        for (String s : unloc) {
            ret.add(localize(s));
        }
        return ret;
    }

    public String[] localizeAll(LanguageHandler lang, String... unloc) {
        String[] ret = new String[unloc.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = lang.localize(unloc[i]);
        }
        return ret;
    }

    public String[] splitList(String list) {
        return list.split("\\|");
    }

    public String[] splitList(String list, String split) {
        return list.split(split);
    }

    public boolean canLocalize(String unloc) {
        return canLocalizeExact(addPrefix(unloc));
    }

    public boolean canLocalizeExact(String unloc) {
        return I18n.canTranslate(unloc);
    }
}


