package daya.dataparse;

public class Contacts {
    private String id,type,topic,_v;
 public Contacts(String id,String type, String topic ,String _v)   {
     this.setId(id);
     this.setType(type);
     this.setTopic(topic);
     this.set_v(_v);

 }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String get_v() {
        return _v;
    }

    public void set_v(String _v) {
        this._v = _v;
    }
}
