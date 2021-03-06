package bgu.spl.net.impl.msg;

import bgu.spl.net.api.bidi.Connections;
import bgu.spl.net.api.bidi.Message;
import bgu.spl.net.srv.BGS.BgsDB;

import java.util.Optional;

public class ACKMsg implements Message {
    final short optcode;
    final short messageOptcode;
    private Optional<String> additionalData;


    public ACKMsg(short messageOptcode) {
        this.optcode = 10;
        this.messageOptcode = messageOptcode;
    }

    public ACKMsg(short messageOptcode ,String additionalData) {
        this.optcode = 10;
        this.messageOptcode = messageOptcode;
        this.additionalData = Optional.of(additionalData);
    }

    public short getOptCode() {
        return optcode;
    }

    public short getMessageOptcode() {
        return messageOptcode;
    }
    public boolean hasData(){
        return this.additionalData!=null && this.additionalData.isPresent();
    }
    public String getAdditionalData() {
        return additionalData.get();
    }

    @Override
    public void process(BgsDB db, Connections connections, int connectionId) {
        //not implemented- relevant to server-to-client only
    }

    public String ACKToString(){
  //      return "ACK ADDITIONAL INFO";
        String ans= this.getOptCode() +" "+ this.getMessageOptcode();
        if(this.additionalData.isPresent())
            ans+=" "+additionalData.get();
        return ans;
    }
}
