package lab3.view.page;

public interface InputReader {
     default String getUserRole(){ return " ";}
     default String getUsername(){return " ";}
     default String getPassword(){return " ";}
     default String getEmail(){return " ";}
     default double getDouble(String string){return 0;}
     default int getIntValue(String str){return 0;}
     default String getBlockRequest(){return "";}
     default int getOrderStatus(){return 0;}
}
