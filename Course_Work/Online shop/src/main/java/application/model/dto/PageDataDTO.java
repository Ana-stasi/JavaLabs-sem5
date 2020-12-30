package application.model.dto;

import java.util.List;

public class PageDataDTO<E>{
        private int page;
        private int offset;
        private int count;
    private List<E> data;

    public PageDataDTO( List<E> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public int getOffset() {
        return offset;
    }

    public int getCount() {
        return count;
    }

    public List<E> getData() {
        return data;
    }

}
