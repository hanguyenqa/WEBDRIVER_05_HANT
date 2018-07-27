package java_01_basic;

public class Topic_12_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		String chuoi = "Automation Testing Tutorials Online 123456";
		
		
		String newchuoi = chuoi.toLowerCase();
		int count = 0;
		
		for (int i = 0, len = newchuoi.length(); i < len; i++) {
			
		    if (String.valueOf(newchuoi.charAt(i)).equals("a")) {
		        count++;
		    }
		}
		
	
		System.out.println("Số ký tự a trong chuổi: " + count);

		
		//Kiểm tra chuổi có chứa từ "Testing" hay không
		boolean testing = chuoi.contains("Testing");		
		System.out.println("Chuổi có chứa từ \"Testing\" : " + testing);
		
		//Kiểm tra chuổi có bắt đầu bằng từ "Automation" hay ko
		boolean startWith = chuoi.startsWith("Automation");
		System.out.println("Chuổi có bắt đàu bằng từ \"Automation\" : " + startWith);
		
		//Kiểm tra chuổi có kết thúc bằng từ "Online" hay ko
		boolean endWith = chuoi.endsWith("Online");		
		System.out.println("Chuổi có kết thúc bằng từ \"Online\" : " + endWith);
		
		//Lấy vị trí của từ Tutorials
		int vitri = chuoi.indexOf("Tutorials");
		System.out.println("Vị trí của từ \"Tutorials\" : " + vitri);
		
		//Thay thế Online bằng Offline
		String chuoimoi = chuoi.replace("Online", "Offline");
		System.out.println("chuổi mới sau khi thay thế Online bằng Offline: " + chuoimoi);
		
		
		//Đếm số lượng ký tự là số có trong chuỗi
		int secondCount = 0;
		for (int j = 0, leng = chuoi.length(); j < leng; j++) {
		    if (Character.isDigit(chuoi.charAt(j))) {
		    	secondCount++;
		    }
		}
		
		System.out.println("Số number trong chuổi: " + secondCount);
		
		

	}

}
