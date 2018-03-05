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
			System.err.println("��ʼ��ʧ�ܣ�\n"+resultString);
			return;
		}
		
		
		String sInput = "������һ����ֿ�ĸ�������ҵ���ǰ��û����ϧ��" + "\r"
				+ "����ʧȥ��ʱ���׷��Ī�����˼���ʹ�����Ī���ڴˣ�"
				+ "��Ľ����ҵ��ʺ��ϴ���ȥ�ɣ���������ԥ�ˣ���������ܸ���һ������һ�εĻ��ᣬ"
				+ "�һ���ĸ�Ů��˵�����֣��Ұ��㣬�����Ҫ����ݰ��ϼ�һ�����ޣ���ϣ����һ���꣡";
		
		try {
			resultString = instance.NLPIR_ParagraphProcess(sInput, 0);
			System.out.println(resultString);
			
			instance.NLPIR_Exit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
