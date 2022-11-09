package dao;

/**
 * @author 李鑫
 * @version1.0
 */
public class Brand {
    private int id;
    private String brandName;
    private String companName;
    private int oldered;
    private String description;
    private int status;

    public Brand() {
    }

    public Brand(int id, String brandName, String companName, int oldered, String description, int status) {
        this.id = id;
        this.brandName = brandName;
        this.companName = companName;
        this.oldered = oldered;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanName() {
        return companName;
    }

    public void setCompanName(String companName) {
        this.companName = companName;
    }

    public int getOldered() {
        return oldered;
    }

    public void setOldered(int oldered) {
        this.oldered = oldered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "dao.Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companName='" + companName + '\'' +
                ", oldered=" + oldered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
