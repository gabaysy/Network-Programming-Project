package bgu.spl.net.srv;

import bgu.spl.net.impl.BidiMessagingProtocolImpl;
import bgu.spl.net.impl.MessageEncoderDecoder;
import bgu.spl.net.srv.BGS.BgsDB;
import bgu.spl.net.srv.Server;

public class TPCMain {
    public static void main(String[] args) {

        BgsDB DB = new BgsDB(); //one shared object
        ServerTPC server= new ServerTPC(
            //    Integer.parseInt(args[0]), //port
                7777,
                () -> new BidiMessagingProtocolImpl(DB), //protocol factory
                MessageEncoderDecoder::new //message encoder decoder factory
        );
        server.serve();

    }
}