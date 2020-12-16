package view.page;

public interface InputReader {
     default String getUserRole(){ return " ";}
     default String getUsername(){return " ";}
     default String getPassword(){return " ";}
     default String getEmail(){return " ";}
     default int getValueByItem(String request,int amount){return 0;}
     default double getDouble(String string){return 0;}
     default int getIntValue(String str){return 0;}
     default String getBlockRequest(){return "";}
}
