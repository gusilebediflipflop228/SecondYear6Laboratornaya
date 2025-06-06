package Classes;

public class Group {
    private int id;
    private int[] data;

    public Group(int id, int[] data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int length() {
        return data.length;
    }
}
