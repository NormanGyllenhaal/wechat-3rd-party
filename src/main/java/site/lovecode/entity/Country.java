package site.lovecode.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "country")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String countryname;

    private String countrycode;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return countryname
     */
    public String getCountryname() {
        return countryname;
    }

    /**
     * @param countryname
     */
    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    /**
     * @return countrycode
     */
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * @param countrycode
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", countryname=").append(countryname);
        sb.append(", countrycode=").append(countrycode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}