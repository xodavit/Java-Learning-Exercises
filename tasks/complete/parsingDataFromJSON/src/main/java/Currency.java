import com.google.gson.annotations.SerializedName;

public class Currency {
    private int id;
    private String code;
    @SerializedName("name_short")
    private String nameShort;
    @SerializedName("name_full")
    private String nameFull;

    public Currency() {
    }

    public Currency(int id, String code, String nameShort, String nameFull) {
        this.id = id;
        this.code = code;
        this.nameShort = nameShort;
        this.nameFull = nameFull;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name_short='" + nameShort + '\'' +
                ", name_full='" + nameFull + '\'' +
                '}';
    }
}
