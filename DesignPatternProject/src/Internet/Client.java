package Internet;



public class Client {

    private static ProxyConnected internet;

    public static void main (String[] args){
        internet = new ProxyConnected();
        try{
            internet.connectTo("onlinecasino.ie");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

