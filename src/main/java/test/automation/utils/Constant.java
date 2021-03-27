package test.automation.utils;

public class Constant {
    static String url;
    private static String userName, password;

    static String adminPortalUrl = "http://10.99.99.60:20020/ui/system";
    static String dmsPortallUrl = "http://10.99.99.95:20020/ui/dms";
    static String callcenter_portal_url = "http://10.99.99.95:20030/ui/call-center/";

    public static String  getUrl(String portal) {
        if(portal == "admin") {
            url = adminPortalUrl;
        }
        else if(portal == "dms") {
            url = dmsPortallUrl;
        }
        else if(portal == "callcenter") {
            url = callcenter_portal_url;
        }
        else {
            System.out.println("Invalid url wanted");
        }
        return url;

    }
    public static String getUserName(String portal){
        if(portal == "admin") {
            userName = "mbl_admin";
        }
        else if(portal == "dms") {
            userName = "MC002208";
        }
        else if(portal == "callcenter") {
            userName = "cch@mblbd.com";
        }
        else {
            System.out.println("Invalid url wanted");
        }
        return userName;
    }
    public static String getPassword(){
        password = "1234";
        return password;
    }




}
