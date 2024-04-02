package com.dev.articlePlatform.populator.impl;

import com.dev.articlePlatform.data.ItemData;
import com.dev.articlePlatform.model.ItemModel;
import com.dev.articlePlatform.populator.Populator;
import com.dev.articlePlatform.util.DateUtil;

public class ItemPopulator<S extends ItemModel, T extends ItemData> implements Populator<S, T> {

    @Override
    public void populate(S source, T target) {
        target.setCreationDate(DateUtil.date2String(source.getCreationDate()));
        target.setModificationDate(DateUtil.date2String(source.getModificationDate()));
    }
}
