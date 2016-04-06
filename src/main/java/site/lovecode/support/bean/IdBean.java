package site.lovecode.support.bean;

/**
 * Created by Administrator on 2016/4/6.
 */
public class IdBean {

    private String Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "IdBean{" +
                "Id='" + Id + '\'' +
                '}';
    }
}
