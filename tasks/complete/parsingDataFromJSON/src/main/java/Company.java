import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.LoggingPermission;

public class Company {
    private int id;
    private String code;
    @SerializedName("name_full")
    private String nameFull;
    @SerializedName("name_short")
    private String nameShort;
    private String inn;
    @SerializedName("company_type")
    private CompanyType type;
    private String ogrn;
    @SerializedName("egrul_date")
    private String egrulDate;
    private Country country;
    @SerializedName("fio_head")
    private String fioHead;
    private String address;
    private String phone;
    @SerializedName("e_mail")
    private String eMail;
    private String www;
    @SerializedName("is_resident")
    private boolean isResident;
    //private Securities[] securities;
    private List<Securities> securities;

    public Company() {
    }

    public Company(int id, String code, String nameFull, String nameShort, String inn, CompanyType type, String ogrn, String egrulDate, Country country, String fioHead, String address, String phone, String eMail, String www, boolean isResident, List<Securities> securities) {
        this.id = id;
        this.code = code;
        this.nameFull = nameFull;
        this.nameShort = nameShort;
        this.inn = inn;
        this.type = type;
        this.ogrn = ogrn;
        this.egrulDate = egrulDate;
        this.country = country;
        this.fioHead = fioHead;
        this.address = address;
        this.phone = phone;
        this.eMail = eMail;
        this.www = www;
        this.isResident = isResident;
        this.securities = securities;
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

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public LocalDate getEgrulDate()
    {
        LocalDate localEgrulDate = LocalDate.parse(egrulDate);
        return localEgrulDate;
    }

    public void setEgrulDate(String egrulDate) {
        this.egrulDate = egrulDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getFioHead() {
        return fioHead;
    }

    public void setFioHead(String fioHead) {
        this.fioHead = fioHead;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public boolean isResident() {
        return isResident;
    }

    public void setResident(boolean resident) {
        isResident = resident;
    }

    public List<Securities> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Securities> securities) {
        this.securities = securities;
    }

    @Override
    public String toString() {
        return "Company{" +
                "\nid=" + id +
                ", \ncode='" + code + '\'' +
                ", \nname_full='" + nameFull + '\'' +
                ", \nname_short='" + nameShort + '\'' +
                ", \ninn='" + inn + '\'' +
                ", \ntype=" + type +
                ", \nogrn='" + ogrn + '\'' +
                ", \negrul_date='" + egrulDate + '\'' +
                ", \ncountry=" + country +
                ", \nfio_head='" + fioHead + '\'' +
                ", \naddress='" + address + '\'' +
                ", \nphone='" + phone + '\'' +
                ", \ne_mail='" + eMail + '\'' +
                ", \nwww='" + www + '\'' +
                ", \nis_resident=" + isResident +
                ", \nsecurities=" + securities +
                "\n}\n";
    }
}
