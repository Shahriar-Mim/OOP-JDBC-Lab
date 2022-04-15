package model;

public class Section {
    int id;
    String section_no;
    String timing;
    int seat_remaining;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSection_no() {
        return section_no;
    }

    public void setSection_no(String section_no) {
        this.section_no = section_no;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public int getSeat_remaining() {
        return seat_remaining;
    }

    public void setSeat_remaining(int seat_remaining) {
        this.seat_remaining = seat_remaining;
    }
}
