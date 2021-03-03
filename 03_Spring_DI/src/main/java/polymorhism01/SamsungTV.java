package polymorhism01;

public class SamsungTV implements TV {
	private SonySpeaker speaker;
	
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 객체 생성");
		//필드 SonySpeaker 객체 주입
		speaker = new SonySpeaker();
	}
	
	public void powerOn() {
		System.out.println("SamsungTV - 전원 ON");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV - 전원 OFF");
	}
	
	public void volumnUp() {
		System.out.println("SamsungTV - 소리 크게");
		speaker.volumnUp();
	}
	
	public void volumnDown() {
		System.out.println("SamsungTV - 소리 작게");
		speaker.volumnDown();
	}
	
	//-------------------------------------------
	public void initMethod() {
		System.out.println("SamsungTV - initMethod() 실행");
	}
	
	public void destroyMethod() {
		System.out.println("SamsungTV - destroyMethod() 실행");
	}
	
	
}
