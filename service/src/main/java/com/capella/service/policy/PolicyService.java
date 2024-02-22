package com.capella.service.policy;

import com.capella.domain.model.extend.ItemModel;

public interface PolicyService<T extends ItemModel> {
    default void invoke(T model) {
        // Burada void döndüren işlemler yapılır
        System.out.println("Void invoked");
    }

    // Dinamik bir tipte veri döndüren invoke metodu
    default <R> R invokeAndGetResult(T model) {
        // Burada isteğe bağlı olarak bir şeyler yapılır ve bir sonuç döndürülür
        System.out.println("Invoke and get result invoked");
        // Örnek olarak null döndürelim, gerçek kullanıma göre değiştirilebilir
        return null;
    }
}
