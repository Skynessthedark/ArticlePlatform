package com.dev.articleplatform.populator.impl;

import com.dev.articleplatform.data.ItemData;
import com.dev.articleplatform.model.ItemModel;
import com.dev.articleplatform.populator.Populator;
import com.dev.articleplatform.util.DateUtil;

public class ItemPopulator<S extends ItemModel, T extends ItemData> implements Populator<S, T> {

    @Override
    public void populate(S source, T target) {
        target.setCreationDate(DateUtil.date2String(source.getCreationDate()));
        target.setModificationDate(DateUtil.date2String(source.getModificationDate()));
    }
}
