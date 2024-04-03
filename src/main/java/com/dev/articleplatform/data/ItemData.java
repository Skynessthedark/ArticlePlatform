package com.dev.articleplatform.data;

import java.io.Serializable;

public class ItemData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String creationDate;
    private String modificationDate;

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }
}
