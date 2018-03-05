package Demo;

import nlp_interface.CLibrary;

import com.sun.jna.Native;

public class Demo {
	public static void main(String[] args) {
		CLibrary instance = (CLibrary)Native.loadLibrary(System.getProperty("user.dir")+"\\source\\NLPIR", CLibrary.class);
		int init_flag = instance.NLPIR_Init("", 1, "0");
		String resultString = null;
		if(0 == init_flag){
			resultString = instance.NLPIR_GetLastErrorMsg();
			System.err.println("初始化失败！\n"+resultString);
			return;
		}
		
		
		String sInput = "曾经有一份真挚的感情摆在我的面前我没有珍惜，" + "\r"
				+ "等我失去的时候才追悔莫及，人间最痛苦的事莫过于此，"
				+ "你的剑在我的咽喉上刺下去吧，不用在犹豫了！如果上天能给我一次再来一次的机会，"
				+ "我会对哪个女孩说三个字：我爱你，如果非要在这份爱上加一个期限，我希望是一万年！";
		
		try {
			resultString = instance.NLPIR_ParagraphProcess(sInput, 0);
			System.out.println(resultString);
			
			instance.NLPIR_Exit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
