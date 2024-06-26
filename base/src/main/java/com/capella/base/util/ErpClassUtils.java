package com.capella.base.util;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ErpClassUtils extends ClassUtils {
    public static Class getClassForPackage(String className, String packageName) {
        var classes = getClassesForPackage(packageName);
        return classes.stream().filter(p -> StringUtils.equals(ClassUtils.getSimpleName(p), className)).
                findFirst().orElseThrow(() -> new RuntimeException("Sınıf bulunamadı.Lütfen dosya adını veya " +
                        "rest api üzerindeki parametrenizi kontrol ediniz"));
    }

    public static Set<Class<?>> getClassesForPackage(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        var classes = reflections.getSubTypesOf(Object.class)
                .stream()
                .collect(Collectors.toSet());
        return classes;
    }

    public static String generateClassName(String className, String delimiter, String prefix) {
        var parts = StringUtils.split(className, delimiter);
        var plainName = Arrays.asList(parts).stream().map(p-> StringUtils.capitalize(p)).collect(Collectors.joining());
        if(StringUtils.contains(plainName, "Model")){
            return plainName;
        }
        return StringUtils.join(plainName, prefix);
    }
}
