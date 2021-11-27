package jaefactory.newboard.util;

public class Script {

    public static String back(String msg) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("alert('"+msg+"');");
        sb.append("history.back();");
        sb.append("</script>");
        return sb.toString();
    }

    public static String success() {
        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("alert('회원가입이 완료되었습니다.');");
        sb.append("</script>");
        return sb.toString();
    }
}
