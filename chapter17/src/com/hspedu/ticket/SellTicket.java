package com.hspedu.ticket;

/**
 * @author Solider
 * @version 1.0
 */
public class SellTicket {
    public static void main(String[] args) {
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket011 = new SellTicket01();
//        SellTicket01 sellTicket012 = new SellTicket01();
//        sellTicket01.start();
//        sellTicket011.start();
//        sellTicket012.start();
        new Thread(new SellTicket02()).start();
        new Thread(new SellTicket02()).start();
        new Thread(new SellTicket02()).start();
    }
}
