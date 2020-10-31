package j1.s.p0012;

/**
 *
 * @author ASUS
 */
public class Data {
    String data;
    long timeToLive;
    long start;

    public Data(String data, long timeToLive, long start) {
        this.data = data;
        this.timeToLive = timeToLive;
        this.start = start;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(long timeToLive) {
        this.timeToLive = timeToLive;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Data: "+getData()+"\nTime to live: "+getTimeToLive()+"\nStart time: "+ getStart();
    }
    
    
}
