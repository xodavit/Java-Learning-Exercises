import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.Date;

public class Securities {
    private int id;
    private String code;
    @SerializedName("name_full")
    private String nameFull;
    private String cfi;
    @SerializedName("date_to")
    private String dateTo;
    @SerializedName("state_reg_date")
    private String regDate;
    private State state;
    private Currency currency;

    public Securities() {
    }

    public Securities(int id, String code, String nameFull, String cfi, String dateTo, String regDate, State state, Currency currency) {
        this.id = id;
        this.code = code;
        this.nameFull = nameFull;
        this.cfi = cfi;
        this.dateTo = dateTo;
        this.regDate = regDate;
        this.state = state;
        this.currency = currency;
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

    public String getCfi() {
        return cfi;
    }

    public void setCfi(String cfi) {
        this.cfi = cfi;
    }

    public LocalDate getDateTo() {
        LocalDate localDateTo = LocalDate.parse(dateTo);
        return localDateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public LocalDate getRegDate() {
        LocalDate localRegDate = LocalDate.parse(regDate);
        return localRegDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "\nSecurities{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name_full='" + nameFull + '\'' +
                ", cfi='" + cfi + '\'' +
                ", date_to='" + dateTo + '\'' +
                ", reg_date='" + regDate + '\'' +
                ", \nstate=" + state +
                ", \ncurrency=" + currency +
                "}\n";
    }
}
