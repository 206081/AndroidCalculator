package msikora_206081.calc;

public class DataHolder {
    private static String data = "";
    private static int position = 0;

    public static String getData() {
        return data;
    }

    public static int getPosition(){
        return position;
    }
    public static void setData(String data) {
        DataHolder.data = data;
    }

    public static void setPosition(int position){
        DataHolder.position = position;
    }

    public static boolean isEmpty(){
        return data.isEmpty();
    }
}