package commerce_java;

public class Category {
    private int id;
    private String type;
    private String description;
    private Category[] sub_cat;

    public Category(int id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.sub_cat = null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSub_cat(Category[] sub_cat) {
        this.sub_cat = sub_cat; // Use clone to avoid reference issues
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public Category[] getSub_cat() {
        return sub_cat;
    }
}
