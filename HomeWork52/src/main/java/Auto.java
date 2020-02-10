public class Auto {
    private Integer id;
    private String licence;

    public Auto(Integer id, String licence) {
        this.id = id;
        this.licence = licence;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", licence='" + licence + '\'' +
                '}';
    }

    public Auto(String licence) {
        this.licence = licence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }
}
