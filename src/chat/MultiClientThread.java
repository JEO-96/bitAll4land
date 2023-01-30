package chat;

public class MultiClientThread extends Thread{
    private MultiClient mc;
    public MultiClientThread(MultiClient mc){
        this.mc = mc;
    }
    public void run(){
        String message = null;
        String[] receivedMsg = null;
        boolean isStop = false;
		
        while(!isStop){
            try{
                message = (String)mc.getOis().readObject();
                receivedMsg = message.split("#");
                System.out.println(receivedMsg[0]);
                System.out.println(receivedMsg[0]+","+receivedMsg[1]);
            }catch(Exception e){
                e.printStackTrace();
                isStop = true;
            }
            if(receivedMsg[1].equals("exit")){	// 종료
                if(receivedMsg[0].equals(mc.getId())){
                    mc.exit();
                }else{	// 메시지 보내기
                    mc.getJta().append(
                    receivedMsg[0] +"님이 종료 하셨습니다."+
                    System.getProperty("line.separator"));
                    mc.getJta().setCaretPosition(
                    mc.getJta().getDocument().getLength());
                }
            } else if (receivedMsg[1].contains("/n")) {	// 공지사항 전송
            	mc.getNoticeContentsLabel().setText(receivedMsg[0] +" : " + receivedMsg[2]);
            } else if (receivedMsg[1].contains("list")) {
            		new MultiClientList(mc, message);
            } else if ((receivedMsg[1].contains("kick"))) {
            	System.out.println("message: " + message);
            	if (receivedMsg[2].equals(mc.getId())) {
            		mc.exit();
            	}	
            }
            else{             // 받은 메시지 추가   
                mc.getJta().append(
                receivedMsg[0] +" : "+receivedMsg[1]+
                System.getProperty("line.separator"));
                mc.getJta().setCaretPosition(
                    mc.getJta().getDocument().getLength());
                
            }
        }
    }
}