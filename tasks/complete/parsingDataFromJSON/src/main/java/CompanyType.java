import com.google.gson.annotations.SerializedName;

public class CompanyType {
    private int id;
    @SerializedName("name_short")
    private String nameShort;
    @SerializedName("name_full")
    private String nameFull;

    public CompanyType() {
    }

    public CompanyType(int id, String nameShort, String nameFull) {
        this.id = id;
        this.nameShort = nameShort;
        this.nameFull = nameFull;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setName_short(String nameShort) {
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
        return "CompanyType{" +
                "id=" + id +
                ", name_short='" + nameShort + '\'' +
                ", name_full='" + nameFull + '\'' +
                "}";
    }
}
