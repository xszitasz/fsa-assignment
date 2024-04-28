package sk.posam.fsa;

public class Credit {
    private Long id;
    private long count;

    public Credit() {
        this.count = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
